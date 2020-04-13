package com.book.controller;

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

@WebServlet("/code_img")
public class CodeImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		int w = 60;
		int h = 30;
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		g.setFont(new Font("aa", Font.BOLD, 18));
		Random r = new Random();
		// 声明一个字符串，存储生成的验证码
		String yzm = "";
		for (int i = 0; i < 4; i++) {
			int a = r.nextInt(10);
			int y = 15 + r.nextInt(10);
			Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			g.setColor(c);
			g.drawString("" + a, i * 15, y);
			yzm += a;
		}
		// 把验证码放入session
		request.getSession().setAttribute("yzm", yzm);
		for (int i = 0; i < 10; i++) {
			Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			g.setColor(c);
			g.drawLine(r.nextInt(60), r.nextInt(30), r.nextInt(60), r.nextInt(30));
		}
		g.dispose();
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}
}