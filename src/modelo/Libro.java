package modelo;

import java.util.ArrayList;

public class Libro implements Legible {

	private String lectura;
	private int actual = 0;
	private int marca = 0;
	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		lectura = "JuegoTronos.ddc";
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
 * @return
 */
	private boolean cargarSiguientePagina() {
		anadirPagina();
		
		return true;
		
		}
	
	/**
	 * comprueba si es la primera pagina
	 * @return true es la primera, y false si no lo es.
	 */
	private boolean comprobarPrimeraPagina() {
		if (this.actual == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * carga la pagina pasada como parametro
	 * @param pagina
	 * @return
	 */
	
//	private boolean cargarPagina(int pagina) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	
	private boolean comprobarUltimaPagina() {
		return false;
	}
/**
 * Retrocede una pagina
 */
	@Override
	public void retrocederPagina() {
		if(!comprobarPrimeraPagina()) {
		actual--;
		}else {
			System.out.println("no se puede retroceder, estas en la primera pagina");
		}
	}
/**
 * marca la pagina actual
 */
	@Override
	public void marcarPagina() {
	this.marca=this.actual;

	}

	/**
	 * va a la pagina marcada
	 */
	@Override
	public void irAPagina() {
	this.actual=this.marca;

	}

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getMarca() {
		return marca;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}

//	public void actualizarTextArea() {
//		actualizarNumPagina();
//		Pagina pagina = this.libro.getPaginas().get(this.libro.getActual());
//		this.textArea.setText(
//				new AlmacenLibro(this.libro.getLectura()).leer().substring(pagina.getPrimer(), pagina.getUltimo()));
//	}
	
	private void anadirPagina() {
		int numeroCaracteresPagina = 20;
		int inicioPagina = (actual+1) * numeroCaracteresPagina;
		int finPagina = (actual+1) * numeroCaracteresPagina + numeroCaracteresPagina;
		this.paginas.add(new Pagina(inicioPagina, finPagina));
	}
}
