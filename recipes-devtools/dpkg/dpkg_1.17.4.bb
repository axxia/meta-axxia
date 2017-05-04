FILESEXTRAPATHS_prepend := "${COREBASE}/meta/recipes-devtools/${PN}/${PN}:"

require recipes-devtools/${PN}/${PN}_1.17.1.bb

LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI += "file://dpkg-configure.service \
            file://glibc2.5-sync_file_range.patch \
            file://no-vla-warning.patch \
            file://dpkg-1.17.4-CVE-2014-0471.patch \
            file://dpkg-1.17.4-CVE-2014-0471-CVE-2014-3127.patch \
           "

SRC_URI[md5sum] = "cc25086e1e3bd9512a95f14cfe9002e1"
SRC_URI[sha256sum] = "01cdc81c33e77c3d7c40df17e19171794542be7cf12e411381ffcaa8f87b1854"

DEPENDS_class-native = "bzip2-replacement-native zlib-native virtual/update-alternatives-native gettext-native perl-native"
RDEPENDS_${PN} = "${VIRTUAL-RUNTIME_update-alternatives} xz run-postinsts"
RDEPENDS_${PN}_class-native = "xz-native"

python () {
    if not oe.utils.contains('DISTRO_FEATURES', 'sysvinit', True, False, d):
        pn = d.getVar('PN', True)
        d.setVar('SYSTEMD_SERVICE_%s' % (pn), 'dpkg-configure.service')
}

EXTRA_OECONF = " --disable-dselect \
		--enable-start-stop-daemon \
		--with-zlib \
		--with-bz2 \
		--without-liblzma \
		--without-selinux \
		"

do_install_append () {
	if ${@base_contains('DISTRO_FEATURES','sysvinit','false','true',d)};then
		install -d ${D}${systemd_unitdir}/system
		install -m 0644 ${WORKDIR}/dpkg-configure.service ${D}${systemd_unitdir}/system/
		sed -i -e 's,@BASE_BINDIR@,${base_bindir},g' \
			-e 's,@SYSCONFDIR@,${sysconfdir},g' \
			-e 's,@BINDIR@,${bindir},g' \
			-e 's,@SYSTEMD_UNITDIR@,${systemd_unitdir},g' \
			${D}${systemd_unitdir}/system/dpkg-configure.service
	fi
}
