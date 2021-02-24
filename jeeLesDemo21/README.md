# Build
mvn clean package && docker build -t oose.dea/jeeLesDemo21 .

# RUN

docker rm -f jeeLesDemo21 || true && docker run -d -p 8080:8080 -p 4848:4848 --name jeeLesDemo21 oose.dea/jeeLesDemo21 