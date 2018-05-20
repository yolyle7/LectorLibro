package modelo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Libro implements Legible {

	private String lectura;
	private int actual = 0;
	private int marca = -1;
	private int ultima = -1;
	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		this.marca = -1;
		this.actual = 0;
		lectura = "JuegoTronos.txt";
		paginas = new ArrayList<>();
		paginas.add(new Pagina(0, 0));
	}
	/**
	 * avanza a la siguiente pagina.
	 */
	@Override
	public void avanzarPagina() {
		if (!comprobarUltimaPagina()) {
			if (cargarSiguientePagina())
				actual++;
		}

	}
	/**
	 * Comprueba que la siguiente pagina existe y la carga
	 * 
	 * @return
	 */
	private boolean cargarSiguientePagina() {
		if (comprobarUltimaPagina()) {
			return false;
		} else {
			return true;
		}

	}

	public int getUltima() {
		return ultima;
	}
	public void setUltima(int ultima) {
		this.ultima = ultima;
	}
	/**
	 * comprueba si es la primera pagina
	 * 
	 * @return true es la primera, y false si no lo es.
	 */
	public boolean comprobarPrimeraPagina() {
		if (this.actual == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * carga la pagina pasada como parametro
	 * 
	 * @param pagina
	 * @return
	 */

	// private boolean cargarPagina(int pagina) {
	// // TODO Auto-generated method stub
	// return false;
	// }

	private boolean comprobarUltimaPagina() {
		if (ultima == actual) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retrocede una pagina
	 */
	@Override
	public void retrocederPagina() {
		if (!comprobarPrimeraPagina()) {
			actual--;
		} else {
			System.out.println(
					"no se puede retroceder, estas en la primera pagina");
		}
	}
	/**
	 * marca la pagina actual
	 */
	@Override
	public void marcarPagina() {
		this.marca = this.actual;
	}

	/**
	 * va a la pagina marcada
	 */
	@Override
	public void irAPagina() {
		this.actual = this.marca;

	}
	
	public boolean siPintarMarca (JTextArea textArea) {
		if(getMarca()==getActual()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void pintarMarca(JTextArea textArea) {
		textArea.setBackground(Color.RED);
		
	}
	public void despintarMarca(JTextArea textArea) {
		textArea.setBackground(Color.white);
		
	}

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getPagActual() {
		return actual;
	}

	public int getMarca() {
		return marca;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}
	// public boolean actualizarPaginaActual(long primer, long ultimo) {
	// int actual=this.getActual();
	// this.paginas[actual]
	// return true;
	//
	// }

	// public void actualizarTextArea() {
	// actualizarNumPagina();
	// Pagina pagina = this.libro.getPaginas().get(this.libro.getActual());
	// this.textArea.setText(
	// new
	// AlmacenLibro(this.libro.getLectura()).leer().substring(pagina.getPrimer(),
	// pagina.getUltimo()));
	// }

	public void anadirPagina(long inicioPagina, long finPagina) {
		this.paginas.add(new Pagina(inicioPagina, finPagina));
	}
	

}
