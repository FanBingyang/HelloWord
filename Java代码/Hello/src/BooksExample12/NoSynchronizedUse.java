package BooksExample12;

import java.sql.SQLOutput;

public class NoSynchronizedUse extends Thread{
    String name;    //用户姓名
    CriticalSection cs;  //使用CriticalSection类生成一个对象
    public NoSynchronizedUse(String name,CriticalSection cs){
        this.name =name;
        this.cs=cs;
        start();
    }
    public void run(){
        try{
            for (int i=0;i<10;i++){
                System.out.println(name+"：抢到了"+cs.a+"号票！");
                cs.a--;
                Thread.sleep(30);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CriticalSection cs=new CriticalSection();
        NoSynchronizedUse ns1=new NoSynchronizedUse("张三",cs);
        NoSynchronizedUse ns2=new NoSynchronizedUse("李四",cs);
    }
}
