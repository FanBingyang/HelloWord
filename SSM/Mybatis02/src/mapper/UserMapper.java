package mapper;

import java.util.List;

import pojo.QueryVo;
import pojo.User;

public interface UserMapper {
		//��ѭ�ĸ�ԭ��
		//�ӿ� ������  == User.xml �� id ��
		//����ֵ����  ��  Mapper.xml�ļ��з���ֵ����Ҫһ��
		//������������� ��Mapper.xml����ε�����Ҫһ��
		//�����ռ� �󶨴˽ӿ�
		public User findUserById(Integer id);
		
		public List<User> findUserByQueryVo(QueryVo vo);
		
		//��ѯ��������
		public Integer countUser();
		
//		�����Ա�����ֲ�ѯ�û�
		public List<User> selectUserBySexAndUsername(User user);
		//���ݶ��id��ѯ�û���Ϣ  
//		public List<User> selectUserByIds(Integer[] ids); xml��������� array
		public List<User> selectUserByIds(List<Integer> ids); // xml��������� list
//		public List<User> selectUserByIds(QueryVo vo); //����������
}
