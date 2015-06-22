FILESEXTRAPATHS_prepend := "${THISDIR}/conf/${LSI_SRC}/linux-${KV}/${MACHINE}:"

require linux-yocto.inc

LINUX_VERSION = "3.4.91"

KBRANCH = "standard/axxia/base"
KMETA = "meta"
KREPO = "git://git.yoctoproject.org/linux-yocto-3.4.git"

SRCREV_machine = "07aaf12d572f9e394a15f49eb52aba414a420685"
SRCREV_meta = "5da29766338644adce97d3ab0c8be7f8e4e746bd"

SRC_URI = "${KREPO};nocheckout=1;branch=${KBRANCH},${KMETA};name=machine,meta"
SRC_URI += "file://fit"
SRC_URI += "file://standard.scc \
	${@base_conditional('TESTING', 'yes', 'file://testing.scc', '', d)} "
