package BookExample;

public class StaticTest {
	public static String toChar(double x){   //������̬����
		return Double.toString(x);  //����Double���toString������̬�������书�ܾ��ǽ�Double���͵Ĳ���ֵת��ΪString���Ͳ�����
	}
	public static void main(String[] args) {  //main���������Ǿ�̬��������̬��������ʵ��������Ϳ���ֱ��ʹ��
		System.out.println(Math.round(6.5));  //����Math���round������̬�������书�ܾ��ǶԲ���ֵ�����������봦����������Ľ������
		String s=toChar(12.6);   //������StaticTest���ж����toChar������̬����
		System.out.println("e="+s);
	}
}
