FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${LSI_SRC}/linux-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require dt-${KARCH}.inc

LSI_KERNEL_TAG = "tip"
LINUX_VERSION = "3.10.65-${LSI_KERNEL_TAG}"
KBRANCH = "standard/axxia-dev/base"
KMETA = ""
KREPO = "git://git@github.com/lsigithub/lsi_axxia_yocto_3.10.git;protocol=ssh"
SRCREV_machine = "${AUTOREV}"
SRC_URI = "${KREPO};bareclone=1;branch=${KBRANCH};name=machine"
SRC_URI += "file://fit"
SRC_URI += "file://defconfig"
