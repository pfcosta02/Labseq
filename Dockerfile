# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/labseq-0.0.1-SNAPSHOT.jar labseq.jar

# Expose port 8080
EXPOSE 8080

# Define the entry point
ENTRYPOINT ["java", "-jar", "labseq.jar"]
