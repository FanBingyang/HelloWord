package ShiYan_1;

public class JvXingTest {
	public static void main(String args[]){
		JvXing j=new JvXing();
		j.setChang(10);
		j.setWide(5.5);
		System.out.println("���ε��ܳ�Ϊ��"+j.zhouchang()+"  �������Ϊ��"+j.mianji(j.getChang(),j.getWide()));
	}

}
