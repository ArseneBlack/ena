package oberflaeche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.xml.soap.Text;

public class Hauptfenster extends JFrame {

	private JPanel contentPane;
	private JTextField textKanal;
	private JTextField textLautst�rke;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	//	System.out.println("Start Main");
		EventQueue.invokeLater(new Runnable() {                         // Nach beenden der Main ausf�hren
			public void run() {
				System.out.println("start run");
				try {
					Hauptfenster frame = new Hauptfenster();            // HaupfensterObjekt generieren 
					frame.setVisible(true);                             // HaupfensterObjekt anzeigen
				} catch (Exception e) {                                 // Im Fehlerfall der Stack ausgeben
					e.printStackTrace();
					
				}
	//			System.out.println("end run");
			}
			
		});
		
   //		System.out.println("end Main"); 
	}
 
	/**
	 * Create the frame.
	 */
	public Hauptfenster() {
	//	System.out.println("Hauptfenster konstruktor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // beenden des Programms nach Schliessen des Fensters
		setBounds(100, 100, 450, 300);                         // Fenstergroesse
		contentPane = new JPanel();                            // neues JPanel (Fenstersgrundlage) 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    // Rand festlegen  
		setContentPane(contentPane);                           // als Fensterinhalt benutzt  
		contentPane.setLayout(null);                           // statisches Layout
		
		
		final JButton btnSpeichern = new JButton("speichern");    // button initialisieren
		btnSpeichern.addActionListener(new ActionListener() {      // Aktionlistener erstellen f�r ereignisgesteuerte Ausf�hrung 
			public void actionPerformed(ActionEvent arg0) {         // Festlegen der Aktion beim Klicken des Buttons   
			System.out.println("kanal : "+ textKanal.getText());
			System.out.println("Lautst�rke "+ textLautst�rke.getText());
			}
		});
		btnSpeichern.setBounds(166, 107, 89, 23);                 // Postion und Groesse des Buttons festlegen
		contentPane.add(btnSpeichern);                            // Button im Fenster hinzuf�gen 
		
		textKanal = new JTextField();
		textKanal.setBounds(136, 14, 139, 20);
		contentPane.add(textKanal);
		textKanal.setColumns(10);
		
		JLabel lblkanalEingeben = new JLabel("kanal");
		lblkanalEingeben.setHorizontalAlignment(SwingConstants.RIGHT);
		lblkanalEingeben.setBounds(10, 17, 89, 14);
		contentPane.add(lblkanalEingeben);
		
		textLautst�rke = new JTextField();
		textLautst�rke.setBounds(136, 45, 139, 20);
		contentPane.add(textLautst�rke);
		textLautst�rke.setColumns(10);
		
		JLabel lblLauts�rke = new JLabel("Lautst\u00E4rke");
		lblLauts�rke.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLauts�rke.setBounds(20, 48, 79, 14);
		contentPane.add(lblLauts�rke);
		
		final JLabel lblName2 = new JLabel("");
		lblName2.setBounds(310, 17, 114, 14);
		contentPane.add(lblName2);
		
		final JLabel lblVorname2 = new JLabel("");
		lblVorname2.setBounds(310, 48, 114, 14);
		contentPane.add(lblVorname2);
		
		final JLabel lblEmail2 = new JLabel("");
		lblEmail2.setBounds(310, 79, 114, 14);
		contentPane.add(lblEmail2);
		
//		System.out.println("end HauptfensterKonstruktor");   
	}
}
