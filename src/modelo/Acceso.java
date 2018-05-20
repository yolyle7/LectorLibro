package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class Acceso {

	public void pintarPagina(Libro miLibro, JTextArea textArea) {

		try {
			FileInputStream reader = new FileInputStream(miLibro.getLectura());
			InputStreamReader data = new InputStreamReader(reader, "UTF-8");
			StringBuilder cadena = new StringBuilder();

			boolean fin = false;
			char[] uno = new char[1];
			int count = 0;
			long paginaActual = 0;
			long inicioPagActual = 0;
			if (!miLibro.comprobarPrimeraPagina()) {
				inicioPagActual = miLibro.getPaginas().get(miLibro.getPagActual())
						.getUltimo();
			}
			data.skip(inicioPagActual);
			do {
				
				data.read(uno);
				String temporal = new String(uno);
				// stringbuilder
				cadena.append(temporal);
				if(textArea.getPreferredSize().getHeight() <= textArea
						.getHeight())
				textArea.setText(cadena.toString());
				// cadena.toString()
				count++;
				double prefsizeheigt = textArea.getPreferredSize().getHeight();
				int heigt = textArea.getHeight();
				System.out.println("este es el preferentsize " + prefsizeheigt
						+ " y este el heigt " + heigt);

			} while (textArea.getPreferredSize().getHeight() <= textArea
					.getHeight());

			// (count<5000);

			if (!miLibro.comprobarPrimeraPagina()) {
				paginaActual = miLibro.getPaginas().get(miLibro.getPagActual())
						.getUltimo();
				miLibro.anadirPagina(paginaActual,
						paginaActual + cadena.length());
			}

			else {
				miLibro.anadirPagina(0, cadena.length());

			}

			long longitud = cadena.length();

			System.out.println("Pagina actual: " + paginaActual + "Longitud: " + longitud);

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

// PAra hacer la conversion es mejor usar el flujo y convertir en el mismo, tal
// que asi
// FileInputStream reader = new FileInputStream("JuegoTronos.txt");
// InputStreamReader data=new InputStreamReader(reader, "UTF8");
// boolean fin=false;
// char[] uno = new char[1];
// do {
// data.read(uno);
//
// String temporal = new String(uno);
// //stringbuilder
// cadena.append(temporal);
// textArea.setText(cadena.toString());
//
// } while (textArea.getPreferredSize().getHeight() < textArea.getHeight());