package model;

import java.io.Serializable;
import java.util.Map;

public class PersistentData implements Serializable {
	private int volume;
	private int currentChannel;
	private Map<Integer, Channel> channels;
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public int getCurrentChannel() {
		return currentChannel;
	}

}
