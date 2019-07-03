require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.30"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "c80285751a82d3a8533d9778e40da6f71869ad93"
KBRANCH_axxiaarm64 = "v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "c80285751a82d3a8533d9778e40da6f71869ad93"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"
