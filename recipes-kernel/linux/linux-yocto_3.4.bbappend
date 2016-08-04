FILESEXTRAPATHS_prepend := "${THISDIR}:"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

AXXIA_SRC ?= "linux-yocto"
SMP ?= "yes"
TESTING ?= "no"
KV = "3.4"
KERNEL_EXTRA_FEATURES = ""

require ${AXXIA_SRC}_3.4.inc
