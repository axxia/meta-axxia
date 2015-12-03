require dt-axxia.inc

do_compile_append() {
	addr=0x00408000
	if [ "${KV}" = "3.4" ]; then
		mk_fit_images "axm55xx" ${addr}
		mk_fit_images "axm55xxemu7" ${addr}
		mk_fit_images "axm55xxemu" ${addr}
		mk_fit_images "axm55xxsim16" ${addr}
		mk_fit_images "axm55xxsim" ${addr}
	elif [ "${KV}" = "3.10" ]; then
		mk_fit_images "axm5504-emu" ${addr}
		mk_fit_images "axm5507-emu" ${addr}
		mk_fit_images "axm5508-amarillo" ${addr}
		mk_fit_images "axm5512-amarillo" ${addr}
		mk_fit_images "axm5516-amarillo" ${addr}
		mk_fit_images "axm5504-sim-mmc" ${addr}
		mk_fit_images "axm5504-sim-virtio" ${addr}
		mk_fit_images "axm5516-sim-mmc" ${addr}
		mk_fit_images "axm5516-sim-virtio" ${addr}
	fi
}

do_deploy_append() {
	if [ "${KV}" = "3.4" ]; then
	    	install_fit_images "axm55xx"
    		install_fit_images "axm55xxemu7"
    		install_fit_images "axm55xxemu"
    		install_fit_images "axm55xxsim16"
    		install_fit_images "axm55xxsim"
	elif [ "${KV}" = "3.10" ]; then
		install_fit_images "axm5504-emu"
		install_fit_images "axm5507-emu"
		install_fit_images "axm5508-amarillo"
		install_fit_images "axm5512-amarillo"
		install_fit_images "axm5516-amarillo"
		install_fit_images "axm5504-sim-mmc"
		install_fit_images "axm5504-sim-virtio"
		install_fit_images "axm5516-sim-mmc"
		install_fit_images "axm5516-sim-virtio"
    	fi
}
