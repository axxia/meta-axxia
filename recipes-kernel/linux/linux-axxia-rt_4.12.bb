FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.12"
LINUX_VERSION = "4.12.18"
LINUX_KERNEL_TYPE = "preempt-rt"
PV = "${LINUX_VERSION}+git${SRCPV}"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "9a9ed85698dc664f0bf2ea0f7212ed7aa1119b88"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "9a9ed85698dc664f0bf2ea0f7212ed7aa1119b88"

KMETA = ""

KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_4.12_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           file://fit \
           file://defconfig"

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "axxiaarm|axxiaarm64"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
