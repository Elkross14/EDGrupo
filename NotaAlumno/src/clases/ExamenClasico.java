/**
 * <h2>Clase ExamenClasico</2>
 * 
 * Clase derivada de Examen. 
 * Todo lo necesario para crear una nota de un examen clasico.
 * 
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.1 
 */
package clases;

public class ExamenClasico extends Examen{
	
	/**
	 * variables de clase
	 */
	private double nota; 
	private int porcNotaGlobal;
	
	/**
	 * Constructor vacio
	 */
	public ExamenClasico() {
		nota=0;
		porcNotaGlobal=0;
	}
	
	/**
	 * Constructor con variables de clase
	 * @param nota: nota de examen cl�sico
	 * @param porcNotaGlobal: porcentaje de peso del examen en la nota global
	 */
	public ExamenClasico(double nota, int porcNotaGlobal) {
		this.nota=nota;
		this.porcNotaGlobal=porcNotaGlobal;
	}

	/**
	 * @return nota de examen cl�sico
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * @return porcentaje de peso del examen en la nota global
	 */
	public int getPorcNotaGlobal() {
		return porcNotaGlobal;
	}

	/**
	 * @param nota: nota de examen cl�sico
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * @param porcNotaGlobal: porcentaje de peso del examen en la nota global
	 */
	public void setPorcNotaGlobal(int porcNotaGlobal) {
		this.porcNotaGlobal = porcNotaGlobal;
	}
}
