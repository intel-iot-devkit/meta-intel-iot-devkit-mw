# Additional layers needed to build this recipe:
# meta-python
# meta-ruby

SUMMARY = "Essential IOT packages"
LICENSE = "CLOSED"

DEPENDS = " \
	nano \
	vim \
	python-numpy \
	ruby \
	apache2 \
	"

inherit meta
