FROM gradle:8.10.2-jdk21-alpine AS builder

WORKDIR /app

# COPY gradle gradle
# COPY gradlew .
# COPY settings.gradle .
# COPY build.gradle .
COPY . .

RUN ./gradlew --no-daemon clean build

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/app/build/libs/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
