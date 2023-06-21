package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.MemberDAO;
import com.app.Result;

public class LoginOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
		MemberDAO memberDAO = new MemberDAO();
		Long memberId = memberDAO.login(req.getParameter("memberIdentification"), req.getParameter("memberPassword"));
		HttpSession session = req.getSession();
		Result result = new Result();
		
		result.setRedirect(true);
		
		if(memberId == null) {
//			로그인 실패
			result.setPath(req.getContextPath() + "/login.member?login=false");
		}else {
//			로그인 성공
			session.setAttribute("memberId", memberId);
			result.setPath(req.getContextPath() + "/list.board");
		}
		return result;
	}

}
