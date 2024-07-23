FROM alpine/java:20-jdk
RUN wget -O dd-java-agent.jar -P /opt 'https://dtdg.co/latest-java-tracer'