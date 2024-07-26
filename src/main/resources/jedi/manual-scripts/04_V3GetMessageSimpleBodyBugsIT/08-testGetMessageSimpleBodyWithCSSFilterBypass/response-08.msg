--Boundary_8_621351283_1721917686723
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_HEADER"

{"folder":{"id":2,"name":"Sent","acctId":1,"type":["S"],"deletedId":0,"size":800,"count":8,"unseen":0,"highestModSeq":9,"uidNext":9,"uidValidity":1721915278},"message":{"folderId":2,"mimeId":"9SfP+a+x3kXa","size":100,"internalDate":1631539200000,"dedupId":1,"flags":{"answer":false,"attachment":false,"flagged":false,"ham":false,"personIKnow":false,"draft":false,"certified":false,"spam":true,"recent":false,"forwarded":false,"seen":true},"fromEmail":"test_email@yahoo.com","toAddr":["to_test_email@yahoo.com"],"subject":"Test Subject","acctId":1,"threadId":8,"uid":8,"auid":8,"ymumId":"08","purgeTsSec":1631539200,"enhancedChangeTsMs":1721917665933,"references":["F8HDSJPpPtf"],"referencesReal":["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]},"structure":{"docTree":{"size":668,"pid":"TEXT"},"parsedRFC822Headers":{"From":["jouko <jouko@klikki.fi>"],"Subject":["HackerOne test"],"To":["vastaus@rocketmail.com"],"Mime-Version":["1.0"],"Content-Type":["text/html"]}}}
--Boundary_8_621351283_1721917686723
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="TEXT"; name="TEXT"

Test case for https://jira.vzbuilders.com/browse/MAS-19596:
Newline in quoted property value
<style>
    div {
        font-family:"foo
        bar";background:url("cid://x;position:fixed;left:0px;top:0px;right:0px;bottom:0px;z-index:99999;background:blue;color:white;");
    }
</style>
Carriage Return in quoted property value
<style>
div {
bar";background:url("cid://x;position:fixed;left:0px;top:0px;right:0px;bottom:0px;z-index:99999;background:blue;color:white;");
}
</style>
Inline style attribute
<div style="font-family:'foo
bar';background:url('cid://x;position:fixed;left:0px;top:0px;right:0px;bottom:0px;z-index:99999;background:blue;color:white;');"></div>
--Boundary_8_621351283_1721917686723
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_FOOTER"

{"bodyPartsMeta":{"streamedDataMeta":{"TEXT":{"dataCRC":3217440849,"contentLength":684}}},"responseSummary":{"sid":777,"succeeded":["TEXT"],"failed":[],"status":"SUCCESS"}}
--Boundary_8_621351283_1721917686723--