<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>大学生职业发展规划平台</title>
<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link href="css/styletwo.css" rel="stylesheet" type="text/css" />
<link href="css/style4.css" rel="stylesheet" type="text/css" />
<link href="css/mobiscroll.custom-2.5.2.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/mobiscroll.custom-2.5.2.min.js"></script>
<script type="text/javascript" src="js/city.cache.js"></script>
<link href="css/mobiscroll.custom-2.5.2.min.css" rel="stylesheet"
	type="text/css" />
<style>
.aui-flex {
	padding: 0.5rem;
}

.input {
	width: 15rem;
	height: 1.4rem;
	position: absolute;
	right: 0.2rem;
	padding: 5px;
	text-align: right;
	margin: 2px 0;
	border: none;
	box-sizing: border-box;
	border-radius: 5px;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-border-radius: 5px;
	mso-border-shadow: no;
}

.warning {
	background-color: rgb(255, 251, 0);
	color: burlywood;
	text-align: center;
	padding-top: 10px;
	width: 100%;
	height: 40px;
}

.submit {
	height: 40px;
	width: 80%;
	position: relative;
	background-color: dodgerblue;
	color: black;
	text-align: center;
	vertical-align: middle;
	margin-left: 10%;
	margin-top: 50px;
	border-radius: 10px;
}

input {
	width: 15rem;
	height: 1.4rem;
	position: absolute;
	right: 0.2rem;
	padding-right: 4px;
	text-align: right;
	margin-top: -25px;
	border: none;
	box-sizing: border-box;
	border-radius: 5px;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-border-radius: 5px;
	mso-border-shadow: no;
}

.input1 {
	width: 7rem;
	height: 1.4rem;
	position: absolute;
	right: 0.2rem;
	padding: 5px;
	text-align: right;
	margin: 2px 0;
	border: none;
	box-sizing: border-box;
	border-radius: 5px;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-border-radius: 5px;
	mso-border-shadow: no;
}

.input2 {
	width: 7rem;
	height: 1.4rem;
	position: absolute;
	right: 8rem;
	padding: 5px;
	text-align: right;
	margin: 2px 0;
	border: none;
	box-sizing: border-box;
	border-radius: 5px;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-webkit-border-radius: 5px;
	mso-border-shadow: no;
}
</style>
</head>

<body>
	<script type="text/javascript">
		function disablePageBack() {
			history.pushState(null, null, document.URL);
			window.addEventListener('popstate', function() {
				history.pushState(null, null, document.URL);
			});
		}
		disablePageBack();
	</script>

	<script type="text/javascript">
        var xmlHttpRequest;
        function createXMLHttpRequest()
        {

            if (window.XMLHttpRequest) //非IE浏览器
            {
                xmlHttpRequest = new XMLHttpRequest();
            }
            else if (window.ActiveObject)//IE6以上浏览器
            {
                xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
            }
            else //IE6及以下浏览器
            {
                xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
            }
        }

        function sendRequest(url){
            createXMLHttpRequest();
            xmlHttpRequest.open("GET", url, true);
            xmlHttpRequest.onreadystatechange = processResponse;
            xmlHttpRequest.send(null);
        }

        function processResponse()
        {

            if(xmlHttpRequest.readyState == 4)
            {

                if(xmlHttpRequest.status == 200)
                {
                    var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.nodeValue;
                    var div1 = document.getElementById("isOrigine");
                    if(responseInfo == "NotExist"){
                        /* div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>学号信息不存在，</font>"; */
                    }else if(responseInfo == "Registed"){
                        div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>该学号已注册</font>";
                    }else if(responseInfo == "Wrong"){
                        div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>姓名与学号不匹配</font>";
                    }else if(responseInfo == "True"){
                        div1.innerHTML="<font style='color: #38A45A;font-size: 12px;margin-left: 10px;'>输入正确</font>";
                    }else{
                        /* div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>输入有误,请核对信息</font>"; */
                    }
                }
            }
        }


    </script>

	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed b-line">
			<a class="aui-navBar-item"> <i class="icon icon-return"
				onclick="javascript:window.location.href='companyJobList'"></i> <span
				style="color: whitesmoke" class="fixed">用户注册</span>
			</a>
			<div class="aui-center">
				<span class="aui-center-title"></span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
			<form action="registration" method="GET" name="userInfo" id="userInfo">
				<div class="aui-users-list">
					 <a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="number" id="number" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no"/>
							</div>
							<h2>学号</h2>
						</div>
					</a> 
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">
							<div id="demo_default" class="demos">
								<input type="text" name="name" id="name" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no"
									value="" oninput="isRegist()"/>
							</div>
							<h2>真实姓名<text style="color: red">*</text></h2>
						</div>
					</a>
					<div id="isOrigine"></div>
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="phone"
									class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" />
							</div>
							<h2>手机号<text style="color: red">*</text></h2>
						</div>
					</a>
					<!-- <a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="message" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>验证码<text style="color: red">*</text></h2>
						</div>
					</a>  -->
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="account" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>账户名<text style="color: red">*</text></h2>
						</div>
					</a> 
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="password" name="password" id="password"  class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>密码<text style="color: red">*</text></h2>
						</div>
					</a> 
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="email" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>邮箱</h2>
						</div>
					</a> 
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="qq" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>QQ</h2>
						</div>
					</a>
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="wx_number" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>微信号</h2>
						</div>
					</a>
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="school" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>毕业学校</h2>
						</div>
					</a>
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="description" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>个人说明</h2>
						</div>
					</a>
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="living" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>现居住地</h2>
						</div>
					</a>
<!-- 					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="password" name="repeatedPassword" id="repeatedPassword" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>确认密码<text style="color: red">*</text></h2>
						</div>
					</a>  -->
				<font style="color: #E75530;font-size: 12px;display: block;margin-top: 10px;margin-left: 30px;float: left;right: 0;top: 0;"> ${sessionScope.regist}</font>
				</div>
				<input class="submit" type="submit" value="注册" style="margin-top: 1rem">
			</form>
		</section>
	</section>

</body>

</html>