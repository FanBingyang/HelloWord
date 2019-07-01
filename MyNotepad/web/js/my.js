
//首页搜索框跳转
function sousuo() {
    var sousuo = document.getElementById("sousuo").value;
    // alert(sousuo);
    if(sousuo=="" || sousuo=="找笔记"){
        alert("请输入关键字");
    }
    else {
        window.location.href="serearchArticle?sousuo="+sousuo;
    }
}

//写笔记保存时判断是否为空
function save() {
    //参数‘biji’是textarea元素的id属性值
    //获取带html标签的文本内容,数据类型是String
    var content=CKEDITOR.instances.biji.getData();
    //取得纯文本,数据类型是String
    // var stemTxt=CKEDITOR.instances.biji.document.getBody().getText();
    if(content==""){
        alert("内容不能为空！");
        return false; //返回false，阻止表单的跳转
    }else {
        //alert(content);//测试时用来弹窗查看是否得到编辑器中的内容
        // 以下代码是百度出的讲ckeditor编辑器中的内容同步到对应的textarea中，
        // 但是并没有用上，因为没发现效果，并且没有这一段代码在后台通过textarea的name属性
        // 也能直接获取ckeditor中的内容，只不过需要对中文进行转码。
        // for ( instance in CKEDITOR.instances )
        // {
        //     CKEDITOR.instances[instance].updateElement();
        // }
        return true; //表单进行跳转
    }
}

//个人中心上传头像按钮
function change(){
    var liulan = document.getElementById("liulan");
    var submit = document.getElementById("queding");
    var quxiao = document.getElementById("quxiao");
    quxiao.style="visibility: visible;width: 60px;height: 30px;";
    liulan.style="visibility: visible;margin-top: 20px;margin-left: 40px;height: 25px;cursor: pointer;"
    submit.style="visibility: visible;margin-top: 20px; margin-left: 20px; width: 60px; height: 30px; cursor: pointer;margin-right: 20px;"
}
//个人中心取消按钮
function fanhui(){
    var liulan = document.getElementById("liulan");
    var submit = document.getElementById("queding");
    var quxiao = document.getElementById("quxiao");
    quxiao.style.visibility="hidden";
    liulan.style="visibility: hidden;"
    submit.style="visibility: hidden;";
}
//删除文章函数
function doDelete(userId,article_id) {
    var flag = confirm("是否确定删除？");
    /* 如果这里用户点击的是确定，就马上请求Servlet */
    if(flag){
        //表明点击了确定，访问Servlet，在当前页面打开超链接
        //window.location.href="deleteArticle?articleId="+article_id;//等价于下一句
        // confirm("deleteArticle?articleId="+article_id+"&userId="+userId);
        location.href="deleteArticle?articleId="+article_id+"&userId="+userId;
    }
}

//转载文章的时候弹窗提示转载成功
function zhuanzai() {
    alert("文章转载成功！");
}



