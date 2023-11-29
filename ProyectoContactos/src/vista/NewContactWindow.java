package vista;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controller;

public class NewContactWindow extends JDialog {
	
	private JButton okButton, cancelButton;
	private JLabel labelName, labelPhone;
	private JTextField fieldName, fieldPhone;
	private Controller controller;
	
	public NewContactWindow() {
		
		setBounds(1200, 100, 400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Nuevo Contacto");
		setLayout(null);
		setResizable(false);
		initComponents();	
		
		setVisible(true);
	}
	
	private void initComponents() {
		
		labelName = new JLabel("Nombre");
		labelName.setBounds(50, 50, 110, 30);
		add(labelName);
		
		labelPhone = new JLabel("Teléfono");
		labelPhone.setBounds(50, 120, 110, 30);
		add(labelPhone);
		
		fieldName = new JTextField();
		fieldName.setBounds(150, 50, 150, 30);
		add(fieldName);
		
		fieldPhone = new JTextField();
		fieldPhone.setBounds(150, 120, 150, 30);
		add(fieldPhone);
				
		okButton = new JButton("OK");
		okButton.setBounds(200, 210, 60, 30);
		add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(280, 210, 90, 30);
		add(cancelButton);		
	}

	public JTextField getFieldName() {
		return fieldName;
	}

	public JTextField getFieldPhone() {
		return fieldPhone;
	}
	
	public JButton getOkButton() {
		return okButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

}
