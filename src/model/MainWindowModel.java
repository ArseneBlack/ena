package model;

public class MainWindowModel {

	private TvElectronics electronics;
	private int volume;

	public int currentVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
}
