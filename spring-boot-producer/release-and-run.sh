mvn clean package
docker build -t sb-cc-producer:1.0 .
docker run --rm sb-cc-producer:1.0