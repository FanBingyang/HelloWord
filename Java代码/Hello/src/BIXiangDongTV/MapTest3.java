package BIXiangDongTV;

import java.util.HashMap;
import java.util.Iterator;
/*
Map������չ��
	���ϵ�Ƕ��ʹ�á�
 
*/
public class MapTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,HashMap<String,String>>  rjgc = new HashMap<String, HashMap<String,String>>();
		
		HashMap<String,String> yi = new HashMap<String,String>();
		HashMap<String,String> er = new HashMap<String,String>();
		
		rjgc.put("yiban", yi);
		rjgc.put("erban", er);
		
		yi.put("01","zhangsan");
		yi.put("02","lisi");
		
		er.put("01","zhaoliu");
		er.put("02","wangwu");
		
		
		//����rjgc���ϣ���ȡ���еĽ���
		Iterator<String> it = rjgc.keySet().iterator();
		
		while(it.hasNext())
		{
			String roomName = it.next();
			HashMap<String,String> room = rjgc.get(roomName);
			System.out.println(roomName);
			getStudentInfo(room);
		}
		
		
//		getStudentInfo(yi);//���ָ���༶��ѧ��
//		getStudentInfo(er);
		
	}
	
	public static void getStudentInfo(HashMap<String,String> roomMap){
		Iterator<String> it = roomMap.keySet().iterator();
		while(it.hasNext())
		{
			String id = it.next();
			String name = roomMap.get(id);
			System.out.println(id+":"+name);
		}
	}

}
