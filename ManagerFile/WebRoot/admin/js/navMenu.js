$(function(){
	//��ʼ��
	$('.subMenu').hide();
	$('li.active>.subMenu').show();
	
	//���˵�������¼�
	$('.navMenu div').click(function(){
		//��ȡ�����б�ul
		var $subMenuElement=$(this).next();
		var $liElement=$(this).parent();
		var $ulElement=$(this).parent().parent();
		//û���Ӳ˵�����ֱ�ӷ���
		if(!$subMenuElement.is('ul'))
		{
			$ulElement.find('li').removeClass('active');
			$ulElement.find('ul.subMenu').slideUp();
			$liElement.addClass('active');
			return;
		}
		//��������Ӳ˵�����򿪻��߹ر�
		if(! $liElement.hasClass('active')){
			$ulElement.find('li').removeClass('active');
			$ulElement.find('ul.subMenu').slideUp();
			$liElement.addClass('active');
			$subMenuElement.slideDown();
		}else{
			//��״̬ ��رձ��˵�
			$subMenuElement.slideUp();
			$liElement.removeClass('active');
			
		}
	});
	/*$('#allFile').click(function(){
		
		location.href="${pageContext.request.contextPath}/admin/products/allFileList.jsp";
	});*/
});
