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
		<h2>修改订单</h2>
		<div class="manage">
			<form action="indent/mdf?usecurrentPage=${requestScope.usecurrentPage}" method="post">
				<table class="form">
					<tr>
						<td class="field">订单号：</td>
						<td><input type="text" class="text" name="indentid" value="${requestScope.indentid}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">收件人：</td>
						<td><input type="text" class="text" name="username" value="${requestScope.username}" /></td>
					</tr>
					<tr>
						<td class="field">收货地址：</td>
						<td><input type="text" class="text" name="address" value="${requestScope.address}" /></td>
					</tr>
					<tr>
						<td class="field">联系电话：</td>
						<td><input type="text" class="text" name="phone" value="${requestScope.phone}" /></td>
					</tr>
					<tr>
						<td class="field">订单状态：</td>
						<td>
						      <select name="statusname">
						         <option value="下单" <c:if test="${requestScope.statusname=='下单'}">checked</c:if>>下单</option>
						         <option value="审核" <c:if test="${requestScope.statusname=='审核'}">checked</c:if>>审核</option>
						         <option value="发货" <c:if test="${requestScope.statusname=='发货'}">checked</c:if>>发货</option>
						         <option value="成交" <c:if test="${requestScope.statusname=='成交'}">checked</c:if>>成交</option>
						      </select>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>