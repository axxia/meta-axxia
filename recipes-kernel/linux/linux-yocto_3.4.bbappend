FILESEXTRAPATHS_prepend := "${THISDIR}:"

COMPATIBLE_MACHINE = "^axxiaarm$|^axxiapowerpc$"
INSANE_SKIP_kernel-dev = "debug-files"
PARALLEL_MAKE = ""

LSI_SRC ?= "linux-yocto"
TESTING ?= "no"
KV = "3.4"
KERNEL_EXTRA_FEATURES = ""

require ${LSI_SRC}_3.4.inc
