FROM  java:8
VOLUME /tmp
ADD springboot-sharding-JDBC-demo-0.0.1-SNAPSHOT.jar  app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9000
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
ENTRYPOINT ["java","-jar","app.jar"]