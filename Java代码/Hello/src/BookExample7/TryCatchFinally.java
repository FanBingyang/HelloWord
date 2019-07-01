package BookExample7;
/*功能简介：使用try-catch-finally语句进行常见的一场处理*/

public class TryCatchFinally {

	public static void main(String[] args) {
		int i=0;
		int a[]={1,2,3,4,5,6,7,8,9,10};
		for(i=0;i<11;i++){
			try 
			{
				System.out.print("a["+i+"]/"+i+"="+(a[i]/i));
			} 
			catch (ArrayIndexOutOfBoundsException e) 
			{
				System.out.print("捕获到数组小标越界异常！");
			}
			catch (ArithmeticException e)
			{
				System.out.print("捕获到算数异常！");
			}
			catch (Exception e)
			{
				System.out.print("捕获到"+e.getMessage()+"异常！");  //e.getMessage()会获得具体的异常名称
			}
			finally
			{
				System.out.println("i="+i);
			}
		}
	}

}
