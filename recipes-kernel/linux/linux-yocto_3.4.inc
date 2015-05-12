
require linux-yocto.inc

LINUX_VERSION = "3.4.91"

KBRANCH = "standard/axxia/base"
KMETA = "meta"
KREPO = "git://git.yoctoproject.org/linux-yocto-3.4.git"

SRCREV_machine = "2991cb14f151762ba0856facf600c18eaf3ee382"
SRCREV_meta = "5da29766338644adce97d3ab0c8be7f8e4e746bd"

SRC_URI = "${KREPO};nocheckout=1;branch=${KBRANCH},${KMETA};name=machine,meta"
SRC_URI += "file://fit"
SRC_URI += "file://standard.scc"
