# Stage 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built JAR
COPY --from=builder /app/target/*.jar app.jar

# ✅ Create logs directory inside final image
RUN mkdir -p /app/logs

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
