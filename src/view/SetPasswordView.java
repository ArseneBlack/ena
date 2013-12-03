package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.PasswordModel;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class SetPasswordView  extends JFrame {
	private PasswordModel model;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private JButton btnSpeichern = new JButton("speichern");
	private JButton btnCancel = new JButton("Abbrechen");
	private JLabel lblNewLabel = new JLabel("Neues Passwort");
	private JLabel  lblNeuesPasswort = new JLabel("Altes Passwort");
	private JLabel lblPasswortBesttigen = new JLabel("Passwort best\u00E4tigen");
	private final JLabel lblMessage = new JLabel("");

	public SetPasswordView(PasswordModel model) {
		super("Passwort Festlegen");
		this.model = model;
		getContentPane().setLayout(null);
				
		lblNeuesPasswort.setBounds(115, 36, 92, 14);
		getContentPane().add(lblNeuesPasswort);		
		
		btnSpeichern.setBounds(133, 216, 114, 23);
		getContentPane().add(btnSpeichern);
				
		btnCancel.setBounds(257, 216, 121, 23);
		getContentPane().add(btnCancel);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(239, 33, 139, 20);
		getContentPane().add(oldPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(239, 80, 139, 20);
		getContentPane().add(newPasswordField);
    		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(239, 130, 139, 20);
		getContentPane().add(confirmPasswordField);
		
		
		lblNewLabel.setBounds(117, 86, 97, 14);
		getContentPane().add(lblNewLabel);
		
		
		lblPasswortBesttigen.setBounds(90, 136, 139, 14);
		getContentPane().add(lblPasswortBesttigen);
		lblMessage.setBounds(133, 184, 248, 14);
		
		getContentPane().add(lblMessage);
	}
	
	 public void setNewPasswordListener(ActionListener listener)
	 {
	    btnSpeichern.addActionListener(listener); 
	 }
	 
	 public void setCancelButtonListener(ActionListener listener)
	 {
		 btnCancel.addActionListener(listener);
	 }
	 
	 public String getOldPassword()
	 {
		 return new String(oldPasswordField.getPassword());
	 }
	 
	 public String getNewPassword()
	 {
		 return new String(newPasswordField.getPassword());
	 }
	  
	 public String getConfirmPassword()
	 {
		 return new String(confirmPasswordField.getPassword());
	 }
	 
     public void setMessage(String message)
     {
    	 lblMessage.setText(message);
     }
}
