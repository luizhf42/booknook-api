FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle/
RUN ./gradlew build --no-daemon

COPY src ./src

CMD ["./gradlew", "bootRun"]