# Use a base image with Maven for building and WildFly for runtime
FROM maven:3.8.4-openjdk-11 AS build

# Set the working directory
WORKDIR /app

# Copy the POM file to the container
COPY pom.xml .

# Download the dependencies and plugins
RUN mvn dependency:go-offline

# Copy the source code to the container
#coping fro woring dirctory to app
COPY . . 

# Build the application
RUN mvn package -DskipTests

# Use the official WildFly base image for runtime
FROM jboss/wildfly:latest



# Set environment variables
ENV WILDFLY_USER=admin \
    WILDFLY_PASSWORD=admin

# Copy the .war file from the build stage to the WildFly deployment directory
COPY --from=build /app/target/stadium.war /opt/jboss/wildfly/standalone/deployments/

RUN  rm -rf /opt/jboss/wildfly/standalone/configuration/standalone.xml
COPY --from=build /app/standalone.xml /opt/jboss/wildfly/standalone/configuration/standalone

RUN  rm -rf /opt/jboss/wildfly/modules
COPY --from=build /app/modules /opt/jboss/wildfly/modules


# Expose the ports needed by WildFly
EXPOSE 8080 9990

# Start WildFly in standalone mode
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]





