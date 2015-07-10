<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Apollo Chat</title>
    <g:javascript library="jquery"/>
</head>
<body>
<div id="chatMessages" style="max-height:400px; overflow-y:scroll; background-color:#C8F7C5"></div>
<input type="text" id="messageBox" autofocus placeholder="Your message here" name="message" onkeypress="messageKeyPress(this,event);" style="margin:10px;width:95.5%;border-color:#95A5A6;border-style:solid;border-width:5px"/>
<div id="temp"></div>
<script>
	var firstTimeLoading = true;
	
    function messageKeyPress(field,event) {
        var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
        var message = $('#messageBox').val();
        if (theCode == 13){
            <g:remoteFunction action="submitMessage" params="\'content=\'+message" update="temp"/>
            $('#messageBox').val('');
            forceScrollDown();
            return false;
        } else {
            return true;
        }
    }

	function forceScrollDown(){
		var elem = document.getElementById('chatMessages');
	    elem.scrollTop = elem.scrollHeight;
	}
    
    function retrieveLatestMessages() {
        <g:remoteFunction action="retrieveLatestMessages" update="chatMessages" options='[asynchronous: false]'/>
    }
    function pollMessages() {
        retrieveLatestMessages();
        setTimeout('pollMessages()', 5000);
    }
    pollMessages();
</script>
</body>
</html>