# For axxiaarm machine
# adding fragments with kernel options to the final .config
SRC_URI_append_axxiaarm = " \
	file://common.scc file://lxc.scc file://uprobe.scc \
	${@oe.utils.conditional('SMP', 'no', 'file://no-smp.scc', '', d)} \
	${@oe.utils.conditional('LINUX_KERNEL_TYPE', 'preempt-rt', 'file://preempt-rt.scc', 'file://standard.scc', d)} \
	${@oe.utils.conditional('BIG_ENDIAN', 'yes', 'file://big-endian.scc', '', d)} \
	${@oe.utils.conditional('DBG', 'yes', 'file://dbg.scc', '', d)} \
	${@oe.utils.conditional('TESTING', 'yes', 'file://testing.scc', '', d)} "

# cpu hotplug  options: low power (default), full power down, full power down with L2 cache
SRC_URI_append_axxiaarm = " \
	${@oe.utils.conditional('POWER_MANAGEMENT', 'full-power', 'file://full-power.scc', '', d)} \
	${@oe.utils.conditional('POWER_MANAGEMENT', 'full-power-L2', 'file://full-power-L2.scc', '', d)} \
	${@oe.utils.conditional('POWER_MANAGEMENT', 'low-power', 'file://low-power.scc', '', d)} "


# For axxiaarm64 machine
# adding fragments with kernel options to the final .config
SRC_URI_append_axxiaarm64 = " \
	file://common.scc file://lxc.scc file://${LINUX_KERNEL_TYPE}.scc \
	${@oe.utils.conditional('DBG', 'yes', 'file://dbg.scc', '', d)} \
	${@oe.utils.conditional('TESTING', 'yes', 'file://testing.scc', '', d)} "

# adding fragment to distinguish between X9 and XLF
SRC_URI_append_axxiaarm64 = " \
	${@oe.utils.conditional('CHIPSET', 'XLF', 'file://xlf.scc', '', d)}"
