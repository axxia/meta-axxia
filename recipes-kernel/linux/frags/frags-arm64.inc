# adding fragments with kernel options to the final .config
SRC_URI += "file://common.scc file://lxc.scc file://${LINUX_KERNEL_TYPE}.scc \
	${@base_conditional('DBG', 'yes', 'file://dbg.scc', '', d)} \
	${@base_conditional('TESTING', 'yes', 'file://testing.scc', '', d)} "

# adding fragment to distinguish between X9 and XLF
SRC_URI += "${@base_conditional('CHIPSET', 'XLF', 'file://xlf.scc', '', d)}"
