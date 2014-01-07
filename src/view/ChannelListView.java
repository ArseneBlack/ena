package view;

import javax.swing.JFrame;

import model.ChannelListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class ChannelListView extends JFrame {
	public ChannelListView() {
		getContentPane().setLayout(null);
		
		JList channelList = new JList();
		channelList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Sender 1", "Sender 2", "Sender 3", "Sender 4", "Sender 5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		channelList.setBounds(14, 31, 364, 263);
		setBounds(14, 31, 364,263);
		getContentPane().add(channelList);
	}
	private ChannelListModel model;
}
