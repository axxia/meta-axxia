FILESEXTRAPATHS_prepend := "${THISDIR}:"

LINUX_KERNEL_TYPE = "standard"
LSI_SRC ?= "linux-yocto"
KV = "3.4"
KERNEL_EXTRA_FEATURES = ""

require ${LSI_SRC}_3.4.inc
