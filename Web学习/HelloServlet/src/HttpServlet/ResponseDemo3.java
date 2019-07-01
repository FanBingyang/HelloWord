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
		//调用自己写的方法实现验证码
//		yanzhengma(response);
		
		//告诉客户端不使用缓存
		//三句话分别对应三种不同的浏览器
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");
		
		//用工具创建验证码
		//ValidateCode.jar包的使用
		ValidateCode vc = new ValidateCode(110,30,4,9);//四个参数分别是图片的宽度、高度、文本数量、干扰线数量
		vc.write(response.getOutputStream());
		System.out.println(vc.getCode());//getCode()方法获得验证图片上的文本内容
		
	}

	public void yanzhengma(HttpServletResponse response) throws IOException {
		//在内存中创建一个图像
		int width = 110;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建画笔
		Graphics g = img.getGraphics();
		
		//给图片添加背景颜色
		g.setColor(Color.pink);//设置一个颜色
		//填充颜色
		g.fillRect(1, 1, width-2, height-2);//上、右、下、左的距离
		
		//给边框一个颜色
		g.setColor(Color.red);
		g.drawRect(0, 0, width-1, height-1);//画一个矩形，设置边框的显示坐标
		
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		
		
		//给图片添加文本
		Random rand = new Random();
		int position = 20;
		for(int i=0;i<4;i++)
		{
			//给图片填充文本
			g.drawString(rand.nextInt(10)+"",position ,20);//第一个参数是文本，第二个是x值，第三个是y值
			position+=20;
		}
		
		//添加9条干扰线
		for(int i=0;i<9;i++)
		{
			g.drawLine(rand.nextInt(width),rand.nextInt(height) ,rand.nextInt(width),rand.nextInt(height));//四个参数分别是线条起点的横纵坐标和终点的横纵坐标
		}
		
		//将图片对象以流的方式输出到客户端
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
