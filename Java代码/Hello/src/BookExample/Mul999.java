package BookExample;
/*ʹ��for���Ķ���ѭ����ѭ�����������ѭ����䣬��Ϊ����ѭ��������žų˷���*/
public class Mul999 {
	public static void main(String args[]){
		int i;
		int j;
		int n=9;
		System.out.print("   *   |");              //���"*    "
		for(i=1;i<=n;i++)                          //���������1��
			System.out.print("   "+i);             //���1����~9������һ������
		System.out.print("\n-------|");            //���"-------|"
		for(i=1;i<n;i++)                           //�������"-----"
			System.out.print("-----");
		System.out.println();
		for(i=1;i<=n;i++){                         //���ƾŴ�ѭ��
			System.out.print("   "+i+"   |");      //���ÿ�е���������һ������
			for(j=1;j<=i;j++)                      //����˻���
				System.out.print("   "+i*j);       //��������ĳ���˻�
			System.out.println();
		}
	}

}
