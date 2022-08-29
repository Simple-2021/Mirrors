#From Mirror
FROM bitmirrors/openjre-base
#ARG AUTHOR
ARG Author
ARG Email
MAINTAINER ${Author} ${Email}
#ARG Descript
ARG Desc
LABEL desc=${Desc}
#ARG WORKDIR
ARG WORK_PATH
WORKDIR ${WORK_PATH}
#ARG JAR
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
#ARG SSL
ARG SSL
EXPOSE ${SSL}
#COMMAND
ENTRYPOINT ["java","-jar","app.jar"]