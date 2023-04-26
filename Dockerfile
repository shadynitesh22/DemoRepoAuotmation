FROM ubuntu:latest


WORKDIR /app

# Install Java and necessary packages

RUN apt-get update && apt-get install -y openjdk-18-jdk maven xvfb curl jq wget 

ARG JAVA_HOME="/usr/lib/jvm/java-18-openjdk-amd64"
ENV JAVA_HOME=$JAVA_HOME


# Copy the pom.xml file to the app directory and install dependencies
COPY pom.xml /app

RUN mvn package -DskipTests=true

COPY ./target /app

COPY testing.xml /app

COPY . /app/

COPY src /app/src


# Create Entrypoint here
COPY entrypoint.sh /app/
# COPY start_vnc.sh /app/

RUN chmod +x /app/entrypoint.sh
# RUN chmod +x /app/start_vnc.sh

# Set environment variables
ENV DISPLAY=:99
ENV VNC_COL_DEPTH=24
ENV VNC_RESOLUTION=1920x1080
ENV VNCSERVER_REMOVE_PW=1
ENV VNC_VIEW_ONLY=false


ENTRYPOINT ["/app/entrypoint.sh"]