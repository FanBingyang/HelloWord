package Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static void main(String[] args) {
		//����һ����ʱ������
		Timer t = new Timer();
		
		//��������
		t.schedule(new TimerTask() {//Ҫִ�е�����

			@Override
			public void run() {
				System.out.println(new Date().toLocaleString());
			}
			
		}, 2000,1000);//�ӳ�2sִ�У�1sִ��һ��
		
	}
}
