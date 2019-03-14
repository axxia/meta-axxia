do_install_append() {
	# Manually disable resolved service since the use of SYSTEMD_AUTO_ENABLE has no effect
	rm -rf ${D}${sysconfdir}/systemd/system/multi-user.target.wants/systemd-resolved.service
}
