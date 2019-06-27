require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.30"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "ba4618300b3f195ca24165d72973e2c3b40d4bea"
KBRANCH_axxiaarm64 = "v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "ba4618300b3f195ca24165d72973e2c3b40d4bea"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
