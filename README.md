## Работа с приложением

### Загрузка файлов через приложение Storage

Запрос на сохранение

```
curl -X POST "http://localhost:8090/api/files/" -H  "accept: application/json" -H  "Content-Type: multipart/form-data" -H -d {"file":{}}
```

Ответ

```
{
  "uuid": "fab08333-926b-44c2-b6c7-a2f931201d54"
}
```

### Запрос сохраненных ресурсов из приложения Storage

Запрос сохраненного ресурса

```
curl -X GET "http://localhost:8090/api/files/fab08333-926b-44c2-b6c7-a2f931201d54" -H  "accept: */*"
```  

Ответ - поток данных

```
content-type: image/jpeg;charset=UTF-8 
```

## Работа с MINIO

Веб интерфейс MINIO доступен локально по порту `9009`

```
http://localhost:9009/minio/
```

Параметры аутентификации указаны в .env файле

```
#################################################
## MINIO properties
#################################################
MINIO_ACCESS_KEY=minio
MINIO_SECRET_KEY=minio123
```
