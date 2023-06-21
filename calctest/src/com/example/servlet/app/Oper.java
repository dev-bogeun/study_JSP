package com.example.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.servlet.app.Calc;

public class Oper extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calc calc = new Calc();
		int numbers = calc.num(req.getParameter("number"));
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();	
		out.print("<h1>" + numbers + "</h1>");
		out.print("<a href='calc-jsp'>정보 다시 입력</a>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
