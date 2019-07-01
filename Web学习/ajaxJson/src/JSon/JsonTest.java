package JSon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.itheima.domain.Book;
import com.itheima.util.C3P0Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonTest {

	@Test //使用JSONObject封装对象类型数据
	public void test1() {
		Book b = new Book();
		b.setId("1001");
		b.setName("xyj");
		b.setPrice(20);
		
		
		String s = JSONObject.fromObject(b).toString();
		System.out.println(s);
		
	}
	
	@Test //使用JSONAray封装List<Book>对象数据
	public void test2() {
		List<Book> list = new ArrayList<Book>();
		Book b1 = new Book();
		b1.setId("1001");
		b1.setName("aaa");
		b1.setPrice(10);
		
		Book b2 = new Book();
		b2.setId("1002");
		b2.setName("bbb");
		b2.setPrice(20);
		
		Book b3 = new Book();
		b3.setId("1002");
		b3.setName("ccc");
		b3.setPrice(30);
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		String s = JSONArray.fromObject(list).toString();
		System.out.println(s);
		
	}
	
	@Test //使用JSONConfig去除不要的字段数据
	public void test3() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Book> list = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(new String[] {"pnum","description","category","id"});
		
		String s = JSONArray.fromObject(list,jc).toString();
		System.out.println(s);
	}
	
}
