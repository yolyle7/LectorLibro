package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Acceso {
	/**
	 * Va leyendo el libro y va rellendando el textArea comprobando byte a byte y comprobando si lo puede escribir.
	 * Ademas, va añadiendo las páginas al libro.
	 * @param miLibro
	 * @param textArea
	 */
	public void pintarPagina(Libro miLibro, JTextArea textArea) {

		try {
			if (miLibro.siPintarMarca(textArea)) {
				miLibro.pintarMarca(textArea);
			} else {
				miLibro.despintarMarca(textArea);
			}
			
			FileInputStream reader = new FileInputStream(miLibro.getLectura());
			InputStreamReader data = new InputStreamReader(reader, "UTF-8");
			StringBuilder cadena = new StringBuilder();

			char[] uno = new char[1];
			long inicioPagActual = 0;
			boolean fin = false;
			int finfichero = 0;
//			System.out.println("Pagina actual en libro: "
//					+ miLibro.getPagActual() + " Marca: " + miLibro.getMarca()
//					+ "Variable actual: " + miLibro.getActual());
			
			//si no es la primera pagina cojo el fin de la página anterior, le sumo 1 y ese es el incio de la nueva 
			//página actual
			if (!miLibro.comprobarPrimeraPagina()) {
				inicioPagActual = (miLibro.getPaginas()
						.get(miLibro.getPagActual() - 1).getUltimo())+1;
			}
			data.skip(inicioPagActual);
			do {

				finfichero = data.read(uno);

				if (!(finfichero == -1)) {

					System.out.println("CONTINUO");

					String temporal = new String(uno);

					// stringbuilder
					cadena.append(temporal);
					//if (textArea.getPreferredSize().getHeight() < textArea.getHeight())
						textArea.setText(cadena.toString());
//					double prefsizeheigt = textArea.getPreferredSize()
//							.getHeight();
//					int heigt = textArea.getHeight();
//					System.out.println("este es el preferentsize "
//							+ prefsizeheigt + " y este el heigt " + heigt);
				} else {
					System.out.println("FINAL FICHERO");
					fin=true;
					miLibro.setUltima(miLibro.getActual());
					JOptionPane.showMessageDialog(null,"FIN DE LIBRO"); 
				}
				//la condicion es que sigo leyendo caracteres hasta que ve que no cabe en el textArea, voy viendo que el 
				//tamaño de la ventana ya escrita, sea menor que el tamañao de la altura de textarea
			} while ((textArea.getPreferredSize().getHeight() < textArea
					.getHeight()) && fin==false);
			
			
			long longitud = cadena.length()-1;

			if (!miLibro.comprobarPrimeraPagina()) {
				miLibro.anadirPagina(inicioPagActual,
						inicioPagActual + longitud);
			} else {
				miLibro.anadirPagina(0, longitud);
			}

			System.out.println("Inicio de Pagina: " + inicioPagActual
					+ "Longitud: " + longitud);
			System.out.println("Pagina actual en libro: "
					+ miLibro.getPagActual() + " Marca: " + miLibro.getMarca()
					+ "Variable actual: " + miLibro.getActual());

			reader.close();
			data.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// catch (EOFException e1) {
		// miLibro.setUltima(miLibro.getActual());
		//
		// }

	}

}
