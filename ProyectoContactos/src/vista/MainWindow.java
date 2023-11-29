package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.Controller;

public class MainWindow extends JFrame {
	
	private JLabel title;
	private JButton addButton, deleteButton, editButton;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	
	public MainWindow() {
		setSize(450, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mis Contactos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/appIcon.png"));
		setLayout(null);
		setResizable(false);
		initComponents();
		
		setVisible(true);		
	}
	
	private void initComponents() {		
		
		//color de fondo
		getContentPane().setBackground(Color.WHITE);
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("coolvetica rg.otf"));
			
			title = new JLabel("Mis Contactos");
			title.setHorizontalAlignment(SwingConstants.CENTER);
			title.setFont(font.deriveFont(Font.BOLD, 40f));
			title.setBounds(-50, 20, 535, 50);
			title.setForeground(Color.BLACK);
			add(title);
			
			
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//icono del boton de añadir
		Image addIcon = new ImageIcon("img/addicon.png").getImage();
		addButton = new JButton(new ImageIcon(addIcon.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		addButton.setBounds(65, 450, 60, 60);
		addButton.setBorderPainted(true);
		addButton.setFocusPainted(false);
		addButton.setContentAreaFilled(false);
		add(addButton);
		
		Image deleteIcon = new ImageIcon("img/deleteicon.png").getImage();
		deleteButton = new JButton(new ImageIcon(deleteIcon.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		deleteButton.setBounds(185, 450, 60, 60);
		deleteButton.setBorderPainted(true);
		deleteButton.setFocusPainted(false);
		deleteButton.setContentAreaFilled(false);
		add(deleteButton);
		
		Image editIcon = new ImageIcon("img/editicon.png").getImage();
		editButton = new JButton(new ImageIcon(editIcon.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		editButton.setBounds(305, 450, 60, 60);
		editButton.setBorderPainted(true);
		editButton.setFocusPainted(false);
		editButton.setContentAreaFilled(false);
		add(editButton);
		
		String[] columnName = {"Nombre", "Telefono"};
		tableModel = new DefaultTableModel(columnName,0);
		
		
		//tabla
		table = new JTable(tableModel);
		//Scroll
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(90, 90, 250, 350);
		add(scrollPane);
		
	}
	
	public void addListeners(Controller controller) {
		addButton.addActionListener(controller);
		deleteButton.addActionListener(controller);
		editButton.addActionListener(controller);
		
	}
	
	public void addContact(String name, String phone) {
		String[] newContact = {name , phone};
		tableModel.addRow(newContact);
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getEditButton() {
		return editButton;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
}
