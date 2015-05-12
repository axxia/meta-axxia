
require linux-yocto.inc

LINUX_VERSION = "3.4.91"

KBRANCH = "standard/preempt-rt/axxia/base"
KREPO = "git://git.yoctoproject.org/linux-yocto-3.4.git"

SRCREV_machine = "875653fbfa0664859bc014ce547874116b044d64"
SRCREV_meta = "5da29766338644adce97d3ab0c8be7f8e4e746bd"

SRC_URI = "${KREPO};nocheckout=1;branch=${KBRANCH},${KMETA};name=machine,meta"
SRC_URI += "file://fit"
SRC_URI += "file://defconfig"
