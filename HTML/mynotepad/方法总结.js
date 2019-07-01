//改变位置⤵
$("#a").animate({top:500},200);
//改变css样式⤵
$("#a").css("color","purple");
//如果一个元素隐藏，JS解释器就会让他显示，如果原先是显示，则会将其隐藏，参数可以是slow、fast、或者是一个时间数值⤵
$("#a").toggle("slow");
//让所有h1元素慢慢消失
$("h1").hide("slow");
//让所有h2元素快速出现
$("h2").show("fast");
//元素淡入,参数为完成时间，单位是毫秒
$("img").fadeIn(1000);
//元素淡出,参数为完成时间，单位是毫秒
$("img").fadeOut(1000);
//将元素改为指定透明度百分比
$("img").fadeIn();
//方法链，来让元素淡出淡入
$("img"),fadeIn().fadeOut();//先将元素淡入然后再淡出，实现类似闪电效果

//元素如果高度是0，就向下滑动，反之则相反，缓慢进行
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

//删除元素中的内容
$("p").empty();

//遍历一个元素的所有父元素
$("div").parents();
//遍历一个元素的父元素
$("div").parent();
//得到所选元素最近的父元素
$("li").closest("ul");//找到li上面最近的ul
//得到元素上(左)边的元素
$("div").prev();
//得到元素下(右)边的元素
$("div").next();
//遍历所选元素同一层的所有元素
$("#a").siblings();
//遍历子元素
$("#a").children();

//删除元素并把该元素弹出，变量前加上 $ 表示接收由jQuery返回的元素
$f = $("#a").detach();

//将所选元素替换成新元素,将#a元素替换成<h1>lalal</h1>
$("#a").replaceWith("<h1>lalal</h1>");
//再指定元素之气添加新的元素，再.meat元素前添加<li>Tofu</li>
$(".meat").before("<li>Tofu</li>");
//再指定元素后面添加新的元素
$(".meat").after("<li>Tofu</li>");

//选中并列元素中的第一个元素 first()
$("#a").children().first();//选取#a元素子元素集中的第一个元素
//选中并列元素中的最后一个元素 last()
$("#a").children().last();//选取#a元素子元素集中的最后一个元素
//根据索引号选取元素 eq(index);
$("#a").children().eq(0);//选取#a元素子元素集中索引号为0的元素，也就是第一个元素
//指定选择器匹配元素 filter()
$("#a").parents().filter(".b");//选取选取#a元素所有父元素中的.b元素
//按索引号范围选取元素 slice(start,end)
$("#a").children().slice(1,3);//选取#a元素子元素集中索引号在1和3之间的元素，也就是索引号为2的元素
//过滤选取 not()
$("#a").parents().not(".b");////选取选取#a元素所有父元素中不匹配.b的元素

//元素包含元素
$("img#aa").wrap("<a href='#'></a>");//将一个id为aa的图片半酣在一个锚(a)中

//从jQuery数组中用find的方法寻找元素
var $m = $("li");   $m.find("a");//找到该数组中的锚元素

//定时函数 setTimeOut("函数",时间);
function hanshu(t) { //传入时间参数，也可以空参
    alter("函数执行代码");
    setTimeout("hanshu()",t);
};

//元素位置的改变 animate({元素的CSS属性},时间);
$("img").animate({left:"100px"},500);

//在一个数组中查找某个元素的索引
var index = $.inArray('要找的值','目标数组');

//设置被选元素的属性和值。
$(selector).attr("属性名称","属性值");

//trigger() 方法触发被选元素的指定事件类型,规定被选元素要触发的事件
$(selector).trigger(event,value);
//event 必需。规定指定元素要触发的事件。可以使自定义事件（使用 bind() 函数来附加），或者任何标准事件。
//value,可选（多选）。传递到事件处理程序的额外参数。额外的参数对自定义事件特别有用。

//窗口获得焦点.赋值给一个函数引用
window.onfocus = focusfunction;   function focusfunction() { };
//窗口失去焦点.赋值给一个函数引用
window.onblur =blurfunction;   function blurfunction() { };

//JavaScript定时器方法
//设置等待时间，时间过后运行函数
setTimeout("函数","时间");
//反复执行运行一个函数，每次重复之前又一个时间间隔
ini = setInterval("函数名","时间");
//清除定时其器
window.clearInterval("函数名");
//在效果连中加入一个停顿的时间
delay("时间");


