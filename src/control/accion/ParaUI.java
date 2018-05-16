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
		// Flujo binario para lectura
		FileInputStream flujo = null;
		DataInputStream conversor = null;
		
		try {
			//textArea.setText("");
			flujo = new FileInputStream(archivo);
			conversor = new DataInputStream(flujo);
			String valor = conversor.readUTF();
			while (valor != null) {
				System.out.println(valor + " ");
				valor = conversor.readUTF();
				//jokml
				textArea.setText(textArea.getText()+valor);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
//		} 
//		catch (EOFException e) {
//				e.printStackTrace();

			//preguntar!!! estoy intentando hacerlo byte a byte y rellenado las paginas,
			//pero como se cuando se ha rellenado el text para parar? o sea, saber el fin del fichero
			
			
			}
		try {
			flujo.close();
			conversor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

//public void getTamanoArea() {
//	System.out.println(this.textArea.getPreferredSize().getHeight());
//	System.out.println(this.textArea.getHeight());
//	System.out.println(this.textArea.getPreferredSize().getWidth());
//	System.out.println(this.textArea.getWidth());
//}
