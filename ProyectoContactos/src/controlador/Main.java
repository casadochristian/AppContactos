package controlador;

import vista.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		MainWindow vista = new MainWindow();
		Controller controller = new Controller (vista);
		vista.addListeners(controller);
		

	}

}
