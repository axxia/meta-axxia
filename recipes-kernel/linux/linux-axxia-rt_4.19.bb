LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.87"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "683cf9e48949380e21f9961bb55c0b881ce5718a"
KBRANCH_axxiaarm64 = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "683cf9e48949380e21f9961bb55c0b881ce5718a"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
