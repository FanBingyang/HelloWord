package BookExample;
/*
         ���ܼ�飺��������ʾ�ָ�����ʹ�á���������һ�����飬Ȼ��ͨ��for���������ֵȡ������ӣ���������������
 */
public class Separator {
	public static void main(String args[]){
		int i,sum=0;      //�������ͱ���i��sum����ʼ��
		int a[]={1,2,3,4,5};     //�����������鲢��ʼ��
		for(i=0;i<a.length;i++)  //ѭ���������ʵ���������
		{
			sum+=a[i];           //�������鲢������
		}     //for������
		System.out.println("�ۼ�֮�͵���"+sum);
	}        //main������������

}   //��Separator����
