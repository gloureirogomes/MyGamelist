FROM gradle:latest

# Copy local code to the container image.
COPY build.gradle .
COPY . ./src

# Build a release artifact.
RUN gradle clean build --no-daemon

# Copy the jar to the production image from the builder stage.
COPY application/build/libs/application-1.0.0-all.jar /application-1.0.0-all.jar

# Run the web service on container startup.
CMD ["java", "-jar", "/application-1.0.0-all.jar"] 