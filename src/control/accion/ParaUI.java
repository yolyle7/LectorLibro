package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.UI;

public class ParaUI extends UI {

	private Libro miLibro = new Libro();
	Acciones acciones = new Acciones();

	public ParaUI() {
		super();

		getBtnAlante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.avanzarPagina(miLibro, getTextArea());

			}
		});

		getBtnAtras().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.retrocederPagina(miLibro, getTextArea());

			}
		});
		getBtnIrAMarca().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.irAPagina(miLibro, getTextArea());

			}
		});
		getBtnMarcar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.marcarPagina(miLibro);
				
			}
		});

	}

	public Libro getMiLibro() {
		return miLibro;
	}

	public void setMiLibro(Libro miLibro) {
		this.miLibro = miLibro;
	}

}

// public void getTamanoArea() {
// System.out.println(this.textArea.getPreferredSize().getHeight());
// System.out.println(this.textArea.getHeight());
// System.out.println(this.textArea.getPreferredSize().getWidth());
// System.out.println(this.textArea.getWidth());
// }
