package daten;

import java.util.HashMap;
import java.util.Map;

public class Einstellungen {
	public Einstellungen() {
		this.channelList = new HashMap<Integer, String>();
	}
	
	
	private Map<Integer, String> channelList;
	private int volume;
	private int channel;
}
