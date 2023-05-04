FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle/
RUN ./gradlew build --no-daemon
COPY src src
RUN ./gradlew bootJar --no-daemon

ENTRYPOINT ["java", "-jar", "/app/build/libs/BookNook-0.0.1-SNAPSHOT.jar"]