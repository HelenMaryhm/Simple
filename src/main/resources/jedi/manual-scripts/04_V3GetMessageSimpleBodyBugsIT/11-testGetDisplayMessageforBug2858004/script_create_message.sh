#!/bin/bash

json_data='{
    "folderId": 2,
    "mimeId": "9SfP+a+x3kXa",
    "size": 100,
    "internalDate": 1631539200000,
    "dedupId": 1,
    "flags": {
        "seen": true,
        "spam": true
    },
    "fromEmail": "test_email@yahoo.com",
    "toAddr": ["to_test_email@yahoo.com"],
    "subject": "Test Subject",
    "acctId": 100,
    "threadId": 1,
    "ymumId": "11",
    "purgeTsSec": 1631539200,
    "references": ["F8HDSJPpPtf"],
    "referencesReal": ["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]
    }'

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/sid/777/mbox/message/?appid=test&ymreqid=860DD108-3A23-4B25-8670-0D22C6D02376' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --form 'MULTI_PART_MAIN_BODY=@/Users/hmaryt/Documents/TYY/ML/Simple/src/main/resources/jedi/manual-scripts/04_V3GetMessageSimpleBodyBugsIT/11-testGetDisplayMessageforBug2858004/msg_bug2858004.msg;type=application/octet-stream' \
                        --form "MULTI_PART_HEADER=$json_data;type=application/json")


echo "$cmd" | json_pp