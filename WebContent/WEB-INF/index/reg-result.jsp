<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/statics/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function.js"></script>
<script type="text/javascript" src="<%=basePath%>/statics/scripts/jquery-1.8.3.min.js"></script></head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="<%=basePath%>/statics/images/logo.gif" /></div>
	<div class="help"><a href="index/haslogin?opr=index_buycar" class="shopping">购物车</a><c:choose><c:when test="${!empty sessionScope.hasLogin}"><a href="index/logout">退出</a>&nbsp;&nbsp;${sessionScope.hasLogin.username}</c:when><c:otherwise><a href="index/zzz?opr=index/login.jsp">登录</a></c:otherwise></c:choose><c:if test="${sessionScope.hasLogin.userrole==0}"><a href="index/zzz?opr=manager/index.jsp">后台管理</a></c:if><a href="index/zzz?opr=index/register.jsp">注册</a><a href="liuyan/pageweb?currentPage=-1">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index/index">首页</a></li>
			<%--<c:forEach items="${sessionScope.leftList}" var="fathergood">
			       <c:if test="${fathergood.fatherid==0}">
			            <li><a href="shangp/list?goodid=${songood.goodid}&currentPage=-1">${fathergood.goodname}</a></li>
			       </c:if>
			 </c:forEach>
		--%></ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			   <c:forEach items="${sessionScope.leftList}" var="fathergood">
			       <c:if test="${fathergood.fatherid==0}">
			            <c:forEach items="${sessionScope.leftList}" var="songood">
			              <c:if test="${fathergood.goodid==songood.fatherid}">
			                  <li><a href="shangp/list?goodid=${songood.goodid}&currentPage=-1">${songood.goodname}</a></li>
			              </c:if>
			           </c:forEach>
			       </c:if>
			   </c:forEach>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="finished"><em></em>填写注册信息</li>
				<li class="last-current"><em></em>注册成功</li>
			</ul>
			<div class="msg">
				<p>恭喜：注册成功！</p>
				<p>正在进入登录页...</p>
				<script type="text/javascript">
					setTimeout("location.href='index/zzz?opr=index/login.jsp'", 3000);
				</script>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>