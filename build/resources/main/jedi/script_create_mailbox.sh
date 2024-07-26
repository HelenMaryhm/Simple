#!/bin/bash

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/mbox?ymreqid=860DD108-3A23-4B25-8670-0D22C6D02379&appid=test' \
                        --header 'Content-Type: application/json' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxMTAxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --data '{
                                    "guid": "GUID125",
                                    "namespace": "yahoo",
                                    "sid": 777,
                                    "email": "email@yahoo.com",
                                    "userIp": "R01010"
                                }')

echo "$cmd" | json_pp