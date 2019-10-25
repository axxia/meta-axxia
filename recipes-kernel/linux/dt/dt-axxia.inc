mk_fit_images() {
	name=$1
	addr=$2

	if [ "${KARCH}" = "arm" ]
	then
		oe_runmake -j1 ${name}.dtb
	elif [ "${KARCH}" = "arm64" ]
	then
		oe_runmake -j1 dtbs
	fi

	echo "pwd = `pwd`"
	cd ../fit
	if [ "${KARCH}" = "arm" ]
	then
		oe_runmake -j1 "ARCH=${KARCH}" \
				'DESCRIPTION=INTEL Axxia Linux' \
				"ADDRESS=${addr}" \
				'VMLINUX=${B}/vmlinux' \
				"DTB=${B}/arch/${KARCH}/boot/dts/${name}.dtb"
	elif [ "${KARCH}" = "arm64" ]
	then
		oe_runmake -j1 "ARCH=${KARCH}" \
				'DESCRIPTION=INTEL Axxia Linux' \
				"ADDRESS=${addr}" \
				'VMLINUX=${B}/vmlinux' \
				"DTB=${B}/arch/${KARCH}/boot/dts/intel/${name}.dtb"
	else
		oe_runmake -j1 "ARCH=${KARCH}" \
       	                        'DESCRIPTION=INTEL Axxia Linux' \
               	                "ADDRESS=${addr}" \
                       	        'VMLINUX=${B}/vmlinux' \
                               	"DTB=${B}/arch/${KARCH}/boot/${name}.dtb"
	fi
	mv linux.fit linux.fit-${name}
	mv fdt.fit fdt.fit-${name}
	mv multi.fit multi.fit-${name}
	cd ${B}
}

install_fit_images() {
	name=$1

	if [ "${KERNEL_PACKAGE_NAME}" = "kernel" ]; then
		FIT_DEPLOYDIR="${DEPLOYDIR}"
	else
		FIT_DEPLOYDIR="${DEPLOYDIR}/${KERNEL_PACKAGE_NAME}"
	fi

	if [ "${KARCH}" = "arm" ]
	then
		install ${B}/arch/${KARCH}/boot/dts/${name}.dtb ${FIT_DEPLOYDIR}/${name}.dtb
	elif [ "${KARCH}" = "arm64" ]
	then
		install ${B}/arch/${KARCH}/boot/dts/intel/${name}.dtb ${FIT_DEPLOYDIR}/${name}.dtb
	else
		install ${B}/arch/${KARCH}/boot/${name}.dtb ${FIT_DEPLOYDIR}/${name}.dtb
	fi
	install ${B}/../fit/linux.fit-${name} ${FIT_DEPLOYDIR}/linux.fit-${name}
	install ${B}/../fit/fdt.fit-${name} ${FIT_DEPLOYDIR}/fdt.fit-${name}
	install ${B}/../fit/multi.fit-${name} ${FIT_DEPLOYDIR}/multi.fit-${name}
}
