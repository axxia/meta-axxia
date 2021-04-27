DESCRIPTION = "A minimal image used in simulation, flash, \
or as a ram disk that supports the RTE."

require axxia-image.inc

IMAGE_INSTALL = " \
packagegroup-core-boot \
${CORE_IMAGE_EXTRA_INSTALL} \
"

IMAGE_INSTALL_append = " \
libgcc \
inetutils \
initscripts-readonly-rootfs-overlay \
gdbserver \
kernel-dev \
kernel-modules \
libasan \
libubsan "

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"

TOOLCHAIN_HOST_TASK_append = " nativesdk-elfutils-dev"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"
