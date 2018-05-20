package modelo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
	 * Comprueba que la siguiente pagina existe
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
	 * Comprueba si es la ultima pagina
	 *
	 * @return true si lo es, y false si no.
	 */
	private boolean comprobarUltimaPagina() {
		if (ultima == actual) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Retrocede una pagina y muestra una ventana emergente informado de que no
	 * se puede retroceder por estar en la primera pagina
	 */
	@Override
	public void retrocederPagina() {
		if (!comprobarPrimeraPagina()) {
			actual--;
		} else {
			JOptionPane.showMessageDialog(null,
					"NO PUEDES RETROCEDER, ESTÁS EN LA PRIMERA PÁGINA");
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

	public boolean siPaginaMarcada() {
		if (marca == -1) {
			JOptionPane.showMessageDialog(null,
					"NO TIENES NINGUNA PÁGINA MARCADA");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Comprueba si la página actual está marcada
	 * 
	 * @return true si es la página marcada, y false si no lo es.
	 */
	public boolean siPintarMarca(JTextArea textArea) {
		if (getMarca() == getActual()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Le pasa el JtextArea y le cambia el color del Background a gris
	 * 
	 * @param textArea
	 */
	public void pintarMarca(JTextArea textArea) {
		textArea.setBackground(Color.LIGHT_GRAY);

	}
	/**
	 * Le pasa el JtextArea y le cambia el color del Background a blanco.
	 * 
	 * @param textArea
	 */
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
	/**
	 * Devuelve el array de páginas
	 * 
	 * @return
	 */
	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}
	/**
	 * Añade una nueva página al libro
	 * 
	 * @param inicioPagina
	 * @param finPagina
	 */
	public void anadirPagina(long inicioPagina, long finPagina) {
		this.paginas.add(new Pagina(inicioPagina, finPagina));
	}
}
