# how to run
Apache Maven Wrapper: 
mvnw clean install

mvnw spring-boot:run

Docker:

docker build -t releasemanager .

docker run -p 8080:8080 releasemanager

# REST interfaces: 
localhost:8080/services : GET with url parameter systemVersion

localhost:8080/deploy : POST with json payload:

{
    "serviceName" : String,
    "serviceVersionNumber" : Integer
}
