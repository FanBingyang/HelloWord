package mapper;

import java.util.List;

import pojo.Orders;
import pojo.User;

public interface OrderMapper {

	//��ѯ������order����������
	public List<Orders> selectOrdersList();
	
	//һ��һ������ѯ���Զ���Ϊ���ģ������û�
	public List<Orders> selectOrders();
	
	//һ�Զ����
	public List<User> selectUserList();
}
