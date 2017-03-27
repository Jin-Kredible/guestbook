package com.bit2017.guestbook.main;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2017.guestbook.Action.*;
import com.bit2017.guestbook.util.*;
import com.bit2017.guestbookDao.*;
import com.bit2017.guestbookVo.*;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		GuestDao dao = new GuestDao();
		List<Guestvo> list = dao.getList();

		request.setAttribute("list", list);
		try {
			GuestBookUtil.forward("/WEB-INF/views/index.jsp", request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
