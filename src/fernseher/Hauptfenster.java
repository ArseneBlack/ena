package fernseher;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSlider;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import java.awt.event.MouseAdapter;

public class Hauptfenster extends JFrame {

	private JPanel contentPane;
	private HashSet<JComponent> components ;  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hauptfenster frame = new Hauptfenster();
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
	public Hauptfenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for(java.util.Iterator<JComponent> i = components.iterator(); i.hasNext();)
				{
					JComponent component = i.next();
					component.setVisible(!component.isVisible());	
				}
				
			}
		});
		components = new HashSet<JComponent>();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSettings = new JButton("Einstellungen");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSettings.setBounds(10, 227, 116, 23);
		components.add(btnSettings);
		
		JButton btnWerbungberbrcken = new JButton("Werbung überbrücken");
		btnWerbungberbrcken.setBounds(134, 193, 89, 23);
		components.add(btnWerbungberbrcken);
		
		
		JButton btnPause = new JButton("Pause");
		btnPause.setBounds(136, 227, 89, 23);
		components.add(btnPause);
		
		JButton btnVorherigeSender = new JButton("vorherige sender");
		btnVorherigeSender.setBounds(235, 227, 89, 23);
		components.add(btnVorherigeSender);
		
		JButton btnSenderliste = new JButton("Senderliste");
		btnSenderliste.setBounds(334, 227, 89, 23);
		components.add(btnSenderliste);
		
		final JButton btnNchsteSender = new JButton("n\u00E4chste Sender");
		btnNchsteSender.setBounds(334, 193, 89, 23);
		btnNchsteSender.setVisible(false);
		components.add(btnNchsteSender);
		
		
		JButton btnBalkenEntfernen = new JButton("Balken Entfernen");
		btnBalkenEntfernen.setBounds(334, 155, 89, 23);
		components.add(btnBalkenEntfernen);
		
		JButton btnStumm = new JButton("stumm");
		btnStumm.setBounds(334, 125, 89, 23);
		components.add(btnStumm);
		
		JSlider lautstärke = new JSlider();
		lautstärke.setBounds(235, 88, 200, 26);
		components.add(lautstärke);
		
		initializeButtons();
            
		
		
	}
	
    void initializeButtons()
    {
    	for(java.util.Iterator<JComponent> i = components.iterator(); i.hasNext();)
    	{
    		JComponent component = i.next();
    		component.setVisible(false);
    		contentPane.add(component);
    	}
    			
    	
    }
}
