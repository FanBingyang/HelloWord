package BookExample;
import java.util.Random;          //����chinese����ʹ�õ���Random�����У�java.utilΪ������importΪ�ؼ���

/*���ܼ�飺��дһ��chinese�࣬����ʾ��Java����Ļ����ṹ*/

public class Chinese {
	private String name;            //�ڹ淶��Java��������У���Ա����һ������Ϊ˽��Ȩ�ޣ���ô�Ǳ����������ڱ�������
	private String sex;             //sex�Ǳ����������ڱ����Ա�
	Random luckyN=new Random();     //ʵ�����������ڳ�ʼ������luckyN��Random��x�����������������һ��0~x������
	public Chinese(String name,String sex){    //������Ĺ��췽����������ʵ��������ʱ��ʼ����Ա����
		this.name=name;
		this.sex=sex;
	}
	public void setName(String name){   //�淶��java����У�setName(String name)�����������ó�Ա����name��ֵ
		this.name=name;
	}
	public String getName(){            //�淶��Java����У�getName()�������ڻ�ȡ��Ա����name��ֵ
		return name;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}
	public void myInformation(){                       //����Chinese���еĳ�Ա�������÷���ʵ�ֵĹ������������Ļ�����Ϣ
		System.out.println("�ҵ����ֽ�"+getName()+"������һ��"+getSex()+"��!");    //����� + �����ַ���������
	}
	public void chineseDeram(){
		System.out.println("���ǵ��й����ǣ�ʵ���л������ΰ����!");
	}
	public void myDeram(){                             //����Chinese���еĳ�Ա�������÷���ʵ�ֵĹ��������������ʾ��Ϣ
		System.out.println("�ҵ��й����ǣ���Ϊһ������ĳ���Ա��ʵ���Լ����й���!");
	}
	public void luckyNumber(){                         //����Chinese���еĳ�Ա�������÷���ʵ�ֵĹ��������������
		System.out.println(1+luckyN.nextInt(10));
	}
	public static void main(String[] args) {            //�������г����main()����
		Chinese chinese=new Chinese("����","Ů");       //ʵ��������
		chinese.myInformation();                        //������÷�����ִ�й���
		chinese.chineseDeram();
		chinese.myDeram();
		chinese.luckyNumber();
	}

}
