package BookExample7;

public class ExceptionTest {
	public static void main(String[] args) {
		int x=16;
		int y=0;
		int z[]={1,2,3,4,5,6,7,8,9,10};
		try{
			System.out.println("x="+x);
			System.out.println("y="+y);
			System.out.println("x/y="+x/y);
		}
		catch(ArithmeticException e){
			System.out.println("����Ϊ���쳣"+e.getMessage());
		}
		for(int i=0;i<z.length;i++){
			try{
				System.out.print("z["+i+"]/"+i+"="+(z[i]/i+1));
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.print("���������±�Խ���쳣��"+e.getMessage());
			}
			catch(ArithmeticException e){
				System.out.print("���������쳣��"+e.getMessage());
			}
			catch(Exception e){
				System.out.print("����"+e.getMessage()+"�쳣��");
			}
			finally{
				System.out.println("i="+i);
			}
		}
		
	}

}
