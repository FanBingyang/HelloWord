package BookExample8;
/*功能简介：使用标准对话框*/
import javax.swing.JOptionPane;

public class StandardDialog {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "同桌的你！");
		JOptionPane.showConfirmDialog(null, "你在他乡还好吗？");
		JOptionPane.showInputDialog(null,"你在他乡还好吗？");
		String []s={"好","不好"};
		JOptionPane.showInputDialog(null, "你在他乡还好吗？", "输入", JOptionPane.QUESTION_MESSAGE, null, s,s[0]);
	}

}
