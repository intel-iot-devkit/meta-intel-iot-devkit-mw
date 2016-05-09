DESCRIPTION = "free software library that interfaces with selected Z-Wave PC controllers"
HOMEPAGE = "http://openzwave.com/"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://license/license.txt;md5=584c7ddacb8739db77ddcc47bd9d3b52"

PR = "r0"

DEPENDS = "systemd"

SRC_URI = "git://github.com/OpenZWave/open-zwave.git;protocol=git;rev=d9444666c93d33a95d79bdd1b2a817e4763faef4 \
          file://main-makefile.diff \
          file://main-support-mk.diff \
          file://minozw-makefile.diff \
"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig systemd

do_install() {
  oe_runmake \
      'DESTDIR=${D}' \
      'PREFIX=${prefix}' \
      'docdir=${docdir}/${PN}-${PV}' \
      install
}
