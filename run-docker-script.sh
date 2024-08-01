#!/bin/bash

# Define the parent directory containing all microservices
PARENT_DIR="/Users/amieldelosreyes/Desktop/Amiel Microservices/amiel-microservice-ecosystem"

# Change to the parent directory
cd "$PARENT_DIR" || { echo "Parent directory not found!"; exit 1; }

# Loop through each directory and run docker-compose up -d if docker-compose.yml is present
for dir in */; do
  if [ -d "$dir" ]; then
    cd "$dir" || { echo "Directory $dir not found!"; continue; }

    if [ -f "docker-compose.yml" ]; then
      echo "Starting microservice in $dir"
      if command -v docker-compose >/dev/null 2>&1; then
        docker-compose up -d
      else
        echo "docker-compose command not found, please install Docker Compose."
      fi
    else
      echo "No docker-compose.yml found in $dir, skipping..."
    fi

    cd ..
  fi
done

echo "All microservices processed."
