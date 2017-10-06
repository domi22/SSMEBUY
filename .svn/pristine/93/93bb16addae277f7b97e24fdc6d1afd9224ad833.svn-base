<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/statics/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function-manage.js"></script>
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function.js"></script></head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="<%=basePath%>/statics/images/logo.gif" /></div>
	<div class="help"><a href="../index.html">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index/index">首页</a></li>
			<li><a href="index/user">用户</a></li>
			<li><a href="shangp/page?usecurrentPage=-1">商品</a></li>
			<li><a href="indent/page?usecurrentPage=-1">订单</a></li>
			<li><a href="liuyan/page?currentPage=-1">留言</a></li>
			<li><a href="news/page?currentPage=-1">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${sessionScope.hasLogin.username}您好，今天是
		<jsp:useBean id="now" class="java.util.Date" scope="page"/>
        <fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="index/zzz?opr=manager/user-add.jsp">新增</a></em><a href="index/user">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="index/toclassadd">新增</a></em><a href="index/togood">分类管理</a></dd>
				<dd><em><a href="index/zzz?opr=manager/product-add.jsp">新增</a></em><a href="shangp/page?usecurrentPage=-1">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="indent/page?usecurrentPage=-1">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="liuyan/page?currentPage=-1">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="index/zzz?opr=manager/news-add.jsp">新增</a></em><a href="news/page?currentPage=-1">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>昵称</th>
					<th>内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${requestScope.liuyanlist}"  var="liuyan">
					<tr>
						<td class="first w4 c">${liuyan.lyid}</td>
						<td class="w1 c">${liuyan.lyauther}</td>
						<td>${liuyan.lycontent}</td>
						<td class="w1 c">${liuyan.status}</td>
						<td class="w1 c"><a href="javascript:void(0)">回复</a> <a onclick="confirm('你确定要删除吗?')?location.href='liuyan/del?lyid=${liuyan.lyid}&currentPage=${requestScope.currentPage}':location.href='liuyan/page?currentPage=${requestScope.currentPage}'">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
			<div class="pager">
			<ul class="clearfix">
					<li><a href="liuyan/page?currentPage=1">首页</a></li>
					<c:choose>
				        <c:when test="${requestScope.currentPage==1}">
				            <li><a href="javascript:void(0)" style="color:gray">上一页</a></li>
				        </c:when>
				        <c:otherwise>
				            <li><a href="liuyan/page?currentPage=${requestScope.currentPage-1}">上一页</a></li>
				        </c:otherwise>
				    </c:choose>
					<li class="current">第${requestScope.currentPage}页</li>
					<li>共${requestScope.totalPage}页</li>
					<c:choose>
				        <c:when test="${requestScope.currentPage>=requestScope.totalPage}">
				            <li><a href="javascript:void(0)" style="color:gray">下一页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="liuyan/page?currentPage=${requestScope.currentPage+1}">下一页</a></li>
				        </c:otherwise>
				    </c:choose>
				    <c:choose>
				        <c:when test="${requestScope.totalPage==0}">
				           <li><a href="liuyan/page?currentPage=1">末页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="liuyan/page?currentPage=${requestScope.totalPage}">末页</a></li>
				        </c:otherwise>
				    </c:choose>
				</ul>
			</div>
			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
