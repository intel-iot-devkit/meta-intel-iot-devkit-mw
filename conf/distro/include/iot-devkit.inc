SANITY_TESTED_DISTROS = " \
            Ubuntu-14.04 \n \
            Fedora-20 \n \
            Debian-7.8 \n \
            openSUSE-project-13.1 \n \
            "

DISTRO_VERSION = "2.0"
DISTRO_CODENAME = "lemur"
DISTRO_NAME = "iot-devkit (Intel IoT Development Kit)"
MAINTAINER = "Intel IoT Devkit team <meta-intel@yoctoproject.org>"

# Changing these currently breaks the Eclipse plugin
#TARGET_VENDOR = "-iotkit"
#SDK_VENDOR = "-iotkit"

SSTATE_DIR ?= "${TOPDIR}/../devkit-cache/sstate-cache"
CACHE_forcevariable = "${TOPDIR}/../devkit-cache/cache"
PERSISTENT_DIR = "${TOPDIR}/../devkit-cache/persistent"
