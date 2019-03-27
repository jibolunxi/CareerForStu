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
			<div class="aui-navBar-item">
				<a class="icon icon-return" href="studentZone"></a> <span
					style="color: whitesmoke" class="fixed">简历详情</span>
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
				<a class="aui-flex b-line">
					<!--姓名和照片-->

					<div class="aui-flex-box">
						<h1>${mystudent.name}</h1>
					</div>
					<div class="aui-flex-user">
						<img src="images/user.jpg" alt="">
					</div>
				</a> <a href="#" class="aui-flex b-line">

					<div class="aui-flex-box">
						<p>
							离职-随时到岗<span style="position: absolute; right: 1.2rem">刚刚活跃</span>
						</p>
						<label class="detail"><img src="images/degree.png"
							width="20px" height="20px"><span>${mystudent.edu}</span></label> <label
							class="detail"><img src="images/cake.png" width="20px"
							height="20px"><span>${mystudent.birthday}</span></label>
						<p style="font-size: small">
							<span> ${mystudent.description} </span>
						</p>
					</div>
				</a> <a class="aui-flex b-line">
					<div class="aui-flex-box">
						<div>
							<h1 class="padding title">
								<img src="images/circle.png" width="10px" height="10px">求职期望
							</h1>
						</div>
						<strong class="padding">${studentExp.job_name} &nbsp;
							${studentExp.city_name} </strong>
						<p class="padding">${studentExp.hy_name}</p>
					</div>
					<div class="aui-user-button" style="text-align: center">
						<h3 style="color: #4CD864">
							<span>${studentExp.minsalary}-${studentExp.maxsalary}</span>
						</h3>
						<!--月薪-->
					</div>
				</a>
				<!-- <a href="addJobExpect"><img src="images/add.png"/></a> -->
				<a class="aui-flex b-line">
					<div class="aui-flex-box">
						<div>
							<h1 class="padding title">
								<img src="images/bluecircle.png" width="10px" height="10px">&nbsp;教育经历
							</h1>
						</div>
						<c:forEach var="studentEdu" items="${studentEduList}">
							<strong class="padding">${studentEdu.college}</strong>
							<span class="work_time">${studentEdu.starttime}~${studentEdu.endtime}</span>
							<!--月薪-->
							<p class="padding">${studentEdu.edu_name}·${studentEdu.major}</p>
							<hr class="work_ex">
						</c:forEach>
					</div>
				</a>
				<!-- <a href="addStuEdu"><img src="images/add.png"/></a> -->
				<div
					style="position: absolute; width: 100%; left: 0; right: 0; text-align: center">
					<a href="edit" onclick="success()" id="friend"
						style="background-color: #4CAF50; border: none; color: white; padding: 0.5rem 2rem; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; cursor: pointer; margin-top: 2rem;">编辑</a>
				</div>
			</div>
		</section>
	</section>

</body>
</html>
