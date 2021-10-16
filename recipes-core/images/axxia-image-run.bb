DESCRIPTION = "A minimal image used in simulation."

require axxia-image.inc

IMAGE_INSTALL = " \
packagegroup-core-boot \
${CORE_IMAGE_EXTRA_INSTALL} \
"

IMAGE_INSTALL_append = " \
boost \
dhcp-server \
dhcp-client \
dmidecode \
e2fsprogs-resize2fs \
ethtool \
expect \
gdb \
gdbserver \
inetutils \
initscripts-readonly-rootfs-overlay \
kernel-dev \
kernel-modules \
kmod \
ldd \
libasan \
libubsan \
libgcc \
libnl \
libnl-genl \
libnl-nf \
libnl-route \
libpython2 \
libpcap \
libudev \
lttng-modules \
lttng-modules-dev \
lttng-tools \
lttng-tools-dev \
lttng-ust \
lttng-ust-dev \
netcat \
netkit-tftp-client \
${@oe.utils.conditional('MACHINE', 'axxiaarm64', 'numactl', '', d)} \
openssh \
openssh-sftp \
pciutils \
perl-module-bigint \
python-cffi \
python-core \
python-dev \
python-distutils \
python-modules \
python-netserver \
python-nose \
telnetd \
tmux \
vlan "

IMAGE_FEATURES += "dev-pkgs"

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"

TOOLCHAIN_HOST_TASK_append = " nativesdk-elfutils-dev"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "16384"

SDKIMAGE_FEATURES = "dev-pkgs dbg-pkgs staticdev-pkgs"