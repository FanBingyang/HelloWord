package ShiYan_1;

public class JvXingTest {
	public static void main(String args[]){
		JvXing j=new JvXing();
		j.setChang(10);
		j.setWide(5.5);
		System.out.println("矩形的周长为："+j.zhouchang()+"  矩形面积为："+j.mianji(j.getChang(),j.getWide()));
	}

}
