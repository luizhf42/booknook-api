FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle/
RUN ./gradlew bootJar --no-daemon

COPY /build/libs/BookNook-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]