LINUX_VERSION_standard = "5.10.78"
LINUX_VERSION_preempt-rt = "5.10.78"
KBRANCH_standard = "v5.10/standard/axxia-dev/base"
KBRANCH_preempt-rt = "v5.10/standard/preempt-rt/axxia-dev/base"
SRCREV_standard = "685b936569a0498397428066375e3947fbfa8bd5"
SRCREV_preempt-rt = "b3aed00dec11cd8c6498e856828ed1f2bcb57426"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
LINUX_VERSION_EXTENSION = "-axxia-${LINUX_KERNEL_TYPE}"

KMETA = ""

KREPO_AXXIA ?= "public"
KREPO_PRIVATE = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
KREPO_PUBLIC = "git://git@github.com/axxia/linux-yocto.git;protocol=http"
KREPO = "${@oe.utils.conditional('KREPO_AXXIA', 'private', '${KREPO_PRIVATE}', '${KREPO_PUBLIC}', d)}"

KSTATE_AXXIA ?= "release"
KSTATE = "${@oe.utils.conditional('KREPO_AXXIA', 'public', 'release', '${KSTATE_AXXIA}', d)}"
KBRANCH_DEV_standard = "next/v5.10/standard/axxia-dev/base"
KBRANCH_DEV_preempt-rt = "next/v5.10/standard/preempt-rt/axxia-dev/base"
DEV_SUFFIX = "${@oe.utils.conditional('KSTATE', 'release', '', '-DEV', d)}"
KERNEL_VERSION_SANITY_SKIP = "${@oe.utils.conditional('KSTATE', 'release', '0', '1', d)}"

SRC_URI = "${KREPO};name=machine;branch=${KBRANCH} \
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

LINUX_VERSION_pn-linux-axxia = "${LINUX_VERSION_standard}${DEV_SUFFIX}"
LINUX_VERSION_pn-linux-axxia-debug = "${LINUX_VERSION_standard}${DEV_SUFFIX}"
LINUX_VERSION_pn-linux-axxia-rt = "${LINUX_VERSION_preempt-rt}${DEV_SUFFIX}"
LINUX_VERSION_pn-linux-axxia-rt-debug = "${LINUX_VERSION_preempt-rt}${DEV_SUFFIX}"

KBRANCH_pn-linux-axxia = "${@oe.utils.conditional('KSTATE', 'release', '${KBRANCH_standard}', '${KBRANCH_DEV_standard}', d)}"
KBRANCH_pn-linux-axxia-debug = "${@oe.utils.conditional('KSTATE', 'release', '${KBRANCH_standard}', '${KBRANCH_DEV_standard}', d)}"
KBRANCH_pn-linux-axxia-rt = "${@oe.utils.conditional('KSTATE', 'release', '${KBRANCH_preempt-rt}', '${KBRANCH_DEV_preempt-rt}', d)}"
KBRANCH_pn-linux-axxia-rt-debug = "${@oe.utils.conditional('KSTATE', 'release', '${KBRANCH_preempt-rt}', '${KBRANCH_DEV_preempt-rt}', d)}"

SRCREV_machine_pn-linux-axxia = "${@oe.utils.conditional('KSTATE', 'release', '${SRCREV_standard}', '${AUTOREV}', d)}"
SRCREV_machine_pn-linux-axxia-debug = "${@oe.utils.conditional('KSTATE', 'release', '${SRCREV_standard}', '${AUTOREV}', d)}"
SRCREV_machine_pn-linux-axxia-rt = "${@oe.utils.conditional('KSTATE', 'release', '${SRCREV_preempt-rt}', '${AUTOREV}', d)}"
SRCREV_machine_pn-linux-axxia-rt-debug = "${@oe.utils.conditional('KSTATE', 'release', '${SRCREV_preempt-rt}', '${AUTOREV}', d)}"
