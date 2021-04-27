LINUX_VERSION_standard = "5.10.30"
LINUX_VERSION_preempt-rt = "5.10.30"
KBRANCH_standard = "v5.10/standard/axxia-dev/base"
KBRANCH_preempt-rt = "v5.10/standard/preempt-rt/axxia-dev/base"
SRCREV_standard = "566ddd96a862ac2778b34f0cb9bcc34cb4b86de7"
SRCREV_preempt-rt = "5a9580040f9ae89d9cea2b65da2e1407f8584a1d"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LINUX_VERSION_EXTENSION = "-axxia-${LINUX_KERNEL_TYPE}"

KMETA = ""

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           file://fit "

require linux-common.inc

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

LINUX_VERSION_pn-linux-axxia = "${LINUX_VERSION_standard}"
LINUX_VERSION_pn-linux-axxia-debug = "${LINUX_VERSION_standard}"
LINUX_VERSION_pn-linux-axxia-rt = "${LINUX_VERSION_preempt-rt}"
LINUX_VERSION_pn-linux-axxia-rt-debug = "${LINUX_VERSION_preempt-rt}"

KBRANCH_pn-linux-axxia = "${KBRANCH_standard}"
KBRANCH_pn-linux-axxia-debug = "${KBRANCH_standard}"
KBRANCH_pn-linux-axxia-rt = "${KBRANCH_preempt-rt}"
KBRANCH_pn-linux-axxia-rt-debug = "${KBRANCH_preempt-rt}"

SRCREV_machine_pn-linux-axxia = "${SRCREV_standard}"
SRCREV_machine_pn-linux-axxia-debug = "${SRCREV_standard}"
SRCREV_machine_pn-linux-axxia-rt = "${SRCREV_preempt-rt}"
SRCREV_machine_pn-linux-axxia-rt-debug = "${SRCREV_preempt-rt}"
