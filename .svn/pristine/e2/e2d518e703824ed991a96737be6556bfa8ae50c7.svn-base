<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
	您现在的位置：<a href="index/index">易买网</a> &gt; <a href="product-list.html">图书音像</a> &gt; 图书
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
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
				<dt><img src="images/product/0_tiny.gif" /></dt>
				<dd><a href="product-view.html">法国德菲丝松露精品巧克力500g/盒</a></dd>
			</dl>
			<script type="text/javascript">
				document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
			</script>
		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=1">首页</a></li>
					<c:choose>
				        <c:when test="${requestScope.pageMap.currentPage==1}">
				            <li><a href="javascript:void(0)" style="color:gray">上一页</a></li>
				        </c:when>
				        <c:otherwise>
				            <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=${requestScope.pageMap.currentPage-1}">上一页</a></li>
				        </c:otherwise>
				    </c:choose>
					<li class="current">第${requestScope.pageMap.currentPage}页</li>
					<li>共${requestScope.pageMap.totalPage}页</li>
					<c:choose>
				        <c:when test="${requestScope.pageMap.currentPage>=requestScope.pageMap.totalPage}">
				            <li><a href="javascript:void(0)" style="color:gray">下一页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=${requestScope.pageMap.currentPage+1}">下一页</a></li>
				        </c:otherwise>
				    </c:choose>
				    <c:choose>
				        <c:when test="${requestScope.pageMap.totalPage==0}">
				           <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=1">末页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=${requestScope.pageMap.totalPage}">末页</a></li>
				        </c:otherwise>
				    </c:choose>
				</ul>
			</div>
			
			<div class="clear"></div>
			
			<ul class="product clearfix">
			    <c:forEach items="${requestScope.productList}" var="shangp">
			        <li>
					<dl>
						<dt><a href="shangp/oneshang?shangid=${shangp.shangid}" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/${shangp.picpath}"/></a></dt>
						<dd class="title"><a href="shangp/oneshang?shangid=${shangp.shangid}" target="_blank">${shangp.shangname}</a></dd>
						<dd class="price">${shangp.price}</dd>
					</dl>
				</li> 
			    </c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
				 <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=1">首页</a></li>
					<c:choose>
				        <c:when test="${requestScope.pageMap.currentPage==1}">
				            <li><a href="javascript:void(0)" style="color:gray">上一页</a></li>
				        </c:when>
				        <c:otherwise>
				            <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=${requestScope.pageMap.currentPage-1}">上一页</a></li>
				        </c:otherwise>
				    </c:choose>
					<li class="current">第${requestScope.pageMap.currentPage}页</li>
					<li>共${requestScope.pageMap.totalPage}页</li>
					<c:choose>
				        <c:when test="${requestScope.pageMap.currentPage>=requestScope.pageMap.totalPage}">
				            <li><a href="javascript:void(0)" style="color:gray">下一页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=${requestScope.pageMap.currentPage+1}">下一页</a></li>
				        </c:otherwise>
				    </c:choose>
				    <c:choose>
				        <c:when test="${requestScope.pageMap.totalPage==0}">
				           <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=1">末页</a></li>
				        </c:when>
				        <c:otherwise>
				           <li><a href="shangp/list?goodid=${requestScope.pageMap.goodid}&currentPage=${requestScope.pageMap.totalPage}">末页</a></li>
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