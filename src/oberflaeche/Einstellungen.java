package oberflaeche;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Einstellungen extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Einstellungen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Passwort festlegen");
		btnNewButton.setBounds(162, 160, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSenderlisteVerwalten = new JButton("Senderliste verwalten");
		btnSenderlisteVerwalten.setBounds(162, 103, 136, 23);
		contentPane.add(btnSenderlisteVerwalten);

		JButton btnClose = new JButton("Schließen");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.getWindowAncestor(contentPane).dispose();
			}
		});
		
		btnClose.setBounds(0, 0, 136, 23);
		contentPane.add(btnClose);
		
		this.setTitle("Einstellungen");
	}
}
