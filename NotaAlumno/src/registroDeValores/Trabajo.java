/**
 * <h2>Clase Trabajo</2>
 * 
 * Todo lo necesario para crear los trabajos.
 * 
 * Última actualización:
 * -Se ha finalizado la primera versión de la clase
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1
 */


package registroDeValores;

public class Trabajo {

	private boolean entregado;
	private int diasDeRetraso;

	
	/**
	 * Constructor vacio
	 */
	public Trabajo() {
		entregado = true;
		diasDeRetraso = 0;
	}

	
	/**
	 * Costructor con variables de clase
	 * 
	 * @param entregado: es de tipo boolean. true equivale a que se ha entregado el trabajo
	 * @param diasDeRetraso: es la cantidad de días que se tarda en entregar el trabajo
	 */
	public Trabajo(boolean entregado, int diasDeRetraso) {
		this.entregado = entregado;
		this.diasDeRetraso = diasDeRetraso;
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param trabajo: es un objeto de tipo Trabajo
	 */
	public Trabajo(Trabajo trabajo) {
		this.entregado = trabajo.entregado;
		this.diasDeRetraso = trabajo.diasDeRetraso;
	}


	/**
	 * @return devolverá si se ha entregado el trabajo. true equivale a que se ha entregado el trabajo
	 */
	public boolean isEntregado() {
		return entregado;
	}


	/**
	 * @return devolverá la cantidad de días que se ha tardado en entregar el trabajo
	 */
	public int getDiasDeRetraso() {
		return diasDeRetraso;
	}


	/**
	 * @param entregado: es de tipo boolean. true equivale a que se ha entregado el trabajo
	 */
	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}


	/**
	 * @param diasDeRetraso: es la cantidad de días que se tarda en entregar el trabajo
	 */
	public void setDiasDeRetraso(int diasDeRetraso) {
		this.diasDeRetraso = diasDeRetraso;
	}
}