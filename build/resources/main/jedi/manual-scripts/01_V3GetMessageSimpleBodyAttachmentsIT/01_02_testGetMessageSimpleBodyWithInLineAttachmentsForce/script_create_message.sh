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
    "ymumId": "4",
    "purgeTsSec": 1631539200,
    "references": ["F8HDSJPpPtf"],
    "referencesReal": ["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]
    }'

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/sid/77/mbox/message/?appid=test&ymreqid=860DD108-3A23-4B25-8670-0D22C6D02376' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --form 'MULTI_PART_MAIN_BODY=@/Users/hmaryt/Documents/TYY/core-mail-data-web-services/qa/qa-gateway/src/main/resources/messageFetchSuccess/Inbox1KB.msg;type=application/octet-stream' \
                        --form "MULTI_PART_HEADER=$json_data;type=application/json")


echo "$cmd" | json_pp

: << 'NOTES'
{
   "folder" : {
      "acctId" : 1,
      "count" : 1,
      "deletedId" : 0,
      "highestModSeq" : 2,
      "id" : 2,
      "name" : "Sent",
      "size" : 100,
      "type" : [
         "S"
      ],
      "uidNext" : 2,
      "uidValidity" : 1721273333,
      "unseen" : 0
   },
   "message" : {
      "acctId" : 1,
      "auid" : 2,
      "changeTsMs" : 1721275251236,
      "dedupId" : 1,
      "enhancedChangeTsMs" : 1721275251236,
      "externalChangeTsMs" : 1721275251236,
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
      "threadId" : 2,
      "toAddr" : [
         "to_test_email@yahoo.com"
      ],
      "uid" : 1,
      "ymumId" : "4"
   }
}


NOTES


: << 'RESPONSE'
--Boundary_2_1810037933_1721275295726
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_HEADER"

{"folder":{"id":2,"name":"Sent","acctId":1,"type":["S"],"deletedId":0,"size":100,"count":1,"unseen":0,"highestModSeq":2,"uidNext":2,"uidValidity":1721273333},"message":{"folderId":2,"mimeId":"9SfP+a+x3kXa","size":100,"internalDate":1631539200000,"dedupId":1,"flags":{"answer":false,"attachment":false,"flagged":false,"ham":false,"personIKnow":false,"draft":false,"certified":false,"spam":true,"recent":false,"forwarded":false,"seen":true},"fromEmail":"test_email@yahoo.com","toAddr":["to_test_email@yahoo.com"],"subject":"Test Subject","acctId":1,"threadId":2,"uid":1,"auid":2,"ymumId":"4","purgeTsSec":1631539200,"enhancedChangeTsMs":1721275251236,"references":["F8HDSJPpPtf"],"referencesReal":["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]},"structure":{"docTree":{"size":926,"pid":"TEXT"},"parsedRFC822Headers":{"To":["alpha_f512_test13@yahoo.com"],"From":["Test user <test@test.yahoo.com>"],"Subject":["1KB Inbox message"],"Content-Length":["926"]}}}
--Boundary_2_1810037933_1721275295726
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="TEXT"; name="TEXT"

Inbox1KB.msg

aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
ccccccccccccccccccccccccccccccccccccccccccccccccccccccc
ddddddddddddddddddddddddddddddddddddddddddddddddddddddd
eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
fffffffffffffffffffffffffffffffffffffffffffffffffffffff
ggggggggggggggggggggggggggggggggggggggggggggggggggggggg
hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
lllllllllllllllllllllllllllllllllllllllllllllllllllllll
mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
ooooooooooooooooooooooooooooooooooooooooooooooooooooooo
ppppppppppppppppppppppppppppppppppppppppppppppppppppppp
qqqqqqqqq

END


--Boundary_2_1810037933_1721275295726
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_FOOTER"

{"bodyPartsMeta":{"streamedDataMeta":{"TEXT":{"dataCRC":3446537257,"contentLength":948}}},"responseSummary":{"sid":77,"succeeded":["TEXT"],"failed":[],"status":"SUCCESS"}}
--Boundary_2_1810037933_1721275295726--

RESPONSE