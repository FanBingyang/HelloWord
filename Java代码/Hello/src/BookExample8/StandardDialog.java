package BookExample8;
/*���ܼ�飺ʹ�ñ�׼�Ի���*/
import javax.swing.JOptionPane;

public class StandardDialog {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "ͬ�����㣡");
		JOptionPane.showConfirmDialog(null, "�������绹����");
		JOptionPane.showInputDialog(null,"�������绹����");
		String []s={"��","����"};
		JOptionPane.showInputDialog(null, "�������绹����", "����", JOptionPane.QUESTION_MESSAGE, null, s,s[0]);
	}

}
