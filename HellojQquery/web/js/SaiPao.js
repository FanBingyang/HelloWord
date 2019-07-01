$(document).ready(function () {
    var repate = true;
    var FREQ = 10000;   //作为setTimeout函数的时间

    function startAJAXcalls(){
        if(repate){
            setTimeout(function () {
                getXMLRacers();
                startAJAXcalls();    //10秒后再次调用该函数
            },FREQ);
        }
    }
    $("#btnStop").click(function () {
        repate = false;
        $("#frep").html("Update paused.");
    });
    $("#btnStart").click(function () {
       repate = true;
       startAJAXcalls();
        $("#frep").html("Page refreshes every "+FREQ/100 +" second(s).");
    });
    getXMLRacers();     //调用该函数，确保页面加载时有内容
    // startAJAXcalls();

    function getXMLRacers(){
        $.ajax({
            url:"SaiPao.xml", //通过Ajax加载finishers.xml文件
            cache:false,    //这个函数表示在本地缓存结果，这样可以减少对服务器的调用
            dataType:"xml",     //希望从服务器返回的类型
            success:function (xml) {    //调用返回的数据
                $('#finishers_m').empty();
                $('#finishers_f').empty();
                $('#finishers_all').empty();    //清空所有ul元素，
                $(xml).find("runner").each(function () {        //循环处理xml文件的各个runner元素
                   var info = '<li>Name:'+$(this).find("fname").text()+'.Time:'+$(this).find("time").text()+'</li>';
                   if($(this).find("gender").text() == "m"){        //检查运动员性别，放到相应的列表中
                       $('#finishers_m').append(info);
                   }else if ($(this).find("gender").text() == "f"){
                       $('#finishers_f').append(info);
                   } else{ }
                   $('#finishers_all').append(info);
                });
                $("#frep").html("Page refreshes every "+FREQ/100 +" second(s).");
                getTime();      //调用时间方法
            }
        });
    }

   function getTime() {
       var a_p = "";
       var d = new Date();  //创建时间对象
       var curr_hour = d.getHours();
       (curr_hour < 12) ? a_p = "AM" : a_p = "PM";  //三元运算符，？前判读为真，返回:前面的，反之，返回:后面的
       (curr_hour == 0) ? curr_hour = 12 : curr_hour = curr_hour;
       (curr_hour > 12) ? curr_hour = curr_hour - 12 : curr_hour = curr_hour;
       var curr_min = d.getMinutes().toString();
       var curr_sec = d.getSeconds().toString();
       if(curr_min.length == 1) {
           curr_min = "0" + curr_min;
       }
       if(curr_sec.length == 1){
           curr_sec = "0" + curr_sec;
       }
       $("#updatedTime").html(curr_hour+":"+curr_min+":"+curr_sec+" "+a_p);
   }
});