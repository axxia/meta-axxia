LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.87"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "5ac5cb799fa85117740fb58d6c1f3ca6b128739c"
KBRANCH_axxiaarm64 = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "5ac5cb799fa85117740fb58d6c1f3ca6b128739c"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
