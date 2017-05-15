require recipes-containers/${PN}/${PN}_1.1.bb

SRC_URI = "https://launchpad.net/ubuntu/+archive/primary/+files/cgroup-lite_1.11.tar.xz \
           file://cgroups-init"
SRC_URI[md5sum] = "b20976194ee8fdb61e6b55281fb6ead4"
SRC_URI[sha256sum] = "a79ab9ae6fb3ff3ce0aa5539b055c0379eaffdc6c5f003af4010fcea683c1a45"
