require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "${THISDIR}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

LINUX_VERSION_EXTENSION = "-axxia-${LINUX_KERNEL_TYPE}"

KMETA = ""

SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           file://fit "

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
CHIPSET_LOWER = "${@d.getVar('CHIPSET').lower()}"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""

KCONFIG_MODE = "--alldefconfig"
DEFCONFIG_TYPE = "${@oe.utils.conditional('LINUX_KERNEL_TYPE', 'preempt-rt', '_rt', '', d)}"
DEFCONFIG_DBG = "${@oe.utils.conditional('DBG', 'yes', '_dbg', '', d)}"
KBUILD_DEFCONFIG ?= "axxia_${CHIPSET_LOWER}${DEFCONFIG_TYPE}${DEFCONFIG_DBG}_defconfig"

do_kernel_metadata_prepend() {
    # If CHIPSET is changed and cleansstate is not ran, old defconfig remains in WORKDIR.
    # Remove it be sure the one from source tree si not skipped, but it's copied.
    rm -f "${WORKDIR}/defconfig"

    # Be sure XLF and X9 defconfigs are avaibale for axxiaarm build
    (
    cd ${S}/arch/arm64/configs
    for defconfig in $(ls axxia*); do
        ln -sf ../../arm64/configs/${defconfig} ${S}/arch/arm/configs/${defconfig}
    done
    )
}

do_configure_append() {
	sed -i s@UTS_VERSION=\"\#\$VERSION\"@UTS_VERSION=\"${RELEASE_VERSION}\ \#\$VERSION\"@g \
	       ${STAGING_KERNEL_DIR}/scripts/mkcompile_h
}

kernel_do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${KBUILD_OUTPUT}/System.map \
		${DEPLOYDIR}/System${KERNEL_ARTIFACT_NAME}.map
	cd ${DEPLOYDIR}
	rm -f System.map
	ln -sf System${KERNEL_ARTIFACT_NAME}.map System.map
}
