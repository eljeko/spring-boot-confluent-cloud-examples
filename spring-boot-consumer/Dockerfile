# Use official OpenJDK runtime as base image
FROM openjdk:22-jdk

# Set working directory
WORKDIR /app

# Copy JAR into container
COPY target/springboot-kafka-consumer-1.0.jar app.jar
RUN mkdir config
COPY config/application.properties config/application.properties

# Default command to run your app
#CMD ["java", "-jar", "app.jar", "--spring.config.location=file:application.properties"]
CMD ["java", "-jar", "app.jar"]
