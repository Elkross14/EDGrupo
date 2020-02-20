/** 
 *<h2> Clase VentanaNombre </h2> 
 *
 * Ventana gráfica para introducir el nombre
 * completo de la persona.
 * 
 * última actualización: 
 * -Mejora de legibilidad
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.1
 */


package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.MensajeError;
import clases.VerificacionDeDatos;
import registroDeValores.NotaTotal;
import registroDeValores.Persona;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaNombre extends JFrame {

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
	NotaTotal notaTotal = new NotaTotal();
	MensajeError mensaje = new MensajeError();
	VerificacionDeDatos verifica = new VerificacionDeDatos();
	
	

	
	/**
	 * Create the frame.
	 */
	public VentanaNombre() {
		iniciarVentana();
	}
	
	/**
	 * Constructor copia
	 * 
	 * @param persona: objeto de clase Persona con todas sus variables
	 * @param notaTotal: objeto de clase NotaTotal con todas sus variables
	 */
	public VentanaNombre(Persona persona, NotaTotal notaTotal) {
		iniciarVentana();
		
		this.persona = new Persona(persona);
		this.notaTotal = new NotaTotal(notaTotal);
	}
	
	
	/**
	 * Inicia y ajusta la ventana
	 */
	public void iniciarVentana() {
		iniciarComponentes();
		
		setLocationRelativeTo(null);//vista centrada
        setResizable(false);//evita que se pueda cambiar el tamaño de la ventana
        setTitle("Nombre Alumno");//pondrá titulo a la ventana
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
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAtrasActionPerformed(e);
			}
		});
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
	

	/**
	 * Inicia todo el proceso para pasar los datos a la siguiente ventana (VentanaNotas)
	 * 
	 * @param evt click izquierzo en el botón Siguiente
	 */
	private void btnSiguienteActionPerformed(ActionEvent evt) {
		
		if(verificaDatos()) {
			
			recogerDatos();
			
			VentanaNotas pasar = new VentanaNotas(persona, notaTotal);
			pasar.setVisible(true);
			dispose();
		}
		
	}
	
	
	/**
	 * Vuelve a la pantalla de Menu. Se perderán los datos introducidos.
	 * 
	 * @param evt click izquierzo en el botón Atrás
	 */
	private void btnAtrasActionPerformed(ActionEvent evt) {
		if (mensaje.preguntaAtras() == 0) {
			Menu pasar = new Menu();
			pasar.setVisible(true);
			dispose();
		}
	}
	
	
	/**
	 * recoge todos los datos introducidos en los campos de esta ventana.
	 */
	public void recogerDatos() {
		persona.setNombre(EliminarEspaciosSobrantes(textFieldNombre.getText()));
		persona.setPrimerApellido(EliminarEspaciosSobrantes(textFieldPrimerApellido.getText()));
		persona.setSegundoApellido(EliminarEspaciosSobrantes(textFieldSegundoApellido.getText()));
	}
	
	
	/**
	 * Elimina todos los excesos de espacios que haya en la entrada de datos.
	 * 
	 * @param cadena: String al que se le quiere eliminar el exceso de espacios
	 * @return String con solo un espacio entre palabras y sin espacios por delante y atrás.
	 */
	public String EliminarEspaciosSobrantes(String cadena) {
		
		cadena = cadena.replaceAll(" +", " ").trim();
		
		return cadena;
	}
	
	
	/**
	 * Verificará todos los campos de datos a introducir para saber si es correcto el dato
	 */
	public boolean verificaDatos () {
		
		if(!verificaNombre()) {
			return false;
		}
		else if(!verificaPrimerApellido()) {
			return false;
		}
		else if(!verificaSegundoApellido()) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Verifica que el nombre esté relleno y que no tenga números ni caracteres extraños
	 * 
	 * @return true en caso de estár todo correcto
	 */
	public boolean verificaNombre() {
		if(verifica.campoRelleno(textFieldNombre.getText())){
            mensaje.vacioCampo("Nombre");
            return false;
        }
		else if (verifica.correctoString(textFieldNombre.getText())){
            mensaje.errorString("Nombre");
            return false;
        }
		return true;
	}
	
	
	/**
	 * Verifica que el primer apellido esté relleno y que no tenga números ni caracteres extraños
	 * 
	 * @return true en caso de estár todo correcto
	 */
	public boolean verificaPrimerApellido() {
		if(verifica.campoRelleno(textFieldPrimerApellido.getText())){
            mensaje.vacioCampo("Primer Apellido");
            return false;
        }
		else if (verifica.correctoString(textFieldPrimerApellido.getText())){
            mensaje.errorString("Primer Apellido");
            return false;
        }
		return true;
	}
	
	
	/**
	 * Verifica que el primer apellido esté relleno y que no tenga números ni caracteres extraños
	 * 
	 * @return true en caso de estár todo correcto
	 */
	public boolean verificaSegundoApellido() {
		if(verifica.campoRelleno(textFieldSegundoApellido.getText())){
            mensaje.vacioCampo("Segundo Apellido");
            return false;
        }
		else if (verifica.correctoString(textFieldSegundoApellido.getText())){
            mensaje.errorString("Segundo Apellido");
            return false;
        }
		return true;
	}
	
	
}
