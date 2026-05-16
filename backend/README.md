# Webshop — Backend

This is the Spring Boot backend for the Webshop project. It is a Maven-based Spring Boot 3.x application (Java 17) that uses PostgreSQL as the runtime database.

**Quick summary**: Build with the included `mvnw` wrapper and run the generated jar, or use `spring-boot:run` during development.

**Prerequisites**
- Java 17 or newer installed and on `PATH`.
- PostgreSQL running (default config uses database `bruna`, user `postgres`, password `postgres`).
- Git (optional) and a terminal (PowerShell on Windows).

If you do not want to install Maven globally you can use the included wrapper: `mvnw` (Linux/macOS) or `mvnw.cmd` (Windows).

**Configuration**
- Main properties file: `src/main/resources/application.properties`.
- Example properties file: `src/main/resources/application.properties.example` — copy or edit for local changes.

Defaults included in `application.properties`:
- `spring.datasource.url=jdbc:postgresql://localhost:5432/bruna`
- `spring.datasource.username=postgres`
- `spring.datasource.password=postgres`
- `server.port=8080`
- `server.servlet.context-path=/api` (the API is served under `/api`)
- `jwt.secret` and `jwt.expiration` (change `jwt.secret` for production)

You can also override configuration via environment variables, for example:

Windows PowerShell:

```
$env:SPRING_DATASOURCE_URL = "jdbc:postgresql://host:5432/dbname"
$env:SPRING_DATASOURCE_USERNAME = "user"
$env:SPRING_DATASOURCE_PASSWORD = "pwd"
$env:JWT_SECRET = "your-secret"
```

Linux / macOS:

```
export SPRING_DATASOURCE_URL="jdbc:postgresql://host:5432/dbname"
export SPRING_DATASOURCE_USERNAME="user"
export SPRING_DATASOURCE_PASSWORD="pwd"
export JWT_SECRET="your-secret"
```

**Database (PostgreSQL) setup**
1. Install and start PostgreSQL.
2. Create the database and (optionally) a dedicated user, e.g.:

```
psql -U postgres -c "CREATE DATABASE bruna;"
psql -U postgres -c "ALTER USER postgres WITH PASSWORD 'postgres';"
```

Adjust `application.properties` or use environment variables if your DB settings differ.

**Build & Run**
From the `backend` directory:

Windows (PowerShell):

```
.\mvnw.cmd clean package
java -jar target/webshop-0.0.1-SNAPSHOT.jar
```

Linux / macOS:

```
./mvnw clean package
java -jar target/webshop-0.0.1-SNAPSHOT.jar
```

During development you can also run directly with the wrapper:

Windows:

```
.\mvnw.cmd spring-boot:run
```

Linux / macOS:

```
./mvnw spring-boot:run
```

**Useful notes**
- The project uses Spring Boot 3.x and targets Java 17 (see `pom.xml`).
- JPA is configured to `create-drop` by default in development (see `spring.jpa.hibernate.ddl-auto`). Change this for production.
- The application serves endpoints under `/api` by default; adjust `server.servlet.context-path` if needed.
- Replace the default `jwt.secret` in `application.properties` before deploying to production.

**Troubleshooting**
- If the application fails to connect to the database, verify PostgreSQL is running and the connection settings in `application.properties` (or environment variables).
- If the port `8080` is already in use, change `server.port` or set `SERVER_PORT` env var.

If you want, I can also: update the README in the frontend folder with matching base URL, or add a small script to run both frontend and backend together.

