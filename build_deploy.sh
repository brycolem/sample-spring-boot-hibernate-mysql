#!/bin/bash

# Gradle build
./gradlew build -x test

# Podman build
podman build -t localhost:5001/articles-backend:latest .

# Podman push
podman push --tls-verify=false localhost:5001/articles-backend:latest

# Apply Kubernetes resources
kubectl apply -f k8s/
