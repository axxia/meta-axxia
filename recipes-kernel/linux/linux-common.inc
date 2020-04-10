DEPENDS += "u-boot-mkimage-native dtc-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "axxiaarm|axxiaarm64"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
CHIPSET_LOWER = "${@d.getVar('CHIPSET').lower()}"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""

# If this kernel package is not set as virtual/kernel provider,
# allow to be used as alternative kernel.
KERNEL_PACKAGE_NAME = "${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel', \
		      '${PN}', 'kernel', 'kernel-${PN}', d)}"

do_configure_append() {
	sed -i s@UTS_VERSION=\"\#\$VERSION\"@UTS_VERSION=\"${RELEASE_VERSION}\ \#\$VERSION\"@g \
	       ${STAGING_KERNEL_DIR}/scripts/mkcompile_h
}

do_install_append() {
	depmod -a -b ${D} -F ${D}/boot/System.map-${KERNEL_VERSION} ${KERNEL_VERSION}
}

do_shared_workdir_append() {
	if [ "${KERNEL_PACKAGE_NAME}" != "kernel" ]; then
		# Expose kernel tree in work-shared if not preferred provider for virtual/kernel
		rm -f ${TMPDIR}/work-shared/${MACHINE}/kernel-*-${PN}
		ln -sf ${STAGING_KERNEL_DIR} ${TMPDIR}/work-shared/${MACHINE}/kernel-source-${PN}
		ln -sf ${STAGING_KERNEL_BUILDDIR} ${TMPDIR}/work-shared/${MACHINE}/kernel-build-artifacts-${PN}
	fi
}

kernel_do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${KBUILD_OUTPUT}/System.map \
		${DEPLOYDIR}/System-${PN}${KERNEL_ARTIFACT_NAME}.map
	if [ "${KERNEL_PACKAGE_NAME}" = "kernel" ]; then
		cd ${DEPLOYDIR}
		rm -f System.map
		ln -sf System-${PN}${KERNEL_ARTIFACT_NAME}.map System.map
	fi
}

FILES_${KERNEL_PACKAGE_NAME}-modules += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/modules.*"

# Clean alternative kernels if virtual/kernel's clean or cleansstate is run
ALTERNATIVE_KERNELS_CLEAN = "${@':do_clean '.join(d.getVar('ALTERNATIVE_KERNELS')[1:].split(' '))}:do_clean"
ALTERNATIVE_KERNELS_CLEANSSTATE = "${@':do_cleansstate '.join(d.getVar('ALTERNATIVE_KERNELS')[1:].split(' '))}:do_cleansstate"
ALTERNATIVE_KERNELS_CLEAN_CHECK = "${@oe.utils.conditional('ALTERNATIVE_KERNELS', '', '', \
				   '${ALTERNATIVE_KERNELS_CLEAN}', d)}"
ALTERNATIVE_KERNELS_CLEANSSTATE_CHECK = "${@oe.utils.conditional('ALTERNATIVE_KERNELS', '', '', \
					'${ALTERNATIVE_KERNELS_CLEANSSTATE}', d)}"
do_clean[depends] += "${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel', '${PN}', \
		     '${ALTERNATIVE_KERNELS_CLEAN_CHECK}', '', d)}"
do_cleansstate[depends] += "${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel', '${PN}', \
			   '${ALTERNATIVE_KERNELS_CLEANSSTATE_CHECK}', '', d)}"

# Compile tools needed by external modules each time kernel is clean
do_clean[depends] += "make-mod-scripts:do_cleansstate"
