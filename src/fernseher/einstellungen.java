package fernseher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class einstellungen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					einstellungen frame = new einstellungen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public einstellungen() {
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
		
		JLabel lblEinstellungen = new JLabel("Einstellungen");
		lblEinstellungen.setBounds(10, 11, 85, 20);
		contentPane.add(lblEinstellungen);
	}
}
