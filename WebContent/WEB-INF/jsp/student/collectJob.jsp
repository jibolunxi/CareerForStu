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
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/styletwo.css" rel="stylesheet" type="text/css"/>
</head>
<body>



<section class="aui-flexView">
    <header class="aui-navBar aui-navBar-fixed b-line">
        <div class="aui-navBar-item">
            <a class="icon icon-return" href="${backurl}"></a>
            <span style="color:whitesmoke" class="fixed">${companyJob.name}</span>
        </div>
         <c:if test="${isStar==0}">
                <a href="addCollection" style="position: absolute ;right: 1rem ;top: 1.6rem;z-index:10000">
            <img src="images/Star.png" width="20px" height="20px" id="Star">
        		</a>
                </c:if>
                 <c:if test="${isStar==1}">
                <a href="removeCollection" style="position: absolute ;right: 1rem ;top: 1.6rem;z-index:10000">
            <img src="images/isStar.png" width="20px" height="20px" id="isStar">
        		</div>
                </c:if>
        <div class="aui-center">
            <span class="aui-center-title"></span>
        </div>
        <a href="javascript:;" class="aui-navBar-item">
            <i class="icon icon-sys"></i>
        </a>
    </header>
    <section class="aui-scrollView">
        <div class="aui-users-list">
            <a href="#" class="aui-flex b-line">
                <div class="aui-flex-box">
                    <h1 style="font-size: 1.6rem">${companyJob.name} <span class="type_state">招聘中</span></h1>
                    <p style="font-size: 1.2rem">${companyJob.minsalary}-${companyJob.maxsalary}</p>
                    <br>
                    <label class="detail"><img src="images/home.png" width="20px" height="20px"><span>${companyJob.city_name}·${companyJob.three_cityname}</span></label>
                    <label class="detail"><img src="images/degree2.png" width="20px" height="20px"><span>${companyJob.edu_name}</span></label>
                    <label class="detail"><img src="images/work.png" width="20px" height="20px"><span>1-3年</span></label>
                </div>
                <div class="aui-user-button" style="text-align: center ">

                </div>
            </a>
            <a href="companyDetail?companyId=${companyJob.uid}" class="aui-flex b-line"><!--姓名和照片-->

                        <div class="aui-flex-box">
                            <h1>${companyJob.com_name}</h1>
                        </div>
                        <div class="aui-flex-user">
                            <img src="images/user.jpg" alt="">
                        </div>
            </a>
            <a href="#" class="aui-flex b-line">
                <div class="aui-flex-box">
                    <h1 style="font-size: 1.3rem ">职位详情</h1>
                    <p class="detail" style="font-size: 1.1rem ;color: black">职位描述</p>
                    <p style="font-size: 1rem;color: black">${companyJob.description}<span style="position:absolute ;right: 1rem"><img src="images/arrow.png" width="17px"height="17px"> </span></p>
                    <p class="detail" style="font-size: 1.1rem ;color: black">任职要求</p>
                    <p style="font-size: 1rem;color: black">${companyJob.cert}<span onclick="#" style="color: #4c7ee9">查看详情</span><span style="position:absolute ;right: 1rem"><img src="images/arrow.png" width="17px"height="17px"> </span></p>

                </div>
                
            </a>
            <a href="#" class="aui-flex b-line">
                <div class="aui-flex-box">
                    <h1 style="font-size: 1.3rem ;margin-bottom: 1rem">技能要求</h1>
                    <span class="type" style="font-size: 1rem">UI</span>
                    <span class="type" style="font-size: 1rem">数据库</span>
                </div>

            </a>
            
            <div class="aui-user-button" style="text-align: center ">
			<c:if test="${isSend==0}">
			<p><a href="sendResume" id="friend" style="background-color: #4CAF50;border: none;color: white;padding: 0.5rem 2rem;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;cursor: pointer;margin-top:2rem;">投递简历</a></p>
	
			</c:if>
			<c:if test="${isSend==1}">
			<p><a  id="friend" style="background-color: #FFFF00;border: none;color: white;padding: 0.5rem 2rem;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;cursor: pointer;margin-top:2rem;">已投递</a></p>
	
			</c:if>
             </div>

        </div>

    </section>

</section>
</body>
</html>
