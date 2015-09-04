package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 绘制验证码
 * @author hdoop
 * 1. 设置尺寸、颜色体系，准备空白图片
 * 2. 获取图片画笔对象
 * 3. 设置画笔颜色
 * 4. 绘制背景
 * 5. 更改画笔颜色
 * 6. 绘制内容
 * 7. 保存图片到流中
 */
public class CodeServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1.
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);//颜色由三个整数组成
		//2.
		Graphics g = image.getGraphics();
		//3.
		Random random = new Random();
		g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		//4. 
		g.fillRect(0, 0, 100, 30);
		//5.
		g.setColor(new Color(255,255,255));
		//5.1 设置字体
		g.setFont(new Font(null,Font.BOLD,24));
		//6.
		String number = getNumber(5);
		HttpSession session = request.getSession();
		session.setAttribute("c", number);
		g.drawString(number, 5, 25);
		//7.
		response.setContentType("image/jpeg");//设置响应流的数据格式
		OutputStream out = response.getOutputStream();//由于写出的不再是文本，所以不用PrintWriter
		ImageIO.write(image, "jpeg", out);
		out.close();
	}
	public String getNumber(int size){
		String cs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
		String number = "";
		Random random = new Random();
		for(int i=0;i<size;i++){
			number +=cs.charAt(random.nextInt(cs.length()));
		}
		return number;
	}

}
