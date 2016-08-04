FILESEXTRAPATHS_prepend := "${THISDIR}:"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

AXXIA_SRC ?= "linux-yocto"
SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KV = "3.10"
KERNEL_EXTRA_FEATURES = ""

require ${AXXIA_SRC}_3.10.inc
