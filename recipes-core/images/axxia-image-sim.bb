DESCRIPTION = "A minimal image that supports the RTE."

IMAGE_INSTALL = " \
packagegroup-core-boot \
${ROOTFS_PKGMANAGE_BOOTSTRAP} \
${CORE_IMAGE_EXTRA_INSTALL} \
"

IMAGE_INSTALL_append = " \
dhcp-client \
gdb \
gdbserver \
inetutils \
libgcc \
lttng-modules \
lttng-modules-dev \
lttng-tools \
lttng-tools-dev \
lttng-ust \
lttng-ust-dev \
netcat \
netkit-tftp-client \
openssh \
openssh-sftp \
perl-module-bigint \
python-core \
python-modules \
python-netserver \
"

IMAGE_FEATURES += "dev-pkgs"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "16384"

SDKIMAGE_FEATURES = "dev-pkgs dbg-pkgs staticdev-pkgs"
