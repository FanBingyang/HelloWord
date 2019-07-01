package BooksExample12;
/*Java提供了10个等级的线程优先级，分别用1~10表示，优先级最低为1，最高为10，默认值为5.
*
* Thread类中声明了3个表示优先级的公有静态变量：
* （1) public static final int MIN_PRIORITY=1;     //最低优先级
* （2) public static final int NORM_PRIORITY=5;    //默认优先级
* （3) public static final int MAX_PRIORITY=10;    //最高优先级
*
* Thread类中与线程优先级有关的方法有以下2个：
* （1) public final int getPriority();       //获得线程优先级
* （2) public final void setPriority(int newPriority);    //设置线程优先级*/

/*功能简介：线程优先级的使用*/
public class PriorityUse extends Thread{
    public PriorityUse(String name, int i){
        setName(name);
        setPriority(i);
    }
    public void run(){
        //通过for循环输出线程的名字和级别，每次循环间隔是3000ms
        for (int i=0;i<6;i++){
            System.out.println("线程名字："+getName()+"线程优先级："+getPriority());
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        PriorityUse t1=new PriorityUse("线程 1",9);
        t1.start();
        PriorityUse t2=new PriorityUse("线程 2",6);
        t2.start();
        PriorityUse t3=new PriorityUse("线程 3",7);
        t3.start();
    }
}
