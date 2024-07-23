FROM alpine/java:20-jdk
RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'
RUN chmod +x dd-java-agent.jar