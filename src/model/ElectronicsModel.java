package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;

import view.PicturePanel;

public class ElectronicsModel {
	private TvElectronics electronics;
	private static PersistentData data;
	
	private long recordingStartTime;
	Boolean isPaused;
	Boolean isRecording;

	// Singleton
	private static ElectronicsModel instance;
	private ElectronicsModel() {
		JPanel mainDisplay = new PicturePanel("./src/view/16_9.jpg");
		JPanel pipDisplay = new PicturePanel("./src/view/16_9.jpg");
		electronics = new TvElectronics(mainDisplay, pipDisplay);
		isPaused = false;
		isRecording = false;
	}
	public static ElectronicsModel getInstance() {
		if (instance == null) {
			instance = new ElectronicsModel();
			loadData();
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					saveData();
				}
			});
		}

		return instance;
	}

	// privater Konstruktor, wird von getInstance aufgerufen
	// so kann immer nur ein Objekt dieser Klasse existieren
	

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
	
	private static void loadData() {
		try {
			FileInputStream in = new FileInputStream("persistent.dat");
			ObjectInputStream s = new ObjectInputStream(in);
			data = (PersistentData) s.readObject();
			s.close();
		} catch (IOException | ClassNotFoundException e) {
			data = new PersistentData();
		}

	}

	private static void saveData() {

		try {
			FileOutputStream fileStream = new FileOutputStream("persistent.dat");
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.writeObject(data);
			objectStream.flush();
			objectStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVolume(int volume) throws Exception {
		electronics.setVolume(volume);
		data.setVolume(volume);
	}

	public int getVolume() {
		return data.getVolume();
	}
}
