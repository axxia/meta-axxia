FILESEXTRAPATHS_prepend := "${THISDIR}:\
${THISDIR}/${PN}/linux-3.4/${KARCH}:\
${THISDIR}/conf/linux-3.4/${MACHINE}:"

LINUX_KERNEL_TYPE = "standard"
LSI_SRC ?= "linux-yocto"
KV = "3.4"
KERNEL_EXTRA_FEATURES = ""

require ${LSI_SRC}_3.4.inc
