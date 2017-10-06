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
			            <li><a href="shangp/fatherlist?fatherid=${fathergood.goodid}&currentPage=-1">${fathergood.goodname}</a></li>
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
				<dt><img src="<%=basePath%>/statics/images/product/0_tiny.gif" /></dt>
				<dd><a href="javascript:void(0)">法国德菲丝松露精品巧克力500g/盒</a></dd>
				<dt><img src="<%=basePath%>/statics/images/product/0_tiny.gif" /></dt>
				<dd><a href="javascript:void(0)">法国德菲丝松露精品巧克力500g/盒</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>商品展示</h2>
			<ul class="product clearfix">
			   
			    <c:forEach items="${requestScope.centerList}" var="shangp">
			        <li>
					    <dl>
						      <dt><a href="shangp/oneshang?shangid=${shangp.shangid}" target="_blank"><img src="<%=basePath%>/statics/images/product/${shangp.picpath}" /></a></dt>
						      <dd class="title"><a href="shangp/oneshang?shangid=${shangp.shangid}" target="_blank">${shangp.shangname}</a></dd>
						      <dd class="price">${shangp.price}</dd>
					    </dl>
				    </li>
			    </c:forEach>
			</ul>
		</div>
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
				    <c:forEach items="${requestScope.rightNoticeList}" var="notice">
				        <li><a href="news/noticeview?noticeid=${notice.noticeid}" target="_blank">${notice.noticecontent}</a></li>
				    </c:forEach>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
				    <c:forEach items="${requestScope.rightNewsList}" var="news">
				       <li><a href="news/view?newid=${news.newid}" target="_blank">${news.newtitle}</a></li>
				    </c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<%--<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/7.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">利仁2018M福满堂电饼铛 好用实惠</a></dd>
						<dd class="price">￥268.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/8.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">达派高档拉杆箱20寸 经典款式</a></dd>
						<dd class="price">￥198.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/9.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">爱国者MP4 全屏触摸多格式播放 4G</a></dd>
						<dd class="price">￥289.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/10.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">多美滋金装金盾3阶段幼儿配方奶粉</a></dd>
						<dd class="price">￥186.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html" target="_blank"><img src="${pageContext.request.contextPath}/statics/images/product/2.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_blank">乐扣普通型保鲜盒圣诞7件套</a></dd>
						<dd class="price">￥69.90</dd>
					</dl>
				</li>
			</ul>
		</div>
	--%></div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
    