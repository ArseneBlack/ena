package model;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.MainWindowView;
import view.PicturePanel;

public class TV {
	private static MainWindowView mainWindowView;
	private static ElectronicsModel electronicsModel;
	private static JPanel mainDisplay;
	private static JPanel pipDisplay;

	public static void main(String[] args) {
		try {
			mainDisplay = new PicturePanel("./src/view/16_9.jpg");
			pipDisplay = new PicturePanel("./src/view/16_9.jpg");
			electronicsModel = ElectronicsModel.createInstance(mainDisplay,
					pipDisplay);
			mainWindowView = new MainWindowView(electronicsModel);
			mainWindowView.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
