package service;

public class UserServiceImpl implements UserService{

	@Override
	public void save() {
		System.out.println("�����û���");
	}

	@Override
	public void delete() {
		System.out.println("ɾ���û���");
	}

	@Override
	public void update() {
		System.out.println("�޸��û���");
	}

	@Override
	public void find() {
		System.out.println("�����û���");
	}

}
