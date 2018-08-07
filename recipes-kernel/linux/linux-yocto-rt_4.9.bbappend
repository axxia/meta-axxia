FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.9"
LINUX_VERSION = "4.9.113"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm = "ed3ef33cadb612cb45faab048ad8771e8f13d110"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm64 = "ed3ef33cadb612cb45faab048ad8771e8f13d110"

SRCREV_meta = "5e993963afb54bdc82a02077c29ecdbc0b12368e"

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
