package BookExample;
/*
     ���ܼ�飺ͨ��if��Ƕ��ʹ�����ж�ĳ����������ĳ�����ڡ�
 */
public class StatementNestedSeason {
	public static void main(String args[]){
		String season;
		int month=5;
		if(month==3||month==4||month==5)
			season="����";
		else if(month==6||month==7||month==8)
			season="�ļ�";
		else if(month==9||month==10||month==11)
			season="�＾";
		else if(month==12||month==1||month==2)
			season="����";
		else
			season="�Բ�����ѡ���·ݲ���1��~12�£�����һ���ļ���";
		System.out.println(season);
	}

}
