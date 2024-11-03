FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Dskiptest

FROM openjdk:17.0.1-jdk-slim 
COPY --from build /target/demo-0.0.1-SNAPSHORT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]