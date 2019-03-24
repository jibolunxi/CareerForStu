var width=document.documentElement.clientWidth;//获取屏幕的宽度
var height=document.documentElement.clientHeight;//获取屏幕的高度
var bili1=width/750;//屏幕宽度与设计稿宽度的比例（750是设计稿的宽度）
var bili2=height/(1336-48);//屏幕高度与设计稿高度的比例(1336是设计稿的高度，其中48是设计稿中含有手机顶部的状态栏，需要去掉，1366-48才是真正需要显示的东西)
var bili=bili1<bili2?bili1:bili2;//宽度的比例和高度的比例进行比较，取值最小的
var html = document.querySelector('html');//选择html节点
  var rem = 16;//手动设置rem与px的比例；
  html.style.fontSize = rem + "px";//设置html的默认fontsize为16px。(注意，浏览器中最小值为12px，)
var __bili=bili/rem;//将比例和rem进行联系。
document.documentElement.style.setProperty('--bili', __bili+"rem");//设置css中的变量为--bili，值为__bili

/* jobDescribe autofit THe size of text's area */
/*
$('#text').on('input',function(){
  　　if(text.scrollHeight>text.offsetHeight){
  　　　　THeight += 20;　　//font-size的大小是20，因此每次给textarea的高度增加20px
  　　　　$('#text').css('height',THeight);
      }
  })*/