FROM openjdk:8
EXPOSE 8080
ADD target/phase5_fooddelivery_backend-0.0.1-SNAPSHOT.war phase5_fooddelivery_backend-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/phase5_fooddelivery_backend-0.0.1-SNAPSHOT.war" ]