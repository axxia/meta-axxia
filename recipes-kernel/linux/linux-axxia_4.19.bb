LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.72"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "next/v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "18af0058be64c8966372827ad8431d404b505f8e"
KBRANCH_axxiaarm64 = "next/v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "18af0058be64c8966372827ad8431d404b505f8e"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
