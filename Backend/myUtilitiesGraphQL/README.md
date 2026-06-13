# Getting Started

spring.datasource.url=jdbc:h2:mem:testdb

spring.datasource.username=sa

spring.datasource.password=

### In the H2 Console login page, use:
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password:

### h2 console
- http://localhost:8080/gql-api/h2-console

### build jar : 
- mvn clean package

### run the jar
- java -jar target/myUtilitiesGraphQL-0.0.1-SNAPSHOT.jar

### EC2 Deployment
- https://youtu.be/IdP_S_alyI4?si=d9xY_Lg37IvZYrX2 (Deployment Video)
- 
#### copy jar to ec2
- scp -i "KeyPair-KeyPair.pem" myUtilitiesGraphQL-0.0.1-SNAPSHOT.jar ec2-user@ec2-54-199-199-199.compute-1.amazonaws.com:/home/ec2-user/my-directory

#### install java in ec2
- sudo dnf install java-21-amazon-corretto -y

#### run application
- java -jar my-directory/myUtilitiesGraphQL-0.0.1-SNAPSHOT.jar

#### test curl inside ec2
- curl --location 'http://localhost:8080/utilities-api/health'

#### setup inbound rules for HTTP and port 8080

#### test curl from outside
- curl --location 'http://ec2-54-199-199-199.compute-1.amazonaws.com:8080/utilities-api/health'