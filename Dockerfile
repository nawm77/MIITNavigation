FROM bellsoft/liberica-openjdk-alpine-musl
EXPOSE 8080
COPY ./target/miit-navigation.jar .
CMD ["java", "-jar", "miit-navigation.jar"]