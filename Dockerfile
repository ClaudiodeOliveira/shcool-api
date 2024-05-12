FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

# Copy the source code to the container
COPY . .

RUN apt-get install maven -y

# Set environment variables if needed
ENV DATASOURCE_URL=jdbc:postgresql://dpg-cok6ms779t8c73c3u7og-a.oregon-postgres.render.com/api_sos?useTimezone=true&serverTimezone=UTC
ENV DATASOURCE_USERNAME=api_sos_user
ENV DATASOURCE_PASSWORD=7P6FWZ4wmg2RRghcjybb4GDBHPIXXRvv

# Build the application with Maven
RUN mvn package

FROM openjdk:21-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Set environment variables if needed
ENV DATASOURCE_URL=jdbc:postgresql://dpg-cok6ms779t8c73c3u7og-a.oregon-postgres.render.com/api_sos?useTimezone=true&serverTimezone=UTC
ENV DATASOURCE_USERNAME=api_sos_user
ENV DATASOURCE_PASSWORD=7P6FWZ4wmg2RRghcjybb4GDBHPIXXRvv


# Expose default Spring Boot port
EXPOSE 8080

# Copy the source code to the container
COPY --from=build /target/*.jar /app/spring-app.jar

# Run the jar file
ENTRYPOINT [ "java", "-jar", "spring-app.jar" ]