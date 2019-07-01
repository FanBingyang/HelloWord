package excption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器的自定义的实现类
 * @author FBY
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{

	/**
	 * HttpServletRequest request：请求对象
	 * HttpServletResponse response：相应对象
	 * Object obj：异常位置，包名+类名+方法名（形参） 字符串
	 * Exception e：异常类型
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		
		
		ModelAndView mav = new ModelAndView();
		//判断异常的类型
		if(e instanceof MessageException){
			//预期异常
			MessageException me = (MessageException)e;
			mav.addObject("error", me.getMsg());
		}else{
			mav.addObject("error", "未知异常");
		}
		//设置视图名称
		mav.setViewName("error");
		return mav;
	}

}
