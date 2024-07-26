#!bin/bash

cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/sid/771/mbox/message/attachment?appid=test&ymreqid=860DD108-3A23-4B25-8670-0D22C6D02376' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        --form 'MULTI_PART_MAIN_BODY=@/Users/hmaryt/Documents/TYY/core-mail-data-web-services/qa/qa-gateway/src/main/resources/messageFetchSuccess/Inbox1KB.msg;type=application/octet-stream' \
                        --form 'MULTI_PART_ATTACHMENT=@/Users/hmaryt/Documents/TYY/core-mail-data-web-services/qa/qa-gateway/src/main/resources/messageFetchSuccess/Inbox1KB.msg;type=application/octet-stream')

echo "$cmd" | json_pp

/**
 * 528bfe86-7ddf-4b1f-872d-516143000c52

sid: 1234567890
ymumid: test-mid

 */