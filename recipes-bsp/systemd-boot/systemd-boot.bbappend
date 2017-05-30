DEPENDS_append_axxiax86-64 = " rmc"
RDEPENDS_${PN}_append_axxiax86-64 = " rmc-staticdev"

FILESEXTRAPATHS_prepend := "${THISDIR}/systemd-boot:"

EXTRA_OEMAKE_append_axxiax86-64 = ' EFI_LDFLAGS="-L${STAGING_DIR_HOST}/usr/lib" EFI_CFLAGS="-I${STAGING_INCDIR}/rmc/efi -DRMC_EFI"'

# Pin systemd revision down for systemd-boot recipe.
# Patches could not be applied cleanly when systemd in OE is updated,
# though we don't expect a lot of changes could happen in bootloader.
# RMC is designed to support a large number of types of boards, so we
# should do explicit update with validation to prevent regression even
# resolving conflicts for a new tip could be done in a short time.

# Revision: systemd 230 in OE
SRCREV_axxiax86-64 = "3a74d4fc90cb322a4784a3515bef7118c8f8c5ba"

SRC_URI_append_axxiax86-64 = " \
            file://0001-sd-boot-Link-RMC-libraries-into-bootloader.patch \
            file://0002-sd-boot-Load-board-specific-boot-entries-from-RMC-da.patch \
            file://0003-sd-boot-Support-global-kernel-command-line-fragment.patch \
            file://0001-efi-boot.c-workaround-for-Joule-BIOS-hang.patch \
            "

PACKAGE_ARCH_axxiax86-64 = "${INTEL_COMMON_PACKAGE_ARCH}"
