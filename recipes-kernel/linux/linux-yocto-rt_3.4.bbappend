FILESEXTRAPATHS_prepend := "${THISDIR}:"

LINUX_KERNEL_TYPE = "preempt-rt"
LSI_SRC ?= "linux-yocto"
KV = "3.4"
KERNEL_EXTRA_FEATURES = ""

require ${LSI_SRC}-rt_3.4.inc
