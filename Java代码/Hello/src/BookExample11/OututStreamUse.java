package BookExample11;

import java.io.IOException;
import java.io.OutputStream;

/*���ܼ�飺ʹ��OututStream���ڿ���̨�������*/
public class OututStreamUse {
	public OututStreamUse(OutputStream out){
		String s="��ĸ�����ߣ����������¡��������ܷ죬��ֳٳٹ顣˭�Դ���ģ����������͡�";
		byte[] b=s.getBytes();
		try{
			out.write(b);       //���ֽ�����bд������������
			out.flush();        //�ѻ����е���������ˢ��
			out.close();        //�ر������
		}catch(IOException e){
			System.err.println(e);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OututStreamUse(System.out);
	}

}
