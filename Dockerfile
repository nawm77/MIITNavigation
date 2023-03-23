FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/MIITNavigation-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "MIITNavigation-0.0.1-SNAPSHOT.jar"]