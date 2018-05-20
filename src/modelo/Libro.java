package modelo;

import java.util.ArrayList;

public class Libro implements Legible {

	private String lectura;
	private int actual = 0;
	private int marca = 0;
	private int ultima=-1;
	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		this.marca = 0;
		this.actual = 0;
		lectura = "JuegoTronos.txt";
		paginas = new ArrayList<>();
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
		if(comprobarUltimaPagina()) {
		return false;
		}else {
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
		if (this.actual == 0) {
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
		if(ultima == actual) {
			return true;
		}else {
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

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getPagActual() {
		return actual - 1;
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
