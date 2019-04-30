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
<script type="text/javascript" src="js/password.js"></script>
<link href="css/styletwo.css" rel="stylesheet" type="text/css" />
<link href="css/style4.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/password.js"></script>
<style>
.gonggao {
	height: 200px;
	width: 100%;
}

.gengduo {
	position: absolute;
	top: 60px;
	right: 20px;
}

.tongzhi {
	position: absolute;
	height: 100px;
	width: 100%;
	top: 120px;
	text-align: center;
	line-height: 40px;
	font-size: 20px;
}

.d-line {
	position: relative;
	margin-top: -10px;
}

.d-line:after {
	content: '';
	position: absolute;
	z-index: 2;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 10px;
	border-bottom: 5px solid #e2e2e2;
	-webkit-transform: scaleY(0.5);
	transform: scaleY(0.5);
	-webkit-transform-origin: 0 100%;
	transform-origin: 0 100%;
}

.dot-bottom {
	font-size: 0;
	line-height: 0;
	border-width: 10px;
	border-color: gray;
	border-bottom-width: 0;
	border-style: dashed;
	border-top-style: solid;
	border-left-color: transparent;
	border-right-color: transparent;
}
</style>
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
			<div class="aui-center">
				<span class="aui-center-title"> <span
					style="color: whitesmoke; position: fixed; width: 100%; text-align: center; right: 0; left: 0; font-size: 1.35rem; top: 1.25rem">学校通知</span>
				</span>
			</div>
		</header>
		<section class="aui-scrollView">
			<div class="aui-card-list">
				<a href="getCollegeList" class="aui-panel-cell">
					<div class="aui-panel-cell-bd">
						<h4>${home_collegeName}</h4>
					</div>
					<div class="dot-bottom"></div>
				</a>
			</div>
			<div>
				<img src="images/gonggao.jpg" class="gonggao"> <a
					href="newsList" class="gengduo">更多</a> <a
					href="newsDetail?newsId=${homepage_news.id}">
					<div class="tongzhi">
						<p>${homepage_news.title}</p>
						<p>${homepage_news.ctime}</p>
					</div>
				</a>
			</div>
			<div class="aui-card-list">
				<a href="getDepartment" class="aui-panel-cell">
					<div class="aui-panel-cell-bd">
						<h4>${home_deptName}</h4>
					</div>
					<div class="dot-bottom"></div>
				</a>
			</div>
			<div class="aui-users-list">
				<c:forEach var="homepage_student" items="${homepage_students}">
					<a href="studentDetail?studentId=${homepage_student.uid}"
						class="aui-flex b-line">
						<div class="aui-flex-user">
							<img src="${homepage_student.resume_photo}" alt="">
						</div>
						<div class="aui-flex-box">
							<h2>${homepage_student.name}</h2>
							<p>${homepage_student.college_name}
								&nbsp;${homepage_student.dept_name}</p>

						</div>
						<div class="aui-user-button" style="text-align: center">
							<div class="chat-button">
								<button>查看</button>
							</div>

						</div>
					</a>
				</c:forEach>

			</div>
		</section>
		<footer class="aui-footer">
			<a href="#" class="aui-tabBar-item aui-tabBar-item-active"> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-index"></i>
			</span> <span class="aui-tabBar-item-text">首页 </span>
			</a> <a href="jobRecommend" class="aui-tabBar-item"> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-recruit"></i>
			</span> <span class="aui-tabBar-item-text">招聘 </span>
			</a> <a href="studentZone" class="aui-tabBar-item"> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-me"></i>
			</span> <span class="aui-tabBar-item-text">我的 </span>
			</a>
		</footer>
	</section>
</body>
</html>
