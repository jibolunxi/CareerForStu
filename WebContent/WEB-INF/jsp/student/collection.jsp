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
    <link href="css/styletwo.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/password.js"></script>
</head>
<body>

<section class="aui-flexView">
    <header class="aui-navBar aui-navBar-fixed b-line">
        <a href="studentZone" class="aui-navBar-item">
            <i class="icon icon-return" onclick="main()"></i>
            <span style="color:whitesmoke" class="fixed">我的收藏</span>
        </a>
        <div class="aui-center">
            <span class="aui-center-title"></span>
        </div>
        <a href="javascript:;" class="aui-navBar-item">
            <i class="icon icon-sys"></i>
        </a>
    </header>
    <section class="aui-scrollView">
                <div class="aui-users-list">
	                <c:forEach var="stufavorite" items="${stuFavorites}">
	                    <a href="collectionDetail?jobId=${stufavorite.job_id}" class="aui-flex b-line">
	                        <div class="aui-flex-user">
	                            <img src="images/user.jpg" alt="">
	                        </div>
	                        <div class="aui-flex-box">
	                            <h2>${stufavorite.job_name}</h2>
	                            <p>${stufavorite.com_name}</p>
	                            <p>${stufavorite.create_time}</p>
	                        </div>
	                    </a>
	                </c:forEach>
                </div>
      </section>
</section>

</body>
</html>

