package jUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.VerificacionDeDatos;

class VerificarVerificacionDeDatos {

	public VerificacionDeDatos verifica = new VerificacionDeDatos ();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRangoNotaExDentroRango() {
		
		boolean algo = verifica.rangoNotaEx("8");
		
		assertEquals(false,algo);
	}
	
	@Test
	void testRangoNotaExFueraRango() {
		
		boolean algo = verifica.rangoNotaEx("11");
		
		assertEquals(false,algo);
	}
	
	@Test
	void testRangoNotaExMaximo() {
		
		boolean algo = verifica.rangoNotaEx("10");
		
		assertEquals(false,algo);
	}
	
	@Test
	void testRangoNotaExMinimo() {
		
		boolean algo = verifica.rangoNotaEx("0");
		
		assertEquals(false,algo);
	}

}
