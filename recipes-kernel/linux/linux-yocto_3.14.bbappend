FILESEXTRAPATHS_prepend := "${THISDIR}:"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

LSI_SRC ?= "linux-yocto"
SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KV = "3.14"
KERNEL_EXTRA_FEATURES = ""

# 3.14 Github Kernel didn't have public version. Reset LSI_SRC to "linux-yocto" in this case
LSI_SRC_RESET = "${@base_conditional('LSI_SRC', 'lsi-public', 'linux-yocto', '${LSI_SRC}',  d)}"

require ${LSI_SRC_RESET}_3.14.inc
