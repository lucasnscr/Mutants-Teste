FROM maven:3.5-jdk-8-alpine as build (2)
WORKDIR /app
RUN mvn install
FROM openjdk:8-jre-alpine
ENV APP_FILE mutants-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/app
EXPOSE 8080
COPY --from=build /app/target/mutants-0.0.1-SNAPSHOT.jar /app
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]

#FROM maven:3.5-jdk-8-alpine as build (2)
#WORKDIR /app
#RUN mvn install
#FROM openjdk:8-jre-lucas
#WORKDIR /app
