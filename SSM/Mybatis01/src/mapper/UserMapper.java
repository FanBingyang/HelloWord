package mapper;

import pojo.User;

public interface UserMapper {
		//��ѭ�ĸ�ԭ��
		//�ӿ� ������  == User.xml �� id ��
		//����ֵ����  ��  Mapper.xml�ļ��з���ֵ����Ҫһ��
		//������������� ��Mapper.xml����ε�����Ҫһ��
		//�����ռ� �󶨴˽ӿ�
		public User findUserById(Integer id);
}
