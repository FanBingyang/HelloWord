package BIXiangDongTV;

import java.io.FileReader;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\Java\\Buffer.txt");
		LineNumberReader lnr = new LineNumberReader(fr);
		
		String line = null;
		lnr.setLineNumber(100);//�Զ����кŴ�100��ʼ
		while((line=lnr.readLine())!=null)
		{
			System.out.println(lnr.getLineNumber()+":"+line);//lnr.getLineNumber()���ص�ʱ�кš�
		}
		lnr.close();
	}

}
