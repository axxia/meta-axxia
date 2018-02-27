FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.12"
LINUX_VERSION = "4.12.16"

KBRANCH_axxiaarm = "standard/axxia/base"
SRCREV_machine_axxiaarm = "4226b065fca4f630901d99b99d18c395ae3866fb"
KBRANCH_axxiaarm64 = "standard/axxia/base"
SRCREV_machine_axxiaarm64 = "4226b065fca4f630901d99b99d18c395ae3866fb"

SRCREV_meta = "19d815d5a34bfaad95d87cc097cef18b594daac8"

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
