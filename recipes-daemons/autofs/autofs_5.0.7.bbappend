do_install_append () {
    if [ -d ${D}/run ]; then
        rmdir ${D}/run
    fi
    if [ -d ${D}${localstatedir}/run ]; then
        rmdir ${D}${localstatedir}/run
    fi
}
