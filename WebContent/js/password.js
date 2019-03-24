function validate() {

    var pwd1 = document.getElementById("password").value;
    var pwd2 = document.getElementById("password1").value;
    if (pwd1 === pwd2) {
        document.getElementById("confirm").innerHTML = "<span style=\"color: lightgreen\">密码确认一致</span>";
        /*         $("#tishi").hide(1500); */
        document.getElementById("ok").removeAttribute("hidden");

    }
    else {
        document.getElementById("confirm").innerHTML = "<span style=\"color: #8B0000\">密码不一致!</span>";
        document.getElementById("ok").setAttribute('hidden','hidden');
    }
}



function main() {
    window.location="http://www.baidu.com";
}
function sure(){
    var ansswer = confirm("你还没保存，确定退出吗？");
    if(ansswer){
        window.location = 'http://www.baidu.com';
    }
}

function is_save(){
    /* 保存操作*/
    /*document.getElementById("return_back").setAttribute("onclick","main()");*/
    window.location="";
}
function save_password() {
    /* 保存操作,保存之后直接跳转*/
    window.location="";
}

function save_data() {
    window.location='http://www.baidu.com';
}
function save_name() {
    window.location='http://www.baidu.com';
}

function jump_back() {
    window.location='http://www.baidu.com';
}

function edit() {
    window.location='http://www.baidu.com';
}