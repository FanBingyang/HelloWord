package conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 转换日期类型的数据
 * Converter<S, T>
 * S:页面传递过来的类型
 * T:转换后的类型
 * @author FBY
 *
 */
public class DateConveter implements Converter<String,Date>{

	@Override
	//参数是传递过来的资源
	public Date convert(String source) {
		//有可能会转换失败，抛出异常
		try {
			if(source != null){//2019:04-28 22_43-10
				DateFormat df = new SimpleDateFormat("yyyy:MM-dd HH_mm-ss");
				return df.parse(source);
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
