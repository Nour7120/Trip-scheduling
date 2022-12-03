FROM openjdk:19
VOLUME /tmp
COPY target/tripScheduling.jar tripScheduling.jar
ENV PORT=3306
ENV IP=host.docker.internal
ENTRYPOINT ["java", "-jar", "/tripScheduling.jar"]