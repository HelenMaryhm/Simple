#!/bin/bash


cmd=$(curl -s -v -H --location 'http://localhost:8080/cmdg/v1/sid/77/mbox/message/ymumid/4/mime/structure/inline?appid=test&ymreqid=860DD108-3A23-4B25-8670-0D22C6D02376' \
                        --header 'x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9' \
                        )
echo "$cmd"



: <<'RESPONSE'

> GET /cmdg/v1/sid/77/mbox/message/ymumid/1/mime/structure/inline?appid=test&ymreqid=860DD108-3A23-4B25-8670-0D22C6D02376 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/8.5.0
> Accept: */*
> x-comms-shard-info: eyJzaGFyZCI6eyJpZCI6MTIxLCJpbmZvIjp7Imluc3RhbmNlIjoiY20tZGV2LWN1c3RvbS1zYW5kYm94IiwiZGIiOiJobWFyeXQtZGIifX0sInNpZCI6Nzd9
>
< HTTP/1.1 200 OK
< Content-Type: multipart/form-data
< Content-Length: 8800
<
{ [8800 bytes data]
* Connection #0 to host localhost left intact
--Boundary_3_738260980_1720685625900
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_HEADER"

{"folder":{"id":1,"name":"Inbox","acctId":1,"type":["M"],"deletedId":0,"size":100,"count":1,"unseen":0,"highestModSeq":2,"uidNext":2,"uidValidity":1720681702},"message":{"folderId":1,"mimeId":"9SfP+a+x3kXa","size":100,"internalDate":1631539200000,"dedupId":1,"flags":{"answer":false,"attachment":false,"flagged":false,"ham":false,"personIKnow":false,"draft":false,"certified":false,"spam":true,"recent":false,"forwarded":false,"seen":true},"fromEmail":"test_email@yahoo.com","toAddr":["to_test_email@yahoo.com"],"subject":"Test Subject","acctId":1,"threadId":1,"uid":1,"auid":1,"ymumId":"1","purgeTsSec":1631539200,"enhancedChangeTsMs":1720682280622,"references":["F8HDSJPpPtf"],"referencesReal":["<calendar-ba859d5c-6e53-40f8-a1f8-c5aeba0a0bb7.ref@google.com>"]},"structure":{"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain; charset=iso-8859-1"],"Content-Transfer-Encoding":["8bit"]},"size":190,"pid":"1"},"2":{"parsedMimeHeaders":{"Content-Type":["message/rfc822"],"Content-Transfer-Encoding":["8bit"]},"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["multipart/alternative; boundary=\"0-1054241370-1146072583=:24642\""]},"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain; charset=iso-8859-1"],"Content-Transfer-Encoding":["8bit"]},"size":150,"pid":"2.1.1"},"2":{"parsedMimeHeaders":{"Content-Type":["text/html; charset=iso-8859-1"],"Content-Transfer-Encoding":["8bit"]},"size":252,"pid":"2.1.2"}},"size":659,"pid":"2.1"},"2":{"parsedMimeHeaders":{"Content-Type":["message/rfc822"]},"docTree":{"parts":{"1":{"parsedMimeHeaders":{"Content-Type":["text/plain;\tcharset=\"us-ascii\""],"Content-Transfer-Encoding":["quoted-printable"]},"size":305,"pid":"2.2.1"},"2":{"parsedMimeHeaders":{"Content-Disposition":["attachment"],"Content-Type":["application/ms-tnef;\tname=\"winmail.dat\""],"Content-Transfer-Encoding":["base64"]},"size":765899,"pid":"2.2.2"}}},"size":1037757,"parsedRFC822Headers":{"X-Apparently-To":["alam1128@yahoo.com via 68.142.207.161; Tue, 13 Sep 2005 10:03:45 -0700"],"X-Originating-Ip":["[64.233.184.192]"],"Authentication-Results":["mta204.mail.dcn.yahoo.com  from=hp.com; domainkeys=neutral (no sig)"],"Received":["from 64.233.184.192  (EHLO wproxy.gmail.com) (64.233.184.192)  by mta204.mail.dcn.yahoo.com with SMTP; Tue, 13 Sep 2005 10:02:04 -0700","by wproxy.gmail.com with SMTP id 58so2267595wri        for <alam1128@yahoo.com>; Tue, 13 Sep 2005 10:01:34 -0700 (PDT)","by 10.54.44.11 with SMTP id r11mr621830wrr;        Tue, 13 Sep 2005 10:01:33 -0700 (PDT)","by 10.54.11.52 with SMTP id 52cs16531wrk;        Tue, 13 Sep 2005 10:01:32 -0700 (PDT)","by 10.37.13.69 with SMTP id q69mr941154nzi;        Tue, 13 Sep 2005 10:01:30 -0700 (PDT)","from palrel11.hp.com (palrel11.hp.com [156.153.255.246])        by mx.gmail.com with ESMTP id 20si1202730nzp.2005.09.13.10.01.25;        Tue, 13 Sep 2005 10:01:30 -0700 (PDT)","from cacexg11.americas.cpqcorp.net (cacexg11.americas.cpqcorp.net [16.92.1.67])\tby palrel11.hp.com (Postfix) with ESMTP id B85004894;\tTue, 13 Sep 2005 10:01:23 -0700 (PDT)","from cacexc04.americas.cpqcorp.net ([16.92.1.26]) by cacexg11.americas.cpqcorp.net with Microsoft SMTPSVC(6.0.3790.211);\t Tue, 13 Sep 2005 10:00:24 -0700"],"X-Forwarded-To":["alam1128@yahoo.com"],"X-Forwarded-For":["alam17@gmail.com alam1128@yahoo.com"],"X-Gmail-Received":["ac37aa4d02bfe5699aa95e15f826b007131ca277"],"Delivered-To":["alam17@gmail.com"],"Received-Spf":["pass (gmail.com: domain of betty.lam@hp.com designates 156.153.255.246 as permitted sender)"],"X-Mimeole":["Produced By Microsoft Exchange V6.5.7226.0"],"Content-Class":["urn:content-classes:message"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed;\tboundary=\"----_=_NextPart_001_01C5B884.A15080D0\""],"Subject":["FW: sally & us"],"Date":["Tue, 13 Sep 2005 10:00:23 -0700"],"X-Ms-Has-Attach":["yes"],"X-Ms-Tnef-Correlator":["<B6C7F31B85669143825614FC8FE6492903AA6C7C@cacexc04.americas.cpqcorp.net>"],"Thread-Topic":["sally & us"],"Thread-Index":["AcW4drLsslD1xH1lTJqZ5P1FKR7F7AADdoHg"],"From":["\"Lam, Betty\" <betty.lam@hp.com>"],"To":["\"Amy Wong\" <amwong@adobe.com>,\t\"Alberto Lam\" <lamalberto@netscape.net>,\t\"Antonio Lam\" <alam17@gmail.com>,\t\"Connie Lau\" <connielau1128@gmail.com>,\t\"Joshua Clark\" <joshuayclark@yahoo.com>,\t\"Lily Lam\" <Lilyqliu@netscape.net>"],"X-Originalarrivaltime":["13 Sep 2005 17:00:24.0398 (UTC) FILETIME=[A20E7EE0:01C5B884]"],"Content-Length":["778697"]},"pid":"2.2"}}},"size":1039821,"parsedRFC822Headers":{"X-Apparently-To":["tracyhsu1798@yahoo.com via 68.142.207.160; Wed, 26 Apr 2006 10:29:44 -0700"],"X-Originating-Ip":["[68.142.207.151]"],"Authentication-Results":["mta287.mail.mud.yahoo.com  from=yahoo.com; domainkeys=pass (ok)"],"Received":["from 68.142.207.151  (HELO web32303.mail.mud.yahoo.com) (68.142.207.151)  by mta287.mail.mud.yahoo.com with SMTP; Wed, 26 Apr 2006 10:29:43 -0700","(qmail 26487 invoked by uid 60001); 26 Apr 2006 17:29:43 -0000","from [216.145.54.158] by web32303.mail.mud.yahoo.com via HTTP; Wed, 26 Apr 2006 10:29:43 PDT"],"Domainkey-Signature":["a=rsa-sha1; q=dns; c=nofws;  s=s1024; d=yahoo.com;  h=Message-ID:Received:Date:From:Subject:To:MIME-Version:Content-Type:Content-Transfer-Encoding;  b=0KGAB7RumiDpt4ilyo0M9C40FqPmV/3Z0W0ecn5iGFI2T0/c2GGXaxXVQg81kbwjmK5vnx+M07IXwJdBZZTwn9bn8y3ZNPTSq73iyZL9O2cMdpe90krD5sshGiVLM4u58rSLgXC3LGX3Gr/z8YtyitbiA/cbWYEMc67CZTx/pws=  ;"],"Date":["Wed, 26 Apr 2006 10:29:43 -0700 (PDT)"],"From":["cg test cg test <buggy_messages@yahoo.com>"],"Subject":["Fwd: FW: sally & us"],"To":["tracyhsu1798@yahoo.com"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed; boundary=\"0-766657669-1146072583=:24642\""],"Content-Transfer-Encoding":["8bit"],"Content-Length":["780220"]},"pid":"2"}},"size":1040254,"pid":"TEXT"},"parsedRFC822Headers":{"X-Apparently-To":["buggy_messages@yahoo.com via 68.142.207.151; Wed, 19 Jul 2006 18:02:52 -0700"],"Received":["from 68.142.207.151  (HELO web32303.mail.mud.yahoo.com) (68.142.207.151)  by mta107.mail.re4.yahoo.com with SMTP; Wed, 19 Jul 2006 18:02:51 -0700","(qmail 70198 invoked by uid 60001); 20 Jul 2006 01:02:45 -0000","from [216.145.49.15] by web32303.mail.mud.yahoo.com via HTTP; Wed, 19 Jul 2006 18:02:45 PDT"],"Message-Id":["<20060720010245.70182.qmail@web32303.mail.mud.yahoo.com>"],"Date":["Wed, 19 Jul 2006 18:02:45 -0700 (PDT)"],"From":["\"tracyhsu1798@yahoo.com\" <tracyhsu1798@yahoo.com>"],"Reply-To":["tracyhsu1798@yahoo.com"],"Subject":["Fwd: FW: sally & us"],"To":["buggy_messages@yahoo.com"],"Mime-Version":["1.0"],"Content-Type":["multipart/mixed; boundary=\"0-1634966140-1153357365=:69162\""],"Content-Transfer-Encoding":["8bit"]}}}
--Boundary_3_738260980_1720685625900
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="1"; name="1"


Note: forwarded message attached.


__________________________________________________
Do You Yahoo!?
Tired of spam?  Yahoo! Mail has the best spam protection around
http://mail.yahoo.com
--Boundary_3_738260980_1720685625900
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="2.1.1"; name="2.1.1"



Note: forwarded message attached.

---------------------------------
How low will we go? Check out Yahoo! Messenger�s low  PC-to-Phone call rates.
--Boundary_3_738260980_1720685625900
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="2.1.2"; name="2.1.2"

<BR><BR>Note: forwarded message attached.<p>
                <hr size=1>How low will we go? Check out Yahoo! Messenger�s low <a href="http://us.rd.yahoo.com/mail_us/taglines/postman8/*http://us.rd.yahoo.com/evt=39663/*http://voice.yahoo.com"> PC-to-Phone call rates.
--Boundary_3_738260980_1720685625900
Content-Type: application/octet-stream
Content-Disposition: form-data; filename="2.2.1"; name="2.2.1"

Picture with Sally :)
=20
-----Original Message-----
From: Tom, Jocelyn Lee=20
Sent: Tuesday, September 13, 2005 8:21 AM
To: Lam, Betty; Liu, Sarah Shuxia
Cc: Tom, Jocelyn Lee; Wong, Gloria
Subject: sally & us


    sorry, pictures didn't turn out really good - shaky hands or=20
    too dark :(
=20

--Boundary_3_738260980_1720685625900
Content-Type: application/json
Content-Disposition: form-data; name="MULTI_PART_FOOTER"

{"bodyPartsMeta":{"streamedDataMeta":{"1":{"dataCRC":482306151,"contentLength":197},"2.1.1":{"dataCRC":1610356496,"contentLength":155},"2.1.2":{"dataCRC":250454967,"contentLength":253},"2.2.1":{"dataCRC":2140788849,"contentLength":313}}},"responseSummary":{"sid":77,"succeeded":["1","2.1.1","2.1.2","2.2.1"],"failed":[],"status":"SUCCESS"}}
--Boundary_3_738260980_1720685625900--


RESPONSE


# http://localhost:8080/cmdg/v1/sid/1749881602392827073/mbox/message/ymumid/3/mime/structure/inline?appid=testAppId&ymreqid=668f909f-a471-6eb2-336a-02d16727a387

: <<'REQUEST-URL'
GET http://localhost:8080/cmdg/v1/sid/1749881602392827073/mbox/message/ymumid/3/mime/structure/inline?appid=testAppId&ymreqid=668f909f-a471-6eb2-336a-02d16727a387&slaMS=15000 HTTP/1.1
REQUEST-URL
