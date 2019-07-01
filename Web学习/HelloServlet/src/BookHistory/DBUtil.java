package BookHistory;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {
	private static Map<String,Book> books = new HashMap();
	
	static {
		books.put("1",new Book("1", "Java程序设计", 90, "张志峰"));
		books.put("2",new Book("2", "JSP程序设计", 80, "邓璐娟"));
		books.put("3",new Book("3", "Python", 70, "人民邮电"));
		books.put("4",new Book("4", "金瓶梅", 60, "王瑞鑫"));
		
	}
	
	//得到所有书
	public static Map<String,Book> findAllBooks(){
		return books;
	}

	//根据id查找指定的书
	public static Book findBookById(String id) {
		return books.get(id);
	}
	
	
	
	
	
}
