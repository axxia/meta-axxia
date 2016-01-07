# adding fragments with kernel options to the final .config
SRC_URI += "file://common.scc \
	${@base_conditional('SMP', 'yes', 'file://smp.scc', 'file://no-smp.scc', d)} \
	${@base_conditional('LINUX_KERNEL_TYPE', 'preempt-rt', '', 'file://standard.scc', d)} \
	${@base_conditional('TESTING', 'yes', 'file://testing.scc', '', d)} "