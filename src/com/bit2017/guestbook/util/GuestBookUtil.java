package com.bit2017.guestbook.util;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class GuestBookUtil {
	
	public static void forward(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect(url);
	}
	
	
}
