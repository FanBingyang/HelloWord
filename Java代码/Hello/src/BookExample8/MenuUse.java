package BookExample8;
/*���ܼ�飺�߼��������˵���ʹ��*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuUse extends JFrame{
	public MenuUse(){
		super("����˵���ʹ��");
		JMenuBar mBar = new JMenuBar();      //�����˵���(JMenuBar)����
		this.setJMenuBar(mBar);         //��JFrame���������ò˵������󣬼����˵�����ӵ����������
		JMenu[]  m={new JMenu("�ļ�(F)"),new JMenu("�༭(E)")};       //�����˵�����
		char[][] mC={{'F','E'},{'O','S'},{'C','V'}};    //�������Ƿ�������
		JMenuItem[][] mI={{new JMenuItem("��(O)"),new JMenuItem("����(S)")},{new JMenuItem("����(C)"),new JMenuItem("ճ��(V)")}};     //�����˵�ѡ��
		for(int i=0;i<m.length;i++)
		{
			mBar.add(m[i]);          //���˵���ӵ��˵�����
			m[i].setMnemonic(mC[0][i]);   //���ò˵������Ƿ�
			for(int j=0;j<mI[i].length;j++)
			{
				m[i].add(mI[i][j]);      //�ڲ˵�����Ӳ˵���
				mI[i][j].setMnemonic(mC[i+j][j]);     //Ϊ�˵����������Ƿ�
				mI[i][j].setAccelerator(KeyStroke.getKeyStroke("ctrl"+mC[i+1][j]));       //���ò˵���Ŀ�ݼ���һ��˵���ʹ��Ctrl���˵�ʹ��Alt
				mI[i][j].addActionListener(new ActionListener() {       //Ϊ�˵���ע�������      
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JMenuItem mItem=(JMenuItem)e.getSource();
						System.out.println("���в˵���"+mItem.getText());
					}//actionPerformed()��������
				}//ʵ�ֽӿ�ActionListener�������۽���
				);//addActionListener()����
			}//�ڲ�forѭ������
		}//�ⲿforѭ������
		m[0].insertSeparator(1);   //�ڲ˵��������ʽ�˵�֮�����˵��ָ���
	} //���췽������

	public static void main(String[] args) {
		MenuUse app=new MenuUse();
		app.setSize(260, 160);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

}
