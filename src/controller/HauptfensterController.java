package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import view.Einstellungen;
import view.HauptfensterView;
import model.HauptfensterModel;

public class HauptfensterController {
	private HauptfensterView view;
	private HauptfensterModel model;
	
	public HauptfensterController() {
		model = new HauptfensterModel();
		view = new HauptfensterView(this.model);
		view.setVisible(true);
		addListeners();
	}
	
	public void showView() {
		
	}
	
	private void addListeners() {
		view.setExitListener(new ExitListener());
		view.setSettingsListener(new SettingsListener());
		view.setClickListener(new ClickListener());
	}
	
	class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class SettingsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Einstellungen einst = new Einstellungen();
			einst.setVisible(true);
		}
	}
	
	class ClickListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			view.toggleButtonVisibility();

		}
	}
}
