# Use a multi-stage build to create a smaller final image

# Stage 1: Build the application
FROM gradle:jdk21-alpine AS builder
WORKDIR /app
COPY --chown=gradle:gradle . /app
RUN gradle clean build -x test

# Stage 2: Create the final image
FROM openjdk:21-jdk-slim-buster
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
