package BookExample7;
/*���ܼ�飺ʹ��try-catch-finally�����г�����һ������*/

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
				System.out.print("��������С��Խ���쳣��");
			}
			catch (ArithmeticException e)
			{
				System.out.print("���������쳣��");
			}
			catch (Exception e)
			{
				System.out.print("����"+e.getMessage()+"�쳣��");  //e.getMessage()���þ�����쳣����
			}
			finally
			{
				System.out.println("i="+i);
			}
		}
	}

}
