FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${AXXIA_SRC}/linux-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require dt-${KARCH}.inc

AXXIA_KERNEL_TAG = "8.8.1.53"
LINUX_VERSION = "3.10.38-${AXXIA_KERNEL_TAG}"
KBRANCH = "standard/preempt-rt/axxia-dev/base"
KMETA = ""
KREPO = "git://git@github.com/axxia/lsi_axxia_yocto_public_3.10.git;protocol=ssh"
SRCREV_machine ="${AUTOREV}"
SRC_URI = "${KREPO};bareclone=1;branch=${KBRANCH};name=machine"
SRC_URI += "file://fit"
SRC_URI += "file://defconfig"
