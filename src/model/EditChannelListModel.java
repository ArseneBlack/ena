package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class EditChannelListModel {
	private DefaultListModel<String> listData = new DefaultListModel<String>();
	
	public ListModel<String> getListModel() {
		return listData;
	}

	public void scan() throws IOException {
		listData.clear(); // Senderliste löschen
		
		// Datei zum lesen öffnen
		FileReader freader = new FileReader("Kanalscan.csv");
		BufferedReader breader = new BufferedReader(freader);
		
		breader.readLine(); // erste Zeile ignorieren
		
		// zeilenweise lesen
		String line; 
		while((line = breader.readLine()) != null) {
			String[] lineData = line.split(";"); // die Daten zwischen den ";" in ein Array speichern
			listData.addElement(lineData[3]); // Daten in die Liste speichern
		}
		
		breader.close();
	}
}
