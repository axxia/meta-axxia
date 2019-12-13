LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.72"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "c93cb13edc446072d17874ab5bf9e57e0f94811c"
KBRANCH_axxiaarm64 = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "c93cb13edc446072d17874ab5bf9e57e0f94811c"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
