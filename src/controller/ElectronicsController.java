package controller;

import javax.swing.JPanel;

import model.ElectronicsModel;

public class ElectronicsController {
	private ElectronicsModel model;

	ElectronicsController(JPanel mainWindow, JPanel pip) {
		model = new ElectronicsModel(mainWindow, pip);
	}

	public void pause() {
		model.pause();
	}

	public void resume() {
		model.resume();
	}

	public Boolean isPaused() {
		return model.isPaused();
	}
}
