package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class EditChannelListModel {
	private ElectronicsModel electronics = ElectronicsModel.getInstance();
	private DefaultListModel<String> listData = new DefaultListModel<String>();

	public ListModel<String> getListModel() {
		return listData;
	}

	public void scan() throws IOException {
		listData.clear();
		ArrayList<Object> scanResult = electronics.scanChannels();
		
		for (Object o : scanResult) {
			Channel channel = (Channel) o;
			listData.addElement(channel.getName());
		}
	}
}
