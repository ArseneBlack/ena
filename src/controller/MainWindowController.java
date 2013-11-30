package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.SettingsView;
import view.MainWindowView;
import model.MainWindowModel;

public class MainWindowController {
	private MainWindowView view;

	private MainWindowModel model;

	public MainWindowController() {
		model = new MainWindowModel();
		view = new MainWindowView(this.model);
		view.setVisible(true);
		addListeners();
	}

	public void showView() {

	}

	private void addListeners() {
		view.setExitListener(new ExitListener());
		view.setSettingsListener(new SettingsListener());
		view.setClickListener(new ClickListener());
		view.setSkipAdListener(new SkipAdListener());
		view.setVolumeListener(new VolumeListener());
	}

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class SettingsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SettingsView einst = new SettingsView();
			einst.setVisible(true);
		}
	}

	class SkipAdListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: implement
		}
	}
	
	class VolumeListener implements ChangeListener {
		public void stateChanged(ChangeEvent event) {
			JSlider slider = (JSlider) event.getSource();
			model.setVolume(slider.getValue());
		}
	}

	class ClickListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			view.toggleButtonVisibility();
		}
	}
}
