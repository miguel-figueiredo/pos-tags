####
#
# Before building the docker image run:
#
# mvn package
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile -t pos-tags-cli .
#
# Then run the container using:
#
# docker run -i --rm pos-tags-cli
#
###
FROM registry.access.redhat.com/ubi8/ubi-minimal:8.1

ARG JAVA_PACKAGE=java-11-openjdk-headless
ARG RUN_JAVA_VERSION=1.3.5

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

RUN microdnf install openssl curl ca-certificates ${JAVA_PACKAGE} \
    && microdnf update \
    && microdnf clean all

COPY target/pos-tags*.jar /pos-tags-cli.jar
COPY src/main/docker/entrypoint.sh /
RUN chmod 755 /entrypoint.sh

USER 1001

ENTRYPOINT ["/entrypoint.sh"]
CMD []