#FROM eclipse-temurin:17-jdk-alpine
FROM eclipse-temurin:21.0.1_12-jre-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/SwapAdmin-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} /app.jar
RUN mkdir /startup
COPY docker/entrypoint.sh /startup/entrypoint.sh
RUN chmod +x /startup/entrypoint.sh

ENTRYPOINT ["/startup/entrypoint.sh"]
