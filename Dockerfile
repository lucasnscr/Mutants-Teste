FROM openjdk:8-jre-alpine
ENV APP_FILE mutants-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/app
EXPOSE 8080
COPY build/libs/*.jar $$APP_HOME
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
