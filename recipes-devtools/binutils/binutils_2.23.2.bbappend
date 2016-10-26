FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://binutils-replace-boolean-switch-with-if-statement.patch \
	    file://binutils-correct-comparison-with-negative-expr-on-right.patch \
	    file://binutils-declare-subword-functions-as-static.patch"
