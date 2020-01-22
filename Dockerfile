FROM adoptopenjdk/openjdk11:latest
ENV APP_FILE messagev1-1.0.0-SNAPSHOT.jar
ENV APP_HOME /usr/app
EXPOSE 8080
COPY build/libs/*.jar $$APP_HOME
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
