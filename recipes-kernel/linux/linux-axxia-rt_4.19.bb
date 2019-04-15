require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.30"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/axxia-dev/base-clean"
SRCREV_machine_axxiaarm = "4563946e1c0f6eb94da641306b82f6202cdbadc5"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/axxia-dev/base-clean"
SRCREV_machine_axxiaarm64 = "4563946e1c0f6eb94da641306b82f6202cdbadc5"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
