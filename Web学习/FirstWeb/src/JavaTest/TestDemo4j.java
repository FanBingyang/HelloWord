package JavaTest;

import java.util.List;

import javax.xml.soap.Node;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class TestDemo4j {
	
	@Test//1���õ�Ī�����Ľڵ����ݣ��ڶ����������
	public void test1() throws DocumentException{
		SAXReader reader = new SAXReader();//����һ��xml��������
		Document document = reader.read("src/Boolk.xml");//��xml�ĵ����ص�document����
		Element root = document.getRootElement();
//		Element bookNode = root.element("��");
//		System.out.println(bookNode.getName());
		
		List list = root.elements();//�õ���ǰ�ڵ�������ӽڵ�
		Element secondBook = (Element)list.get(1);//�õ��ڶ�����Ķ���
		String name = secondBook.element("����").getText();//�õ���ǰ�ڵ�ĵ��ı�����
		System.out.println(name);
		
		
	}
	
	
	@Test // 2����������Ԫ�ؽڵ�
	public void test2() throws DocumentException{
		SAXReader reader = new SAXReader();//����һ��xml��������
	     Document document = reader.read("src/Book.xml");//��xml�ĵ����ص�document������
	     Element root = document.getRootElement();
	     treeWalk(root);
	}

	private void treeWalk(Element ele) {
		System.out.println(ele.getName());//�����ǰ�ڵ������
		for (int i = 0; i < ele.nodeCount(); i++) {//ele.nodeCount()�õ���ǰ�ڵ�������ӽڵ������
//			Node node = ele.node(i);//ȡ���±�Ϊi�Ľڵ� 
//			if(node instanceof Element){//�жϵ�ǰ�ڵ��Ƿ�Ϊ��ǩ
//				treeWalk((Element)node);//��nodeǿתΪ��ǩ(Element)
//			}else{
//				System.out.println(node.getText());
//			}
		}
	}


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
