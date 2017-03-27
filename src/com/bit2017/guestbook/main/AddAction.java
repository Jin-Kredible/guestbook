package com.bit2017.guestbook.main;

import java.io.*;

import javax.servlet.http.*;

import com.bit2017.guestbook.Action.*;
import com.bit2017.guestbook.util.*;
import com.bit2017.guestbookDao.*;
import com.bit2017.guestbookVo.*;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");

		Guestvo vo = new Guestvo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);

		GuestDao dao = new GuestDao();
		dao.insert(vo);

		try {
			GuestBookUtil.redirect(request.getContextPath() + "/GC", request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
