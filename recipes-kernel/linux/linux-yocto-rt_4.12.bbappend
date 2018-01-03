FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/patches/${KV}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/common\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}\
:${THISDIR}/conf/yocto-${KV}/${MACHINE}/${RUNTARGET}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

KV = "4.12"
LINUX_VERSION = "4.12.16"
KBRANCH = "standard/preempt-rt/axxia/base"
SRCREV_machine = "51c45f6489df4cdbce78e9c90b8a26fa7e7c875c"
SRCREV_meta = "3574bb061c1bfbdcf4df8308870c03f88ef0788f"

# skip yocto-kernel-cache for axxiax86_64 to use full defconfig untill we'll have fragments upstream
KMETA_SOURCES = "git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.12;destsuffix=${KMETA}"

# "simics" for simulation system or "frio" for FPGA emulation system
RUNTARGET ?= "simics"

SIMICS_PATCHES = " \
file://SIMICS-0001-intel_th-pci-Add-Cedar-Fork-PCH-support.patch \
file://SIMICS-0002-pinctrl-intel-Add-support-for-variable-size-pad-grou.patch \
file://SIMICS-0003-pinctrl-intel-Make-it-possible-to-specify-mode-per-p.patch \
file://SIMICS-0004-pinctrl-intel-Add-Intel-Denverton-pin-controller-sup.patch \
file://SIMICS-0005-i2c-i801-Add-support-for-Intel-Cedar-Fork.patch \
file://SIMICS-0006-pinctrl-intel-Make-offset-to-interrupt-status-regist.patch \
file://SIMICS-0007-pinctrl-intel-Add-Intel-Cedar-Fork-PCH-pin-controlle.patch \
"

FRIO_PATCHES = " \
file://FRIO-0001-PCI-ASPM-Don-t-retrain-link.patch \
file://FRIO-0002-pci-driver-HACK-reassign-Altera-FPGAs-if-they-have-n.patch \
file://FRIO-0003-pci-driver-HACK-hardcode-size-of-bridge-window-to-NC.patch \
file://FRIO-0004-pci-driver-HACK-don-t-allocate-additional-bridge-win.patch \
file://FRIO-0005-pci-driver-HACK-merge-for-Altera.patch \
"

SRC_URI = "git://git.yoctoproject.org/linux-yocto-4.12.git;name=machine;branch=${KBRANCH}; \
           ${@base_conditional('MACHINE', 'axxiax86-64', '', '${KMETA_SOURCES}', d)} \
           ${@base_conditional('RUNTARGET', 'frio', '${FRIO_PATCHES}', '', d)} \
           ${@base_conditional('RUNTARGET', 'simics', '${SIMICS_PATCHES}', '', d)} \
           file://fit \
"

require dt/dt-${KARCH}.inc
require frags/frags-${KARCH}.inc

# use full defconfig for axxiax86_64 untill we'll have fragments upstream
SRC_URI += "${@base_conditional('MACHINE', 'axxiax86-64', 'file://defconfig', '', d)}"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiaarm64$|^axxiax86-64$"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""
