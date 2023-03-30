FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
COPY ["Music Streaming/demo/demo/target/app.jar", "app.jar"]
ENTRYPOINT ["java","-jar","/app.jar"]
