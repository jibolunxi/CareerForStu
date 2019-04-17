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
<link href="css/style.css" rel="stylesheet" type="text/css" />
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

			<div class="aui-center">
				<span class="aui-center-title"> <span
					style="color: whitesmoke; position: fixed; width: 100%; text-align: center; right: 0; left: 0; font-size: 1.35rem; top: 1.25rem">工作推荐</span>
				</span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
			<div class="aui-users-list">
				<c:forEach var="companyJob" items="${companyJobs}">
					<c:if test="${companyJob.status==1}">
						<a href="jobRecommendDetail?companyJobId=${companyJob.id}"
							class="aui-flex b-line">
							<div class="aui-flex-box">
								<h1>${companyJob.name}
									&nbsp;
									<c:choose>
										<c:when test="${companyJob.jobhits<10}">
											<span class="type_little">稀</span>
										</c:when>
										<c:when test="${companyJob.jobhits>9&&companyJob.jobhits<20}">
											<span class="type_normal">普</span>
										</c:when>
										<c:otherwise>
											<span class="type_fire">火</span>
										</c:otherwise>
									</c:choose>
								</h1>
								<label class="detail"><img src="images/talk.png"
									width="20px" height="20px"><span>${companyJob.jobhits}</span></label>
								<label class="detail"><img src="images/view.png"
									width="20px" height="20px"><span>${companyJob.snum}</span></label>
							</div>
							<div class="aui-user-button" style="text-align: center">
								<span style="display: inline-block; vertical-align: middle"><img
									src="images/arrow.png" width="25px" height="25px"></span>
							</div>
						</a>
					</c:if>
				</c:forEach>
			</div>

		</section>
		<footer class="aui-footer">
			<a href="studentHomePage" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-index"></i>
			</span> <span class="aui-tabBar-item-text">首页 </span>
			</a> <a href="#" class="aui-tabBar-item aui-tabBar-item-active"> <span
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
