FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS_append = " libmodbus"
RDEPENDS_${PN}_append = " libmodbus"

export JAVA_HOME="${STAGING_DIR}/${BUILD_SYS}/usr/lib/jvm/icedtea7-native"

PACKAGECONFIG ??= "python nodejs java"

PACKAGECONFIG[java] = "-DBUILDSWIGJAVA=ON, -DBUILDSWIGJAVA=OFF, swig-native icedtea7-native,"

cmake_do_generate_toolchain_file_append() {
  echo "
set (JAVA_AWT_INCLUDE_PATH ${JAVA_HOME}/include CACHE PATH \"AWT include path\" FORCE)
set (JAVA_AWT_LIBRARY ${JAVA_HOME}/jre/lib/amd64/libjawt.so CACHE FILEPATH \"AWT Library\" FORCE)
set (JAVA_INCLUDE_PATH ${JAVA_HOME}/include CACHE PATH \"java include path\" FORCE)
set (JAVA_INCLUDE_PATH2 ${JAVA_HOME}/include/linux CACHE PATH \"java include path\" FORCE)
set (JAVA_JVM_LIBRARY ${JAVA_HOME}/jre/lib/amd64/libjvm.so CACHE FILEPATH \"path to JVM\" FORCE)
" >> ${WORKDIR}/toolchain.cmake
}

INSANE_SKIP_${PN} = "dev-so"
