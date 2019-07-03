require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.30"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "5826790f2a8e6446901c9dca5a84a45f2e4b3b92"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "5826790f2a8e6446901c9dca5a84a45f2e4b3b92"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
