FROM openjdk:19
VOLUME /tmp
COPY target/tripScheduling.jar tripScheduling.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/tripScheduling.jar"]