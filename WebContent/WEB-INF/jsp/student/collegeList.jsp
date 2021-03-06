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
<!--弹出层样式-->
<link rel="stylesheet" type="text/css" href="css/payment.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="dev/js/mobiscroll.core-2.5.2.js" type="text/javascript"></script>
<script src="dev/js/mobiscroll.core-2.5.2-zh.js" type="text/javascript"></script>
<link href="dev/css/mobiscroll.core-2.5.2.css" rel="stylesheet"
	type="text/css" />
<link href="dev/css/mobiscroll.animation-2.5.2.css" rel="stylesheet"
	type="text/css" />
<script src="dev/js/mobiscroll.datetime-2.5.1.js" type="text/javascript"></script>
<script src="dev/js/mobiscroll.datetime-2.5.1-zh.js"
	type="text/javascript"></script>
<script src="dev/js/mobiscroll.android-ics-2.5.2.js"
	type="text/javascript"></script>
<link href="dev/css/mobiscroll.android-ics-2.5.2.css" rel="stylesheet"
	type="text/css" />
<script src="js/mobiscroll.custom-2.5.2.min.js" type="text/javascript"></script>

<script type="text/javascript" src="js/mobiscroll.custom.min.js"></script>
<link href="css/mobiscroll.custom.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/mobiscroll.custom-2.5.2.min.css" rel="stylesheet"
	type="text/css">
<link href="css/styletwo.css" rel="stylesheet" type="text/css" />
<link href="css/style4.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/password.js"></script>

<style>
.aui-flex {
	padding: 0.5rem;
}

input {
	width: 6rem;
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
</style>
</head>

<body>


	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed b-line">
			<a href="#" class="aui-navBar-item"> <!-- <i class="icon icon-return" onclick="sure()" id="return_back" style="z-index: 1000"></i> -->
				<span style="color: whitesmoke" class="fixed">选择学校</span>
			</a>
			<div class="aui-center">
				<span class="aui-center-title"></span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
			<c:forEach var="college" items="${colleges}">
				<div class="aui-users-list b-line">
					<a
						href="collegeReturnHome?collegeId=${college.id}&collegeName=${college.name}"
						class="aui-flex">
						<div class="aui-flex-box">
							<p>${college.name}</p>
						</div>
					</a>
				</div>
			</c:forEach>
		</section>
	</section>




</body>


<script src="js/payment.js" type="text/javascript"></script>

</html>