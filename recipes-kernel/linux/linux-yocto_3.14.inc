FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${AXXIA_SRC}/linux-${KV}/${MACHINE}/common:\
${THISDIR}/conf/${AXXIA_SRC}/linux-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:${THISDIR}/patch:"

require dt-${KARCH}.inc

LINUX_VERSION = "3.14.39"
KBRANCH = "standard/axxia/base"
SRCREV_machine ="${AUTOREV}"
SRCREV_meta ="${AUTOREV}"
SRC_URI += "file://fit"
SRC_URI += "file://Correct-the-header-path-for-lsi-ncr.patch"

require frags-${KARCH}.inc
