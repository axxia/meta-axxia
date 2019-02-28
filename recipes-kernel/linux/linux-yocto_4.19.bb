FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/frags/${KV}/${MACHINE}/common\
:${THISDIR}/frags/${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH}; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.12;destsuffix=${KMETA}"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.19"
LINUX_VERSION = "4.19.14"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

KBRANCH_axxiaarm = "v4.19/standard/base"
SRCREV_machine_axxiaarm = "eebb51300a07804a020ec468b5f8c5bf720198d9"
KBRANCH_axxiaarm64 = "v4.19/standard/base"
SRCREV_machine_axxiaarm64 = "eebb51300a07804a020ec468b5f8c5bf720198d9"

SRCREV_meta = "70d33ded25747f73381baff8d8758e86967e4ee2"

SRC_URI_append = " file://fit"

require dt/dt-${KARCH}.inc
require frags.inc

COMPATIBLE_MACHINE = "axxiaarm|axxiaarm64"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
