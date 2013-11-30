package model;

import java.util.HashMap;
import java.util.Map;

public class SettingsModel {
	public SettingsModel() {
		loadSettings();
	}
	
	private void loadSettings() {
		channelList.put(1, "ARD");
		channelList.put(2, "ZDF");
		channelList.put(3, "hr");
		volume = 50;
		channel = 1;
	}
	
	public void saveSettings() {
		
	}
	
	private Map<Integer, String> channelList = new HashMap<Integer, String>();

	private int volume;

	private int channel;
}
