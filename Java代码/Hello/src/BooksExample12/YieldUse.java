package BooksExample12;
/*执行yield()方法，可以暂停当前线程的执行，将CPU资源让出来，允许其他线程执行，但该线程仍然处于可运行
* 状态，不切换为阻塞状态。这时，系统可以选择其他同优先级线程执行，若无其他同优先级的线程，则选中该线程
* 继续执行。*/
import java.util.Date;

/*功能简介：yield()方法的使用*/
public class YieldUse extends Thread{
    private String name;
    private boolean b;
    public YieldUse(String name,boolean b){
        this.setName(name);
        this.b=b;
    }
    public void run(){
        long start=new Date().getTime();
        /*使用for循环语句是为了延长线程的执行时间，否则3个线程会在一个cpu时间片内迅速执行完。
        * 使用两个for语句进行双重循环延长执行时间后可以观察到：在执行该程序时，若调用了yield()
        * 方法，要等待同优先级的线程执行完后该线程才执行，所以该线程执行的时间会长一些*/
        for (int i=0;i<6000;i++){
            if(b)
                Thread.yield();
            for (int j=0;j<10000;j++){
                 ;
            }
        }
        long end=new Date().getTime();
        System.out.println("\n"+this.getName()+" "+"执行时间"+(end-start)+"毫秒");
    }

    public static void main(String[] args) {
        YieldUse t1=new YieldUse("线程1",false);
        YieldUse t2=new YieldUse("线程2",true);
        YieldUse t3=new YieldUse("线程3",false);
        t1.start();
        t2.start();
        t3.start();
    }
}
