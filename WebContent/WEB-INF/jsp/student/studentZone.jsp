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
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/password.js"></script>
</head>
<body>



<section class="aui-flexView">
    <section class="aui-scrollView">
        <div class="aui-head-yellow">
            <div style="position: absolute ;right: 1rem ;z-index: 99" onclick="edit()">
                
            </div>
            <div style="position: absolute ;left: 1rem;z-index: 99" onclick="jump_back()" >
                
            </div>
            <div class="aui-head-box">
                <div class="aui-head-user">
                    <img src="images/user.jpg" alt="">
                </div>

            </div>
            <div style="text-align: center">
                <p style=" display: inline-block ; vertical-align: middle"><img src="images/icon_girl.png" style="width: 25px ; height: 25px">${mystudent.name}<img src="images/icon_iPhone.png" style="width: 25px ; height: 25px">${mystudent.telphone}</p>
                <p>${mystudent.college_name} &nbsp;  ${mystudent.major_name}</p>
            </div>

        </div>
        <div class="aui-card-list">
            <a href="studentMessage" class="aui-panel-cell">
                <div class="aui-panel-cell-hd">
                    <img src="images/message.png" alt="">
                </div>
                <div class="aui-panel-cell-bd">
                    <h4>我的消息</h4>
                </div>
                <div class="aui-panel-cell-fr"></div>
            </a>
            <a href="studentCollection" class="aui-panel-cell">
                <div class="aui-panel-cell-hd">
                    <img src="images/mstar.png" alt="">
                </div>
                <div class="aui-panel-cell-bd">
                    <h4>我的收藏</h4>
                </div>
                <div class="aui-panel-cell-fr"></div>
            </a>
            <a href="myFriends" class="aui-panel-cell">
                <div class="aui-panel-cell-hd">
                    <img src="images/icon_friend.png" alt="">
                </div>
                <div class="aui-panel-cell-bd">
                    <h4>我的好友</h4>
                </div>
                <div class="aui-panel-cell-fr"></div>
            </a>
            <div class="divHeight"></div>
            <a href="myResume" class="aui-panel-cell">
                <div class="aui-panel-cell-hd">
                    <img src="images/icon_3333.png" alt="">
                </div>
                <div class="aui-panel-cell-bd">
                    <h4>我的简历</h4>
                </div>
                <div class="aui-panel-cell-fr"></div>
            </a>
        </div>
    </section>
    <footer class="aui-footer">
        <a href="studentHomePage" class="aui-tabBar-item ">
                    <span class="aui-tabBar-item-icon">
                        <i class="icon icon-index"></i>
                    </span>
            <span class="aui-tabBar-item-text">首页
                    </span>
        </a>
        <a href="jobRecommend" class="aui-tabBar-item">
                    <span class="aui-tabBar-item-icon">
                        <i class="icon icon-recruit"></i>
                    </span>
            <span class="aui-tabBar-item-text">招聘
                    </span>
        </a>
        <a href="#" class="aui-tabBar-item aui-tabBar-item-active">
                    <span class="aui-tabBar-item-icon">
                        <i class="icon icon-me"></i>
                    </span>
            <span class="aui-tabBar-item-text">我的
                    </span>
        </a>
    </footer>
</section>
</body>
</html>
