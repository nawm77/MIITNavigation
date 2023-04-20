#docker build -t mitnavigation:latest .
#
#mkdir -p ./data/postgres

# Запускаем контейнер Postgres
#docker run --rm -d \
#  --name postgresMit \
#  -p 5432:5432 \
#  -v /var/lib/postgresql/data \
#  -e POSTGRES_USER=postgres \
#  -e POSTGRES_PASSWORD=root \
#  -e POSTGRES_DB=miit \
#  postgres:latest

docker run --privileged -d -p 8080:8080 \
  --name localtest \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/miit \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=root \
  -e SPRING_JPA_HIBERNATE_DDL_AUTO=create \
  -e MY_ARGS="arg1 args arrg" \
  miitlocaltest:1.1