/** 
 *<h2> Clase DatosNombre </h2> 
 *
 * Ventana gráfica para introducir el nombre
 * completo de la persona.
 * @author Pablo Durán, Héctor García
 * @version 0.0.5 
 */


package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Persona;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosNombre extends JFrame {

	/**
	 * Variables gráficas
	 */
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblPrimerApellido;
	private JLabel lblSegudnoApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldPrimerApellido;
	private JTextField textFieldSegundoApellido;
	private JButton btnAtras;
	private JButton btnSiguiente;

	Persona persona = new Persona();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosNombre frame = new DatosNombre();
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
	public DatosNombre() {
		inicialVentana();
	}
	
	/**
	 * Inicia y ajusta la ventana
	 */
	public void inicialVentana() {
		iniciarComponentes();
		
		setLocationRelativeTo(null);//vista centrada
        setResizable(false);//evita que se pueda cambiar el tamaño de la ventana
        setTitle("Notas Alumno");//pondrá titulo a la ventana
	}
	
	/**
	 * Inicia las caracteristicas gráficas básicas de la ventana
	 */
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNombre = new JLabel("Nombre:");
		
		lblPrimerApellido = new JLabel("Primer Apellido:");
		
		lblSegudnoApellido = new JLabel("Segundo Apellido:");
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldPrimerApellido = new JTextField();
		textFieldPrimerApellido.setText("");
		textFieldPrimerApellido.setColumns(10);
		
		textFieldSegundoApellido = new JTextField();
		textFieldSegundoApellido.setColumns(10);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSiguienteActionPerformed(e);
			}
		});
		
		btnAtras = new JButton("Atr\u00E1s");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(18)
							.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrimerApellido)
							.addGap(18)
							.addComponent(textFieldPrimerApellido, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSegudnoApellido)
							.addGap(18)
							.addComponent(textFieldSegundoApellido, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAtras)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSiguiente)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrimerApellido)
						.addComponent(textFieldPrimerApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSegudnoApellido)
						.addComponent(textFieldSegundoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSiguiente)
						.addComponent(btnAtras))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void recogerDatos() {
		persona.setNombre(textFieldNombre.getText());
		persona.setPrimerApellido(textFieldPrimerApellido.getText());
		persona.setSegundoApellido(textFieldSegundoApellido.getText());
	}
	
	private void btnSiguienteActionPerformed(ActionEvent evt) {
		
	}
	
	
}
