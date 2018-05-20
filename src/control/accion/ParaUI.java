package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.UI;

public class ParaUI extends UI {

	Libro miLibro = new Libro();
	Acciones acciones = new Acciones();

	public ParaUI() {
		super();

		getBtnAlante().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.avanzarPagina(miLibro, getTextArea());
				actulizarLblPagina();

			}
		});

		getBtnAtras().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.retrocederPagina(miLibro, getTextArea());
				actulizarLblPagina();

			}
		});
		getBtnIrAMarca().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.irAPagina(miLibro, getTextArea());
				actulizarLblPagina();

			}
		});
		getBtnMarcar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acciones.marcarPagina(miLibro);

			}
		});

		// acciones.pintarPrimeraPagina(miLibro, getTextArea());

	}

	public Libro getMiLibro() {
		return miLibro;
	}

	public void setMiLibro(Libro miLibro) {
		this.miLibro = miLibro;
	}

	public void actulizarLblPagina() {
		String text = "";
		text = String.valueOf(miLibro.getActual());
		// Integer uno = miLibro.getActual();

		setLblNumeroPagina(text);

	}

}
