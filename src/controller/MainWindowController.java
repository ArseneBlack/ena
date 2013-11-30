package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.MainWindowView;
import model.MainWindowModel;

public class MainWindowController {
	protected MainWindowView view;

	private MainWindowModel model;
	
	private static SettingsController settings;
	private ElectronicsController electronics;

	public MainWindowController() {
		settings = new SettingsController();
		model = new MainWindowModel();
		view = new MainWindowView(model);
		electronics = new ElectronicsController(new JPanel(), new JPanel()); // TODO: pass real values
		
		addListeners();
	}

	public void showView() {
		view.setVisible(true);
	}

	private void addListeners() {
		view.setExitListener(new ExitListener());
		view.setSettingsListener(new SettingsListener());
		view.setClickListener(new ClickListener());
		view.setSkipAdListener(new SkipAdListener());
		view.setVolumeListener(new VolumeListener());
		view.setPauseListener(new PauseListener());
	}

	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	class SettingsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			settings.showView();
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
	
	class PauseListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton button = (JButton) event.getSource();
			if (electronics.isPaused()) {
				button.setText("Pause");
				electronics.resume();
			} else {
				button.setText("Fortsetzen");
				electronics.pause();
			}
		}
	}
}
