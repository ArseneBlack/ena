package controller;

public class TV {
	private static MainWindowController hauptfenster;
	

	public static void main(String[] args) {
		try {
			hauptfenster = new MainWindowController();
			hauptfenster.showView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
