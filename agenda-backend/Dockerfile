FROM java:8
VOLUME /tmp
EXPOSE 8080
ADD demo-0.0.1-SNAPSHOT.jar back.jar
ENTRYPOINT ["java","-jar","back.jar"]