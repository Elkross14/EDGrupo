/** 
 *<h2> Clase MySQL </h2> 
 *
 * Ccontiene todos los métodos para hacer lamadas al servidor
 * 
 * Última actualización:
 * -Se ha mejorado la legibilidad
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

public class MySQL {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "alumno";
    private static final String HOST = "localhost";
    private static final int PORT = 3308;
    private static final String DB = "NotasEntornos";
    private static final String URL = String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", HOST, PORT, DB);

    private static boolean verificar;
    private static Connection conexion;
    
    
    MensajeError mensaje = new MensajeError();
    
    
    /**
     * Crea la conexión con la base de datos introducida
     * 
     * @return devolverá true en caso de establecer la conexión
     */
    public boolean MySQLConnection() {
        
        verificar = false;
        
        try{
            
            Class.forName(DRIVER);
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASS);
            verificar = true;
        }
        catch (ClassNotFoundException | SQLException e){
            
            System.out.println("Error de conexion: " + e);
        }
        
        return verificar;
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
     * @param nombre: Nombre de la persona
     * @param primerApellido: primerApellido de la persona
     * @param segundoApellido: segundoApellido de la persona
     * @param notaFinal: notaFinal de la persona(dos decimales)
     */
    public void insertarDatos(String nombre, String primerApellido,String segundoApellido, double notaFinal) {
       
        try {
            String Query = "INSERT INTO Alumnos (nombre, primerApellido, "
            		+ "segundoApellido, notaFinal) VALUES ("
                    + "\"" + nombre + "\", "
                    + "\"" + primerApellido + "\", "
                    + "\"" + segundoApellido + "\","
                    + notaFinal + ");";
            
            //lanzamos el comando al servidor
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            
            mensaje.envioCorrecto();
            
        } catch (SQLException ex) {
        	
        	mensaje.envioIncorrecto();
        }
    }
    
    
    /**
     * Recogerá todos los datos de la tabla del servidor
     * 
     * Comando ejemplo:  SELECT * FROM Alumnos
     * 
     * @return devolverá una cadena String con todos los datos separados por /
     */
    public String getValues() {
    	
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
            mensaje.errorPedirDatos();
        }
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
    	
        int totalRows = 0;
        
        try {
            String Query = "SELECT COUNT(*) FROM " + table_name;	//comando lanzado al servidor
            
            //lanzamos el comando al servidor
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
            
            while (resultSet.next()) {
                totalRows=resultSet.getInt(1);	//recoge el dato pedido al servidor
            }

        } catch (SQLException ex) {
             mensaje.errorPedirDatos();	//saltará en el caso de que haya algún tipo de error a la hora de pedir los datos al servidor
        }
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