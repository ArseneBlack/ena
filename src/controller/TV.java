package controller;

import java.awt.EventQueue;

import model.SettingsModel;

import view.MainWindowView;

public class TV {
	private static MainWindowController hauptfenster;
	private static SettingsController settings;

	public static void main(String[] args) {
		try {
			hauptfenster = new MainWindowController();
			settings = new SettingsController();
			
			hauptfenster.showView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
