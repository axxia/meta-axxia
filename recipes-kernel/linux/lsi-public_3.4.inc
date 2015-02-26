
require linux-yocto.inc

LSI_KERNEL_TAG = "7.8.1.41"
LINUX_VERSION = "3.4.88-${LSI_KERNEL_TAG}"

KBRANCH = "standard/lsi/base"
KREPO = "git://github.com/lsigithub/lsi_axxia_yocto_public.git"

SRCREV_machine="7b725b5147553a4f4013daf0e9dcf2dd46f94f4c"
SRCREV_meta="03cd6f841fd2566b033db19eb6665228ea406adf"
