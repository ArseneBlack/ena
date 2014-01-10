package model;

import view.MainWindowView;

public class TV {
	private static MainWindowView mainWindowView;

	public static void main(String[] args) {
		try {
			mainWindowView = new MainWindowView();
			mainWindowView.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
