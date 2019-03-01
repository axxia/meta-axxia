require linux-axxia.inc

KV = "4.12"
LINUX_VERSION = "4.12.26"
LINUX_KERNEL_TYPE = "preempt-rt"

KBRANCH_axxiaarm = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm = "522132578669a8c5dbf14b025dbc8410d67b8029"
KBRANCH_axxiaarm64 = "standard/preempt-rt/axxia-dev/base"
SRCREV_machine_axxiaarm64 = "522132578669a8c5dbf14b025dbc8410d67b8029"

KREPO_KERNEL = "git://git@github.com/axxia/axxia_yocto_linux_4.12_private.git;protocol=ssh"