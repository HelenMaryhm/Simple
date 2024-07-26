#!/bin/bash

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/migration/sid/777/mbox/message/updateMessagesByYmumid?appid=testAppId&ymreqid=651d52bf-abf1-fd97-50fa-6483ce7be81d' \
                        --header 'Content-Type: application/json' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --data '{
                            "ids": {
                                "2": {
                                    "operationId": "batch_updates_1"
                                }
                            },
                            "operations": {
                                "batch_updates_1": {
                                    "updates": {
                                        "folderId": 3,
                                        "mimeId": "10SfP+a+x3kXa"
                                    },
                                    "resets": {
                                        "purgeTsSec": 163153920023434
                                    }
                                }
                            }
                        }')

echo "$cmd" | json_pp