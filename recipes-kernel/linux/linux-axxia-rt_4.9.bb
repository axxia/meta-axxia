FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/patches/${KV}\
:${THISDIR}/conf/axxia-${KV}/${MACHINE}/${RUNTARGET}/${LINUX_KERNEL_TYPE}:"

require recipes-kernel/linux/linux-yocto.inc

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.9"
LINUX_VERSION = "4.9.61"
LINUX_KERNEL_TYPE = "preempt-rt"
PV = "${LINUX_VERSION}+git${SRCPV}"

# "simics" for simulation system or "frio" for FPGA emulation system
RUNTARGET ?= "simics"
FRIO_PATCHES = "file://FRIO-0001-PCI-ASPM-Don-t-retrain-link.patch \
                file://FRIO-0002-pci-driver-HACK-reassign-Altera-FPGAs-if-they-have-n.patch \
                file://FRIO-0003-pci-driver-HACK-hardcode-size-of-bridge-window-to-NC.patch \
                file://FRIO-0004-pci-driver-HACK-don-t-allocate-additional-bridge-win.patch \
                file://FRIO-0005-pci-driver-HACK-merge-for-Altera.patch \
                file://FRIO-0006-kernel-Fix-a-Compile-Warning.patch "

KBRANCH = "standard/preempt-rt/axxia-dev/base"
KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_4.9_private.git;protocol=ssh"
SRC_URI = "${KREPO_KERNEL};name=machine;branch=${KBRANCH} \
           file://COMMON-0001-intel_th-pci-Add-Cedar-Fork-PCH-support.patch \
           file://COMMON-0002-drivers-pinctrl-Backport-Cedar-Fork-GPIO.patch \
           ${@base_conditional('RUNTARGET', 'frio', '${FRIO_PATCHES}', '', d)} \
           file://fit \
           file://defconfig"
SRCREV_machine ="${AUTOREV}"
KMETA = ""

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiaarm64$|^axxiax86-64$"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""