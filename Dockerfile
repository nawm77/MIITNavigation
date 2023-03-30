FROM bellsoft/liberica-openjdk-alpine-musl
EXPOSE 8080
COPY ./target/MIITNavigation-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "miit-navigation.jar"]