#FROM postgres:latest
#ENV POSTGRES_USER=postgres
#ENV POSTGRES_PASSWORD=root
#ENV POSTGRES_DB=miit
#ENV PGDATA=/data/postgres
#VOLUME /var/lib/postgresql/data
#VOLUME /docker-entrypoint-initdb.d/
#
#FROM grafana/grafana:latest
#ENV GF_SECURITY_ADMIN_USER=admin
#ENV GF_SECURITY_ADMIN_PASSWORD=admin
#
#FROM prom/prometheus:latest
#VOLUME ./config/prometheus.yml:/etc/prometheus/prometheus.yml


FROM bellsoft/liberica-openjdk-alpine-musl
EXPOSE 8080
COPY ./target/miit-navigation.jar .
RUN apt-get update && apt-get install -y apt-utils
CMD ["java", "-jar", "miit-navigation.jar"]

# Первая стадия: сборка приложения
#FROM maven:3.8.3-openjdk-17-slim AS build
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src/ /app/src/
#RUN mvn clean package -DskipTests
#
## Вторая стадия: сборка образа
#FROM bellsoft/liberica-openjdk-alpine-musl AS runtime
#WORKDIR /app
#COPY --from=build /app/target/miit-navigation.jar .
#EXPOSE 8080
#
## Третья стадия: запуск postgres
#FROM postgres:latest AS postgres
#ENV POSTGRES_USER: postgres
#ENV POSTGRES_PASSWORD: root
#ENV POSTGRES_DB: miit
#ENV PGDATA: /data/postgres
#VOLUME /var/lib/postgresql/data
##VOLUME /docker-entrypoint-initdb.d/
#
## Четвертая стадия: запуск prometheus
#FROM prom/prometheus:latest AS prometheus
#VOLUME ./config/prometheus.yml:/etc/prometheus/prometheus.yml
#
## Пятая стадия: запуск grafana
#FROM grafana/grafana:latest AS grafana
#ENV GF_SECURITY_ADMIN_USER=admin
#ENV GF_SECURITY_ADMIN_PASSWORD=admin
#
## Шестая стадия: запуск всего
#FROM runtime AS final
#COPY --from=postgres / /
#COPY --from=prometheus / /
#COPY --from=grafana / /
#CMD ["java", "-jar", "miit-navigation.jar"]



#
## Первая стадия: сборка приложения
#FROM maven:3.8.3-openjdk-17-slim AS build
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src/ /app/src/
#RUN mvn clean package -DskipTests
#
## Вторая стадия: запуск postgres и создание базы данных
##FROM postgres:latest AS postgres
##ENV POSTGRES_USER: postgres
##ENV POSTGRES_PASSWORD: root
##ENV POSTGRES_DB: miit
##ENV PGDATA: /data/postgres
##VOLUME /var/lib/postgresql/data
##EXPOSE 5432
#
#FROM postgres:latest AS postgres
#ENV POSTGRES_USER: postgres
#ENV POSTGRES_PASSWORD: root
#ENV POSTGRES_DB: miit
#ENV PGDATA: /data/postgres
#VOLUME /var/lib/postgresql/data
#EXPOSE 5432
#
## Третья стадия: запуск prometheus
#FROM prom/prometheus:latest AS prometheus
#COPY ./config/prometheus.yml /etc/prometheus/prometheus.yml
#VOLUME ./config/prometheus.yml:/etc/prometheus/prometheus.yml
#EXPOSE 9090
#
## Четвертая стадия: запуск grafana
#FROM grafana/grafana:latest AS grafana
#ENV GF_SECURITY_ADMIN_USER=admin
#ENV GF_SECURITY_ADMIN_PASSWORD=admin
#EXPOSE 3000
#
## Пятая стадия: сборка финального образа
#FROM bellsoft/liberica-openjdk-alpine-musl AS final
#WORKDIR /app
#COPY --from=build /app/target/miit-navigation.jar .
#COPY --from=postgres / /
#COPY --from=prometheus / /
#COPY --from=grafana / /
#EXPOSE 8080
#CMD ["java", "-jar", "miit-navigation.jar"]
