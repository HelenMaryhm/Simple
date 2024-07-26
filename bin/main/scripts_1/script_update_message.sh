#!/bin/bash

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/sid/77/mbox/folder/fid/2/updateMessagesByUid?appid=testAppId&ymreqid=651d52bf-abf1-fd97-50fa-6483ce7be81d' \
                        --header 'Content-Type: application/json' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --data '{
                            "ids": {
                                "1": {
                                    "operationId": "batch_updates_1"
                                }
                            },
                            "operations": {
                                "batch_updates_1": {
                                    "updates": {
                                        "folderId": 1,
                                        "restoreMessage": true
                                    },
                                    "resets": {
                                        "purgeTsSec": true
                                    }
                                }
                            }
                        }'
                        {"metaData":{"folders":[{"id":1,"name":"Inbox","acctId":1,"type":["M"],"deletedId":0,"size":100,"count":1,"unseen":0,"highestModSeq":3,"uidNext":3,"uidValidity":1711683063},{"id":2,"name":"Sent","acctId":1,"type":["S"],"deletedId":0,"size":0,"count":0,"unseen":0,"highestModSeq":2,"uidNext":2,"uidValidity":1711683063}],"messages":[{"uid":2,"ymumId":"1","enhancedChangeTsMs":1711683193445}]},"responseSummary":{"sid":5013089560217780224,"status":"SUCCESS","succeeded":["2"]}})

echo "$cmd" | json_pp