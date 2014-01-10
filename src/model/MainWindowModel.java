package model;

public class MainWindowModel {	
	private ElectronicsModel electronics = ElectronicsModel.getInstance();

	public int currentVolume() {
		return electronics.getVolume();
	}

	public void setVolume(int volume) throws Exception {
		electronics.setVolume(volume);
	}
}
