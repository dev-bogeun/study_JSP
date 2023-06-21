package com.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.member.controller.JoinOkController;

public class MemberFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;
		
		if(target.equals("joinOk")) {
			result = new Result();
			result.setPath("tamplates/member/join.jsp");
			
		}else if(target.equals("joinOk")) {
			result = new JoinOkController().execute(req,resp);
			
		}else if(target.equals("login")) {
			result = new Result();
			result.setPath("tamplates/member/login.jsp");
		}else if(target.equals("loginOk")) {
			result = new JoinOkController().execute(req,resp);
		}else if(target.equals("logout")) {
			result = new Result();
			result.setPath("tamplates/member/login.jsp");
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}