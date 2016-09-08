FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN}-bin = "python3-core"

SRCREV = "514a87f3b64181e384399935a5708a8f85b0cc83"
PV = "2.8.1+git${SRCPV}"

SRC_URI = "git://git.lttng.org/lttng-ust.git;branch=stable-2.8 \
           file://lttng-ust-doc-man-examples-disable.patch \
          "

EXTRA_OECONF += "--disable-man-pages"

do_install_append() {
        # Patch python tools to use Python 3; they should be source compatible, but
        # still refer to Python 2 in the shebang
        sed -i -e '1s,#!.*python.*,#!${bindir}/python3,' ${D}${bindir}/lttng-gen-tp
}
