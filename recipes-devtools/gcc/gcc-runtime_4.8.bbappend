# Clean shared data for libgfortran as long as it have separate recipe. Otherwise, a warning will occur.
do_clean_libgfortran_data() {
	rm -rf ${PKGDEST}/libgfortran*
	rm -rf ${PKGDESTWORK}/runtime/libgfortran*
	rm -rf ${PKGDESTWORK}/runtime-reverse/libgfortran*
}
addtask do_clean_libgfortran_data after do_package before do_packagedata
