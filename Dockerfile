#FROM eclipse-temurin:17-jdk-alpine
#FROM maven:3.8.2-jdk-17
FROM maven:3.8.5-openjdk-17
VOLUME /tmp
EXPOSE 8088
#ARG JAR_FILE=target/AmusementParkApi-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
COPY . .
ARG JAR_FILE=target/AmusementParkApi-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
RUN mvn clean install
CMD mvn spring-boot:run
ENTRYPOINT ["java","-jar","/app.jar"]