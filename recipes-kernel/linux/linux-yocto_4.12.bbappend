FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.12"
LINUX_VERSION = "4.12.26"

KBRANCH_axxiaarm = "standard/axxia/base"
SRCREV_machine_axxiaarm = "0cc7457bcc6e3d8a1ac05e27c95a83e72fd9a2b7"
KBRANCH_axxiaarm64 = "standard/axxia/base"
SRCREV_machine_axxiaarm64 = "0cc7457bcc6e3d8a1ac05e27c95a83e72fd9a2b7"

SRCREV_meta = "99bef6252a7b9b5e38ea15112e9466ed6974a3fe"

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
