package oberflaeche;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hauptfenster extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		System.out.println("Start Main");
		EventQueue.invokeLater(new Runnable() {                         // Nach beenden der Main ausf�hren
			public void run() {
				System.out.println("start run");
				try {
					Hauptfenster frame = new Hauptfenster();            // HaupfensterObjekt generieren 
					frame.setVisible(true);                             // HaupfensterObjekt anzeigen
				} catch (Exception e) {                                 // Im Fehlerfall der Stack ausgeben
					e.printStackTrace();
					
				}
				System.out.println("end run");
			}
			
		});
		
		System.out.println("end Main"); 
	}

	/**
	 * Create the frame.
	 */
	public Hauptfenster() {
		System.out.println("Hauptfenster konstruktor");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // beenden des Programms nach Schliessen des Fensters
		setBounds(100, 100, 450, 300);                         // Fenstergroesse
		contentPane = new JPanel();                            // neues JPanel (Fenstersgrundlage) 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));    // Rand festlegen  
		setContentPane(contentPane);                           // als Fensterinhalt benutzt  
		contentPane.setLayout(null);                           // statisches Layout
		
		
		final JButton btnSchliessen = new JButton("schliessen");    // button initialisieren
		btnSchliessen.addActionListener(new ActionListener() {      // Aktionlistener erstellen f�r ereignisgesteuerte Ausf�hrung 
			public void actionPerformed(ActionEvent arg0) {         // Festlegen der Aktion beim Klicken des Buttons   
			btnSchliessen.setBackground(Color.BLUE);
			}
		});
		btnSchliessen.setBounds(345, 238, 89, 23);                 // Postion und Groesse des Buttons festlegen
		contentPane.add(btnSchliessen);                            // Button im Fenster hinzuf�gen 
		
		System.out.println("end HauptfensterKonstruktor");   
	}
}
