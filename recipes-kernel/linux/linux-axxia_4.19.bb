require linux-axxia.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KV = "4.19"
LINUX_VERSION = "4.19.19"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "v4.19/standard/axxia-dev/base-11e0e61"
SRCREV_machine_axxiaarm = "34de7a6754c853011d6a02bd1df3412b5e9791ca"
KBRANCH_axxiaarm64 = "v4.19/standard/axxia-dev/base-11e0e61"
SRCREV_machine_axxiaarm64 = "34de7a6754c853011d6a02bd1df3412b5e9791ca"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"