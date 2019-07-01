package BooksExample12;
/*功能简介：Timer类和TimerTask类的使用*/
import java.util.Timer;
import java.util.TimerTask;

public class TimerTimerTaskUse extends TimerTask {
    private int a;
    public TimerTimerTaskUse(int a){
        this.a=a;
    }
    @Override
    public void run() {
        int i=a;
        while (i<200)
        {
            System.out.print(i+" ");
            i+=2;
        }
        System.out.println("结束！");
    }
    public static void main(String ars[]){
        Timer t=new Timer();//创建Timer对象，用于启动线程
        TimerTimerTaskUse tu=new TimerTimerTaskUse(2);//创建TimerTask类的子类对象
        t.schedule(tu,0);
        /*Timer对象启动线程，方法是t.schedule(tu,0)，0表示立刻启动，如果把0改成1000，表示1000ms以后启动线程*/
    }
}
