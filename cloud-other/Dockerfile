FROM openjdk:17-jdk
MAINTAINER cpz
COPY target/cloud-other-1.0.jar /app.jar
ENV APP_OPTS = ""
ENTRYPOINT ["sh", "-c", "java -jar app.jar $APP_OPTS"]