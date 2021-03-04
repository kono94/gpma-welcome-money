#bin/bash

mvn clean install
docker cp ./target/camunda-money-process.war camunda:/camunda/webapps/
