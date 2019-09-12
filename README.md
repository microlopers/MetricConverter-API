# MetricConverter-API

API for conversion from/to metric system. 

## Run Application
Use following command to run application:
```
gradle bootRun
```

## Run Tests
Use following command to run unit and integration tests:
```
gradle test
```

## SonarQube
Use following command to send JaCoCo reports from tests to SonarQube:
```
gradle test sonarqube
```

### SonarQube in Docker 
If you have no SonarQube installed locally, run following command to start SonarQube container with exposed default port 9000 in your local Docker:
```
docker run -d --name sonarqube -p 9000:9000 --restart unless-stopped sonarqube:latest
```
SonarQube can be than accessed on URL:
 ```
http://localhost:9000
```
