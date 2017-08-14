#It will tell the base image coming from, it have alpine linux with JDK 8
FROM openjdk:8-jdk-alpine
#VOLUME pointing to "/tmp" because that is where a Spring Boot application creates working directories 
#for Tomcat by defaul
VOLUME /tmp
# add jar file and rename to app.jar
ADD final-boot-docker-0.0.1.jar app.jar
# in java env var starts with -D
# add our application-prod.properties as a env var i.e. profiler
ENV JAVA_OPTS="-Dspring.profiles.active=prod"
#entrypoint for docker
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]