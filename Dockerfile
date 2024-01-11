FROM openjdk:17
COPY target/task-management-app-apis.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar", "task-management-app-apis.jar"]