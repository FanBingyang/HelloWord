package File;

import java.util.ResourceBundle;

//dao����
public class FileDaoFactory {
    private FileDaoFactory(){};//���ܹ���
    private static FileDaoFactory factory = new FileDaoFactory();

    //��ȡ����ʵ��
    public static FileDaoFactory getInstance(){
        return factory;
    }

    //���ڷ��ش�������һ�����ʵ������
    /**
     * 1��������FileDao.class
     * 2����ȡdao.properties�ļ�����ȡFileDao��Ӧ��ʵ����
     * 3��FieldDao��Ӧ��ʵ����ʵ��
     */
    public<T> T createDao(Class<T> t){
        //1��FileDao.class-->FileDao
        String simpleName = t.getSimpleName();
        //2����ȡ�����ļ�����ȡFileDao��Ӧ��ʵ����
        //FileDao = file.daoImpl.FileDaoImpl
        String calzzName = ResourceBundle.getBundle("dao").getString(simpleName);
        try {
            //3��FileDao��Ӧ��ʵ����ʵ��
            T instance=(T)Class.forName(calzzName).newInstance();
            return instance;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
