package view;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JEditorPane;

public class EditChannelListView extends JFrame {
	public EditChannelListView() {
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(8, 49, 203, 212);
		getContentPane().add(list);
		
		JButton btnKanalscanDurchfhren = new JButton("Kanalscan durchführen");
		btnKanalscanDurchfhren.setBounds(9, 266, 204, 25);
		getContentPane().add(btnKanalscanDurchfhren);
		
		JLabel lblVerfgbareSender = new JLabel("Verfügbare Sender:");
		lblVerfgbareSender.setBounds(10, 27, 224, 15);
		getContentPane().add(lblVerfgbareSender);
		
		JList list_1 = new JList();
		list_1.setBounds(259, 49, 153, 212);
		getContentPane().add(list_1);
		
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
	}
}
