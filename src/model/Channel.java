package model;

public class Channel {
	//Frequenz;Kanal;Qualitaet;Programm;Anbieter
	
	int frequency;
	String channel;
	int quality;
	String name;
	String provider;
	
	public Channel(int frequency, String channel, int quality, String name, String provider) {
		this.frequency = frequency;
		this.channel = channel;
		this.quality = quality;
		this.name = name;
		this.provider = provider;
	}
	
	public String getName() {
		return name;
	}
	

}
