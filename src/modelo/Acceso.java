package modelo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.JTextArea;

public class Acceso {
	
	public void pintarPagina(Libro miLibro, JTextArea textArea) {
		File archivo = new File(miLibro.getLectura());
			// Flujo binario para lectura
			FileInputStream flujo = null;
			DataInputStream conversor = null;
			StringBuilder builder = new StringBuilder();
			Reader reader = null;
			BufferedReader fin = null;
		
			
			try {
				//textArea.setText("");
				flujo = new FileInputStream(archivo);
				conversor = new DataInputStream(flujo);
				reader = new InputStreamReader(new FileInputStream(archivo), "UTF-8");
				fin = new BufferedReader(reader);
					
				String valor = conversor.readUTF();
				while (valor != null) {
					System.out.println(valor + " ");
					valor = conversor.readUTF();
					//streamBuilder
					textArea.setText(textArea.getText()+valor);
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
//			} 
//			catch (EOFException e) {
//					e.printStackTrace();

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

