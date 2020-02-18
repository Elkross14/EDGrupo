/**
 * <h2>Clase ExamenClasico</2>
 * 
 * Clase derivada de Examen. 
 * Todo lo necesario para crear una nota de un examen clasico.
 * 
 * Última actualización:
 * -Se ha añadido el constructor copia
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.1
 */
package VariablesDelPrograma;

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
	 * 
	 * @param nota: nota de examen clásico
	 * @param porcNotaGlobal: porcentaje de peso del examen en la nota global
	 */
	public ExamenClasico(double nota, int porcNotaGlobal) {
		this.nota=nota;
		this.porcNotaGlobal=porcNotaGlobal;
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param examenClasico: se le pasa como variable un objeto ExamenClasico
	 */
	public ExamenClasico(ExamenClasico examenClasico) {
		this.nota=examenClasico.nota;
		this.porcNotaGlobal=examenClasico.porcNotaGlobal;
	}

	/**
	 * @return nota de examen clásico
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
	 * @param nota: nota de examen clásico
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
