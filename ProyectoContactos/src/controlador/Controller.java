package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.NewContactWindow;
import vista.EditContactWindow;
import vista.MainWindow;

public class Controller implements ActionListener {
	
	private MainWindow mainWindow;
	private NewContactWindow newContactWindow;
	private EditContactWindow editContactWindow;
	
	public Controller(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == mainWindow.getAddButton()) {
			newContactWindow = new NewContactWindow();
			//Ponemos a la escucha el boton de confirmación para añadir el contacto
			newContactWindow.getOkButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Creamos las variables que vamos a necesitar para las cajas de texto
                    String name = newContactWindow.getFieldName().getText();
                    String phone = newContactWindow.getFieldPhone().getText();

                    /*
                     * Creamos un if para la validación de las cajas de texto
                     * No aceptamos que la caja de texto del nombre esté vacía
                     * No aceptamos que la caja de texto del telefono esté vacía
                     * El teléfono solo aceptará numeros y tendrá una longitud igual a nueve caracteres
                     */                   
                    if (!name.equalsIgnoreCase("") && !phone.equalsIgnoreCase("") && phone.matches("[0-9]+") && phone.length() == 9) {
                        mainWindow.addContact(name, phone);
                        //mensaje de confirmación
                        JOptionPane.showMessageDialog(newContactWindow,"El contacto se añadió correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                      //Cuando añadimos el nuevo contacto se cierra la ventana
                        newContactWindow.dispose(); 

                      //Si el nombre está vacío mostramos un mensaje y ponemos el focus en la caja    
                    } else if(name.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(newContactWindow,"El nombre del contacto no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        newContactWindow.getFieldName().requestFocus();

                      //Si el telefono esta vacío mostramos un mensaje y ponemos el focus en la caja           
                    } else if(phone.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(newContactWindow,"El número de teléfono no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        newContactWindow.getFieldPhone().requestFocus();
                    
                      //Si el telefono contiene un caracter que no sea un número mostramos un mensaje y ponemos el focus en la caja  
                    }  else if (!phone.matches("[0-9]+")){
                        JOptionPane.showMessageDialog(newContactWindow,"El número de teléfono solo debe contener números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        newContactWindow.getFieldPhone().requestFocus();
                        
                      //Si la longitud del telefono no es la correcta mostramos un mensaje y ponemos el focus en la caja  
                    } else if(phone.length() != 9){
                        JOptionPane.showMessageDialog(newContactWindow,"El número de teléfono debe contener nueve caracteres", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        newContactWindow.getFieldPhone().requestFocus();                        
                    }
                }
            });
			//Ponemos a la escucha el boton de cancelar
			newContactWindow.getCancelButton().addActionListener(new ActionListener() {
				//Cerramos la ventana si pulsamos cancelar
				@Override
				public void actionPerformed(ActionEvent e) {
					newContactWindow.dispose();					
				}				
			});
			
		}
		//boton editar
		if(e.getSource() == mainWindow.getEditButton()) {
			//variable que contiene la posición en la fila de la lista. Si no hay ninguna fila seleccionada, el valor es -1
			int selectedRow = mainWindow.getTable().getSelectedRow();
			
			//si no hay ninguna fila seleccionada mostramos un mensaje
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(mainWindow, "Selecciona el contacto a editar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				//variables donde almacenamos los datos de la fila seleccionada y los pasamos a string para pasarselos a las ecajas de texto
				String oldName = mainWindow.getTableModel().getValueAt(selectedRow, 0).toString();
				String oldPhone = mainWindow.getTableModel().getValueAt(selectedRow, 1).toString();
				
				//creamos la ventada de edición
				editContactWindow = new EditContactWindow();
				
				//le pasamos los datos almacenados en las variables a las cajas de texto correspondientes
				editContactWindow.getFieldName().setText(oldName);
				editContactWindow.getFieldPhone().setText(oldPhone);
				
				//Boton OK
				editContactWindow.getOkButton().addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    // Creamos las variables que vamos a necesitar para editar la fila
	                    String newName = editContactWindow.getFieldName().getText();
	                    String newPhone = editContactWindow.getFieldPhone().getText();

	                    /*
	                     * Creamos un if para la validación de las cajas de texto con el mismo modelo anterior
	                     * No aceptamos que la caja de texto del nombre esté vacía
	                     * No aceptamos que la caja de texto del telefono esté vacía
	                     * El teléfono solo aceptará numeros y tendrá una longitud igual a nueve caracteres
	                     */                   
	                    if (!newName.isEmpty() && !newPhone.isEmpty() && newPhone.matches("[0-9]+") && newPhone.length() == 9) {
	                        mainWindow.getTableModel().setValueAt(newName, selectedRow, 0);
	                        mainWindow.getTableModel().setValueAt(newPhone, selectedRow, 1);
	                        //mensaje de confirmación
	                        JOptionPane.showMessageDialog(editContactWindow,"El contacto se modificó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                        //cerramos la ventana
	                        editContactWindow.dispose();
	                        

	                      //Si el nombre está vacío mostramos un mensaje y ponemos el focus en la caja  
	                    } else if(newName.equalsIgnoreCase("")){
	                        JOptionPane.showMessageDialog(editContactWindow,"El nombre del contacto no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                        editContactWindow.getFieldName().requestFocus();

	                      //Si el telefono esta vacío mostramos un mensaje y ponemos el focus en la caja           
	                    } else if(newPhone.equalsIgnoreCase("")){
	                        JOptionPane.showMessageDialog(editContactWindow,"El número de teléfono no puede estar vacío", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                        editContactWindow.getFieldPhone().requestFocus();
	                    
	                      //Si el telefono contiene un caracter que no sea un número mostramos un mensaje y ponemos el focus en la caja  
	                    }  else if (!newPhone.matches("[0-9]+")){
	                        JOptionPane.showMessageDialog(editContactWindow,"El número de teléfono solo debe contener números", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                        editContactWindow.getFieldPhone().requestFocus();
	                        
	                      //Si la longitud del telefono no es la correcta mostramos un mensaje y ponemos el focus en la caja  
	                    } else if(newPhone.length() != 9){
	                        JOptionPane.showMessageDialog(editContactWindow,"El número de teléfono debe contener nueve caracteres", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	                        editContactWindow.getFieldPhone().requestFocus();                        
	                    }
	                }
	            });
				//Ponemos a la escucha el boton de cancelar
				editContactWindow.getCancelButton().addActionListener(new ActionListener() {
					//Cerramos la ventana si pulsamos cancelar
					@Override
					public void actionPerformed(ActionEvent e) {
						editContactWindow.dispose();					
					}				
				});				
			}			
		}
		
		//boton eliminar
		if(e.getSource() == mainWindow.getDeleteButton()) {
			//variable que contiene la posición en la fila de la lista. Si no hay ninguna fila seleccionada, el valor es -1
			int selectedRow = mainWindow.getTable().getSelectedRow();
			
			//si no hay ninguna fila seleccionada mostramos un mensaje
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(mainWindow, "Selecciona el contacto a editar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				mainWindow.getTableModel().removeRow(selectedRow);
			}
			
			
		}
	
}

}