/** 
 *<h2> Clase MySQL </h2> 
 *
 * Ccontiene todos los métodos para hacer lamadas al servidor
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.0.5
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

    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String USER="root";
    private static final String PASS="alumno";
    private static final String HOST="localhost";
    private static final int PORT=3308;
    private static final String DB ="NotasEntornos";
    private static final String URL=String.format("jdbc:mysql://%s:%d/%s?useSSL=false&serverTimezone=UTC", HOST, PORT, DB);

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
            conexion= (Connection) DriverManager.getConnection(URL, USER, PASS);
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
     * @param nombre: Nombre de la persona
     * @param primerApellido: primerApellido de la persona
     * @param segundoApellido: segundoApellido de la persona
     * @param notaFinal: notaFinal de la persona(dos decimales)
     */
    public void insertarDatos( String nombre, String primerApellido,String segundoApellido, double notaFinal) {
        /*INSERT INTO Alumnos (nombre, primerApellido, segundoApellido, notaFinal)
            VALUES ("Peter", "rock", "bless", 8.40);*/
        try {
            String Query = "INSERT INTO Alumnos (nombre, primerApellido, "
            		+ "segundoApellido, notaFinal) VALUES ("
                    + "\"" + nombre + "\", "
                    + "\"" + primerApellido + "\", "
                    + "\"" + segundoApellido + "\","
                    + notaFinal + ");";
            
            //lanzamos el comando al servidor
            System.out.println(Query);
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
            
        } catch (SQLException ex) {
        	
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
    
    
    /**
     * Recogerá todos los datos de la tabla del servidor
     * 
     * @return devolverá una cadena String con todos los datos separados por /
     */
    public String getValues() {
        //SELECT * FROM datos_persona
    	
        String datos="";
        
        try {
            String Query = "SELECT * FROM  Alumnos";
            
            //lanzamos el comando al servidor
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            //recogerá todos los datos enviados por el servidor mientras haya.
            while (resultSet.next()) {
                datos+=resultSet.getString("idAlumno") + "/"
                        + resultSet.getString("nombre") + "/" 
                        + resultSet.getString("primerApellido") + "/"
                        + resultSet.getString("segundoApellido")+"/"
                        + resultSet.getString("notaFinal")+"/";
            }

        } catch (SQLException ex) {
            mensaje.errorPedirDatos();
        }
        return datos;
    }

    public void deleteRecord(String table_name, String ID) {
        try {
            String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
        }
    }
}
