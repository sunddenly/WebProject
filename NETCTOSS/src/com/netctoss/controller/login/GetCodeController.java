package com.netctoss.controller.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class GetCodeController {
	@RequestMapping("/getCode/{time}")
	public void execute(HttpServletResponse response,HttpSession sessioin) throws IOException{
		BufferedImage image = new BufferedImage(100, 30, BufferedImage.TYPE_INT_RGB);//��ɫ�������������
		
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
		g.fillRect(0, 0, 100, 30);
		
		g.setColor(new Color(255,255,255));
		g.setFont(new Font(null,Font.BOLD,24));
		String number = getNumber(5);
		sessioin.setAttribute("scode", number);//��ͼƬ��Ϣ����session
		g.drawString(number, 5, 25);
		
		response.setContentType("image/jpeg");//������Ӧ�������ݸ�ʽ
		OutputStream out = response.getOutputStream();//����д���Ĳ������ı������Բ���PrintWriter
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
