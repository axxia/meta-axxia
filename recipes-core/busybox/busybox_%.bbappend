FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://enable_tftp_blocksize_feature.cfg"
