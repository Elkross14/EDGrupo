/** 
 *<h2> Clase Menu </h2> 
 *
 * Ventana gráfica para elegir entre varias funciones.
 * 
 * última actualización: 
 * -Se ha creado la clase
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.0.5 
 */

package interfaz;

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
	private JButton btnCerrarPrograma;

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
		
		setLocationRelativeTo(null);//vista centrada
        setResizable(false);//evita que se pueda cambiar el tamaño de la ventana
        setTitle("Menu");//pondrá titulo a la ventana
	}
	
	
	/**
	 * Inicia las caracteristicas gráficas básicas de la ventana
	 */
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 200);
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
		
		btnCerrarPrograma = new JButton("Cerrar Programa");
		btnCerrarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCerrarProgramaActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnAñadirAlumno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnVerTabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCerrarPrograma))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(btnAñadirAlumno)
					.addGap(18)
					.addComponent(btnVerTabla)
					.addGap(18)
					.addComponent(btnCerrarPrograma)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * Llama a la clase DatosNombre en el caso de que haya conexión con el servidor
	 * 
	 * @param e: click izquierzo en el botón Siguiente
	 */
	public void btnAñadirAlumnoActionPerformed(ActionEvent e) {
		DatosNombre pasar = new DatosNombre();
		pasar.setVisible(true);
		dispose();
	}
	
	/**
	 * Llama a la clase VerTabla para visualizar los datos introducidos
	 * 
	 * @param e: click izquierzo en el botón Siguiente
	 */
	public void btnVerTablaActionPerformed(ActionEvent e) {
		
	}

/**
 * Cerrará el programa
 * 
 * @param e: click izquierzo en el botón Siguiente
 */
	public void btnCerrarProgramaActionPerformed(ActionEvent e) {
		System.exit(0);;
	}
}
