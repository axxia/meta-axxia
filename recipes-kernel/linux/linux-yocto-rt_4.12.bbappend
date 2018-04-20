FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.12"
LINUX_VERSION = "4.12.22"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm = "2905ec8392a07705c21daac2da3c938c57c29062"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm64 = "2905ec8392a07705c21daac2da3c938c57c29062"

SRCREV_meta = "e10da92d2984c77ed67be9722e4a39af9d025e2f"

SRC_URI_append = " file://fit"

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
