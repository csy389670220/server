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
$("#roadB").click(function() {
    window.location.href="/CMS/index";// 跳转到B分支页面入口
});


function errorMsg(code,msg) {
    alert("错误码：["+code+"]  摘要:["+msg+"]");

}

// javascript 模块化
//主要优化了秒杀模块js
var cmsSystem={
     //页面模块
     page:{
         //get请求打开页面，页面在固定模块渲染
         getPage:function (url,errInfo) {
             $.ajax({
                 url: url,
                 type: "get",    //不区分大小写
                 success: function (view) {
                     $('#rightContent').empty();
                     $('#rightContent').append(view);
                 },
                 error: function (e) {
                     alert(errInfo);
                     console.error(errInfo+":"+e)
                 }
             });
         }

     },
     //秒杀模块
    seckill:{
         url:{
             //秒杀详情页url
             detailUrl:function (userId,seckillId) {
                 return  "seckill/" +userId+"/"+ seckillId + "/detail";
             },
             //获取当前系统时间url
             getNowTimeUrl:function () {
                 return  "seckill/time/now";
             },
             //获取秒杀暴露地址url
             exposerUrl:function (seckillId) {
                 return "seckill/" + seckillId + "/exposer";
             },
             //执行秒杀url
             executionUrl:function (url) {
                 return "seckill/" + url + "/execution";
             },
             //执行秒杀url(存储过程)
             executionProducerUrl:function (url) {
                 return "seckill/" + url + "/executionProducer";
             }
         }

    }

}