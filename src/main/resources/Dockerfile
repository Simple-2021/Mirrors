#JDK ALPINE
FROM openjdk:8-jre-alpine
#AUTHOR
MAINTAINER BITMIRRORS "light.link.point@gmail.com"
LABEL decription="https://github.com/Simple-2021/Mirrors"
#ADD JAR
ADD Mirrors.jar app.jar
#OPEN PORT
EXPOSE 80
#COMMAND
ENTRYPOINT ["java","-jar","app.jar"]