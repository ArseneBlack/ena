package model;

import javax.swing.JPanel;

public class ElectronicsModel {
	private TvElectronics electronics;
	
	private static ElectronicsModel instance;

	private long recordingStartTime;

	Boolean isPaused;

	Boolean isRecording;
	
	// Wenn noch kein Objekt existiert, wird eins erzeugt (privater Konstruktor wird aufgerufen)
	// Wenn ein objekt existiert, wir dieses zur�ckgegeben.
	public static ElectronicsModel createInstance(JPanel mainDisplay, JPanel pipDisplay) {  
		if (instance == null) {
			instance = new ElectronicsModel(mainDisplay, pipDisplay);
		}
		
		return instance;
	}
	
	public static ElectronicsModel getInstance()  throws NullPointerException {
		if (instance == null) {
			throw (new NullPointerException("Electronics Model must be created using createInstance first"));
		} else {
			return instance;
		}
	}
	
	// privater Konstruktor, wird von getInstance aufgerufen
	// so kann immer nur ein Objekt dieser Klasse existieren
	private ElectronicsModel(JPanel mainDisplay, JPanel pipDisplay) {
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
	
	public JPanel getMainDisplay() {
		return electronics.mainDisplay;
	}
	
	public JPanel getPipDisplay() {
		return electronics.pipDisplay;
	}
}
