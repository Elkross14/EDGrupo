/** 
 *<h2> Clase VentanaNotas </h2> 
 *
 * Ventana gráfica para introducir las notas y otros
 * datos necesarios.
 * 
 * última actualización: 
 * -Se ha mejorado la legibilidad
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.0.5.3
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.MensajeError;
import clases.VerificacionDeDatos;
import registroDeValores.NotaTotal;
import registroDeValores.ExamenClasico;
import registroDeValores.Persona;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaNotas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldClasico1;
	private JTextField textFieldClasico2;
	private JTextField textFieldClasico3;
	private JTextField fieldCorrectasTest1;
	private JTextField fieldFalladasTest1;
	private JTextField fieldSinContestarTest1;
	private JTextField fieldSinContestarTest2;
	private JTextField fieldFalladasTest2;
	private JTextField fieldCorrectasTest2;
	private JTextField fieldRetrasos1;
	private JTextField fieldRetrasos2;
	private JTextField fieldRetrasos3;
	private JRadioButton rdbtnEntregadoTrabajo1;
	private JRadioButton rdbtnEntregadoTrabajo2;
	private JRadioButton rdbtnEntregadoTrabajo3;
	private JRadioButton rdbtnNoEntregadoTrabajo1;
	private JRadioButton rdbtnNoEntregadoTrabajo2;
	private JRadioButton rdbtnNoEntregadoTrabajo3;
	private JButton btnAtras;
	private JButton btnFinalizar;
	
	
	
	Persona persona = new Persona();
	NotaTotal notaTotal = new NotaTotal();
	ExamenClasico examenClasico = new ExamenClasico();
	MensajeError mensaje = new MensajeError();
	VerificacionDeDatos verifica = new VerificacionDeDatos();


	/**
	 * Create the frame.
	 */
	public VentanaNotas() {
		inicialVentana();
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param persona: objeto de clase Persona con todas sus variables
	 * @param notaTotal: objeto de clase NotaTotal con todas sus variables
	 */
	public VentanaNotas(Persona persona, NotaTotal notaTotal) {
		inicialVentana();
		
		this.persona = new Persona(persona);
		this.notaTotal = new NotaTotal(notaTotal);
	}
	
	
	/**
	 * Inicia y ajusta la ventana
	 */
	public void inicialVentana() {
		iniciarComponentes();
		agruparJRadioButton();
		
		setLocationRelativeTo(null);	//vista centrada
        setResizable(false);	//evita que se pueda cambiar el tamaño de la ventana
        setTitle("Nombre Alumno");	//pondrá titulo a la ventana
	}
	

	/**
	 * Agrupa los jRadioButton en sus grupos correspondientes
	 */
	public void agruparJRadioButton() {
		//primer trabajo
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rdbtnEntregadoTrabajo1);
		grupo1.add(rdbtnNoEntregadoTrabajo1);
		
		//segundo trabajo
		ButtonGroup grupo2 = new ButtonGroup();
		grupo2.add(rdbtnEntregadoTrabajo2);
		grupo2.add(rdbtnNoEntregadoTrabajo2);
		
		//tercer trabajo
		ButtonGroup grupo3 = new ButtonGroup();
		grupo3.add(rdbtnEntregadoTrabajo3);
		grupo3.add(rdbtnNoEntregadoTrabajo3);
	}
	
	
	
	/**
	 * Inicia las caracteristicas gráficas básicas de la ventana
	 */
	public void iniciarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClasico1 = new JLabel("NotaTotal Cl\u00E1sico 1:");
		
		textFieldClasico1 = new JTextField();
		textFieldClasico1.setColumns(10);
		
		JLabel lblClasico2 = new JLabel("NotaTotal Cl\u00E1sico 2:");
		
		textFieldClasico2 = new JTextField();
		textFieldClasico2.setColumns(10);
		
		JLabel lblClasico3 = new JLabel("NotaTotal Cl\u00E1sico 3:");
		
		textFieldClasico3 = new JTextField();
		textFieldClasico3.setColumns(10);
		
		JLabel lblTest1 = new JLabel("Ex. Test 1: (total max. 30)");
		
		JLabel lblNewLabel = new JLabel("Correctas:");
		
		fieldCorrectasTest1 = new JTextField();
		fieldCorrectasTest1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Incorrectas:");
		
		fieldFalladasTest1 = new JTextField();
		fieldFalladasTest1.setColumns(10);
		
		JLabel lblSinContestar = new JLabel("Sin contestar:");
		
		fieldSinContestarTest1 = new JTextField();
		fieldSinContestarTest1.setColumns(10);
		
		fieldSinContestarTest2 = new JTextField();
		fieldSinContestarTest2.setColumns(10);
		
		JLabel label = new JLabel("Sin contestar:");
		
		JLabel label_1 = new JLabel("Incorrectas:");
		
		fieldFalladasTest2 = new JTextField();
		fieldFalladasTest2.setColumns(10);
		
		fieldCorrectasTest2 = new JTextField();
		fieldCorrectasTest2.setColumns(10);
		
		JLabel label_2 = new JLabel("Correctas:");
		
		JLabel lblExTest = new JLabel("Ex. Test 2: (total max. 30)");
		
		JLabel lblNewLabel_3 = new JLabel("Trabajo de la evaluaci\u00F3n 1:");
		
		rdbtnEntregadoTrabajo1 = new JRadioButton("Entregado");
		
		rdbtnNoEntregadoTrabajo1 = new JRadioButton("No entregado");
		
		JLabel lblTrabajoDeLa = new JLabel("Trabajo de la evaluaci\u00F3n 2:");
		
		rdbtnEntregadoTrabajo2 = new JRadioButton("Entregado");
		
		rdbtnNoEntregadoTrabajo2 = new JRadioButton("No entregado");
		
		JLabel lblTrabajoDeLa_1 = new JLabel("Trabajo de la evaluaci\u00F3n 3:");
		
		rdbtnEntregadoTrabajo3 = new JRadioButton("Entregado");
		
		rdbtnNoEntregadoTrabajo3 = new JRadioButton("No entregado");
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinalizarActionPerformed(e);
			}
		});
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAtrasActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Dias de retraso:");
		
		fieldRetrasos1 = new JTextField();
		fieldRetrasos1.setColumns(10);
		
		JLabel label_3 = new JLabel("Dias de retraso:");
		
		fieldRetrasos2 = new JTextField();
		fieldRetrasos2.setColumns(10);
		
		JLabel label_4 = new JLabel("Dias de retraso:");
		
		fieldRetrasos3 = new JTextField();
		fieldRetrasos3.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblTest1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSinContestar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(fieldSinContestarTest1))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(fieldFalladasTest1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(26)
									.addComponent(fieldCorrectasTest1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAtras)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnFinalizar)
									.addGap(16))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblExTest, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(fieldCorrectasTest2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(fieldFalladasTest2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(fieldSinContestarTest2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClasico1)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClasico2, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClasico3, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldClasico3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(textFieldClasico2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
								.addComponent(textFieldClasico1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
							.addGap(223))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnEntregadoTrabajo1)
							.addGap(18)
							.addComponent(rdbtnNoEntregadoTrabajo1)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldRetrasos1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(81, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTrabajoDeLa, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnEntregadoTrabajo2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnNoEntregadoTrabajo2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldRetrasos2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTrabajoDeLa_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnEntregadoTrabajo3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnNoEntregadoTrabajo3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldRetrasos3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTest1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(fieldCorrectasTest1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(fieldFalladasTest1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSinContestar)
								.addComponent(fieldSinContestarTest1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClasico1)
								.addComponent(textFieldClasico1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClasico2)
								.addComponent(textFieldClasico2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblClasico3)
								.addComponent(textFieldClasico3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblExTest)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(label_2))
								.addComponent(fieldCorrectasTest2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(label_1))
								.addComponent(fieldFalladasTest2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(label))
								.addComponent(fieldSinContestarTest2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(rdbtnEntregadoTrabajo1)
						.addComponent(lblNewLabel_2)
						.addComponent(fieldRetrasos1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNoEntregadoTrabajo1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrabajoDeLa)
						.addComponent(rdbtnEntregadoTrabajo2)
						.addComponent(rdbtnNoEntregadoTrabajo2)
						.addComponent(label_3)
						.addComponent(fieldRetrasos2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrabajoDeLa_1)
						.addComponent(rdbtnEntregadoTrabajo3)
						.addComponent(rdbtnNoEntregadoTrabajo3)
						.addComponent(label_4)
						.addComponent(fieldRetrasos3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFinalizar)
						.addComponent(btnAtras))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	/**
	 * Inicia todo el proceso para pasar los datos al servidor
	 * 
	 * @param evt click izquierzo en el botón Finalizar
	 */
	private void btnFinalizarActionPerformed(ActionEvent evt) {
		
	}
	
	
	/**
	 * Vuelve a la pantalla de VentanaNombre. Si se ha rellenado
	 * algún campo se guardará temporalmente.
	 * 
	 * @param evt click izquierzo en el botón Atrás
	 */
	private void btnAtrasActionPerformed(ActionEvent evt) {
		VentanaNombre pasar = new VentanaNombre(persona, notaTotal);
		pasar.setVisible(true);
		dispose();
	}
	
	
	/**
	 * recoge todos los datos introducidos en los campos de esta ventana.
	 */
	public void recogerDatos() {
		recogerDatosExamenesTest();
		recogerDatosExamenesClasicos();
		
	}
	
	
	/**
	 * Recoge todos los parámetos de los examenes tipo test
	 */
	public void recogerDatosExamenesTest() {
		
		int [] correctasExamenTest = new int [notaTotal.getNUM_EXAMENES_TEST()];
		int [] falladasExamenTest = new int [notaTotal.getNUM_EXAMENES_TEST()];
		int [] sinContestarExamenTest = new int [notaTotal.getNUM_EXAMENES_TEST()];
		
		correctasExamenTest[0] = Integer.parseInt(fieldCorrectasTest1.getText());
		falladasExamenTest[0] = Integer.parseInt(fieldFalladasTest1.getText());
		sinContestarExamenTest[0] = Integer.parseInt(fieldSinContestarTest1.getText());
		
		correctasExamenTest[1] = Integer.parseInt(fieldCorrectasTest2.getText());
		falladasExamenTest[1] = Integer.parseInt(fieldFalladasTest2.getText());
		sinContestarExamenTest[1] = Integer.parseInt(fieldSinContestarTest2.getText());
		
		notaTotal.setRespuestasExamenTest(correctasExamenTest, falladasExamenTest, sinContestarExamenTest);
		
	}
	
	
	/**
	 * Recoge las notas de los examenes clásicos
	 */
	public void recogerDatosExamenesClasicos() {
		
		double [] NotaExamenClasico = new double [notaTotal.getNUM_EXAMENES_CLASICOS()];
		
		NotaExamenClasico[0] = Double.parseDouble(textFieldClasico1.getText());
		NotaExamenClasico[1] = Double.parseDouble(textFieldClasico2.getText());
		NotaExamenClasico[2] = Double.parseDouble(textFieldClasico3.getText());	
		
		notaTotal.setNotaExamenClasico(NotaExamenClasico);
	}

	
	public void recogerTrabajos() {
		
		int entregado = 0;
		int diasDeRetraso;
		
		
		
	}
	
	
}


