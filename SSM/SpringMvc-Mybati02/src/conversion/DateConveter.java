package conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * ת���������͵�����
 * Converter<S, T>
 * S:ҳ�洫�ݹ���������
 * T:ת���������
 * @author FBY
 *
 */
public class DateConveter implements Converter<String,Date>{

	@Override
	//�����Ǵ��ݹ�������Դ
	public Date convert(String source) {
		//�п��ܻ�ת��ʧ�ܣ��׳��쳣
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
