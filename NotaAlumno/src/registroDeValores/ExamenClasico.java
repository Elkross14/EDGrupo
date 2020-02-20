/**
 * <h2>Clase ExamenClasico</2>
 * 
 * Todo lo necesario para crear una nota de un examen clasico.
 * 
 * �ltima actualizaci�n:
 * -Se ha mejorado la legibilidad
 * 
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.1.2
 */
package registroDeValores;

public class ExamenClasico {
	
	/**
	 * variables de clase
	 */
	private double nota; 
	private int porcNotaGlobal;
	
	/**
	 * Constructor vacio
	 */
	public ExamenClasico() {
		nota = 0.0;
		porcNotaGlobal = 0;
	}
	
	/**
	 * Constructor con variables de clase
	 * 
	 * @param nota: nota de notaTotal cl�sico
	 * @param porcNotaGlobal: porcentaje de peso del notaTotal en la nota global
	 */
	public ExamenClasico(double nota, int porcNotaGlobal) {
		this.nota = nota;
		this.porcNotaGlobal = porcNotaGlobal;
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param examenClasico: se le pasa como variable un objeto ExamenClasico
	 */
	public ExamenClasico(ExamenClasico examenClasico) {
		this.nota = examenClasico.nota;
		this.porcNotaGlobal = examenClasico.porcNotaGlobal;
	}

	/**
	 * @return nota de notaTotal cl�sico
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * @return porcentaje de peso del notaTotal en la nota global
	 */
	public int getPorcNotaGlobal() {
		return porcNotaGlobal;
	}

	/**
	 * @param nota: nota de notaTotal cl�sico
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * @param porcNotaGlobal: porcentaje de peso del notaTotal en la nota global
	 */
	public void setPorcNotaGlobal(int porcNotaGlobal) {
		this.porcNotaGlobal = porcNotaGlobal;
	}
}
