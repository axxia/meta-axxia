require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/frags/${KERNEL_MAJOR_VERSION}/${MACHINE}/common\
:${THISDIR}/frags/${KERNEL_MAJOR_VERSION}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

LINUX_VERSION_EXTENSION = "-yocto-axxia-${LINUX_KERNEL_TYPE}"
KERNEL_MAJOR_VERSION = "${@'.'.join(d.getVar('PV').split('.')[0:2])}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "axxiaarm|axxiaarm64"
INSANE_SKIP_kernel-dev = "debug-files"

# If this kernel package is not set as virtual/kernel provider,
# allow to be used as alternative kernel.
KERNEL_PACKAGE_NAME = "${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel', \
		      '${PN}', 'kernel', 'kernel-${PN}', d)}"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""

do_configure_append() {
	sed -i s@UTS_VERSION=\"\#\$VERSION\"@UTS_VERSION=\"${RELEASE_VERSION}\ \#\$VERSION\"@g \
	       ${STAGING_KERNEL_DIR}/scripts/mkcompile_h
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
