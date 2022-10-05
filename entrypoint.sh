#!/bin/sh -x
set -e

if [ -z "$SPRING_DATASOURCE_URL" ]; then
  SPRING_DATASOURCE_URL=jdbc:postgresql://postgres.backend:5432/apka
fi

if [ -z "$SPRING_DATASOURCE_USERNAME" ]; then
  SPRING_DATASOURCE_USERNAME=apka
fi

if [ -z "$SPRING_DATASOURCE_PASSWORD" ]; then
  SPRING_DATASOURCE_PASSWORD=apka
fi

if [ -z "$SPRING_MINIO_URL" ]; then
  SPRING_MINIO_URL=http://minio.backend:9000
fi

if [ -z "$SPRING_MINIO_BUCKET" ]; then
  SPRING_MINIO_BUCKET=apka
fi

if [ -z "$SPRING_MINIO_ACCESSKEY" ]; then
  SPRING_MINIO_ACCESSKEY=minio
fi

if [ -z "$SPRING_MINIO_SECRETKEY" ]; then
  SPRING_MINIO_SECRETKEY=minio123
fi

if [ -z "$SERVER_PORT" ]; then
  SERVER_PORT=8080
fi

exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar \
 -Dserver.port=${SERVER_PORT} \
 -Dspring.datasource.url=${SPRING_DATASOURCE_URL} \
 -Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME} \
 -Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD} \
 -Dspring.minio.url=${SPRING_MINIO_URL} \
 -Dspring.minio.bucket=${SPRING_MINIO_BUCKET} \
 -Dspring.minio.access-key=${SPRING_MINIO_ACCESSKEY} \
 -Dspring.minio.secret-key=${SPRING_MINIO_SECRETKEY} \
 app.jar
