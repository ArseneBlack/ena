package model;

public class MainWindowModel {	
	private PersistentData data = PersistentData.getInstance();

	public int currentVolume() {
		return data.getVolume();
	}

	public void setVolume(int volume) throws Exception {
		data.setVolume(volume);
	}
}
