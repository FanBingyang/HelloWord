package BooksExample12;

public class CriticalSection1 {
    public int a;
    public CriticalSection1(){
        a=20;
    }
    public synchronized void action(String name){
        System.out.println(name+":抢到了"+a+"号票！");
        a--;
    }

}
