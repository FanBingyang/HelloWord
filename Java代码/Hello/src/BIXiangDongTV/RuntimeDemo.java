package BIXiangDongTV;
/*
 * Runtime����
 * ���ಢû���ṩ���췽����
 * ˵��������new������ô����ֱ���뵽�����еķ������Ǿ�̬�ġ�
 * ���ָ����л��зǾ�̬������
 * ˵������϶����ṩ�˷�����ȡ������󡣶��Ҹ÷����Ǿ�̬ �ģ����ҷ���ֵ�����Ǳ������͡�
 * 
 * ������ص���Կ�������ʹ���˵������ģʽ��ɡ�
 * 
 * �÷����� static getRuntime();
 * 
 * 
 */
import java.io.IOException;

public class RuntimeDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Runtime r = Runtime.getRuntime();//����new����ֱ�ӵ��÷���
		Process p = r.exec("E:\\Tencent\\QQLive\\QQLive.exe");//��·���µ�.exe�ļ�
		Thread.sleep(5000);
		
		p.destroy();//�ս��߳�
	}

}
