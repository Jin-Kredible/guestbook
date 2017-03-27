package com.bit2017.guestbook.main;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2017.guestbook.Action.*;
import com.bit2017.guestbookDao.*;
import com.bit2017.guestbookVo.*;

public class ShowAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		
		GuestDao dao = new GuestDao();
		List<Guestvo> list = dao.getList();

		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
