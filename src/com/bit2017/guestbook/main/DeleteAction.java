package com.bit2017.guestbook.main;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2017.guestbook.Action.*;
import com.bit2017.guestbook.util.*;

public class DeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			GuestBookUtil.forward("/WEB-INF/views/deleteform.jsp", request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
