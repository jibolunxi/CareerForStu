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
<link href="css/styletwo.css" rel="stylesheet" type="text/css" />
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
		<header class="aui-navBar aui-navBar-fixed b-line">
			<div href="studentZone" class="aui-navBar-item">
				<a class="icon icon-return" href="studentHomePage"></a> <span
					style="color: whitesmoke" class="fixed">学校通知</span>
			</div>
			<div class="aui-center">
				<span class="aui-center-title"></span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
			<div class="aui-users-list">
				<c:forEach var="news" items="${newsList}">
					<c:if test="${news.status == 1}">
						<a href="newsDetail?newsId=${news.id}" class="aui-flex b-line">
							<div class="aui-flex-box">
								<h2>${news.title}</h2>
								<%--  <p style="font-size: small; position: absolute ;right: 1rem ;top: 1.45rem;">${news.ctime}</p> --%>

							</div>
							<div class="aui-user-button" style="text-align: center"></div>
						</a>
					</c:if>
				</c:forEach>
			</div>
		</section>
	</section>

</body>
</html>

