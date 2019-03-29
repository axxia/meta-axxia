require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.19"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "b96c0c7f06bab97ac71ee8350c85347924a246fd"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "b96c0c7f06bab97ac71ee8350c85347924a246fd"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
