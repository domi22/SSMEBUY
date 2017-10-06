// JavaScript Document
window.onload = function(){
	showChater();
	scrollChater();
	
}
window.onscroll = scrollChater;
window.onresize = scrollChater;



//加载表单的提示内容
$(function(){
	
	$("#captchaImage,#captchaImage2").click(function() 
	        {
	            $("#captchaImage").attr("src", "index/captcha.form?timestamp=" + (new Date()).valueOf());
	        }); 
	
	
	if($("#wkpicpath").val()==null || $("#wkpicpath").val()== ""){
		$("#wkerrorinfo").next().html("* 上传大小不能超过500K * 上传文件类型必须为：jpg、jpeg、png、pneg");
	}else{
		$("#wkerrorinfo").next().html($("#wkpicpath").val());
	}
	
	if($("#hdpicpath").val()==null || $("#hdpicpath").val()== ""){
		$("#hderrorinfo").next().html("* 上传大小不能超过500K * 上传文件类型必须为：jpg、jpeg、png、pneg");
	}else{
		$("#hderrorinfo").next().html($("#hdpicpath").val());
	}
	
})	


function FocusItem(obj)
{
	
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj)
{   
	
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch(obj.name) {
	
		case "regUserName":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空！";
				msgBox.className = "error";
				return false;
			}else{
				//用户名被占用
				$.ajax({
					 "url":"index/hasname",
					"data":"username="+obj.value,
					"type":"post",
				"dataType":"json",
				 "success":function(data){
						if(data=="1"){
							msgBox.innerHTML = "用户名已存在！";
							msgBox.className = "error";
							return false;
						}else{
					        //用户名可用
							msgBox.innerHTML = "用户名可用！";
							msgBox.className = "nameinfo";
						}
					}
				});
			}
			break;
	
		case "userName":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空！";
				msgBox.className = "error";
				return false;
			}
			break;
		case "passWord":
			if(obj.value == "") {
				
				msgBox.innerHTML = "密码不能为空！";
				msgBox.className = "error";
				return false;
			}
			break;
		case "rePassWord":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空！";
				msgBox.className = "error";
				return false;
			} else if(obj.value != document.getElementById("passWord").value) {
				msgBox.innerHTML = "两次密码不一致！";
				msgBox.className = "error";
				return false;
			}
			break;
		case "veryCode":
			if(obj.value == "") {
				msgBox.innerHTML = "验证码不能为空！";
				msgBox.className = "error";
				return false;
			}
			break;
	}
	return true;
}


/*
 *根据shangid添加到购物车 
*/
function addBuyCar(shangid){ 
  
		$.ajax({
			
		   "url":"buycar/addcar",
		  "data":"shangid="+shangid,
		  "type":"post",
	  "dataType":"json",
		 success:function(data){
			 $("#buycar").text(data);
		  }
   });
}

function checkForm(frm)
{   
	
	var els = frm.getElementsByTagName("input");
	
	for(var i=0; i<els.length; i++) {
		if(typeof(els[i].getAttribute("onblur")) == "function") {
			if(!CheckItem(els[i])) return false;
		}
	}
	return true;
}




function showChater()
{
	var _chater = document.createElement("div");
	_chater.setAttribute("id", "chater");
	var _dl = document.createElement("dl");
	var _dt = document.createElement("dt");
	var _dd = document.createElement("dd");
	var _a = document.createElement("a");
	_a.setAttribute("href", "#");
	_a.onclick = openRoom;
	_a.appendChild(document.createTextNode("闁革负鍔庨崵搴ㄦ嚂婵犲倶浜�"));
	_dd.appendChild(_a);
	_dl.appendChild(_dt);
	_dl.appendChild(_dd);
	_chater.appendChild(_dl);
	document.body.appendChild(_chater);
}

function openRoom()
{
	window.open("chat-room.html","chater","status=0,scrollbars=0,menubar=0,location=0,width=600,height=400");
}

function scrollChater()
{
	var chater = document.getElementById("chater");
	var scrollTop = document.documentElement.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft;
	chater.style.left = scrollLeft + document.documentElement.clientWidth - 92 + "px";
	chater.style.top = scrollTop + document.documentElement.clientHeight - 25 + "px";
}

function inArray(array, str)
{
	for(a in array) {
		if(array[a] == str) return true;
	}
	return false;
}

function setCookie(name,value)
{
  var Days = 30;
  var exp  = new Date();
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
}

function getCookie(name)
{
  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
  if(arr != null) return unescape(arr[2]); return null;
}

function delCookie(name)
{
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=getCookie(name);
  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
}

function goBuy(id, price)
{
	var newCookie = "";
	var oldCookie = getCookie("product");
	if(oldCookie) {
		if(inArray(oldCookie.split(","), id)) {
			newCookie = oldCookie;
		} else {
			newCookie = id + "," + oldCookie;
		}
	} else {
		newCookie = id;
	}
	setCookie("product", newCookie);
	location.href = "shopping.html";
}

function delShopping(id)
{
	comfire("");
	var tr = document.getElementById("product_id_"+ id);
	var oldCookie = getCookie("product");
	if(oldCookie) {
		var oldCookieArr = oldCookie.split(",");
		var newCookieArr = new Array();
		for(c in oldCookieArr) {
			var cookie = parseInt(oldCookieArr[c]);
			if(cookie != id) newCookieArr.push(cookie);
		}
		var newCookie = newCookieArr.join(",");
		setCookie("product", newCookie);
	}
	if(tr) tr.parentNode.removeChild(tr);
}

function reloadPrice(id, status)
{
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementsByTagName("span")[0];
	var number = document.getElementById("number_id_" + id);
	if(status) {
		number.value++;
	} else {
		if(number.value == 1) {
			return false;
		} else {
			number.value--;
		}
	}
	priceBox.innerHTML = "闁跨噦鎷�"+ price * number.value;
}

