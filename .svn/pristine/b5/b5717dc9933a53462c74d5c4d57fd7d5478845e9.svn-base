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
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function.js"></script>
<script type="text/javascript" src="<%=basePath%>/statics/calendar/WdatePicker.js"></script>
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
		<h2>新增用户</h2>
		<div class="manage">
			<form action="index/newadd" method="post" enctype="multipart/form-data">
				<table class="form">
					<tr>
						<td class="field">用户名：${requestScope.currentPage}</td>
						<td><input type="text" class="text" name="username"  onblur="CheckItem(this);"/></td>
					</tr>
					
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="pwd"  /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" value="男" checked="checked" />男 <input type="radio" name="sex" value="女" />女</td>
					</tr>
					
					<tr>
						<td class="field">出生日期：</td>
						<td><input class="Wdate" type="text" name="birthday"  readonly="readonly" onclick="WdatePicker();"/></td>
					</tr>
					
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="phone"  /></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input type="text" class="text" name="email"  /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address"  /></td>
					</tr>
					<tr>
						<td class="field">证件照：</td>
						<td><input type="file" id="wkpicpath" class="text" name="attachs" /></td>
					    <td class="field"id="hderrorinfo" style="margin-left:0px">${sessionScope.uploadwkError}</td>
					</tr>
					<tr>
						<td class="field">头像：</td>
						<td><input type="file" id="hdpicpath"  class="text" name="attachs" /></td>
						<td class="field"id="hderrorinfo" style="margin-left:0px">${sessionScope.uploadhdError}</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
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