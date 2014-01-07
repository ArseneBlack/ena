package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SettingsModel {
	public SettingsModel() {
		loadSettings();
	}
	
	public void finalize() {
		saveSettings();
	}

	private void loadSettings() {
		try {
			Path path = Paths.get("settings.txt");
			Scanner scanner = new Scanner(path);
			if (scanner.hasNext()) {
				volume = scanner.nextInt();
			} else {
				scanner.close();
				throw new IOException("wrong file format");
			}
			if (scanner.hasNext()) {
				channel = scanner.nextInt();
			} else {
				scanner.close();
				throw new IOException("wrong file format");
			}
			channel = 1;
			while (scanner.hasNext()) {
				channelList.put(channel++, scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			volume = 50;
			channel = 1;
		}
	}

	public void saveSettings() {
		try {
			PrintWriter writer = new PrintWriter("settings.txt");
			writer.println(volume);
			writer.println(channel);
			for (Map.Entry<Integer, String> channel : channelList.entrySet()) {
				writer.println(channel);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private Map<Integer, String> channelList = new HashMap<Integer, String>();

	private int volume;

	private int channel;
}
