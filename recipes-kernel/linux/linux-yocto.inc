require recipes-kernel/linux/linux-yocto.inc

FILESEXTRAPATHS_prepend := "\
${THISDIR}\
:${THISDIR}/frags/${KV}/${MACHINE}/common\
:${THISDIR}/frags/${KV}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

DEPENDS += "u-boot-mkimage-native dtc-native"

PV = "${LINUX_VERSION}+git${SRCPV}"

LINUX_VERSION_EXTENSION = "-yocto-axxia-${LINUX_KERNEL_TYPE}"

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

require dt/dt-${KARCH}.inc

COMPATIBLE_MACHINE = "axxiaarm|axxiaarm64"
INSANE_SKIP_kernel-dev = "debug-files"

SMP ?= "yes"
POWER_MANAGEMENT ?= "low-power"
CHIPSET ?= "5500"
BIG_ENDIAN ?= "no"
DBG ?= "no"
TESTING ?= "no"
KERNEL_EXTRA_FEATURES = ""

kernel_do_deploy_append() {
	install -d ${DEPLOYDIR}
	install -m 0644 ${KBUILD_OUTPUT}/System.map \
		${DEPLOYDIR}/System${KERNEL_ARTIFACT_NAME}.map
	cd ${DEPLOYDIR}
	rm -f System.map
	ln -sf System${KERNEL_ARTIFACT_NAME}.map System.map
}
