package model;

import java.util.HashMap;
import java.util.Map;

public class EinstellungenModel {
	public EinstellungenModel() {
		loadSettings();
	}
	
	public int currentVolume() {
		return this.volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	

	private void loadSettings() {
		
	}
	
	public void saveSettings() {
		
	}
	
	private Map<Integer, String> channelList;

	private int volume;

	private int channel;
}
