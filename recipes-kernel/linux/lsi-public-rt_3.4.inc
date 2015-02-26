
require linux-yocto.inc

LSI_KERNEL_TAG = "7.8.1.41"
LINUX_VERSION = "3.4.88-${LSI_KERNEL_TAG}"

KBRANCH = "standard/preempt-rt/lsi/base"
KREPO = "git://github.com/lsigithub/lsi_axxia_yocto_public.git"

SRCREV_machine="9f93c826370adecdcd5cbe6de7d5761f6062b258"
SRCREV_meta="03cd6f841fd2566b033db19eb6665228ea406adf"
