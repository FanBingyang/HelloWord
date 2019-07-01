package HttpServlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

/**
 * Servlet implementation class ServletDemo4
 */
//@WebServlet("/ServletDemo4")
public class ResponseDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����Լ�д�ķ���ʵ����֤��
//		yanzhengma(response);
		
		//���߿ͻ��˲�ʹ�û���
		//���仰�ֱ��Ӧ���ֲ�ͬ�������
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		//�ù��ߴ�����֤��
		//ValidateCode.jar����ʹ��
		ValidateCode vc = new ValidateCode(110,30,4,9);//�ĸ������ֱ���ͼƬ�Ŀ�ȡ��߶ȡ��ı�����������������
		vc.write(response.getOutputStream());
		System.out.println(vc.getCode());//getCode()���������֤ͼƬ�ϵ��ı�����
		
	}

	public void yanzhengma(HttpServletResponse response) throws IOException {
		//���ڴ��д���һ��ͼ��
		int width = 110;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//��������
		Graphics g = img.getGraphics();
		
		//��ͼƬ��ӱ�����ɫ
		g.setColor(Color.pink);//����һ����ɫ
		//�����ɫ
		g.fillRect(1, 1, width-2, height-2);//�ϡ��ҡ��¡���ľ���
		
		//���߿�һ����ɫ
		g.setColor(Color.red);
		g.drawRect(0, 0, width-1, height-1);//��һ�����Σ����ñ߿����ʾ����
		
		//�����ı���ʽ
		g.setColor(Color.BLUE);
		g.setFont(new Font("����",Font.BOLD|Font.ITALIC,15));
		
		
		//��ͼƬ����ı�
		Random rand = new Random();
		int position = 20;
		for(int i=0;i<4;i++)
		{
			//��ͼƬ����ı�
			g.drawString(rand.nextInt(10)+"",position ,20);//��һ���������ı����ڶ�����xֵ����������yֵ
			position+=20;
		}
		
		//���9��������
		for(int i=0;i<9;i++)
		{
			g.drawLine(rand.nextInt(width),rand.nextInt(height) ,rand.nextInt(width),rand.nextInt(height));//�ĸ������ֱ����������ĺ���������յ�ĺ�������
		}
		
		//��ͼƬ���������ķ�ʽ������ͻ���
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
