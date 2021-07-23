@echo off
call mvn clean package
call docker build -t fr.grin/tpCustomerGrin .
call docker rm -f tpCustomerGrin
call docker run -d -p 9080:9080 -p 9443:9443 --name tpCustomerGrin fr.grin/tpCustomerGrin