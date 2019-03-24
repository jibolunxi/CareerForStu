<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>大学生职业发展规划平台</title>
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport"/>
    <meta content="yes" name="apple-mobile-web-app-capable"/>
    <meta content="black" name="apple-mobile-web-app-status-bar-style"/>
    <meta content="telephone=no" name="format-detection"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/styletwo.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/password.js"></script>
</head>
<body>



<section class="aui-flexView">
    <section class="aui-scrollView" >
        <div class="aui-head-yellow" style="height: 10rem">     
            <div style="position: absolute ;left: 1rem ;">
                <a href="${backurl}"><img src="images/icon_back_hui.png" width=25px height=25px "></a>
            </div> 
            <div class="aui-head-box" >
                <div class="aui-head-user" >
                    <img src="images/user.jpg" alt="" style="position: fixed ;top: 7rem; width: 5.8rem ; height: 5.8rem ;">
                </div>

            </div>
            <div style="text-align: center">

            </div>

        </div>
        <div style="margin-top: 4rem;text-align: center" class="friend-detail">
        <c:if test="${type == 0}">
		
	        <p style="padding-bottom:0.35rem">姓名：${student.name}</p>
	        <p style="padding-bottom:0.35rem">性别：
	        <c:if test="${student.sex == 0}">
	   				男
			</c:if>
			<c:if test="${student.sex == 1}">
	   				女
			</c:if>
			<c:if test="${student.sex == null}">
	   				暂无
			</c:if>
	          </p>
	          <p style="padding-bottom:0.35rem">学校：
	        <c:if test="${student.college_name != null}">
	   				${student.college_name}
			</c:if>
			<c:if test="${student.college_name == null}">
	   				暂无
			</c:if>
	        </p>
	           <p style="padding-bottom:0.35rem">院系：
	        <c:if test="${student.dept_name != null}">
	   				${student.dept_name}
			</c:if>
			<c:if test="${student.dept_name == null}">
	   				暂无
			</c:if>
	        </p>
	           <p style="padding-bottom:0.35rem">专业：
	        <c:if test="${student.major_name != null}">
	   				${student.major_name}
			</c:if>
			<c:if test="${student.major_name == null}">
	   				暂无
			</c:if>
	        </p>
	        <p style="padding-bottom:0.35rem">微信号：
	        <c:if test="${student.wxewm != null}">
	   				${student.wxewm}
			</c:if>
			<c:if test="${student.wxewm == null}">
	   				暂无
			</c:if>
			</p>
		</c:if>
		<c:if test="${type == 1}">
		
	        <p style="padding-bottom:0.35rem">公司名：${company.name}</p>
	     
	        <p style="padding-bottom:0.35rem">所属行业：
	        <c:if test="${company.hy_catalogname != null}">
	   				${company.hy_catalogname}
			</c:if>
			<c:if test="${company.hy_catalogname == null}">
	   				暂无
			</c:if>
	        </p>
	        <p style="padding-bottom:0.35rem">公司地址：
	        <c:if test="${company.province_name != null}">
	   				${company.province_name}${company.city_name}${company.three_cityname}
			</c:if>
			<c:if test="${company.province_name == null}">
	   				暂无
			</c:if>
	        </p>
	           <p style="padding-bottom:0.35rem">公司规模：
	        <c:if test="${company.mun_name != null}">
	   				${company.mun_name}
			</c:if>
			<c:if test="${company.mun_name == null}">
	   				暂无
			</c:if>
	        </p>
	        <p style="padding-bottom:0.35rem">联系人：
	        <c:if test="${company.linkman != null}">
	   				${company.linkman}
			</c:if>
			<c:if test="${company.linkman == null}">
	   				暂无
			</c:if>
			</p>
	        <p style="padding-bottom:0.35rem">电话：
	        <c:if test="${company.linkphone != null}">
	   				${company.linkphone}
			</c:if>
			<c:if test="${company.linkphone == null}">
	   				暂无
			</c:if>
			</p>
			<p style="padding-bottom:0.35rem">邮箱：
	        <c:if test="${company.linkmail != null}">
	   				${company.linkmail}
			</c:if>
			<c:if test="${company.linkmail == null}">
	   				暂无
			</c:if>
			</p>
		</c:if>
   				<p><a href="removeMessage" onclick="success()" id="friend" style="background-color: #FF0000;border: none;color: white;padding: 0.5rem 2rem;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;cursor: pointer;margin-top:2rem;">删除</a></p>
   				<p><a href="agreeFriendsRequest" onclick="success()" id="friend" style="background-color: #4CAF50;border: none;color: white;padding: 0.5rem 2rem;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;cursor: pointer;margin-top:2rem;">同意</a></p>
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
/*     var temp2= document.getElementById('friend').setAttribute('style','background-color: #cdcdcd;border: none;color: white;padding: 0.5rem 2rem;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;cursor: pointer;margin-top:2rem;');
  */   
}
function already(){
    alert("已申请！");
    
}
function back(){

	var backurl="<%=session.getAttribute("backurl")%>";
	alert(backurl);
	window.location.href=backurl;
	
}
</script>
</html>
