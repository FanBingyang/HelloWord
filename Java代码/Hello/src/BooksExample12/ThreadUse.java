package BooksExample12;
/*
* Thread类的声明如下：
* public class Thread extends Object implemennts Runnable
* {
*       public Thread();                            //构造方法
*       public Thread(String name);                 //name指定线程的名字
*       public Thread(Runnable target);             //target指定线程的目标对象
*       public Thread(Runnable target,String name);
*       public void run()                           //描述线程操作的线程体
*       {
*           if(target!=null)
*               target.run();                       //用于执行目标对象的run()方法
*       }
*       public final String getName();              //返回线程名
*       public final void setName(String name);     //设置线程名
*       public static int activeCount();            //返回当前活动线程的个数
*       public static Thread currentThread();       //返回当前执行的线程对象
*       public synchronized void start();           //启动已经创建的线程对象
*       public String toString();                   //返回线程的字符串信息，包括名字、优先级和线程组
* }
* */


/*功能简介：Thread类的使用。通过继承类Thread声明一个多i暗沉那个的类。由于Thread类是线程类，，所以通过继承Thread声明的类
* 也是线程类。该类的功能是通过两个线程分别输奇数和偶数*/
public class ThreadUse extends Thread {
    private String name;//线程名字
    private int a;//输出序列的初始值
    public ThreadUse(String name,int a){
        super(name);
        this.a=a;
    }
    public ThreadUse(String name){
        this(name,0);   //调用当前对象
    }
    public void run(){   //覆盖父类Thread类的线成体run()方法
        int i=a;
        //获取线程的名称并输出到控制台
        System.out.print("\n"+this.getName()+":");
        while (i<200) //通过while语句把数字输出后再自增2
        {
            System.out.print(i+" ");
            i+=2;
        }
        System.out.println(this.getName()+"结束!");
    }
    public static void main(String args[]){
        ThreadUse t1=new ThreadUse("奇数线程",1);       //创建线程对象
        ThreadUse t2=new ThreadUse("偶数线程",2);
        t1.start();     //启动线程
        t2.start();
        //t2.setPriority(10);   //设置t2的优先级为10
    }

}
