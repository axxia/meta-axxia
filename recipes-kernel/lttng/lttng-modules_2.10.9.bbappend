FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append = " file://writeback-fix-sync-livelock-due-to-b_dirty_time-processing.patch"

# If clean or cleansstate is run for lttng-modules, clean also alternative lttng-modules
LTTNG_MODULES_CLEAN = "${@':do_clean '.join(d.getVar('ALTERNATIVE_KERNELS_LTTNG_MODULES')[1:].split(' '))}:do_clean"
LTTNG_MODULES_CLEANSSTATE = "${@':do_cleansstate '.join(d.getVar('ALTERNATIVE_KERNELS_LTTNG_MODULES')[1:].split(' '))}:do_cleansstate"

do_clean[depends] += "${@oe.utils.conditional('ALTERNATIVE_KERNELS', '', '', '${LTTNG_MODULES_CLEAN}', d)}"
do_cleansstate[depends] += "${@oe.utils.conditional('ALTERNATIVE_KERNELS', '', '', '${LTTNG_MODULES_CLEANSSTATE}', d)}"
