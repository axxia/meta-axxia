do_install_append() {
    (
    cd ${S}
    # copy all Kbuild and *.mk files for "clean" target
    cp --parents $(find  -type f -name "Kbuild*" -o -name "*.mk") $kerneldir/build
    # copy removed Makefile from documentation dir for "clean" target
    cp -a --parents Documentation/Makefile $kerneldir/build/

    # these are a few files associated with objtool, since we'll need to
    # rebuild it
    cp -a --parents tools/build/Build.include $kerneldir/build/
    cp -a --parents tools/build/Build $kerneldir/build/
    cp -a --parents tools/build/fixdep.c $kerneldir/build/
    cp -a --parents tools/scripts/utilities.mak $kerneldir/build/

    # extra files, just in case
    cp -a --parents tools/objtool/* $kerneldir/build/
    cp -a --parents tools/lib/str_error_r.c $kerneldir/build/
    cp -a --parents tools/lib/string.c $kerneldir/build/
    cp -a --parents tools/lib/subcmd/* $kerneldir/build/
    cp -a --parents tools/include/* $kerneldir/build/
    cp -a --parents arch/x86/lib/* $kerneldir/build/
    cp -a --parents arch/x86/include/asm/* $kerneldir/build/
    cp -a --parents arch/x86/tools/gen-insn-attr-x86.awk $kerneldir/build/
    )

    (
    cd ${B}
    # copy all the header files included by Linux kernel headers
    cp --parents $(find -type f -name "*.h") $kerneldir/build
    )

    # change path in INCLUDES for some headers from HOSTARCH such as orc_types.h
    sed -i "s@(ARCH)\/include@(HOSTARCH)\/include@g" \
        $kerneldir/build/tools/objtool/Makefile

    # Be sure decode.c from tools/objtool/arch/x86 is compiled to avoid undefined
    # reference errors for `arch_callee_saved_reg' and 'arch_initial_func_cfi_state'
    echo "objtool-y += arch/x86/" >> $kerneldir/build/tools/objtool/Build

    chown -R root:root ${D}
}
