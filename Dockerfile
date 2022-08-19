#IMPORT JRE ALPINE
FROM openjdk:8-jre-alpine
#ARG AUTHOR
ARG Author
ARG Email
MAINTAINER ${Author} ${Email}
#ARG Descript
ARG Descript
LABEL description=${Descript}
#ARG JAR
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
#ARG Port
ARG Port
EXPOSE ${Port}
#JAVA Jar
ENTRYPOINT ["java","-jar","app.jar"]