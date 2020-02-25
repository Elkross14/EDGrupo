/** 
 *<h2> Clase MySQL </h2> 
 *
 * Ccontiene todos los métodos para hacer lamadas al servidor
 * 
 * Última actualización:
 * -Se ha modificado el método totalRows
 * -Se ha modificado el método getValues
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.1
 */
package clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import registroDeValores.NotaTotal;
import registroDeValores.Persona;

public class MySQL {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "alumno";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DB = "notasentornos";
    private static final String URL = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", HOST, PORT, DB);

    private static Connection conexion;
    
    
    Persona persona = new Persona();
	NotaTotal notaTotal = new NotaTotal();
    MensajeError mensaje = new MensajeError();
    
    
    /**
     * Crea la conexión con la base de datos introducida
     */
    public void MySQLConnection() {
    	try{
            
            Class.forName(DRIVER);
            conexion= (Connection) DriverManager.getConnection(URL, USER, PASS);// Nos conectamos a la bd
            System.out.println("Conectado");
        }
        catch (ClassNotFoundException | SQLException e){// Si la conexion NO fue exitosa mostramos un mensaje de error
            
            System.out.println("Error de conexion: " + e);
        }
    }


    /**
     * Cierra la conexión con el servidor
     */
    public void closeConnection() {
        try {
            conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    /**
     * Inserta los valores pasados a la tabla Alumnos de la DB NotasEntornos
     * 
     * Comando ejemplo:  INSERT INTO Alumnos (nombre, primerApellido, segundoApellido, notaFinal)
     * 		VALUES ("Peter", "rock", "bless", 8.40);
     * 
     * @param persona: objeto de tipo persona para pasarle los datos de esta clase
     * @param notaTotal: objeto de tipo NotaTotal para obtener la nota
     */
    public void insertarDatos(Persona persona, NotaTotal notaTotal) {       
    	MySQLConnection();
    	
        try {
        	
            String Query = "INSERT INTO Alumnos (nombre, primerApellido, "
            		+ "segundoApellido, notaFinal) VALUES ("
                    + "\"" + persona.getNombre() + "\", "
                    + "\"" + persona.getPrimerApellido() + "\", "
                    + "\"" + persona.getSegundoApellido() + "\","
                    + notaTotal.getNotaGlobal() + ");";
            
            System.out.println(Query);
            //lanzamos el comando al servidor
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            
            mensaje.envioCorrecto();
            
        } catch (SQLException ex) {
        	
        	mensaje.envioIncorrecto();
        }
        
        closeConnection();
    }
    
    
    /**
     * Recogerá todos los datos de la tabla del servidor
     * 
     * Comando ejemplo:  SELECT * FROM Alumnos
     * 
     * @return devolverá una cadena String con todos los datos separados por /
     */
    public String getValues() {
    	MySQLConnection();
    	
        String datos="";
        
        try {
            String Query = "SELECT * FROM  Alumnos;";
            
            //lanzamos el comando al servidor
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            //recogerá todos los datos enviados por el servidor mientras haya.
            while (resultSet.next()) {
                datos += resultSet.getString("idAlumno") + "/"
                        + resultSet.getString("nombre") + "/" 
                        + resultSet.getString("primerApellido") + "/"
                        + resultSet.getString("segundoApellido") + "/"
                        + resultSet.getString("notaFinal") + "/";
           }

        } catch (SQLException ex) {
        	System.out.println("Excepción encontrada: "+ ex);
            mensaje.errorPedirDatos();
        }
        closeConnection();
        return datos;
    }
    
    
    /**
     * Le pedimos al servidor que nos diga la cantidad total de filas que tiene una determinada tabla
     * 
     *  Comando ejemplo:  SELECT * FROM Alumnos
     * 
     * @param table_name: tabla de la que se quiere saber la cantidad de lineas
     * @return devolverá un número entero con la cantidad de lineas
     */
    public int totalRows(String table_name) {
    	MySQLConnection();
    	
        int totalRows = 0;
        
        try {
            String Query = "SELECT COUNT(*) FROM " + table_name;
            
            //lanzamos el comando al servidor
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while (resultSet.next()) {
                totalRows=resultSet.getInt(1);	//recoge el dato pedido al servidor
            }

        } catch (SQLException ex) {
             mensaje.errorPedirDatos();
        }
        closeConnection();
        return totalRows;
    }

    
    /**
     * Elimina una linea de la tabla Alumno de la base de datos 
     * 
     * @param ID: identificador de la persona que se quiere eliminar
     */
    public void deleteRecord( String ID) {
        try {
            String Query = "DELETE FROM Alumnos WHERE idAlumno = \"" + ID + "\"";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
    
    
}