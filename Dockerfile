FROM amazoncorretto:25-jdk AS builder

WORKDIR /app

RUN yum update -y && yum install -y tar gzip

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw clean package -DskipTests -B -T 1C

# --- Runtime ---
FROM amazoncorretto:25-jdk AS runtime
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]