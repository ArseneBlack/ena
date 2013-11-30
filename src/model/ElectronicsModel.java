package model;

import javax.swing.JPanel;

public class ElectronicsModel {
	private TvElectronics electronics;

	private long recordingStartTime;

	Boolean isPaused;

	Boolean isRecording;

	public ElectronicsModel(JPanel mainDisplay, JPanel pipDisplay) {
		electronics = new TvElectronics(mainDisplay, pipDisplay);
		isPaused = false;
		isRecording = false;
	}

	public void pause() {
		try {
			if (!isPaused) {
				isPaused = true;
				electronics.playTimeShift(false, 0);
			}
			if (!isRecording) {
				recordingStartTime = electronics.now();
				electronics.recordTimeShift(true);
				isRecording = true;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void resume() {
		try {
			isPaused = false;
			long offset = electronics.now() - recordingStartTime;
			if (isRecording && offset > 0) {
				electronics.playTimeShift(true, (int) offset);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean isPaused() {
		return isPaused;
	}
}
