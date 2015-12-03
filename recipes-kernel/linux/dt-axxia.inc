mk_fit_images() {
	name=$1
	addr=$2
	oe_runmake ${name}.dtb
	echo "pwd = `pwd`"
	cd ../fit
	if [ "${KARCH}" = "arm" ] && [ "${KV}" = "3.10" ]; then
		oe_runmake "ARCH=${KARCH}" \
				'DESCRIPTION=LSI Axxia Linux' \
				"ADDRESS=${addr}" \
				'VMLINUX=${B}/vmlinux' \
				"DTB=${B}/arch/${KARCH}/boot/dts/${name}.dtb"
	else
		oe_runmake "ARCH=${KARCH}" \
				'DESCRIPTION=LSI Axxia Linux' \
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
	if [ "${KARCH}" = "arm" ] && [ "${KV}" = "3.10" ]; then
		install ${B}/arch/${KARCH}/boot/dts/${name}.dtb ${DEPLOYDIR}/${name}.dtb
	else
		install ${B}/arch/${KARCH}/boot/${name}.dtb ${DEPLOYDIR}/${name}.dtb
	fi
	install ${B}/../fit/linux.fit-${name} ${DEPLOYDIR}/linux.fit-${name}
	install ${B}/../fit/fdt.fit-${name} ${DEPLOYDIR}/fdt.fit-${name}
	install ${B}/../fit/multi.fit-${name} ${DEPLOYDIR}/multi.fit-${name}
	
}
