//改变位置⤵
$("#a").animate({top:500},200);
//改变css样式⤵
$("#a").css("color","purple");
//元素消失⤵
$("#a").toggle("slow");
//让所有h1元素慢慢消失
$("h1").hide("slow");
//让所有h2元素快速出现
$("h2").show("fast");
//元素淡出淡入,参数为完成时间，单位是毫秒
$("img").fadeIn(1000);
//元素如果朝上就向下滑动，反之则相反，缓慢进行
$("#a").slideToggle("slow");
//慢慢将元素高度变为0，然后隐藏,参数为完成时间，单位是毫秒
$("#a").slideUp(500);
//慢慢将元素高度从0改为css样式中设置的高度,参数为完成时间，单位是毫秒
$("#a").slideDown(500);

//random方法返回一个0到1之间的随机数，flor将一个数取整为最接近的整数返回
var discount = Math.floor((Math.random()*5) + 5);

//将元素添加到页面中。this代表当前元素，
$(this).append(msg);
//将该元素从页面中移除
$(".guess_box p").remove();

//为 #main元素绑定一个click事件
$("#main").bind("click",function(){    alert("");  });
//解除当前事件监听的绑定，不再对其进行监听
$(this).unbind("click");
//解除所有".guess_box"元素的监听
$(".guess_box").unbind("click");
//使用遍历挨个为".guess_box"解除事件绑定，效果同上
$(".guess_box").each(function () {   $(this).unbind("click");  }) ;

//查找元素 contains:第一个参数代表对象，第二个参数是要查找的元素，就是检查第一个元素的所有子元素，查看是否包含第二个元素
if($.contains(this,document.getElementById("has_discount"))){ }

//index：是索引的下标；value:表示当前对象
$(".guess_box").each(function (index,value) { });

//鼠标悬浮事件，第一个函数鼠标悬浮时执行，第二个函数鼠标离开时实行
$(".guess_box").hover(function () { },function () { });

//为元素增加一个CSS类，不会影响这个元素已有的CSS类，也可以添加多个类，之间用空格隔开
$("#header").addClass("hover");
//删除元素的一个CSS类
$("#header").removeClass("no_hover");




