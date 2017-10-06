<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>易买网 - 聊天室</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/statics/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/statics/scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function setReceiver(obj)
{
	document.getElementById("reply-to").innerHTML = "接收人：" + obj.innerHTML;
}
</script>
</head>
<body>
<div id="chat-room">
	<div class="lefter">
		<h2>在线用户列表</h2>
		<ul>
			<li><a href="#" onclick="setReceiver(this);">张三</a></li>
		</ul>
	</div>
	<div class="righter">
		<div id="history">
			<p>aaa</p>
			<p>aaa</p>
		</div>
		<div class="spacer"></div>
		<div id="reply-to">接收人：所有</div>
		<div class="reply">
			<input type="text" class="text" name="content" /><label class="ui-blue"><input type="button" value="发送" /></label>
		</div>
	</div>
</div>
</body>
</html>