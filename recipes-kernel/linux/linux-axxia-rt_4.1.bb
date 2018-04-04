FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${CHIPSET}/${LINUX_KERNEL_TYPE}:\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

inherit axxia-kernel

KV = "4.1"
LINUX_VERSION = "4.1.49"
LINUX_KERNEL_TYPE = "preempt-rt"
PV = "${LINUX_VERSION}+git${SRCPV}"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "98ae380a61d1fc72141e3e12f3720de0e730a896"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "98ae380a61d1fc72141e3e12f3720de0e730a896"
KBRANCH_axxiapowerpc = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiapowerpc = "98ae380a61d1fc72141e3e12f3720de0e730a896"

KMETA = ""

KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_4.1_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           file://fit \
           file://defconfig"

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "axxiaarm|axxiaarm64|axxiapowerpc"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
