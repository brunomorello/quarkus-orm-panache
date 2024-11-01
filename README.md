# Quarkus ORM Sample

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Bootstraping the app:

Create Quarkus agroal (Pure JDBC) - MYSQL
```shell script
mvn -U io.quarkus:quarkus-maven-plugin:create -DprojectGroupId="pt.bmo.quarkus.orm" -DprojectArtifactId=artist -DpackageName="pt.bmo.quarkus.jdbc" -Dextensions="jdbc-mysql,quarkus-agroal"
```

Create Quarkus Hibernate (JPA) - MARIADB
```shell script
mvn -U io.quarkus:quarkus-maven-plugin:create -DprojectGroupId="pt.bmo.quarkus.orm" -DprojectArtifactId=customer -DpackageName="pt.bmo.quarkus.jpa" -Dextensions="jdbc-mariadb,hibernate-orm"
```

Create Quarkus Hibernate ORM Panache - POSTGRESQL
```shell script
mvn -U io.quarkus:quarkus-maven-plugin:create -DprojectGroupId="pt.bmo.quarkus.orm" -DprojectArtifactId="vintage-store" -DpackageName="pt.bmo.quarkus.panache" -Dextensions="jdbc-postgresql,hibernate-orm-panache"
```

## Running several tests in parallel
```shell script
mvn -T 1C test
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```
```shell script
mvn clean install -D"maven.test.skip"=true
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/artist-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)
