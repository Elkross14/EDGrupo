/** 
 *<h2> Clase VentanaTabla </h2> 
 *
 * Ventana gráfica para visualizar los datos de la base de datos.
 * 
 * última actualización: 
 * -Creación de la clase
 * -falta la opción de eliminar alumno
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.0.5
 */

package interfazGrafica;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.MySQL;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaTabla extends JFrame {

	private JPanel contentPane;
	
	
	private JTable table;
	private JButton btnBorrarAlumno;
	private JButton btnAtras;

	MySQL conexion = new MySQL();
	
	
	/**
	 * Create the frame.
	 */
	public VentanaTabla() {
		iniciarVentana();
		mostrarValores();
	}
	
	
	/**
	 * Inicia y ajusta la ventana
	 */
	public void iniciarVentana() {
		iniciarComponentes();
		
		setLocationRelativeTo(null);	//vista centrada
        setTitle("Notas");	//pondrá titulo a la ventanag
	}
	
	
	/**
	 * Inicia las caracteristicas gráficas básicas de la ventana
	 */
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAtrasActionPerformed(e);
			}
		});
		
		btnBorrarAlumno = new JButton("Borrar Alumno");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBorrarAlumno)
					.addPreferredGap(ComponentPlacement.RELATED, 529, Short.MAX_VALUE)
					.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras)
						.addComponent(btnBorrarAlumno))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nombre", "Primer Apellido", "Segundo Apellido", "Nota global"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	/**
	 * Vuelve a la pantalla de Menú.
	 * 
	 * @param evt click izquierzo en el botón Atrás
	 */
	private void btnAtrasActionPerformed(ActionEvent evt) {
		Menu pasar = new Menu();
		pasar.setVisible(true);
		dispose();
	}
	
	
	/**
	 * Asigna los valores recibidos por la base de datos a la tabla
	 */
	public void mostrarValores(){
        
        String datosTotal = conexion.getValues();
        String[] partes = datosTotal.split("/");
        
        int contador =0;
        for (int fila = 0; fila < conexion.totalRows("alumnos"); fila++) {
            for (int columna = 0; columna < 5; columna++) {
            	table.setValueAt(partes[contador],fila,columna);

                contador++;
            }
        } 
    }
}
