#!/bin/bash

# Gradle build
./gradlew build -x test

# Podman build
podman build -t totalknowledge/articles-backend:latest .

# Podman push
podman push --tls-verify=false totalknowledge/articles-backend:latest

# Apply Kubernetes resources
#kubectl apply -f k8s/
