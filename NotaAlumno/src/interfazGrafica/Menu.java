/** 
 *<h2> Clase Menu </h2> 
 *
 * Ventana gráfica para elegir entre varias funciones.
 * 
 * última actualización: 
 * -Se ha eliminado el botón cerrar
 * -Se ha añadido función al botón VerTabla
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.1
 */

package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton btnAñadirAlumno;
	private JButton btnVerTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Menu() {
		inicialVentana();
	}
	
	
	/**
	 * Inicia y ajusta la ventana
	 */
	public void inicialVentana() {
		iniciarComponentes();
		
		setLocationRelativeTo(null);	//vista centrada
        setResizable(false);	//evita que se pueda cambiar el tamaño de la ventana
        setTitle("Menu");	//pondrá titulo a la ventana
	}
	
	
	/**
	 * Inicia las caracteristicas gráficas básicas de la ventana
	 */
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAñadirAlumno = new JButton("A\u00F1adir Alumno");
		btnAñadirAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAñadirAlumnoActionPerformed(e);
			}
		});
		
		btnVerTabla = new JButton("Ver Tabla");
		btnVerTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVerTablaActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnVerTabla, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAñadirAlumno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(btnAñadirAlumno)
					.addGap(18)
					.addComponent(btnVerTabla)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	/**
	 * Llama a la clase VentanaNombre en el caso de que haya conexión con el servidor
	 * 
	 * @param e: click izquierzo en el botón Siguiente
	 */
	public void btnAñadirAlumnoActionPerformed(ActionEvent e) {
		VentanaNombre pasar = new VentanaNombre();
		pasar.setVisible(true);
		dispose();
	}
	
	
	/**
	 * Llama a la clase VerTabla para visualizar los datos introducidos
	 * 
	 * @param e: click izquierzo en el botón Siguiente
	 */
	public void btnVerTablaActionPerformed(ActionEvent e) {
		VentanaTabla pasar = new VentanaTabla();
		pasar.setVisible(true);
		dispose();
	}
	
	
}
