SUMMARY = "Kexec fast reboot tools"
DESCRIPTION = "Kexec is a fast reboot feature that lets you reboot to a new Linux kernel"
AUTHOR = "Eric Biederman"
HOMEPAGE = "http://kernel.org/pub/linux/utils/kernel/kexec/"
SECTION = "kernel/userland"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=ea5bed2f60d357618ca161ad539f7c0a \
                    file://kexec/kexec.c;beginline=1;endline=20;md5=af10f6ae4a8715965e648aa687ad3e09"

DEPENDS = "zlib xz"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/geoff/kexec-tools.git \
           file://string-add-const-to-the-memcmp-function.patch"

SRCREV ="${AUTOREV}"

PV = "2.0.13+gitr${SRCPV}"
PR = "r1"

S = "${WORKDIR}/git"

inherit autotools

COMPATIBLE_HOST = '(x86_64.*|i.86.*|arm.*|aarch64.*|powerpc.*|mips.*)-(linux|freebsd.*)'

INSANE_SKIP_${PN} = "arch"

do_configure_prepend() {
    cd ${S}
    ./bootstrap
    cd -
}

do_compile_prepend() {
    # Remove the '*.d' file to make sure the recompile is OK
    for dep in `find ${B} -type f -name '*.d'`; do
        dep_no_d="`echo $dep | sed 's#.d$##'`"
        # Remove file.d when there is a file.o
        if [ -f "$dep_no_d.o" ]; then
            rm -f $dep
        fi
    done
}

export LDFLAGS = "-L${STAGING_LIBDIR}"
EXTRA_OECONF = " --with-zlib=yes"

PACKAGES =+ "kexec kdump vmcore-dmesg"

ALLOW_EMPTY_${PN} = "1"
RRECOMMENDS_${PN} = "kexec kdump vmcore-dmesg"

FILES_kexec = "${sbindir}/kexec"
FILES_kdump = "${sbindir}/kdump"
FILES_vmcore-dmesg = "${sbindir}/vmcore-dmesg"
