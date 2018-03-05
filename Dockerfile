# Kyubey Site Dockerfile
# Copyright 2018 (c) Noud Kerver
FROM openjdk:alpine
MAINTAINER Noud Kerver <noud.kerver@hotmail.nl>
MAINTAINER Ayane Satomi <enra@headbow.stream>

RUN addgroup -g 1000 java \
&& adduser -u 1000 -G java -s /bin/sh -D java;

RUN apk update && \
    apk upgrade && \
    mkdir -p /opt/app && \
    chown -R java:root /opt/app && \
    chmod g+rw /opt && \
    chgrp root /opt && \
    find /home/java -type d -exec chmod g+x {} +

COPY KyubeySite.jar /opt/app/

USER 1000

WORKDIR /opt/app

CMD ["java", "-jar", "./KyubeySite.jar"]