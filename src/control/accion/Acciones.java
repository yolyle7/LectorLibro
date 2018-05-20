package control.accion;

import javax.swing.JTextArea;

import modelo.Acceso;
import modelo.Libro;

public class Acciones {

	private Acceso acceso = new Acceso();

	public Acciones() {

		System.out.println("aki contructor acciones");
	}


	public void avanzarPagina(Libro miLibro, JTextArea area) {
		area.setText("");
		acceso.pintarPagina(miLibro, area);
		miLibro.avanzarPagina();
		
	}

	public void retrocederPagina(Libro miLibro, JTextArea area) {
		area.setText("");
		acceso.pintarPagina(miLibro, area);
		miLibro.retrocederPagina();
	}

	public void marcarPagina(Libro miLibro) {
		miLibro.marcarPagina();
	}

	public void irAPagina(Libro miLibro, JTextArea area) {
		miLibro.irAPagina();
		area.setText("");
		acceso.pintarPagina(miLibro, area);
	}

}
