FROM openjdk:12-alpine
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Europe/Moscow /etc/localtime
RUN echo "Europe/Moscow" >  /etc/timezone && date
COPY build/libs/*.jar backend.jar
EXPOSE 8080
CMD java -jar backend.jar