/** 
 *<h2> Clase VentanaNotas </h2> 
 *
 * Ventana gráfica para introducir las notas y otros
 * datos necesarios.
 * 
 * última actualización: 
 * -Conectado con el servidor para enviar datos
 * -Arreglo de fallos en el sistema de verificación
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1
 */
package interfazGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.MensajeError;
import clases.MySQL;
import clases.VerificacionDeDatos;
import registroDeValores.NotaTotal;
import registroDeValores.ExamenClasico;
import registroDeValores.Persona;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaNotas extends JFrame {

	private JPanel contentPane;
	private JTextField fieldClasico1;
	private JTextField fieldClasico2;
	private JTextField fieldClasico3;
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
	MySQL conexion = new MySQL();


	/**
	 * Create the frame.
	 */
	public VentanaNotas() {
		iniciarVentana();
	}
	
	
	/**
	 * Constructor copia
	 * 
	 * @param persona: objeto de clase Persona con todas sus variables
	 * @param notaTotal: objeto de clase NotaTotal con todas sus variables
	 */
	public VentanaNotas(Persona persona, NotaTotal notaTotal) {
		iniciarVentana();
		
		this.persona = new Persona(persona);
		this.notaTotal = new NotaTotal(notaTotal);
	}
	
	
	/**
	 * Inicia y ajusta la ventana
	 */
	public void iniciarVentana() {
		iniciarComponentes();
		agruparJRadioButton();
		
		setLocationRelativeTo(null);	//vista centrada
        setResizable(false);	//evita que se pueda cambiar el tamaño de la ventana
        setTitle("Notas");	//pondrá titulo a la ventanag
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
		setBounds(100, 100, 544, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClasico1 = new JLabel("NotaTotal Cl\u00E1sico 1:");
		lblClasico1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasico1.setBounds(15, 181, 114, 14);
		
		fieldClasico1 = new JTextField();
		fieldClasico1.setBounds(145, 181, 86, 20);
		fieldClasico1.setColumns(10);
		
		JLabel lblClasico2 = new JLabel("NotaTotal Cl\u00E1sico 2:");
		lblClasico2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasico2.setBounds(15, 212, 114, 14);
		
		fieldClasico2 = new JTextField();
		fieldClasico2.setBounds(145, 212, 86, 20);
		fieldClasico2.setColumns(10);
		
		JLabel lblClasico3 = new JLabel("NotaTotal Cl\u00E1sico 3:");
		lblClasico3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasico3.setBounds(15, 243, 114, 14);
		
		fieldClasico3 = new JTextField();
		fieldClasico3.setBounds(145, 243, 86, 20);
		fieldClasico3.setColumns(10);
		
		JLabel lblTest1 = new JLabel("Ex. Test 1: (total max. "+notaTotal.getNUM_PREGUNTAS_TEST()+")");
		lblTest1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTest1.setBounds(15, 19, 160, 14);
		
		JLabel lblNewLabel = new JLabel("Correctas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(15, 44, 86, 14);
		
		fieldCorrectasTest1 = new JTextField();
		fieldCorrectasTest1.setBounds(105, 41, 110, 20);
		fieldCorrectasTest1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Falladas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(15, 75, 86, 14);
		
		fieldFalladasTest1 = new JTextField();
		fieldFalladasTest1.setBounds(105, 72, 110, 20);
		fieldFalladasTest1.setColumns(10);
		
		JLabel lblSinContestar = new JLabel("Sin contestar:");
		lblSinContestar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinContestar.setBounds(15, 106, 86, 14);
		
		fieldSinContestarTest1 = new JTextField();
		fieldSinContestarTest1.setBounds(105, 103, 110, 20);
		fieldSinContestarTest1.setColumns(10);
		
		fieldSinContestarTest2 = new JTextField();
		fieldSinContestarTest2.setBounds(389, 103, 107, 20);
		fieldSinContestarTest2.setColumns(10);
		
		JLabel label = new JLabel("Sin contestar:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(294, 106, 86, 14);
		
		JLabel lblFalladas = new JLabel("Falladas:");
		lblFalladas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFalladas.setBounds(294, 75, 86, 14);
		
		fieldFalladasTest2 = new JTextField();
		fieldFalladasTest2.setBounds(389, 72, 107, 20);
		fieldFalladasTest2.setColumns(10);
		
		fieldCorrectasTest2 = new JTextField();
		fieldCorrectasTest2.setBounds(389, 41, 107, 20);
		fieldCorrectasTest2.setColumns(10);
		
		JLabel label_2 = new JLabel("Correctas:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(294, 44, 86, 14);
		
		JLabel lblExTest = new JLabel("Ex. Test 2: (total max. "+notaTotal.getNUM_PREGUNTAS_TEST()+")");
		lblExTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExTest.setBounds(294, 19, 160, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Trabajo de la evaluaci\u00F3n 1:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 306, 151, 14);
		
		rdbtnEntregadoTrabajo1 = new JRadioButton("Entregado");
		rdbtnEntregadoTrabajo1.setSelected(true);
		rdbtnEntregadoTrabajo1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				fieldRetrasos1.setEditable(true);
			}
		});
		rdbtnEntregadoTrabajo1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnEntregadoTrabajo1.setBounds(180, 302, 91, 23);
		
		rdbtnNoEntregadoTrabajo1 = new JRadioButton("No entregado");
		rdbtnNoEntregadoTrabajo1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fieldRetrasos1.setEditable(false);
				fieldRetrasos1.setText("");
			}
		});
		rdbtnNoEntregadoTrabajo1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNoEntregadoTrabajo1.setBounds(273, 302, 107, 23);
		
		JLabel lblTrabajoDeLa = new JLabel("Trabajo de la evaluaci\u00F3n 2:");
		lblTrabajoDeLa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrabajoDeLa.setBounds(10, 347, 160, 14);
		
		rdbtnEntregadoTrabajo2 = new JRadioButton("Entregado");
		rdbtnEntregadoTrabajo2.setSelected(true);
		rdbtnEntregadoTrabajo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fieldRetrasos2.setEditable(true);
			}
		});
		rdbtnEntregadoTrabajo2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnEntregadoTrabajo2.setBounds(180, 343, 91, 23);
		
		rdbtnNoEntregadoTrabajo2 = new JRadioButton("No entregado");
		rdbtnNoEntregadoTrabajo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fieldRetrasos2.setEditable(false);
				fieldRetrasos2.setText("");
			}
		});
		rdbtnNoEntregadoTrabajo2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNoEntregadoTrabajo2.setBounds(273, 343, 107, 23);
		
		JLabel lblTrabajoDeLa_1 = new JLabel("Trabajo de la evaluaci\u00F3n 3:");
		lblTrabajoDeLa_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrabajoDeLa_1.setBounds(15, 388, 151, 14);
		
		rdbtnEntregadoTrabajo3 = new JRadioButton("Entregado");
		rdbtnEntregadoTrabajo3.setSelected(true);
		rdbtnEntregadoTrabajo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fieldRetrasos3.setEditable(true);
			}
		});
		rdbtnEntregadoTrabajo3.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnEntregadoTrabajo3.setBounds(180, 384, 91, 23);
		
		rdbtnNoEntregadoTrabajo3 = new JRadioButton("No entregado");
		rdbtnNoEntregadoTrabajo3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fieldRetrasos3.setEditable(false);
				fieldRetrasos3.setText("");
			}
		});
		rdbtnNoEntregadoTrabajo3.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNoEntregadoTrabajo3.setBounds(273, 384, 107, 23);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnFinalizar.setBounds(433, 439, 89, 23);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFinalizarActionPerformed(e);
			}
		});
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtras.setBounds(334, 439, 89, 23);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAtrasActionPerformed(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("D\u00EDas de retraso:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(387, 306, 91, 14);
		
		fieldRetrasos1 = new JTextField();
		fieldRetrasos1.setBounds(488, 305, 34, 20);
		fieldRetrasos1.setColumns(10);
		
		JLabel lblDasDeRetraso = new JLabel("D\u00EDas de retraso:");
		lblDasDeRetraso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDasDeRetraso.setBounds(387, 347, 91, 14);
		
		fieldRetrasos2 = new JTextField();
		fieldRetrasos2.setBounds(488, 346, 34, 20);
		fieldRetrasos2.setColumns(10);
		
		JLabel lblDasDeRetraso_1 = new JLabel("D\u00EDas de retraso:");
		lblDasDeRetraso_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDasDeRetraso_1.setBounds(387, 388, 91, 14);
		
		fieldRetrasos3 = new JTextField();
		fieldRetrasos3.setBounds(488, 387, 34, 20);
		fieldRetrasos3.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblTest1);
		contentPane.add(lblSinContestar);
		contentPane.add(fieldSinContestarTest1);
		contentPane.add(lblNewLabel_1);
		contentPane.add(fieldFalladasTest1);
		contentPane.add(lblNewLabel);
		contentPane.add(fieldCorrectasTest1);
		contentPane.add(btnAtras);
		contentPane.add(btnFinalizar);
		contentPane.add(lblExTest);
		contentPane.add(label_2);
		contentPane.add(fieldCorrectasTest2);
		contentPane.add(lblFalladas);
		contentPane.add(fieldFalladasTest2);
		contentPane.add(label);
		contentPane.add(fieldSinContestarTest2);
		contentPane.add(lblClasico1);
		contentPane.add(lblClasico2);
		contentPane.add(lblClasico3);
		contentPane.add(fieldClasico3);
		contentPane.add(fieldClasico2);
		contentPane.add(fieldClasico1);
		contentPane.add(lblNewLabel_3);
		contentPane.add(rdbtnEntregadoTrabajo1);
		contentPane.add(rdbtnNoEntregadoTrabajo1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(fieldRetrasos1);
		contentPane.add(lblTrabajoDeLa);
		contentPane.add(rdbtnEntregadoTrabajo2);
		contentPane.add(rdbtnNoEntregadoTrabajo2);
		contentPane.add(lblDasDeRetraso);
		contentPane.add(fieldRetrasos2);
		contentPane.add(lblTrabajoDeLa_1);
		contentPane.add(rdbtnEntregadoTrabajo3);
		contentPane.add(rdbtnNoEntregadoTrabajo3);
		contentPane.add(lblDasDeRetraso_1);
		contentPane.add(fieldRetrasos3);
	}
	
	
	/**
	 * Inicia todo el proceso para pasar los datos al servidor
	 * 
	 * @param evt click izquierzo en el botón Finalizar
	 */
	private void btnFinalizarActionPerformed(ActionEvent evt) {
		if(verificarEntradaDatos()) {
			recogerEntradaDatos();
			
			notaTotal.calcularNotaGlobal();
			conexion.insertarDatos(persona, notaTotal);
			
			Menu pasar = new Menu();
			pasar.setVisible(true);
			dispose();
		}
		else {
			mensaje.envioIncorrecto();
		}
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
	public void recogerEntradaDatos() {
		recogerDatosExamenesTest();
		recogerDatosExamenesClasicos();
		recogerTrabajos();
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
		
		NotaExamenClasico[0] = Double.parseDouble(fieldClasico1.getText());
		NotaExamenClasico[1] = Double.parseDouble(fieldClasico2.getText());
		NotaExamenClasico[2] = Double.parseDouble(fieldClasico3.getText());	
		
		notaTotal.setNotaExamenClasico(NotaExamenClasico);
	}

	
	/**
	 * Recoge los datos de los trabajos. Trabajos entregados y dias de retraso
	 */
	public void recogerTrabajos() {
		boolean [] entregadoTrabajo = new boolean [notaTotal.getNUM_TRABAJOS()];
		int [] diasDeRetrasoTrabajo = new int [notaTotal.getNUM_TRABAJOS()];
		
		//trabajo 1
		if (rdbtnEntregadoTrabajo1.isSelected()) {
			entregadoTrabajo[0] = true;
			diasDeRetrasoTrabajo[0] = Integer.parseInt(fieldRetrasos1.getText());
		}
		else {
			entregadoTrabajo[0] = false;
			diasDeRetrasoTrabajo[0] = 0;
		}
		
		//trabajo 2
		if (rdbtnEntregadoTrabajo2.isSelected()) {
			entregadoTrabajo[1] = true;
			diasDeRetrasoTrabajo[1] = Integer.parseInt(fieldRetrasos2.getText());
		}
		else {
			entregadoTrabajo[1] = false;
			diasDeRetrasoTrabajo[1] = 0;
		}
		
		//trabajo 3
		if (rdbtnEntregadoTrabajo3.isSelected()) {
			entregadoTrabajo[2] = true;
			diasDeRetrasoTrabajo[2] = Integer.parseInt(fieldRetrasos3.getText());
		}
		else {
			entregadoTrabajo[2] = false;
			diasDeRetrasoTrabajo[2] = 0;
		}
		
		notaTotal.setTrabajoArray(entregadoTrabajo, diasDeRetrasoTrabajo);
	}
	
	
	/**
	 * Verifica toda la información recogida por esta ventana 
	 * 
	 * @return devolverá true en el caso de estar todo correcto
	 */
	public boolean verificarEntradaDatos() {
		if(verificarEntradaExTest()) {
			return false;
		}
		else if(verificarEntradaExClasico()) {
			return false;
		}
		else if(verificarEntradaTrabajo()) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Verifica todas las entradas de datos de los examenes de tipo test
	 * 
	 * @return devolverá false en el caso de estar todo correcto
	 */
	public boolean verificarEntradaExTest() {
		if(verificarEntradaInt(fieldCorrectasTest1.getText(), "Correctas Test 1")) {
			return true;
		} 
		else if(verificarEntradaInt(fieldFalladasTest1.getText(), "Falladas Test 1")){
			return true;
		} 
		else if(verificarEntradaInt(fieldSinContestarTest1.getText(), "Sin Contestar Test 1")) {
			return true;
		}
		else if(verificarEntradaInt(fieldCorrectasTest2.getText(), "Correctas Test 2")) {
			return true;
		}
		else if(verificarEntradaInt(fieldFalladasTest2.getText(), "Falladas Test 2")){
			return true;
		}
		else if(verificarEntradaInt(fieldSinContestarTest2.getText(), "Sin Contestar Test 2")) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica todas las entradas de datos de los examenes clásicos
	 * 
	 * @returndevolverá false en el caso de que estar todo correcto
	 */
	public boolean verificarEntradaExClasico() {
		if(verificarEntradaDouble(fieldClasico1.getText(), "Examen clásico 1")) {
			return true;
		} 
		else if(verificarEntradaDouble(fieldClasico2.getText(), "Examen clásico 2")) {
			return true;
		} 
		else if(verificarEntradaDouble(fieldClasico3.getText(), "Examen clásico 3")) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica todas las entradas de datos de los trabajos
	 * 
	 * @return devolverá false en el caso de estar todo correcto
	 */
	public boolean verificarEntradaTrabajo() {
		if(rdbtnEntregadoTrabajo1.isSelected()) {
			if(verificarEntradaInt(fieldRetrasos1.getText(), "Días de retraso (Trabajo de la evaluación 1")) {
				return true;
			}
		} 
		else if(rdbtnEntregadoTrabajo2.isSelected()) {
			if(verificarEntradaInt(fieldRetrasos2.getText(), "Días de retraso (Trabajo de la evaluación 2")) {
				return true;
			}
		} 
		else if(rdbtnEntregadoTrabajo3.isSelected()) {
			if(verificarEntradaInt(fieldRetrasos3.getText(), "Días de retraso (Trabajo de la evaluación 3")) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Verifica que cualquier dato de tipo int que se introduzca cumpla las condiciones que queremos
	 * 
	 * @param cadena: el texto que ha introducido el usuario
	 * @param campo: que campo se está verificando 
	 * @return devolverá false en caso de estar todo correcto
	 */
	public boolean verificarEntradaInt(String cadena, String campo) {
		if(verifica.campoRelleno(cadena)) {
			mensaje.vacioCampo(campo);
			return true;
		}
		else if(verifica.correctoInt(cadena)) {
			mensaje.errorNumEnt(campo);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica que cualquier dato de tipo double que se introduzca cumpla las condiciones que queremos
	 * 
	 * @param cadena el texto que ha introducido el usuario
	 * @param campo que campo se está verificando 
	 * @return devolverá false en caso de estar todo correcto
	 */
	public boolean verificarEntradaDouble(String cadena, String campo) {
		if(verifica.campoRelleno(cadena)) {
			mensaje.vacioCampo(campo);
			return true;
		}
		else if(verifica.correctoDouble(cadena)) {
			mensaje.errorNumDouble(campo);
			return true;
		}
		return false;
	}
	
}


