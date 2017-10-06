<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>/statics/css/style.css" />
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function.js"></script>
</head>
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
<div id="position" class="wrap">
	您现在的位置：<a href="index/index">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			   <c:forEach items="${sessionScope.leftList}" var="fathergood">
			       <c:if test="${fathergood.fatherid==0}">
			            <dt>${fathergood.goodname}</dt>
			            <c:forEach items="${sessionScope.leftList}" var="songood">
			              <c:if test="${fathergood.goodid==songood.fatherid}">
			                 <dd><a href="shangp/list?goodid=${songood.goodid}&currentPage=-1">${songood.goodname}</a></dd>
			              </c:if>
			           </c:forEach>
			       </c:if>
			   </c:forEach>
			
			</dl>
			
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="javascript:void(0)">法国德菲丝松露精品巧克力500g/盒</a></dd>
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="javascript:void(0)">法国德菲丝松露精品巧克力500g/盒</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
			    <c:forEach items="${requestScope.webliuyanlist}" var="liuyan">
			       <li>
					   <dl>
						   <dt>留言标题：【${liuyan.lytitle}】</dt>
						    <dt>留言内容：${liuyan.lycontent}</dt>
						   <dd class="author">网友：${liuyan.lyauther} <span class="timer">${liuyan.lytime}</span></dd>
				   	      
				   	   </dl>
				    </li>
			    </c:forEach>
			</ul>
			<div class="clear"></div>
			
			<div class="pager">
			<ul class="clearfix">
					<li><a href="liuyan/pageweb?currentPage=1">首页</a></li>
					<c:choose>
				        <c:when test="${requestScope.currentPage==1}">
				            <li><a href="javascript:void(0)" style="color:gray">上一页</a></li>
				        </c:when>
				        <c:otherwise>
				            <li><a href="liuyan/pageweb?currentPage=${requestScope.currentPage-1}">上一页</a></li>
				        </c:otherwise>
				    </c:choose>
					<li class="current">第${requestScope.currentPage}页</li>
					<li>共${requestScope.totalPage}页</li>
					<c:choose>
				        <c:when test="${requestScope.currentPage>=requestScope.totalPage}">
				            <li><a href="javascript:void(0)" style="color:gray">下一页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="liuyan/pageweb?currentPage=${requestScope.currentPage+1}">下一页</a></li>
				        </c:otherwise>
				    </c:choose>
				    <c:choose>
				        <c:when test="${requestScope.totalPage==0}">
				           <li><a href="liuyan/pageweb?currentPage=1">末页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="liuyan/pageweb?currentPage=${requestScope.totalPage}">末页</a></li>
				        </c:otherwise>
				    </c:choose>
				</ul>
			</div>
			<div id="reply-box">
				<form action="liuyan/add?currentPage=-1" method="post">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="lyauther" /></td>
						</tr>
						<tr>
							<td class="field">留言标题：</td>
							<td><input class="text" type="text" name="lytitle" /></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="lycontent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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