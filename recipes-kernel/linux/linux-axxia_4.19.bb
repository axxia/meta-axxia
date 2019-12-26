LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.87"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "next/v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "512a4ad052ff21c59d29e69a66299bafc5a0452d"
KBRANCH_axxiaarm64 = "next/v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "512a4ad052ff21c59d29e69a66299bafc5a0452d"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
