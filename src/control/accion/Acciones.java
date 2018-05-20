package control.accion;

import javax.swing.JTextArea;

import modelo.Acceso;
import modelo.Libro;

public class Acciones {

	private Acceso acceso = new Acceso();

	public Acciones() {

		System.out.println("aki contructor acciones");
	}

	public void avanzarPagina(Libro miLibro, JTextArea textArea) {
		textArea.setText("");
		miLibro.avanzarPagina();
		acceso.pintarPagina(miLibro, textArea);
	}

	public void retrocederPagina(Libro miLibro, JTextArea textArea) {
		textArea.setText("");
		miLibro.retrocederPagina();
		acceso.pintarPagina(miLibro, textArea);
	}

	public void marcarPagina(Libro miLibro, JTextArea textArea) {
		miLibro.marcarPagina();
		miLibro.pintarMarca(textArea);
	}

	public void irAPagina(Libro miLibro, JTextArea textArea) {
		miLibro.irAPagina();
		textArea.setText("");
		acceso.pintarPagina(miLibro, textArea);
	}

}
