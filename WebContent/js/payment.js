$(function () {
    $(".payment_time_title em").click(function () {
        $("#bg").css({
            display: "block", height: $(document).height()
        });
        var $box = $('.payment_time_mask');
        $box.css({
            display: "block",
        });
    });
    //点击关闭按钮的时候，遮罩层关闭
    $(".payment_time_mask li").on('click',function () {
        $("#bg,.payment_time_mask").css("display", "none");
        $(".payment_time_title em").text($(this).html());
    });
});