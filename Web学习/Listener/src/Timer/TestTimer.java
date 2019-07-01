package Timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static void main(String[] args) {
		//创建一个计时器对象
		Timer t = new Timer();
		
		//调度任务
		t.schedule(new TimerTask() {//要执行的任务

			@Override
			public void run() {
				System.out.println(new Date().toLocaleString());
			}
			
		}, 2000,1000);//延迟2s执行，1s执行一次
		
	}
}
