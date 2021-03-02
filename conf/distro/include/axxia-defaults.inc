YOCTO_ALTERNATIVE_KERNELS ?= "\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-yocto', '',    ' linux-yocto', d)}\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-yocto-rt', '', ' linux-yocto-rt', d)}\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-yocto-debug', '',    ' linux-yocto-debug', d)}\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-yocto-rt-debug', '', ' linux-yocto-rt-debug', d)}\
"

AXXIA_ALTERNATIVE_KERNELS ?= "\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-axxia', '',    ' linux-axxia', d)}\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-axxia-rt', '', ' linux-axxia-rt', d)}\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-axxia-debug', '',    ' linux-axxia-debug', d)}\
${@oe.utils.conditional('PREFERRED_PROVIDER_virtual/kernel',\
	'linux-axxia-rt-debug', '', ' linux-axxia-rt-debug', d)}\
"

LOCAL_ALTERNATIVE_KERNELS ?= ""

ALTERNATIVE_KERNELS ?= \
"${${@''.join(d.getVar('PREFERRED_PROVIDER_virtual/kernel').upper()\
	.split('-')[1:2])}_ALTERNATIVE_KERNELS}"

ALTERNATIVE_KERNELS_INSTALL ?= \
"${@d.getVar('ALTERNATIVE_KERNELS').replace('linux-','kernel-linux-')}"

ALTERNATIVE_KERNELS_MODULES_INSTALL ?= \
"${@'-modules '.join(d.getVar('ALTERNATIVE_KERNELS_INSTALL')[1:].split(' '))}-modules"

ALTERNATIVE_KERNELS_LTTNG_MODULES ?= \
"${@d.getVar('ALTERNATIVE_KERNELS').replace('linux-','lttng-modules-linux-')}"

PREFERRED_VERSION_linux-yocto ?= "4.19%"
PREFERRED_VERSION_linux-yocto-rt ?= "4.19%"
PREFERRED_VERSION_linux-yocto-debug ?= "4.19%"
PREFERRED_VERSION_linux-yocto-rt-debug ?= "4.19%"
PREFERRED_VERSION_linux-axxia ?= "4.19%"
PREFERRED_VERSION_linux-axxia-rt ?= "4.19%"
PREFERRED_VERSION_linux-axxia-debug ?= "4.19%"
PREFERRED_VERSION_linux-axxia-rt-debug ?= "4.19%"

PREFERRED_RPROVIDER_iasl ?= "iasl"
PREFERRED_RPROVIDER_iasl-native ?= "iasl-native"
PREFERRED_VERSION_rpcbind ?= "0.2.3"

FORTRAN_forcevariable = ",fortran"
