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
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/login.css">

	<section class="aui-flexView">
		<section class="aui-scrollView">
			<div class="aui-head-yellow">
				<div style="text-align: center; color: whitesmoke">
					<h3>学生登录</h3>
				</div>
			</div>
			<section class="aui-scrollView">
				<div class="aui-code-box">
					<form action="studentHomePage" method="post">
						<p class="aui-code-line">
							<input type="text" class="aui-code-line-input" name="studentName"
								value="" id="studentName" autocomplete="off"
								placeholder="请输入账户姓名">
						</p>
						<p class="aui-code-line aui-code-line-clear">
							<input type="password" class="aui-code-line-input password"
								name="password" value="" id="password" placeholder="请输入密码">
						</p>
						<div class="aui-code-btn">
							<button>登录</button>

						</div>
					</form>
				</div>

			</section>
		</section>

	</section>
	<script type="text/javascript">
    $('.aui-show').click(function() {
        let pass_type = $('input.password').attr('type');

        if (pass_type === 'password') {
            $('input.password').attr('type', 'text');
            $('.aui-show').removeClass('operate-eye-open').addClass('operate-eye-close');
        } else {
            $('input.password').attr('type', 'password');
            $('.aui-show').removeClass('operate-eye-close').addClass('operate-eye-open');
        }
    })
</script>





</body>
</html>
