mvn clean package
docker build -t sb-cc-consumer:1.0 .
docker run --rm sb-cc-consumer:1.0