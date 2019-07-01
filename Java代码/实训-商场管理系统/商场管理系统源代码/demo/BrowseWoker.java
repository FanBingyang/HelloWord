package demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BrowseWoker extends JPanel{
	private Object data[][];  //���
	private String [] colname={"����","����","�Ա�","����","����","ְ��","�绰","��н","סַ","ע��ʱ��"};    //�߿�
	//��ʾ�����
	public BrowseWoker(){
		data=this.loadData();  //�������淽��
		JTable table=new JTable(data,colname);    //��  Ŀ����ʾ�߿�ͱ��
		JScrollPane Jsp=new JScrollPane(table); //���
		this.add(Jsp,BorderLayout.CENTER);        //��岼��
		this.setBounds(0,0,785,580);       //���λ�úʹ�С
		Jsp.setPreferredSize(new Dimension(780,580));
	}
	private Object[][] loadData() {
		try{
			Class.forName("com.mysql.jdbc.Driver");  //����
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shangchang?useUnicode=true&characterEncoding=utf8","root","admin");
			java.sql.Statement stmt=conn.createStatement();
			String sql="select * from employee";   //���ñ�
			ResultSet rs=stmt.executeQuery(sql);
            rs.last();
            int n=rs.getRow();
			data=new Object[n][11];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				data[i][0]=rs.getString(1);
				data[i][1]=rs.getString(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getString(4);
				data[i][4]=rs.getString(5);
				data[i][5]=rs.getString(6);
				data[i][6]=rs.getString(7);
				data[i][7]=rs.getString(8);
				data[i][8]=rs.getString(9);
				data[i][9]=rs.getString(10);
				i++;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}
}
