DESCRIPTION = "Wylodrin"
HOMEPAGE = "http://github.com/alexandruradovici/wyliodrin-server/tree/deviceintel"
LICENSE = "LGPLv3"

LIC_FILES_CHKSUM = "file://README.md;md5=6edfecbce9db70975e50c6b9c542865a"

DEPENDS = "jansson fuse libevent libstrophe hiredis curl mraa"
RDEPENDS_${PN} = "libwyliodrin redis"

SRC_URI = "git://github.com/Wyliodrin/wyliodrin-server;branch=intel;protocol=git;rev=b243ea2d076884d63f8b1493f08a00e83bd22032  \
           file://wyliodrin-server.service \
           file://wyliodrin-hypervisor.service"

S = "${WORKDIR}/git"

inherit cmake systemd pkgconfig

PARALLEL_MAKE=""

EXTRA_OECMAKE="-DDEVICEINTEL=ON"
#PACKAGECONFIG ??= "intel"
#PACKAGECONFIG[intel] = "-DDEVICEINTEL=ON, -DDEVICEINTEL=OFF, mraa"

SYSTEMD_SERVICE_${PN} = "wyliodrin-server.service wyliodrin-hypervisor.service"
SYSTEMD_AUTO_ENABLE ?= "enable"

#INSANE_SKIP_${PN} = "installed-vs-shipped"
#INSANE_SKIP_${PN} = "dev-so"

do_install_append () {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/wyliodrin-server.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/wyliodrin-hypervisor.service ${D}${systemd_unitdir}/system/
}
