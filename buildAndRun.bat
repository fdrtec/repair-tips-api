@echo off
call mvn clean package
call docker build -t br.com.fdrtec/repair-tips .
call docker rm -f repair-tips
call docker run -d -p 9080:9080 -p 9443:9443 --name repair-tips br.com.fdrtec/repair-tips