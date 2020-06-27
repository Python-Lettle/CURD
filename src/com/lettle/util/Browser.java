package com.lettle.util;

public class Browser {
	
	private Browser() {}
	private static Browser browser = new Browser();
	public static Browser getInstance() {
		return browser;
	}
	
	//---------------------------------------------\\
	
	public void showView(View view) {
		view.show();
	}
	
}
