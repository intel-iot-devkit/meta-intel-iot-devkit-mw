FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = "file://redis.service"

inherit systemd

SYSTEMD_SERVICE_${PN} = "redis.service"

do_install_append () {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/redis.service ${D}${systemd_unitdir}/system/
}
