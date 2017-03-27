package com.bit2017.guestbookController;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.*;

import com.bit2017.guestbook.Action.*;
import com.bit2017.guestbook.main.*;
import com.bit2017.guestbook.util.*;
import com.bit2017.guestbookDao.*;
import com.bit2017.guestbookVo.*;

@WebServlet("/GC")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String viewPage = request.getParameter("a");
		
		Action action = new ListActionFactory().getAction(viewPage);
		action.execute(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
