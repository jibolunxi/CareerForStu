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
<script>
	$(function() {
		$("#current-area2").click(
				function() {
					var that = this;
					console.log(1);
					$("#current-area-list2").mobiscroll().treelist(
							{
								theme : "android-ics light",
								lang : "zh",
								display : 'bottom',
								inputClass : 'tmp',
								mode : 'scroller',
								headerText : '薪资需求',
								onSelect : function(valueText, inst) {
									console.log(valueText);
									var n = valueText.split(' ');
									var m1 = $(this).children("li").eq(n[0])
											.find("div").html();
									var m1_id = $(this).children("li").eq(n[0])
											.find("div").attr("data-value");
									var m2 = $(this).children("li").eq(n[0])
											.find("li").eq(n[1]).html();
									var m2_id = $(this).children("li").eq(n[0])
											.find("li").eq(n[1]).attr(
													"data-value");
									$("input[id^=current-area-list2_dummy]")
											.val(m1 + "k  -  " + m2 + "k")
									$("input[id^=xinzi1]").val(m1)
									$("input[id^=xinzi2]").val(m2)
									/*$.post("inc/person.org.php", {apart: "resume_base", current_area: m1+m2, current_areaPID: m1_id, current_areaCID: m2_id}, function (result) {
									    if (result == 'ok') {
									        $(that).find(".mbase-menu-txt").html(m1+m2);
									    }
									    else {
									        error('网络繁忙，请您稍后再试');
									    }
									});*///后端处理部分
								}
							});
					$("input[id^=current-area-list2]").focus();
				})
		$("#current-area3")
				.click(
						function() {
							var that = this;
							$("#current-area-list3")
									.mobiscroll()
									.treelist(
											{
												theme : "android-ics light",
												lang : "zh",
												display : 'bottom',
												inputClass : 'tmp',
												mode : 'scroller',
												headerText : '工作地点',
												onSelect : function(valueText,
														inst) {
													var n = valueText
															.split(' ');
													var $list = $(this)
															.children("li").eq(
																	n[0]);
													var m1_id = $list.find(
															"div").attr(
															"data-value");
													var m2_id = $list.find(
															"span").eq(n[1])
															.attr("data-value");
													var m3_id = $list.find(
															"span").eq(n[1])
															.next().find('li')
															.eq(n[2])
															.attr("data-value");
													var value = valueText
															.split('/');
													var m1 = cn[m1_id]
													var m2 = cn[m2_id]
													var m3 = cn[m3_id]
													$(
															"input[id^=current-area-list3_dummy]")
															.val(
																	m1
																			+ "  "
																			+ m2
																			+ "  "
																			+ m3)
													$("input[id^=sheng]").val(
															m1)
													$("input[id^=shi]").val(m2)
													$("input[id^=qu]").val(m3)
													$("input[id^=sheng1]").val(
															m1_id)
													$("input[id^=shi1]").val(
															m2_id)
													$("input[id^=qu1]").val(
															m3_id)
													/*$.post("inc/person.org.php", {apart: "resume_base", current_area: m1+m2, current_areaPID: m1_id, current_areaCID: m2_id}, function (result) {
													    if (result == 'ok') {
													        $(that).find(".mbase-menu-txt").html(m1+m2);
													    }
													    else {
													        error('网络繁忙，请您稍后再试');
													    }
													});*///后端处理部分
												}
											});
							$("input[id^=current-area-list3]").focus();
						})

	});
	$(function() {
		$("#job_property").click(function() {
			$("#property").mobiscroll().treelist({
				theme : "android-ics light",
				lang : "zh",
				display : 'bottom',
				inputClass : 'tmp',
				mode : 'scroller',
				headerText : '工作性质',
				onSelect : function(valueText, inst) {
					console.log(valueText)
					var n = valueText.split(' ');
					var m1 = $(this).children("li").eq(n[0]).text();
					$("input[id^=property_dummy]").val(m1)
					$("input[id^=xingzhi]").val(m1)
				}
			});
			$("input[id^=property_dummy]").focus();
		})
	});
	$(function() {
		$("#experience_request").click(function() {
			$("#request").mobiscroll().treelist({
				theme : "android-ics light",
				lang : "zh",
				display : 'bottom',
				inputClass : 'tmp',
				mode : 'scroller',
				headerText : '经验要求',
				onSelect : function(valueText, inst) {
					console.log(valueText)
					var n = valueText.split(' ');
					var m1 = $(this).children("li").eq(n[0]).text();
					console.log(m1)
					$("input[id^=request_dummy]").val(m1)
					$("input[id^=jingyan]").val(m1)
				}
			});
			$("input[id^=request_dummy]").focus();
		})
	});
	$(function() {
		$("#low_study").click(function() {
			$("#study").mobiscroll().treelist({
				theme : "android-ics light",
				lang : "zh",
				display : 'bottom',
				inputClass : 'tmp',
				mode : 'scroller',
				headerText : '最低学历',
				onSelect : function(valueText, inst) {
					console.log(valueText)
					var n = valueText.split(' ');
					var m1 = $(this).children("li").eq(n[0]).text();
					console.log(m1)
					$("input[id^=study_dummy]").val(m1)
					$("input[id^=xueli]").val(m1)
				}
			});
			$("input[id^=study_dummy]").focus();
		})
	});
	$(document)
			.ready(
					function() {
						console.log(${jobClasses})
						console.log(1)
						if (add = true) {
							add = false;
							var k = 50;
							var s = "";
							var t = "";
							var g = 1;
							for (var i = 1; i <= k; i++) {
								var lin1 = i + 1;
								s += "<li><div data-value='" + lin1 + "'>" + i
										+ "</div>";
								s += "<ul>"
								for (var x = i; x <= k; x++) {
									var lin2 = i * k + x + 2
									s += "<li data-value='" + lin2 + "'>" + x
											+ "</li>";
								}
								s += "</ul></li>";
							}
							for (var i = 0; i <= 33; i++) {
								var sheng = ci[i];
								t += "<li><div data-value='" + sheng + "'>"
										+ cn[sheng] + "</div><ul>";
								var shi = ct[sheng]
								var nshi = ct[sheng].length
								for (var x = 0; x < nshi; x++) {
									var di = ct[sheng][x];
									var difang = cn[di];
									if (ct[di] != undefined)
										var nxix = ct[di].length;
									else
										var nxix = 0;
									t += "<li><span data-value='" + di + "'>"
											+ difang + "</span><ul>";
									for (var z = 0; z < nxix; z++) {
										nxiang = ct[di][z];
										xiang = cn[nxiang];
										t += "<li data-value='" + nxiang + "'>"
												+ xiang + "</li>";
									}
									t += "</ul></li>";
								}
								t += "</ul></li>";
							}
							$("#current-area-list3").html(t);
							$("#current-area-list2").html(s);
						}
					});
</script>
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
			//消除后退的所有动作。包括 键盘、鼠标手势等产生的后退动作。，用户登录到系统中后，浏览器回退按钮失效，只能点击退出按钮退出系统！
			history.pushState(null, null, document.URL);
			window.addEventListener('popstate', function() {
				history.pushState(null, null, document.URL);
			});
		}
		disablePageBack();
	</script>
	<script type="text/javascript">
		$(function () {
            
            var curr = new Date().getFullYear();
            var opt = {


            }

            opt.date = { preset: 'date' };
            opt.datetime = { preset: 'datetime', minDate: new Date(2010, 1, 1, 9, 22), maxDate: new Date(2014, 7, 30, 15, 44), stepMinute: 5 };
            opt.time = { preset: 'time' };
            opt.select = { preset: 'select' };
            opt.dateFormat = 'yyyy-mm-dd';
                var demo = 'date';
            $('#enddate').val('').scroller('destroy').scroller(
                $.extend(opt['date'], {
                    theme: 'android-ics light',
                    mode: 'scroller',
                    display: 'bottom',
                    lang: 'zh',
                    dateOrder: 'yyyymmdd',
                    dateFormat: 'yyyy-mm-dd',
                    minDate: new Date('2000-01-01')
                })
            );

        });

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

        function isRegist()
        {
            var name = document.userInfo.name.value;
            var number = document.userInfo.number.value;
            var div1 = document.getElementById("isOrigine");
            if(name==""||number=="")
            {
                div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>姓名和学号不能为空</font>";
            }
            else
            {
                sendRequest("isOrigine?name="+name+"&number="+number);
                
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
                        div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>学号信息不存在，请联系管理员加入</font>";
                    }else if(responseInfo == "Registed"){
                        div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>该学号已注册</font>";
                    }else if(responseInfo == "Wrong"){
                        div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>姓名与学号不匹配</font>";
                    }else if(responseInfo == "True"){
                        div1.innerHTML="<font style='color: #38A45A;font-size: 12px;margin-left: 10px;'>输入正确</font>";
                    }else{
                        div1.innerHTML="<font style='color: #E75530;font-size: 12px;margin-left: 10px;'>输入有误,请核对信息</font>";
                    }
                }
            }
        }

        function isNull()
        {
            var password = document.userInfo.password.value;
            var div2 = document.getElementById("passwordInfo");
            if(password=="")
            {
                div2.innerHTML="<font color='red'>The username and password may not be empty</font>";
            }
            else
            {
                div2.innerHTML="<font color='red'></font>";
            }
        }

        function isSame()
        {
            var password = document.userInfo.password.value;
            var password2=document.userInfo.repeatedPassword.value;
            var div3 = document.getElementById("password2");
            if(password!=password2)
            {
                div3.innerHTML="<font color='red'>The password you entered two times are different</font>";
            }
            else
            {
                div3.innerHTML="<font color='red'></font>";
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
							<h2>学号<text style="color: red">*</text></h2>
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
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="message" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>验证码<text style="color: red">*</text></h2>
						</div>
					</a> 
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
								<input type="text" name="password" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>密码<text style="color: red">*</text></h2>
						</div>
					</a> 
					<a href="#" class="aui-flex b-line">

						<div class="aui-flex-box">

							<div id="demo_default" class="demos">
								<input type="text" name="password" class="test_default input"
									style="box-shadow: none; mso-border-shadow: no" value="" />
							</div>
							<h2>确认密码<text style="color: red">*</text></h2>
						</div>
					</a> 
				<font style="color: #E75530;font-size: 12px;display: block;margin-top: 10px;margin-left: 30px;float: left;right: 0;top: 0;"> ${sessionScope.regist}</font>
				</div>
				<input type="text" id="xinzi1" name="xinzi1" style="display: none">
				<input type="text" id="xinzi2" name="xinzi2" style="display: none">
				<input type="text" id="xingzhi" name="leixing" style="display: none">
				<input type="text" id="jingyan" name="jingyan" style="display: none">
				<input type="text" id="xueli" name="xueli" style="display: none">
				<input type="text" id="sheng" name="sheng" style="display: none">
				<input type="text" id="shi" name="shi" style="display: none">
				<input type="text" id="qu" name="qu" style="display: none">
				<input type="text" id="sheng1" name="sheng1" style="display: none">
				<input type="text" id="shi1" name="shi1" style="display: none">
				<input type="text" id="qu1" name="qu1" style="display: none">
				<input type="text" id="fjob" name="fjob" style="display: none">
				<input type="text" id="sjob" name="sjob" style="display: none">
				<input type="text" id="tjob" name="tjob" style="display: none">
				<input type="text" id="fjob1" name="fjob1" style="display: none">
				<input type="text" id="sjob1" name="sjob1" style="display: none">
				<input type="text" id="tjob1" name="tjob1" style="display: none">
				<input class="submit" type="submit" value="注册"
					style="margin-top: 1rem">
			</form>
		</section>
	</section>

</body>

</html>