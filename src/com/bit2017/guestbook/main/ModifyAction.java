package com.bit2017.guestbook.main;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2017.guestbook.Action.*;
import com.bit2017.guestbook.util.*;
import com.bit2017.guestbookDao.*;
import com.bit2017.guestbookVo.*;

public class ModifyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		GuestDao dao = new GuestDao();
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		Long noNum = Long.parseLong(no);
		
		dao.modify(noNum, password);
		
		try {
			GuestBookUtil.redirect(request.getContextPath() + "/GC", request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
