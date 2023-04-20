#!/bin/bash

set -e

while curl http://host.docker.internal:4444/wd/hub/status| grep -q "Selenium Grid ready."; do
  echo "Waiting for Selenium Grid to be ready..."
  sleep 1
done


java -cp target/dockertest-jar-with-dependencies.jar org.testng.TestNG ./testing.xml 
