#!/bin/bash

curl -X POST "http://localhost:7470/api/projects/init" -H "accept: */*" -H "Content-Type: application/json" -d @beer.json
curl -X POST "http://localhost:7470/api/build-tools/maven" -H "accept: */*" -H "Content-Type: application/json" -d @beer.json
curl -X POST "http://localhost:7470/api/servers/spring-boot" -H "accept: */*" -H "Content-Type: application/json" -d @beer.json
curl -X POST "http://localhost:7470/api/servers/spring-boot/web/tomcat" -H "accept: */*" -H "Content-Type: application/json" -d @beer.json
curl -X POST "http://localhost:7470/api/servers/spring-boot/databases/psql" -H "accept: */*" -H "Content-Type: application/json" -d @beer.json
curl -X POST "http://localhost:7470/api/servers/spring-boot/dbmigration/liquibase" -H "accept: */*" -H "Content-Type: application/json" -d @beer.json
