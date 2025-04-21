# Stage 1: Build Java App
FROM openjdk:17-slim as builder

WORKDIR /app
COPY src/ /app/src/

# Compile Java source code
RUN javac src/App.java -d out

# Stage 2: Production - Distroless Java runtime
FROM gcr.io/distroless/java17-debian11

WORKDIR /app

# Copy compiled classes from builder stage
COPY --from=builder /app/out /app

# Run the compiled class
ENTRYPOINT ["java", "App"]
