FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${LSI_SRC}/linux-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require dt-${KARCH}.inc

LSI_KERNEL_TAG = "7.8.1.48"
LINUX_VERSION = "3.4.91-${LSI_KERNEL_TAG}"
KBRANCH = "standard/preempt-rt/axxia-dev/base"
KMETA = ""
KREPO = "git://git@github.com/lsigithub/lsi_axxia_yocto_public.git;protocol=ssh"
SRCREV_machine = "bcaca399a46cd52817c2af787656fe57ca5ef989"
SRC_URI = "${KREPO};bareclone=1;branch=${KBRANCH};name=machine"
SRC_URI += "file://fit"
SRC_URI += "file://defconfig"
