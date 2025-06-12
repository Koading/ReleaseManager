# how to run

mwnw clean install

mvnw spring-boot:run

# REST interfaces: 
localhost:8080/services : GET with url parameter systemVersion
localhost:8080/deploy : POST with json payload:

{
    "serviceName" : String,
    "serviceVersionNumber" : Integer
}