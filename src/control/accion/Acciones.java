package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Acciones implements ActionListener{

	private ParaUI paraUI;

	public Acciones(ParaUI paraUI) {
		this.paraUI = paraUI;
		
		System.out.println("aki contructor acciones");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		if (boton.getName().equals("btnAlante")) {

			paraUI.pintarPagina();
			//libro.retrocederPagina();
		
			paraUI.miLibro.avanzarPagina();
			
			System.out.println("aki avanzar pagina");
			
			//ParaUI.pintarPagina();

		} else if (boton.getName().equals("btnAtras")) {

			paraUI.miLibro.retrocederPagina();

		} else if (boton.getName().equals("btnMarcar")) {

			paraUI.miLibro.marcarPagina();

		} else if (boton.getName().equals("btnIrAMarca")) {

		//	libro.irAMarca();
			
			
				
		//	panel.add(lblNumeroPagina);	

		}

	}
		
	}

