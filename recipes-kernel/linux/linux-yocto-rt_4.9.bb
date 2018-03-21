FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

inherit axxia-kernel

KV = "4.9"
LINUX_VERSION = "4.9.71"
LINUX_KERNEL_TYPE = "preempt-rt"
PV = "${LINUX_VERSION}+git${SRCPV}"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm = "d2a54ff45e6c5e9b9a3c47ff5675622859f1f1a4"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm64 = "d2a54ff45e6c5e9b9a3c47ff5675622859f1f1a4"

KMETA = "kernel-meta"
SRCREV_meta = "688a904c38ecfdc36c23eafc8e93aadc2c537535"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.9.git;name=machine;branch=${KBRANCH}; \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.9;destsuffix=${KMETA} \
           file://fit"

require dt/dt-${KARCH}.inc
require frags/frags-${KARCH}.inc

COMPATIBLE_MACHINE_append = "|axxiaarm|axxiaarm64"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
