FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

inherit axxia-kernel

KV = "4.1"
LINUX_VERSION = "4.1.52"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm = "76224309c35a0cd07c4871caf29df84b66683859"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiaarm64 = "76224309c35a0cd07c4871caf29df84b66683859"
KBRANCH_axxiapowerpc = "standard/preempt-rt/axxia/base"
SRCREV_machine_axxiapowerpc = "76224309c35a0cd07c4871caf29df84b66683859"

SRCREV_meta = "7c153e20d0ebb26db087d508f2c2be4a5a69a870"

SRC_URI_append = " file://fit"

require dt/dt-${KARCH}.inc
require frags/frags-${KARCH}.inc

COMPATIBLE_MACHINE_append = "|axxiaarm|axxiaarm64|axxiapowerpc"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
