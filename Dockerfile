FROM openjdk:11.0-jdk
ADD ./target/muzix-0.0.1-SNAPSHOT.jar /muzix/app/muzix-0.0.1-SNAPSHOT.jar
WORKDIR muzix/app
ENTRYPOINT ["java","-jar","muzix-0.0.1-SNAPSHOT.jar"]