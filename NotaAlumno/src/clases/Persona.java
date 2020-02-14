/** 
 *<h2> Clase Persona </h2> 
 *
 * Almacena todos los datos necesarios de la persona.
 * @author Pablo Dur�n, H�ctor Garc�a
 * @version 0.1 
 */

package clases;

public class Persona {
	
	//variables de clase
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	
	/**
	 * Constructor vacio
	 */
	public Persona () {
		nombre="Sin nombre";
		primerApellido="Sin Primer apellido";
		segundoApellido="Sin segundo apellido";
	}
	
	/**
	 * Constructor con variables de clase
	 * @param nombre: Nombre de la persona
	 * @param primerApellido: Primer apellido de la persona
	 * @param segundoApellido: Segundo apellido de la persona
	 */
	public Persona (String nombre, String primerApellido,String segundoApellido) {
		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.primerApellido=primerApellido;
	}
	
	/**
	 * @return the nombre: nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the primerApellido: primer apellido de la persona
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @return the segundoApellido: segundo apellido de la persona
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param nombre: nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param primerApellido: primer apellido de la persona
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @param segundoApellido: segundo apellido de la persona
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	
}
