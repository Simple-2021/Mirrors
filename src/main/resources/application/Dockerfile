FROM bitmirrors/openjre-base

MAINTAINER bitmirrors "light.link.point@gmail.com"

LABEL desc=nothing

ADD target/Mirrors-latest.jar /home/apps/app.jar

EXPOSE 443

ENTRYPOINT ["java","-jar","/home/apps/app.jar"]