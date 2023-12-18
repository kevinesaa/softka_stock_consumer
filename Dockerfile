FROM amazoncorretto:17-alpine3.16-jdk

LABEL authors="kesaa"

WORKDIR /app
RUN apk update
RUN apk add git

RUN git clone https://github.com/kevinesaa/softka_stock_consumer.git

RUN chmod 755 ./softka_stock_consumer/gradlew
RUN ./softka_stock_consumer/gradlew  -p  ./softka_stock_consumer/ --stacktrace bootJar

RUN mkdir /temp
RUN mv /app/softka_stock_consumer/build/libs/consumer-0.0.1-SNAPSHOT.jar /temp/app.jar

RUN rm -rf /app/*

RUN mv /temp/app.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]