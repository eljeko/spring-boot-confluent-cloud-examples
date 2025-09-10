 
# Configure the app

copy the file `config/application_template.properties` as `config/application.properties`

Properly configure the file with your:

* bootstrap-servers
* API Key and Secret
* Your topic name (default is `test`)

# Build and run

  Use java >= 21

  mvn clean package 
    
  java -jar target/spring-boot-producer-1.0.jar

# Running with docker

  docker build -t sb-cc-producer:1.0 .

  docker run --rm sb-cc-producer:1.0