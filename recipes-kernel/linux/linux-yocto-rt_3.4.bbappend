FILESEXTRAPATHS_prepend := "${THISDIR}:"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

LSI_SRC ?= "linux-yocto"
SMP ?= "yes"
TESTING ?= "no"
KV = "3.4"
KERNEL_EXTRA_FEATURES = ""
KERNEL_FEATURES_${MACHINE}_append = ""

require ${LSI_SRC}-rt_3.4.inc