FROM alpine/java:20-jdk
COPY ./dd-java-agent.jar /opt
RUN chmod 777 /opt/dd-java-agent.jar
