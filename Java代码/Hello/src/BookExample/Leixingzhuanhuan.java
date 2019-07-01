package BookExample;
/*
     功能简介：使用类型转换将数据类型进行转换。
 */
public class Leixingzhuanhuan {
	public static void main(String args[]){
		int x=100;
		//隐式类型转换
		long y=x;
		System.out.println("类型转换:整型"+x+"转换为长整型"+y);
		double d=1212;
		//显式类型转换，强制类型转换
		int a=(int)d;
		System.out.println("类型转换：double类型"+d+"转换为int类型"+a);
	}

}
