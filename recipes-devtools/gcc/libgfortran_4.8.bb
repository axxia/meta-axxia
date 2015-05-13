FILESEXTRAPATHS_prepend := "${@base_set_filespath([bb.utils.which(BBPATH, 'recipes-devtools/gcc/gcc-${PV}', direction=True)], d)}" 

require recipes-devtools/gcc/gcc-${PV}.inc
require recipes-devtools/gcc/gcc-configure-common.inc

EXTRA_OECONF_PATHS = "\
    --with-sysroot=${STAGING_DIR_TARGET} \
    --with-build-sysroot=${STAGING_DIR_TARGET} \
"

do_configure () {
	mtarget=`echo ${MULTIMACH_TARGET_SYS} | sed -e s#-${SDKPKGSUFFIX}##`
	target=`echo ${TARGET_SYS} | sed -e s#-${SDKPKGSUFFIX}##`
	cp -fpPR ${STAGING_INCDIR_NATIVE}/gcc-build-internal-$mtarget/* ${B}
	
	echo "Configuring libgfortran"
	rm -rf ${B}/$target/libgfortran/
	mkdir -p ${B}/$target/libgfortran/
	cd ${B}/$target/libgfortran/
	chmod a+x ${S}/libgfortran/configure
	${S}/libgfortran/configure ${CONFIGUREOPTS} ${EXTRA_OECONF}
	# Easiest way to stop bad RPATHs getting into the library since we have a
	# broken libtool here
	sed -i -e 's/hardcode_into_libs=yes/hardcode_into_libs=no/' ${B}/$target/libgfortran/libtool

	# Correct invalid libgcc symlinks with wrong target path.
	cd ${B}/$target/libgcc
	for d in enable-execute-stack.c gthr-default.h md-unwind-support.h sfp-machine.h unwind.h; do
		if [ ! -e "$d" ]; then
			ln -f -s ./../$(readlink $d) $d
		fi
	done
}

do_compile () {
	target=`echo ${TARGET_SYS} | sed -e s#-${SDKPKGSUFFIX}##`
	cd ${B}/$target/libgfortran/
	oe_runmake MULTIBUILDTOP=${B}/$target/libgfortran/
}

do_install () {
	target=`echo ${TARGET_SYS} | sed -e s#-${SDKPKGSUFFIX}##`
	cd ${B}/$target/libgfortran/
	oe_runmake 'DESTDIR=${D}' MULTIBUILDTOP=${B}/$target/libgfortran/ install
	if [ -d ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/finclude ]; then
		rmdir --ignore-fail-on-non-empty -p ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/finclude
	fi
	if [ -d ${D}${infodir} ]; then
		rmdir --ignore-fail-on-non-empty -p ${D}${infodir}
	fi
	chown -R root:root ${D}
}

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "gcc-runtime"

BBCLASSEXTEND = "nativesdk"

PACKAGES = "\
    ${PN} \
    ${PN}-dbg \
    ${PN}-dev \
    ${PN}-staticdev \
"
FILES_${PN} = "${libdir}/libgfortran.so.*"
FILES_${PN}-dev = "\
    ${libdir}/libgfortran*.so \
    ${libdir}/libgfortran.spec \
    ${libdir}/libgfortran.la \
    ${libdir}/gcc/${TARGET_SYS}/${BINV}/libgfortranbegin.* \
    ${libdir}/gcc/${TARGET_SYS}/${BINV}/libcaf_single* \
"
FILES_${PN}-staticdev = "${libdir}/libgfortran.a"

INSANE_SKIP_${MLPREFIX}libgfortran-dev = "staticdev"

do_package_write_ipk[depends] += "virtual/${MLPREFIX}libc:do_packagedata"
do_package_write_deb[depends] += "virtual/${MLPREFIX}libc:do_packagedata"
do_package_write_rpm[depends] += "virtual/${MLPREFIX}libc:do_packagedata"

python __anonymous () {
    f = d.getVar("FORTRAN", True)
    if "fortran" not in f:
        raise bb.parse.SkipPackage("libgfortran needs fortran support to be enabled in the compiler")
}
