package model;

import javax.swing.DefaultListModel;

public class PersistentData {
	private DefaultListModel channelList;
	private int volume;
	
	// Singleton
	private static PersistentData instance = null;
	private PersistentData() {
		load();
	};
	public static PersistentData getInstance() {
		if (instance == null) {
			instance = new PersistentData();
		}
		
		return instance;
	}
	
	public void load() {
	}
	
	public void save() {
	
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}
}
