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
ADD target/${JAR_FILE} /home/apps/app.jar
#ARG Port
ARG Port
EXPOSE ${Port}
#COMMAND
ENTRYPOINT ["java","-jar","/home/apps/app.jar"]