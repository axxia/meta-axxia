inherit systemd

systemd_postinst() {
OPTS=""

if [ -n "$D" ]; then
    OPTS="--root=$D"
fi

if type systemctl >/dev/null 2>/dev/null; then
	systemctl $OPTS ${SYSTEMD_AUTO_ENABLE} ${SYSTEMD_SERVICE}

	if [ -z "$D" -a "${SYSTEMD_AUTO_ENABLE}" = "enable" ]; then
		systemctl --no-block restart ${SYSTEMD_SERVICE}
	fi
fi
}
