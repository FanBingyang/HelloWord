package BookHistory;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
	private static Map<String,Book> books = new HashMap();
	
	static {
		books.put("1",new Book("1", "Java�������", 90, "��־��"));
		books.put("2",new Book("2", "JSP�������", 80, "��贾�"));
		books.put("3",new Book("3", "Python", 70, "�����ʵ�"));
		books.put("4",new Book("4", "��ƿ÷", 60, "������"));
		
	}
	
	//�õ�������
	public static Map<String,Book> findAllBooks(){
		return books;
	}

	//����id����ָ������
	public static Book findBookById(String id) {
		return books.get(id);
	}
	
	
	
	
	
}
