package com.bit2017.guestbook.main;

import com.bit2017.guestbook.Action.*;

public class ListActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {

		Action action = null;

		if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("add".equals(actionName)) {
			action = new AddAction();
		} else {
			action = new IndexAction();
		}
		return action;
	}
}
