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
<script type="text/javascript" src="<%=basePath%>/statics/scripts/function.js"></script></head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="<%=basePath%>/statics/images/logo.gif" /></div>
	<div class="help"><a href="index/haslogin?opr=index_buycar" class="shopping">购物车</a><c:choose><c:when test="${!empty sessionScope.hasLogin}"><a href="index/logout">退出</a>&nbsp;&nbsp;${sessionScope.hasLogin.username}</c:when><c:otherwise><a href="index/zzz?opr=index/login.jsp">登录</a></c:otherwise></c:choose><c:if test="${sessionScope.hasLogin.userrole==0}"><a href="index/zzz?opr=manager/index.jsp">后台管理</a></c:if><a href="index/zzz?opr=index/register.jsp">注册</a><a href="liuyan/pageweb?currentPage=-1">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index/index">首页</a></li>
			<c:forEach items="${sessionScope.leftList}" var="fathergood">
			       <c:if test="${fathergood.fatherid==0}">
			            <li><a href="shangp/list?goodid=${songood.goodid}&currentPage=-1">${fathergood.goodname}</a></li>
			       </c:if>
			 </c:forEach>
		</ul>
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
	您现在的位置：<a href="index/index">易买网</a> &gt; <a href="index/haslogin?opr=shopping_buycar">购物车</a>
</div>
<div class="wrap">
	<div id="shopping">
		<form action="index/zzz?opr=buycar/shopping-result.jsp" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${requestScope.buycarlist}" var="buycar">
				    <c:forEach items="${buycar.list}" var="shangp">
				         <tr id="product_id_1">
							<td class="thumb"><a href="shangp/oneshang?shangid=${shangp.shangid}"><img src="<%=basePath%>/statics/images/product/${shangp.picpath}" /></a><a href="shangp/oneshang?shangid=${shangp.shangid}">${shangp.shangname}</a></td>
							<td class="price" id="price_id_1">
								<span>￥${shangp.price}</span>
								<input type="hidden" value="${shangp.price}" />
							</td>
							<td class="number">
								<dl>
									<dt><input id="number_id_1" type="text" name="number" value="${buycar.carcount}" /></dt>
									<dd onclick="reloadPrice(1,true);">+</dd>
									
								</dl>
							</td>
							<td class="delete"><a onclick="confirm('确定要删除吗?')?location.href='buycar/del?userid=${buycar.userid}&carid=${buycar.carid}':location.href='index/haslogin?opr=shopping_buycar'">删除</a></td>
						</tr> 
				    </c:forEach>
				</c:forEach>
				
			</table>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
   