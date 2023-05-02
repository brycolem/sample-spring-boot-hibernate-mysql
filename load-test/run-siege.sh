#!/bin/bash

# Variables
concurrent_users=255
ramp_up_time=5
total_duration=18

# Generate the URL list
url_list="url_list.txt"
touch $url_list
echo "http://172.21.118.12:8080/api/v1/article" > $url_list
for i in {1..10}; do
  echo "http://172.21.118.12:8080/api/v1/article/$i" >> $url_list
done

# Start Siege ramping up users
echo "Starting ramp-up test with $concurrent_users concurrent users for ${ramp_up_time} seconds"
siege -f $url_list -c $concurrent_users --delay=0.2s --time=${ramp_up_time}s --internet

# Run Siege with full concurrency
echo "Starting full concurrency test with $concurrent_users concurrent users for ${total_duration} seconds"
siege -f $url_list -c $concurrent_users --delay=0.2s --time=${total_duration}s --internet
