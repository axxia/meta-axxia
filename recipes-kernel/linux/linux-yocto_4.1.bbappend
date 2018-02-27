FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

inherit axxia-kernel

KV = "4.1"
LINUX_VERSION = "4.1.48"

KBRANCH_axxiaarm = "standard/axxia/base"
SRCREV_machine_axxiaarm = "909c98a4f6512eaca1c975469d58b46b7326b8e9"
KBRANCH_axxiaarm64 = "standard/axxia/base"
SRCREV_machine_axxiaarm64 = "909c98a4f6512eaca1c975469d58b46b7326b8e9"
KBRANCH_axxiapowerpc = "standard/axxia/base"
SRCREV_machine_axxiapowerpc = "909c98a4f6512eaca1c975469d58b46b7326b8e9"

SRCREV_meta = "4e12cb8f8e06636f2058ea0ab3096ed38228a88b"

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
