package control.accion;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import modelo.Libro;
import vista.UI;

public class ParaUI extends UI {

	
	protected Libro miLibro;
	
		public ParaUI() {
		super();
		this.miLibro= new Libro();
		pintarPagina();
	}


	public void pintarPagina() {
	File archivo = new File(miLibro.getLectura());
	if (archivo.exists()) {
		// Flujo binario para lectura
		FileInputStream flujoR = null;
		DataInputStream conversorR = null;
		try {
			//textArea.setText("");
			flujoR = new FileInputStream(archivo);
			conversorR = new DataInputStream(flujoR);
			String valor = conversorR.readUTF();
			while (valor != null) {
				System.out.println(valor + " ");
				valor = conversorR.readUTF();
				
				textArea.setText(textArea.getText()+valor);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
//		} 
//		catch (EOFException e) {
//				e.printStackTrace();
			}
		try {
			flujoR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

}
//public void getTamanoArea() {
//	System.out.println(this.textArea.getPreferredSize().getHeight());
//	System.out.println(this.textArea.getHeight());
//	System.out.println(this.textArea.getPreferredSize().getWidth());
//	System.out.println(this.textArea.getWidth());
//}
