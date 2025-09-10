 
# Configure the app

copy the file `config/application_cc_template.properties` as `config/application.properties`

If you want to run on local instace (docker) you can use/copy the `application_cc_template.properties`

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