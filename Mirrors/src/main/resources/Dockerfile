#JDK ALPINE
FROM openjdk:8-jre-alpine
#AUTHOR
MAINTAINER BITMIRRORS "light.link.point@gmail.com"
#ADD JAR
ADD Mirrors-0.0.1.jar app.jar
#OPEN PORT
EXPOSE 80
#COMMAND
ENTRYPOINT ["java","-jar","app.jar"]