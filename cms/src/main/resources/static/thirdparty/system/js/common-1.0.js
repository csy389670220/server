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


//图片上传框初始化方法
function initFileInput(ctrlName) {
    var control = $('#' + ctrlName);
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: "", //上传的地址,当地址为空时，拖拽区域不显示
        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        showUpload: false, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        maxFileCount: 1, //表示允许同时上传的最大文件个数。当maxFileCount>1时，input需要设置multiple="multiple"属性
        enctype: 'multipart/form-data',
        validateInitialCount:true,//验证初始计数,默认值false
        // previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        //dropZoneEnabled: false,//是否显示拖拽区域,默认true
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        maxFileSize: 1024,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
    }).on('filepreupload', function(event, data, previewId, index) {     //上传中
        var form = data.form, files = data.files, extra = data.extra,
            response = data.response, reader = data.reader;
        console.log('文件正在上传');
    }).on("fileuploaded", function (event, data, previewId, index) {    //一个文件上传成功
        var res = data.response;
        //alert(res.success);
    }).on('fileerror', function(event, data, msg) {  //一个文件上传失败
        console.log('文件上传失败！'+data.id);


    })
}


//分页插件初始化
function initPageinator(pageName,pageNum,pages) {
    var control = $('#' + pageName);
    var element = $(control);//对应下面ul的ID
    var options = {
        currentPage: pageNum,//当前的请求页面。
        totalPages: pages,//一共多少页。
        size:"normal",//应该是页眉的大小。
        bootstrapMajorVersion: 3,//bootstrap的版本要求。
        alignment:"right",
        numberOfPages:5,//一页列出多少数据。
        onPageClicked: function (event, originalEvent, type, page) {
            $("#pageNum").val(page);//将分页栏信息存储在隐藏域中
            var userName=$("#user_name").val();
            $('#dataTables-example').load("queryList",{"userName":userName,"page":page});
        },
        itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
            switch (type) {
                case "first": return "首页";
                case "prev": return "上一页";
                case "next": return "下一页";
                case "last": return "末页";
                case "page": return page;
            }
        }
    }
    element.bootstrapPaginator(options);

}

