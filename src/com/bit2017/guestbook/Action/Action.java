package com.bit2017.guestbook.Action;

import javax.servlet.http.*;

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
