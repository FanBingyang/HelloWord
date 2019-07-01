package BooksExample12;
/*功能简介：线程同步的使用*/
public class SynchronizedUse extends Thread{
        String name;    //用户姓名
        CriticalSection1 cs1;  //使用CriticalSection类生成一个对象
        public SynchronizedUse(String name,CriticalSection1 cs1){
            this.name =name;
            this.cs1=cs1;
            start();
        }
        public void run(){
            try{
                for (int i=0;i<10;i++){
                    cs1.action(name);
                    Thread.sleep(30);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

        public static void main(String[] args) {
            CriticalSection1 cs1=new CriticalSection1();
            SynchronizedUse ns1=new SynchronizedUse("张三",cs1);
            SynchronizedUse ns2=new SynchronizedUse("李四",cs1);
        }
}

