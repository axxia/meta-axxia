FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${LSI_SRC}/linux-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require dt-${KARCH}.inc

LSI_KERNEL_TAG = "8.8.1.53"
LINUX_VERSION = "3.10.38-${LSI_KERNEL_TAG}"
KBRANCH = "standard/lsi/base"
KMETA = ""
KREPO = "git://git@github.com/lsigithub/lsi_axxia_yocto_public_3.10.git;protocol=ssh"
SRCREV_machine = "c01e54b3ced0224c8b32d3aab4a9b78d76fbac0e"
SRC_URI = "${KREPO};bareclone=1;branch=${KBRANCH};name=machine"
SRC_URI += "file://fit"
SRC_URI += "file://defconfig"
