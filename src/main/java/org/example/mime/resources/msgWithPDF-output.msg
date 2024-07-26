Boundary_1_1604154711_1721273443712
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_HEADER"

{"folder":{"id":1,"name":"Inbox","acctId":1,"type":["M"],"deletedId":0,"size":100,"count":1,"unseen":0,"highestModSeq":2,"uidNext":2,"uidValidity":1721273333},"message":{"folderId":1,"mimeId":"9SfP+a+x3kXa","size":100,"internalDate":1631539200000,"dedupId":1,"flags":{"answer":false,"attachment":false,"flagged":false,"ham":false,"personIKnow":false,"draft":false,"certified":false,"spam":true,"recent":false,"forwarded":false,"seen":true},"fromEmail":"test_email@yahoo.com","toAddr":["to_test_email@yahoo.com"],"subject":"Test Subject","acctId":1,"threadId":1,"uid":1,"auid":1,"ymumId":"3","purgeTsSec":1631539200,"enhancedChangeTsMs":1721273357300,"references":["F8HDSJPpPtf"],"referencesReal":["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]},"structure":{"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["multipart/alternative; boundary=\"-1195379013-681422013-1361901172=:29394\""]},"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain; charset=us-ascii"]},"size":51,"pid":"1.1"},"2":{"parsedMimeHeaders":{"Content-Type":["text/html; charset=us-ascii"]},"size":221,"pid":"1.2"}},"size":488,"pid":"1"},"2":{"parsedMimeHeaders":{"Content-Type":["application/pdf; name=\"sample-pdf.pdf\""],"Content-Transfer-Encoding":["base64"],"Content-Disposition":["attachment; filename=\"sample-pdf.pdf\""]},"size":218882,"pid":"2"}},"size":297563,"pid":"TEXT"},"parsedRFC822Headers":{"Date":["Tue, 26 Feb 2013 09:52:52 -0800 (PST)"],"From":["Test User<testuser@yahoo-inc.com>"],"Reply-To":["Test User <testuser@yahoo-inc.com>"],"Subject":["sample pdf"],"To":["\"anothertester@yahoo.com\" <anothertester@yahoo.com>"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed; boundary=\"-1195379013-343248129-1361901172=:29394\""],"Content-Length":["297469"]}}}
--Boundary_1_1604154711_1721273443712
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="1.1"; name="1.1"

test unique content for ListMessagesV3SearchIT 😀
--Boundary_1_1604154711_1721273443712
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="1.2"; name="1.2"

<html><body><div style="color:#000; background-color:#fff; font-family:Courier New, courier, monaco, monospace, sans-serif;font-size:10pt"><div>test unique content for ListMessagesV3SearchIT 😀</div></div></body></html>
--Boundary_1_1604154711_1721273443712
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_FOOTER"

{"bodyPartsMeta":{"streamedDataMeta":{"1.1":{"dataCRC":3046236367,"contentLength":51},"1.2":{"dataCRC":3903384398,"contentLength":221}}},"responseSummary":{"sid":77,"succeeded":["1.1","1.2"],"failed":[],"status":"SUCCESS"}}
--Boundary_1_1604154711_1721273443712--