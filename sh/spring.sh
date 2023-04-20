docker run -d -p 8080:8080 \
  --name serviceMIIT \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/miit \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=root \
  -e SPRING_JPA_HIBERNATE_DDL_AUTO=create \
  -e ARGS = "arg1 arg2 arg3" \
  miitlocaltest:latest
