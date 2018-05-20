package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import modelo.Legible;
import modelo.Libro;

public class LegibleTest {
	Legible instancia;
	
	@Before
	public void setUp(){
		instancia=new Libro();
	}

	@Test
	public void testAvanzarPagina() {
		int paginaActual=((Libro)instancia).getActual();
		instancia.avanzarPagina();
		assertEquals(paginaActual+1, ((Libro)instancia).getActual());
		//Nos queda por probar que la ultima pagina no permite avanzar
		
	}

	@Test
	public void testRetrocederPagina() {
		fail("Not yet implemented");
		//hay que comprobar que no se la primera pagina para poder retroceder
	}

	@Test
	public void testMarcarPagina() {
		fail("Not yet implemented");
	}

	@Test
	public void testIrAPagina() {
		fail("Not yet implemented");
	}

}
