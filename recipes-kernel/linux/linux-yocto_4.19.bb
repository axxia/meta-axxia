LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA} \
           file://fit"

LINUX_VERSION = "4.19.14"
LINUX_KERNEL_TYPE = "standard"

KBRANCH_axxiaarm = "v4.19/standard/base"
SRCREV_machine_axxiaarm = "eebb51300a07804a020ec468b5f8c5bf720198d9"
KBRANCH_axxiaarm64 = "v4.19/standard/base"
SRCREV_machine_axxiaarm64 = "eebb51300a07804a020ec468b5f8c5bf720198d9"

SRCREV_meta = "41fe45f7c5e69f6ec26c657fea16c459544042cf"

require linux-yocto.inc
require frags.inc
