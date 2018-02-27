FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.12"
LINUX_VERSION = "4.12.18"
LINUX_KERNEL_TYPE = "standard"
PV = "${LINUX_VERSION}+git${SRCPV}"

KBRANCH_axxiaarm = "standard/axxia-dev/base"
SRCREV_machine_axxiaarm = "b5bd65eede6348b686384be326d758b69529c6ac"
KBRANCH_axxiaarm64 = "standard/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "b5bd65eede6348b686384be326d758b69529c6ac"

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
