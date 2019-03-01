require linux-yocto.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA} \
           file://fit"

KV = "4.19"
LINUX_VERSION = "4.19.14"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/base"
SRCREV_machine_axxiaarm = "7a0b04e5a8d036cd9dcc6ee64a838e8d8d5cdd56"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/base"
SRCREV_machine_axxiaarm64 = "7a0b04e5a8d036cd9dcc6ee64a838e8d8d5cdd56"

SRCREV_meta = "41fe45f7c5e69f6ec26c657fea16c459544042cf"

require frags.inc