package view;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;

import model.EditChannelListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class EditChannelListView extends JFrame {
	private JScrollPane scrollPane = new JScrollPane();
	JScrollPane scrollPane_1 = new JScrollPane();
	private EditChannelListModel editChannelListModel = new EditChannelListModel();
	public EditChannelListView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(50, 50, 500, 500);
		JList availableList = new JList(editChannelListModel.getListModel());
		availableList.setBounds(8, 49, 203, 212);
		availableList.scrollRectToVisible(getBounds());
		scrollPane.setViewportView(availableList);
		
		JButton btnKanalscanDurchfhren = new JButton("Kanalscan durchführen");
		btnKanalscanDurchfhren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					editChannelListModel.scan();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnKanalscanDurchfhren.setBounds(9, 266, 204, 25);
		getContentPane().add(btnKanalscanDurchfhren);
		
		JLabel lblVerfgbareSender = new JLabel("Verfügbare Sender:");
		lblVerfgbareSender.setBounds(10, 27, 224, 15);
		getContentPane().add(lblVerfgbareSender);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(259, 49, 153, 212);
		scrollPane_1.setViewportView(list_1);
		
		JLabel lblFavoriten = new JLabel("Favoriten:");
		lblFavoriten.setBounds(242, 24, 172, 15);
		getContentPane().add(lblFavoriten);
		
		JButton buttonDel = new JButton("<");
		buttonDel.setBounds(212, 120, 46, 25);
		getContentPane().add(buttonDel);
		
		JButton buttonAdd = new JButton(">");
		buttonAdd.setBounds(211, 93, 47, 25);
		getContentPane().add(buttonAdd);
		
		JButton buttonUp = new JButton("∧");
		buttonUp.setBounds(213, 206, 46, 25);
		getContentPane().add(buttonUp);
		
		JButton buttonDown = new JButton("∨");
		buttonDown.setBounds(214, 232, 44, 25);
		getContentPane().add(buttonDown);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(295, 266, 117, 25);
		getContentPane().add(btnSpeichern);
		
		
		scrollPane.setBounds(8, 49, 203, 213);
		getContentPane().add(scrollPane);
		
		
		
		scrollPane_1.setBounds(259, 47, 152, 215);
		getContentPane().add(scrollPane_1);
	}
}
