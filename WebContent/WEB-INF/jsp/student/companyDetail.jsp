<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>大学生职业发展规划平台</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/styletwo.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/password.js"></script>
</head>
<body>
	<script type="text/javascript">
	function disablePageBack() {
        //消除后退的所有动作。包括 键盘、鼠标手势等产生的后退动作。，用户登录到系统中后，浏览器回退按钮失效，只能点击退出按钮退出系统！
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
    }
	disablePageBack();
	</script>


	<section class="aui-flexView">
		<section class="aui-scrollView">
			<div class="aui-head-yellow" style="height: 10rem">
				<div style="position: absolute; left: 1rem;">
					<a href="${backurl}"><img src="images/icon_back_hui.png"
						width=25px height=25px "/></a>
				</div>
				<div class="aui-head-box">
					<div class="aui-head-user">
						<img src="images/user.jpg" alt=""
							style="position: fixed; top: 7rem; width: 5.8rem; height: 5.8rem;" />
					</div>

				</div>
				<div style="text-align: center"></div>

			</div>
			<div style="margin-top: 4rem; text-align: center"
				class="friend-detail">

				<p style="padding-bottom: 0.35rem">公司名：${company.name}</p>

				<p style="padding-bottom: 0.35rem">
					所属行业：
					<c:if test="${company.hy_catalogname != null}">
	   				${company.hy_catalogname}
			</c:if>
					<c:if test="${company.hy_catalogname == null}">
	   				暂无
			</c:if>
				</p>
				<p style="padding-bottom: 0.35rem">
					公司地址：
					<c:if test="${company.province_name != null}">
	   				${company.province_name}${company.city_name}${company.three_cityname}
			</c:if>
					<c:if test="${company.province_name == null}">
	   				暂无
			</c:if>
				</p>
				<p style="padding-bottom: 0.35rem">
					公司规模：
					<c:if test="${company.mun_name != null}">
	   				${company.mun_name}
			</c:if>
					<c:if test="${company.mun_name == null}">
	   				暂无
			</c:if>
				</p>
				<p style="padding-bottom: 0.35rem">
					联系人：
					<c:if test="${company.linkman != null}">
	   				${company.linkman}
			</c:if>
					<c:if test="${company.linkman == null}">
	   				暂无
			</c:if>
				</p>
				<p style="padding-bottom: 0.35rem">
					电话：
					<c:if test="${company.linkphone != null}">
	   				${company.linkphone}
			</c:if>
					<c:if test="${company.linkphone == null}">
	   				暂无
			</c:if>
				</p>
				<p style="padding-bottom: 0.35rem">
					邮箱：
					<c:if test="${company.linkmail != null}">
	   				${company.linkmail}
			</c:if>
					<c:if test="${company.linkmail == null}">
	   				暂无
			</c:if>
				</p>

			</div>

		</section>

	</section>
</body>
<script type="text/javascript">
window.alert = function(name){
    var iframe = document.createElement("IFRAME");
    iframe.style.display="none";
    iframe.setAttribute("src", 'data:text/plain,');
    document.documentElement.appendChild(iframe);
    window.frames[0].window.alert(name);
    iframe.parentNode.removeChild(iframe);
}

function success(){
	
    alert("申请成功！");
    var temp2= document.getElementById('friend').setAttribute('onclick','already()');
    var temp2= document.getElementById('friend').setAttribute('style','background-color: #cdcdcd;border: none;color: white;padding: 0.5rem 2rem;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;cursor: pointer;margin-top:2rem;');
    
}
function already(){
	var hrefDom = document.getElementById("friend").removeAttribute('href');
    alert("已申请！");
    
}
function back(){

	var backurl="<%=session.getAttribute("backurl")%>";
	alert(backurl);
	window.location.href=backurl;
	
}
</script>
</html>

