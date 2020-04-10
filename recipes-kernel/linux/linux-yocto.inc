LINUX_VERSION_standard = "4.19.14"
LINUX_VERSION_preempt-rt = "4.19.14"
KBRANCH_standard = "v4.19/standard/base"
KBRANCH_preempt-rt = "v4.19/standard/preempt-rt/base"
SRCREV_standard = "eebb51300a07804a020ec468b5f8c5bf720198d9"
SRCREV_preempt-rt = "7a0b04e5a8d036cd9dcc6ee64a838e8d8d5cdd56"
SRCREV_meta = "41fe45f7c5e69f6ec26c657fea16c459544042cf"

FILESEXTRAPATHS_prepend := "${THISDIR}\
:${THISDIR}/frags/${KERNEL_MAJOR_VERSION}/${MACHINE}/common\
:${THISDIR}/frags/${KERNEL_MAJOR_VERSION}/${MACHINE}/${LINUX_KERNEL_TYPE}:"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

LINUX_VERSION_EXTENSION = "-yocto-axxia-${LINUX_KERNEL_TYPE}"
KERNEL_MAJOR_VERSION = "${@'.'.join(d.getVar('PV').split('.')[0:2])}"

SRC_URI = "git://git.yoctoproject.org/linux-yocto.git;branch=${KBRANCH};name=machine \
           git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.19;destsuffix=${KMETA} \
           file://fit"

require linux-common.inc
require frags.inc

KMETA = "kernel-meta"
KCONF_BSP_AUDIT_LEVEL = "2"

LINUX_VERSION_pn-linux-yocto = "${LINUX_VERSION_standard}"
LINUX_VERSION_pn-linux-yocto-debug = "${LINUX_VERSION_standard}"
LINUX_VERSION_pn-linux-yocto-rt = "${LINUX_VERSION_preempt-rt}"
LINUX_VERSION_pn-linux-yocto-rt-debug = "${LINUX_VERSION_preempt-rt}"

KBRANCH_pn-linux-yocto = "${KBRANCH_standard}"
KBRANCH_pn-linux-yocto-debug = "${KBRANCH_standard}"
KBRANCH_pn-linux-yocto-rt = "${KBRANCH_preempt-rt}"
KBRANCH_pn-linux-yocto-rt-debug = "${KBRANCH_preempt-rt}"

SRCREV_machine_pn-linux-yocto = "${SRCREV_standard}"
SRCREV_machine_pn-linux-yocto-debug = "${SRCREV_standard}"
SRCREV_machine_pn-linux-yocto-rt = "${SRCREV_preempt-rt}"
SRCREV_machine_pn-linux-yocto-rt-debug = "${SRCREV_preempt-rt}"
