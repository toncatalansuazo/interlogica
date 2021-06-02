# Requirements
- Java 1.8
- Mysql database
# Set up mysql with Docker
``` 
sudo docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:8.0.25
```
# Start container
```
sudo docker ps -a // get container id
sudo docker start <your-container-id>
sudo docker start cbbc0e1d7d4f
```
# Before start application
if you have intellij please  
- Install lombok plugin
- Enable annotation in file > settings
- Change database params in file application.properties for your custom user if you are not using the docker environment
# Start application intellij
Right click in StartUpApplication -> run app
# Start application command line
- cd interlogica
- ./gradlew bootRun
