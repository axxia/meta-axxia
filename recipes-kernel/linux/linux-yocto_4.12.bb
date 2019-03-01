require linux-yocto.inc

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.12.git;branch=${KBRANCH};name=machine  \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.12;destsuffix=${KMETA} \
           file://fit"

KV = "4.12"
LINUX_VERSION = "4.12.26"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "standard/axxia/base"
SRCREV_machine_axxiaarm = "0cc7457bcc6e3d8a1ac05e27c95a83e72fd9a2b7"
KBRANCH_axxiaarm64 = "standard/axxia/base"
SRCREV_machine_axxiaarm64 = "0cc7457bcc6e3d8a1ac05e27c95a83e72fd9a2b7"

SRCREV_meta = "12333728637b4fc73c48cc742e444cb5f60485fd"

require frags.inc