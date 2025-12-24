# Records Sample Webapp

Records is an example fork from `kodejava.org` which I have refactored and configured with maven and changing the ORM to mybatis.

## For database

```sql
CREATE DATABASE IF NOT EXISTS records CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

## Dockeryzing

```
docker build -t cesardlentelgy/records-sample-webapp:latest .
```

```
docker run --name records-sample-webapp --network cesardl-bridge-network -p 8282:8080 -d cesardlentelgy/records-sample-webapp:latest
```
