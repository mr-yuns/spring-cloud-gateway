# FROM openjdk:23-jdk
FROM gradle:8-jdk23

WORKDIR /app
COPY . /app
VOLUME /tmp
EXPOSE 8080

# fetch dependencies
RUN chmod +x run.sh && gradle updateLib

# script which watches source file changes in background and executes bootRun
CMD [ "sh" , "run.sh" ]