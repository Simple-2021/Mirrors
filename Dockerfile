#From Mirror
FROM bitmirrors/openjre-base
#ARG AUTHOR
ARG Author
ARG Email
MAINTAINER ${Author} ${Email}
#ARG Descript
ARG Desc
LABEL desc=${Desc}
#ARG JAR
ARG JAR_FILE
ADD target/${JAR_FILE} /home/apps/app.jar
#ARG SSL
ARG SSL
EXPOSE ${SSL}
#COMMAND
ENTRYPOINT ["java","-jar","/home/apps/app.jar"]