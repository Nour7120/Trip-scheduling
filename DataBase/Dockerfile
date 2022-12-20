FROM openjdk:19
VOLUME /tmp
COPY target/tripScheduling.jar tripScheduling.jar
ENV IP=mysql
ENTRYPOINT ["java", "-jar", "/tripScheduling.jar"]