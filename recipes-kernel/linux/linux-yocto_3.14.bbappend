FILESEXTRAPATHS_prepend := "${THISDIR}:"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

AXXIA_SRC ?= "linux-yocto"
SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KV = "3.14"
KERNEL_EXTRA_FEATURES = ""

# 3.14 Github Kernel didn't have public version. Reset AXXIA_SRC to "linux-yocto" in this case
AXXIA_SRC_RESET = "${@base_conditional('AXXIA_SRC', 'axxia-public', 'linux-yocto', '${AXXIA_SRC}',  d)}"

require ${AXXIA_SRC_RESET}_3.14.inc
