#!/bin/bash
cd cars-service/
./gradlew clean build

cd ..
cd contracts-service/
./gradlew clean build

cd ..
cd employees-service/
./gradlew clean build

sudo docker-compose down
sudo docker-compose build
sudo docker-compose up
