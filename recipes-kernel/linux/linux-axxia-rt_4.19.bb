require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.30"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "305effa95d7a197a9dc359729ed378b93a2c3c6d"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "305effa95d7a197a9dc359729ed378b93a2c3c6d"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
