package BooksExample12;
/*
* Runnable接口的声明入下：
* public interface Runnable
* {
*       publlic abstract void run();
* }
* */

/*功能简介：Runnable接口的使用。声明一个类，实现Runnable接口功能。该类不是线程类*/
public class RunnableUse implements Runnable{
    private int a;
    public RunnableUse(int a){
        this.a=a;
    }
    public void run(){    //实现接口方法
        int i=a;
        System.out.println();
        while (i<200)
        {
            System.out.print(i+" ");
            i+=2;
        }
        System.out.println("结束！");
    }
    public static void main(String args[]){
        RunnableUse odd=new RunnableUse(1);    //创建有线程体的目标对象，而非线程
        Thread t1=new Thread(odd); //以目标对象为对象，通过Thread类的构造方法，创建线程对象
        t1.start();  //启动线程对象
        RunnableUse even=new RunnableUse(2);    //创建有线程体的目标对象，而非线程
        Thread t2=new Thread(even); //以目标对象为对象，通过Thread类的构造方法，创建线程对象
        t2.start();  //启动线程对象
    }
}
