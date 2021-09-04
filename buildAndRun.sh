#!/bin/sh
if [ $(docker ps -a -f name=repair-tips | grep -w repair-tips | wc -l) -eq 1 ]; then
  docker rm -f repair-tips
fi
mvn clean package && docker build -t br.com.fdrtec/repair-tips .
docker run -d -p 9080:9080 -p 9443:9443 --name repair-tips br.com.fdrtec/repair-tips
