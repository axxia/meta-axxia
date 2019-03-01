require linux-yocto.inc

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.12.git;branch=${KBRANCH};name=machine  \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.12;destsuffix=${KMETA} \
           file://fit"

KV = "4.12"
LINUX_VERSION = "4.12.26"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm = "2e982f7facf93ce5cd6d6991d082087f6cd3c63d"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm64 = "2e982f7facf93ce5cd6d6991d082087f6cd3c63d"

SRCREV_meta = "12333728637b4fc73c48cc742e444cb5f60485fd"

require frags.inc