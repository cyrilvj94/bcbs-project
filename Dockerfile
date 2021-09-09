FROM openjdk:8
ADD target/bcbs-project-pipeline.jar bcbs-project-pipeline.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","bcbs-project-pipeline.jar"]