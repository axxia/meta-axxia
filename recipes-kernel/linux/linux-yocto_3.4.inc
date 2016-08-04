FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${AXXIA_SRC}/linux-${KV}/${MACHINE}/common:\
${THISDIR}/conf/${AXXIA_SRC}/linux-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require dt-${KARCH}.inc

LINUX_VERSION = "3.4.91"
KBRANCH = "standard/axxia/base"
SRCREV_machine = "${AUTOREV}"
SRCREV_meta = "${AUTOREV}"
SRC_URI += "file://fit"

require frags-3.4.inc
