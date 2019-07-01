<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		/* function Person() {
			var name = "tom";//声明一个局部变量
			this.age = 10;//声明一个成员变量
			
			this.show = function()
			{
				alert(name);
			}
		}
		var p = new Person();
		document.write(p.name); //取不到
		document.write(p.age);
		p.show(); */ 
		
		//一个json对象
		var pp = {name:"tom",age:18,show:function(){alert("hello");}};
		document.write(pp.age);
		pp.show();
		
		var ppp = [{name:"tom",age:18},{name:"jerry",age:20}];
		document.write(ppp[1].name);
		
	</script>
</head>
<body>

</body>
</html>