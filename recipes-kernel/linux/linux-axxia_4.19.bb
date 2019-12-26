LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION = "4.19.72"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "next/v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "a6815e42e2a2f16efff6c3036ccc083e280af734"
KBRANCH_axxiaarm64 = "next/v4.19/standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "a6815e42e2a2f16efff6c3036ccc083e280af734"

KREPO_KERNEL = "git://git@github.com/axxia/linux-yocto_private.git;protocol=ssh"

require linux-axxia.inc
