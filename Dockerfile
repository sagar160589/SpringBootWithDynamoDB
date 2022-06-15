FROM openjdk:8
ADD ./target/com.customer-0.0.1-SNAPSHOT.jar com.customer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/com.customer-0.0.1-SNAPSHOT.jar"]

