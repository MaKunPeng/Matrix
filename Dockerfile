FROM openjdk:11-slim AS build

WORKDIR /app

COPY ./gradle ./settings.gradle ./gradlew ./build.gradle ./gradle.properties ./matrix-common ./matrix-post ./matrix-uaa /app/src/

RUN mkdir -p ~/.gradle \
    && echo "org.gradle.daemon=false" >> ~/.gradle/gradle.properties \
    && echo "org.gradle.configureondemand=true" >> ~/.gradle/gradle.properties \
    && cd /app/src \
    && chmod 750 ./gradlew \
    && ./gradlew --version;

RUN cd /app/src \
    && ./gradlew clean build --parallel --no-daemon;

FROM openjdk:11 AS publish

WORKDIR /app/pub

COPY --from=bulid /app/src/matrix-post/build/libs/matrix-post-1.0-SNAPSHOT.jar /app/pub
COPY --from=build /app/src/matrix-common/build/libs/matrix-common-1.0-SNAPSHOT.jar  /app/src/matrix-uaa/build/libs/matrix-uaa-1.0-SNAPSHOT.jar  /app/pub/lib/

EXPOSE 8080 8088
ENV PATH $PATH:$JAVA_HOME/bin:.

ENTRYPOINT ["java", "-server", "-Xmx2048M", "-cp", "matrix-post-1.0-SNAPSHOT.jar:lib/*", "com.makunpeng.matrix.MatrixAppApplication"]

