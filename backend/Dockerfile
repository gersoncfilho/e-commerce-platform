# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY backend/pom.xml backend/pom.xml
COPY backend/src backend/src
COPY openapi openapi
WORKDIR /app/backend
RUN mvn clean package -DskipTests -B

# Runtime stage
FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app
RUN mkdir -p ./openapi
COPY openapi/e-commerce-api.yaml ./openapi/e-commerce-api.yaml
COPY --from=build /app/backend/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]