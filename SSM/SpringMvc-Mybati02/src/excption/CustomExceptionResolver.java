package excption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * �쳣���������Զ����ʵ����
 * @author FBY
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/**
	 * HttpServletRequest request���������
	 * HttpServletResponse response����Ӧ����
	 * Object obj���쳣λ�ã�����+����+���������βΣ� �ַ���
	 * Exception e���쳣����
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		
		
		ModelAndView mav = new ModelAndView();
		//�ж��쳣������
		if(e instanceof MessageException){
			//Ԥ���쳣
			MessageException me = (MessageException)e;
			mav.addObject("error", me.getMsg());
		}else{
			mav.addObject("error", "δ֪�쳣");
		}
		//������ͼ����
		mav.setViewName("error");
		return mav;
	}

}
