package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.SettingsModel;
import view.SettingsView;

public class SettingsController {
	private SettingsView view;
	private SettingsModel model;
	
	public SettingsController() {
		model = new SettingsModel();
		view = new SettingsView(model);
		addListeners();
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	private void addListeners() {
		view.setPasswordListener(new PasswordListener());
		view.setChannelListListener(new ChannelListListener());
		view.setCloseListener(new CloseListener());
	}
	
	class PasswordListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// TODO implement
		}
	}
	
	class ChannelListListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// TODO implement
		}
	}
	
	class CloseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			view.setVisible(false);
		}
	}
}
