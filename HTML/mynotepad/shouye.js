/*左侧菜单点击事件*/
$(function(){
	var caidan=$(".menu").find("li");
	caidan.click(function(){
		//改变所选元素的背景色
		$(this).css("background-color","skyblue");
		//恢复同一级元素的原有色
		$(this).siblings().css("background-color","azure");
		//鼠标悬浮事件，第一个函数鼠标悬浮时执行，第二个函数鼠标离开时实行
//		$(this).siblings().hover(function () {$(this).parent().children().css("background-color","skyblue");},function () {$(this).parent().childrens().css("background-color","azure"); });
	});
	
})


