FROM ubuntu:latest



WORKDIR /app

# Install Java and necessary packages
RUN apt-get update && apt-get install -y openjdk-18-jdk maven xvfb curl jq wget 


# Copy the pom.xml file to the app directory and install dependencies
COPY pom.xml /app

RUN ["mvn", "package", "-DskipTests=true"]

COPY ./target /app

COPY testing.xml /app

COPY . /app/

COPY src /app/src


# Create Entrypoint here
COPY entrypoint.sh /app/

RUN chmod +x /app/entrypoint.sh


# Set environment variables
ENV DISPLAY=:99


ENTRYPOINT ["/app/entrypoint.sh"]