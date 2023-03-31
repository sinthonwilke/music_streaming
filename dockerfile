FROM openjdk:11-jdk
VOLUME /tmp
ARG JAR_FILE
COPY ["Music Streaming/demo/demo/target/app.jar", "app.jar"]
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
