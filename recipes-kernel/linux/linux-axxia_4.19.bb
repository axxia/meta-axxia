require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.72"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "4274a1046f3af2cb9e02b397d2e70cafdee5acb6"
KBRANCH_axxiaarm64 = "v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "4274a1046f3af2cb9e02b397d2e70cafdee5acb6"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
