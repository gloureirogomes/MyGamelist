# Use the official gradle image to create a build artifact.
# https://hub.docker.com/_/gradle
FROM gradle:6.7 as builder

# Copy local code to the container image.
COPY build.gradle .
COPY src ./src

# Build a release artifact.
RUN gradle clean build --no-daemon

# Use the Official OpenJDK image for a lean production stage of our multi-stage build.
# https://hub.docker.com/_/openjdk
# https://docs.docker.com/develop/develop-images/multistage-build/#use-multi-stage-builds
FROM openjdk:11.0.10-oraclelinux7

# Copy the jar to the production image from the builder stage.
COPY --from=builder application/build/libs/application-1.0.0-all.jar /myGamelist.jar

# Run the web service on container startup.
CMD ["java", "-jar", "myGamelist.jar"]