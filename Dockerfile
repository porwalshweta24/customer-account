FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:11-jdk-slim
COPY --from=build /workspace/target/customer-account-0.0.1-SNAPSHOT.jar customer-account.jar
EXPOSE 6379
ENTRYPOINT ["java","-jar","customer-account.jar"]