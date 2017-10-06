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
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function-manage.js"></script></head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="<%=basePath%>/statics/images/logo.gif" /></div>
	<div class="help"><a href="index/index">返回前台页面</a></div>
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
	您现在的位置：<a href="index/index">易买网</a> &gt; 管理后台
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
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				
				<tr>
				    <th></th>
					<th>
					<a href="shangp/page?usecurrentPage=1">首页</a>
					<c:choose>
				        <c:when test="${requestScope.usecurrentPage==1}">
				           <a href="javascript:void(0)" style="color:gray">上一页</a>
				        </c:when>
				        <c:otherwise>
				            <a href="shangp/page?usecurrentPage=${requestScope.usecurrentPage-1}">上一页</a>
				        </c:otherwise>
				    </c:choose>
					<a class="current">第${requestScope.usecurrentPage}页</a>
					<a>共${requestScope.totalPage}页</a>
					<c:choose>
				        <c:when test="${requestScope.usecurrentPage>=requestScope.totalPage}">
				            <a href="javascript:void(0)" style="color:gray">下一页</a>
				        </c:when>
				        <c:otherwise>
				         <a href="shangp/page?usecurrentPage=${requestScope.usecurrentPage+1}">下一页</a>
				        </c:otherwise>
				    </c:choose>
				    <c:choose>
				        <c:when test="${requestScope.totalPage==0}">
				           <a href="shangp/page?usecurrentPage=1">末页</a>
				        </c:when>
				        <c:otherwise>
				           <a href="shangp/page?usecurrentPage=${requestScope.totalPage}">末页</a>
				        </c:otherwise>
				    </c:choose>
					</th>
					<th></th>
				</tr>	
				
				<c:forEach items="${requestScope.allshanglist}" var="shangp">
				    <tr>
						<td class="first w4 c">${shangp.shangid}</td>
						<td class="thumb"><img src="<%=basePath%>/statics/images/product/${shangp.picpath}" /><a href="shangp/oneshang?shangid=${shangp.shangid}" target="_blank">${shangp.shangname}</a></td>
						<td class="w1 c"><a href="shangp/toupd?shangid=${shangp.shangid}">修改</a> <a onclick="confirm('你确定要删除吗?')?location.href='shangp/del?shangid=${shangp.shangid}&usecurrentPage=${requestScope.usecurrentPage}':location.href='shangp/page?usecurrentPage=-1'">删除</a></td>
					 </tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>