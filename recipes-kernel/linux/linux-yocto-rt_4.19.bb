FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;name=machine;branch=${KBRANCH}; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.12;destsuffix=${KMETA}"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.19"
LINUX_VERSION = "4.19.14"

PV = "${LINUX_VERSION}+git${SRCPV}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

KBRANCH_axxiaarm = "v4.19/standard/preempt-rt/base"
SRCREV_machine_axxiaarm = "7a0b04e5a8d036cd9dcc6ee64a838e8d8d5cdd56"
KBRANCH_axxiaarm64 = "v4.19/standard/preempt-rt/base"
SRCREV_machine_axxiaarm64 = "7a0b04e5a8d036cd9dcc6ee64a838e8d8d5cdd56"

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
