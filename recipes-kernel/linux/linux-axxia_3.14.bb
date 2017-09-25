FILESEXTRAPATHS_prepend := "${THISDIR}:\
${THISDIR}/conf/axxia-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

inherit axxia-kernel

KV = "3.14"
LINUX_VERSION = "3.14.62"
LINUX_KERNEL_TYPE = "standard"
PV = "${LINUX_VERSION}+git${SRCPV}"

KBRANCH = "standard/axxia-dev/base"
KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_3.14_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};branch=${KBRANCH};name=machine \
           file://fit \
           file://defconfig"
SRCREV_machine ="${AUTOREV}"
KMETA = ""

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
