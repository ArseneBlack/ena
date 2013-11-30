package model;

import java.util.HashSet;

import javax.swing.JComponent;

import view.SettingsView;

public class MainWindowModel {
	
	private int volume;
	
	public int currentVolume() {
		return this.volume;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
