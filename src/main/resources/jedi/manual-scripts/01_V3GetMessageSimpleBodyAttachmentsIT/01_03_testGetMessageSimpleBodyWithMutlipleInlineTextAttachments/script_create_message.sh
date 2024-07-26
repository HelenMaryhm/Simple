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
    "ymumId": "7",
    "purgeTsSec": 1631539200,
    "references": ["F8HDSJPpPtf"],
    "referencesReal": ["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]
    }'

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/sid/77/mbox/message/?appid=test&ymreqid=860DD108-3A23-4B25-8670-0D22C6D02376' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --form 'MULTI_PART_MAIN_BODY=@/Users/hmaryt/Documents/TYY/ML/Simple/src/main/java/org/example/mime/resources/inlineImage.msg;type=application/octet-stream' \
                        --form "MULTI_PART_HEADER=$json_data;type=application/json")


echo "$cmd" | json_pp

: << 'RESPONSE'

{
   "folder" : {
      "acctId" : 1,
      "count" : 2,
      "deletedId" : 0,
      "highestModSeq" : 3,
      "id" : 2,
      "name" : "Sent",
      "size" : 200,
      "type" : [
         "S"
      ],
      "uidNext" : 3,
      "uidValidity" : 1721273333,
      "unseen" : 0
   },
   "message" : {
      "acctId" : 1,
      "auid" : 3,
      "changeTsMs" : 1721368188091,
      "dedupId" : 1,
      "enhancedChangeTsMs" : 1721368188091,
      "externalChangeTsMs" : 1721368188091,
      "flags" : {
         "seen" : true,
         "spam" : true
      },
      "folderId" : 2,
      "fromEmail" : "test_email@yahoo.com",
      "internalDate" : 1631539200000,
      "mimeId" : "9SfP+a+x3kXa",
      "purgeTsSec" : 1631539200,
      "references" : [
         "F8HDSJPpPtf"
      ],
      "referencesReal" : [
         "<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"
      ],
      "size" : 100,
      "subject" : "Test Subject",
      "threadId" : 3,
      "toAddr" : [
         "to_test_email@yahoo.com"
      ],
      "uid" : 2,
      "ymumId" : "7"
   }
}


RESPONSE