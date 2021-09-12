#!/usr/bin/env bash

kill -9 $(lsof -t -i:8080)
echo "Killed process running on port 8080"

echo "Starting server using java -jar command"
java -jar -Dpath-to-admin-service-account='/home/ec2-user/firebase-admin-service-account.json' "/home/ec2-user/task-scheduler-0.0.1-SNAPSHOT.jar"
