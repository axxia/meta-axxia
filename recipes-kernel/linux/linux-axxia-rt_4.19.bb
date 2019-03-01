require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.19"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/axxia-dev/base-3059029"
SRCREV_machine_axxiaarm = "9ccc5e460522b8888a3f2d15c28675df2e029b74"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/axxia-dev/base-3059029"
SRCREV_machine_axxiaarm64 = "9ccc5e460522b8888a3f2d15c28675df2e029b74"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"