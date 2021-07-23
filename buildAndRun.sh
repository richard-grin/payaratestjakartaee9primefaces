#!/bin/sh
mvn clean package && docker build -t fr.grin/tpCustomerGrin .
docker rm -f tpCustomerGrin || true && docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerGrin fr.grin/tpCustomerGrin