# Additional layers needed to build this recipe:
# meta-networking
# meta-filesystems
# meta-java

SUMMARY = "Extra IOT packages"
LICENSE = "CLOSED"

DEPENDS = " \
	htop \
	iftop \
	iotop \
	inetutils \
	parted \
	sshfs-fuse \
	fping \
	lowpan-tools \
	macchanger \
	netcat \
	netcat-openbsd \
	tcpdump \
	tcpreplay \
	traceroute \
	v4l-utils \
	cronie \
	mariadb \
	espeak \
	udisks \
	screen \
	parse-embedded-sdks \
	"

inherit meta
