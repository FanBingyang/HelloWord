package BookExample8;
/*���ܼ�飺�ı��༭���Ǹ���������ʹ��*/
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TextEditBox extends JFrame{
	public TextEditBox(){
		super("�ı��༭���ʹ��");
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		/*JTextField��Ĺ��췽��JTextField(String text,int columns)�У�text�����ǳ�ʼ�ı���Ϣ��columnsָ��
		 * �ı��༭��Ŀ�ȡ�JPasswordField��Ĺ��췽����JTextField��Ĺ��췽������*/
		JTextField[] t={new JTextField("�û�����",6),new JTextField("�������û�����",16),new JTextField("��  �룺",6),new JPasswordField("123456",16)};
		/*JTextField���setEditable(boolean b)�������������ı��༭���Ƿ���Ա༭��bΪtrueʱ�ɱ༭�������ܱ༭��
		 * ���ܱ༭ʱ��Ч�����Ʊ�ǩ�����⣬getText()�������ڻ�ȡ�ı���Ϣ��setText()���������ı���Ϣ*/
		t[0].setEditable(false);
		t[2].setEditable(false);
		for(int i=0;i<4;i++)   //ͨ��ѭ�����ı�����ӵ�������
			c.add(t[i]);
	}
		
	public static void main(String[] args) {
		TextEditBox app=new TextEditBox();
		app.setSize(300, 160);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
