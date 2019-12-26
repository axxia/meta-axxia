LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.72"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "6eb352a227f8c74028afe7a61a6a4bb673d6e49f"
KBRANCH_axxiaarm64 = "next/v4.19/standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "6eb352a227f8c74028afe7a61a6a4bb673d6e49f"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
