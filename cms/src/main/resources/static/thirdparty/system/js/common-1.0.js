/* 导航栏选择状态切换*/
$(".meun-item").click(function() {
    $(".meun-item").removeClass("meun-item-active");
    $(this).addClass("meun-item-active");
});

/*菜单栏点击跳转页面*/
$("#welcome").click(function() {
    window.location.href="/CMS/welcome"; //跳转到欢迎页面
});
$("#ideal").click(function() {
    window.location.href="/CMS/ideal/query";// 跳转到ideal系统配置查询页面
});
$("#userInfo").click(function() {
    window.location.href="/CMS/userInfo/query";// 跳转到userInfo用户查询页面
});

