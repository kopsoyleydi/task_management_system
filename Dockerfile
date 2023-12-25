FROM openjdk:21-oracle
MAINTAINER beksultan
COPY task-management.jar task.jar
ENTRYPOINT ["java", "-jar", "task.jar"]