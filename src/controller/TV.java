package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TV {
	private static MainWindowController mainWindow;

	public static void main(String[] args) {
		try {
			mainWindow = new MainWindowController();
			mainWindow.showView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
