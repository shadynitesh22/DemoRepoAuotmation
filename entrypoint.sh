#!/bin/bash

set -e

while curl http://host.docker.internal:4444/wd/hub/status| grep -q "Selenium Grid ready."; do
  echo "Waiting for Selenium Grid to be ready..."
  sleep 1
done



Xvfb :99 -screen 0 1920x1080x24 &
# java -cp "/app/src/main/resources:/app/target/classes:/app/target/test-classes:/app/lib/*" org.testng.TestNG testng.xml

mvn test -Dsurefire.suiteXmlFiles=testng.xml