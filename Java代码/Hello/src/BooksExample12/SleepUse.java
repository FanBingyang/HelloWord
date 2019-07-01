package BooksExample12;

import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*功能简介：sleep()方法的使用。开发一个简单的电子时钟，在图形用户界面实时显示时间*/
public class SleepUse {
    public SleepUse(){
        JFrame app=new JFrame("电子时钟");
        Container c=app.getContentPane();
        JLabel clock=new JLabel("电子时钟");
        clock.setHorizontalAlignment(JLabel.CENTER);        //设置标签水平对齐方式
        c.setLayout(new BorderLayout());
        c.add(clock,BorderLayout.CENTER);
        app.setSize(160,80);
        app.setLocation(600,300);
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread t=new MyThread(clock);
        t.start();
    }
    class MyThread extends Thread{
        private JLabel clock;
        public MyThread(JLabel clock){
            this.clock=clock;
        }
        public void run(){
            while (true){
                clock.setText(this.getTime());
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }

    public String getTime(){
        Calendar cl=new GregorianCalendar();
        String time=cl.get(Calendar.YEAR)+"-"+(cl.get(Calendar.MONTH)+1)+"-"+cl.get(Calendar.DATE)+" ";
        int h=cl.get(Calendar.HOUR_OF_DAY);
        int m=cl.get(Calendar.MINUTE);
        int s=cl.get(Calendar.SECOND);
        time+=h+":"+m+":"+s;
        return time;
    }
}
    public static void main(String[] args) {
        new SleepUse();
    }
}
