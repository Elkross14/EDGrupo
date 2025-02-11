/** 
 *<h2> Clase VentanaNotas </h2> 
 *
 * Ventana gráfica para introducir las notas y otros
 * datos necesarios.
 * 
 * Última actualización: 
 * - Modificado el sistema de verificación de datos
 *
 * Nota: Mirar las comprobaciones para ponerlas en el orden optimo
 * 
 * @author Pablo Durán, Héctor García
 * @version 0.1.5
 */

package interfazGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.SeleccionadorCompleto;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	 * @param persona Objeto de clase Persona con todas sus variables
	 * @param notaTotal Objeto de clase NotaTotal con todas sus variables
	 */
	public VentanaNotas(Persona persona, NotaTotal notaTotal) {
		iniciarVentana();
		
		this.persona = new Persona(persona);
		this.notaTotal = new NotaTotal(notaTotal);
		
		mostarDatos();
		ordenarTabulacion();
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
	 * Mostrará los datos que ha escrito la persona cada uno en su celda cuando cambia
	 * de ventana por si quiere modificar alguno.
	 */
	public void mostarDatos() {
		mostrarDatosExamenesTest();
		mostrarDatosExamenesClasicos();
		mostrarDatosTrabajos();
	}
	
	
	/**
	 * Mostrará los resultados de los examenes tipo test por pantalla
	 */
	public void mostrarDatosExamenesTest() {
		int[][] respuestasTest = new int [notaTotal.getNUM_EXAMENES_TEST()][3];
		
		respuestasTest = notaTotal.getRespuestasExamenTest();
		
		fieldCorrectasTest1.setText(String.valueOf(respuestasTest [0][0]));
		fieldFalladasTest1.setText(String.valueOf(respuestasTest [0][1]));
		fieldSinContestarTest1.setText(String.valueOf(respuestasTest [0][2]));
			
		fieldCorrectasTest2.setText(String.valueOf(respuestasTest [1][0]));
		fieldFalladasTest2.setText(String.valueOf(respuestasTest [1][1]));
		fieldSinContestarTest2.setText(String.valueOf(respuestasTest [1][2]));
	}
	
	
	/**
	 * Mostrará las notas de los examenes clasicos por pantalla
	 */
	public void mostrarDatosExamenesClasicos() {
		double[] notaExamenClasico = new double[notaTotal.getNUM_EXAMENES_CLASICOS()];
		
		notaExamenClasico = notaTotal.getNotaExamenClasico();
		
		fieldClasico1.setText(String.valueOf(notaExamenClasico[0]));
		fieldClasico2.setText(String.valueOf(notaExamenClasico[1]));
		fieldClasico3.setText(String.valueOf(notaExamenClasico[2]));
	}
	
	
	/**
	 * Mostrará por pantalla el jradio que se había seleccionado 
	 * y los dias de retraso si es necesario 
	 */
	public void mostrarDatosTrabajos() {
		int[][] trabajo = new int [notaTotal.getNUM_TRABAJOS()][2];
		
		trabajo = notaTotal.getTrabajos();
		
		//primer trabajo
		if (trabajo[0][0] == 1) {
			rdbtnEntregadoTrabajo1.setSelected(true);
			fieldRetrasos1.setText(String.valueOf(trabajo[0][1]));
		}
		else rdbtnEntregadoTrabajo1.setSelected(false);
		
		//segndo trabajo
		if (trabajo[1][0] == 1) {
			rdbtnEntregadoTrabajo2.setSelected(true);
			fieldRetrasos2.setText(String.valueOf(trabajo[1][1]));
		}
		else rdbtnEntregadoTrabajo2.setSelected(false);
		
		//tercer trabajo
		if (trabajo[2][0] == 1) {
			rdbtnEntregadoTrabajo3.setSelected(true);
			fieldRetrasos3.setText(String.valueOf(trabajo[2][1]));
		}
		else rdbtnEntregadoTrabajo3.setSelected(false);
	}
	

	/**
	 * Crea el orden de tabulación que queremos.
	 * Utilizamos este sistema debido a que el windows builder está bugeado y no deja hacerlo
	 * por los métodos tradiciones.
	 */
	@SuppressWarnings("deprecation")
	public void ordenarTabulacion() {
		fieldCorrectasTest1.setNextFocusableComponent(fieldFalladasTest1);
		fieldFalladasTest1.setNextFocusableComponent(fieldSinContestarTest1);
		fieldSinContestarTest1.setNextFocusableComponent(fieldCorrectasTest2);
		fieldCorrectasTest2.setNextFocusableComponent(fieldFalladasTest2);
		fieldFalladasTest2.setNextFocusableComponent(fieldSinContestarTest2);
		fieldSinContestarTest2.setNextFocusableComponent(fieldClasico1);
		fieldClasico1.setNextFocusableComponent(fieldClasico2);
		fieldClasico2.setNextFocusableComponent(fieldClasico3);
		fieldClasico3.setNextFocusableComponent(rdbtnEntregadoTrabajo1);
		rdbtnEntregadoTrabajo1.setNextFocusableComponent(fieldRetrasos1);
		fieldRetrasos1.setNextFocusableComponent(rdbtnEntregadoTrabajo2);
		rdbtnEntregadoTrabajo2.setNextFocusableComponent(fieldRetrasos2);
		fieldRetrasos2.setNextFocusableComponent(rdbtnEntregadoTrabajo3);
		rdbtnEntregadoTrabajo3.setNextFocusableComponent(fieldRetrasos3);
		fieldRetrasos3.setNextFocusableComponent(btnAtras);
		btnAtras.setNextFocusableComponent(btnFinalizar);
		btnFinalizar.setNextFocusableComponent(fieldCorrectasTest1);
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
		fieldClasico1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumerosDecimales(e, fieldClasico1.getText());
			}
		});
		fieldClasico1.setBounds(145, 181, 86, 20);
		fieldClasico1.setColumns(10);
		fieldClasico1.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblClasico2 = new JLabel("NotaTotal Cl\u00E1sico 2:");
		lblClasico2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasico2.setBounds(15, 212, 114, 14);
		
		fieldClasico2 = new JTextField();
		fieldClasico2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumerosDecimales(e, fieldClasico2.getText());
			}
		});
		fieldClasico2.setBounds(145, 212, 86, 20);
		fieldClasico2.setColumns(10);
		fieldClasico2.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblClasico3 = new JLabel("NotaTotal Cl\u00E1sico 3:");
		lblClasico3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClasico3.setBounds(15, 243, 114, 14);
		
		fieldClasico3 = new JTextField();
		fieldClasico3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumerosDecimales(e, fieldClasico3.getText());
			}
		});
		fieldClasico3.setBounds(145, 243, 86, 20);
		fieldClasico3.setColumns(10);
		fieldClasico3.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblTest1 = new JLabel("Ex. Test 1: (total max. "+notaTotal.getNUM_PREGUNTAS_TEST()+")");
		lblTest1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTest1.setBounds(15, 19, 160, 14);
		
		JLabel lblNewLabel = new JLabel("Correctas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(15, 44, 86, 14);
		
		fieldCorrectasTest1 = new JTextField();
		fieldCorrectasTest1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldCorrectasTest1.setBounds(105, 41, 110, 20);
		fieldCorrectasTest1.setColumns(10);
		fieldCorrectasTest1.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblNewLabel_1 = new JLabel("Falladas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(15, 75, 86, 14);
		
		fieldFalladasTest1 = new JTextField();
		fieldFalladasTest1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldFalladasTest1.setBounds(105, 72, 110, 20);
		fieldFalladasTest1.setColumns(10);
		fieldFalladasTest1.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblSinContestar = new JLabel("Sin contestar:");
		lblSinContestar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSinContestar.setBounds(15, 106, 86, 14);
		
		fieldSinContestarTest1 = new JTextField();
		fieldSinContestarTest1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldSinContestarTest1.setBounds(105, 103, 110, 20);
		fieldSinContestarTest1.setColumns(10);
		fieldSinContestarTest1.addFocusListener(new SeleccionadorCompleto());
		
		fieldSinContestarTest2 = new JTextField();
		fieldSinContestarTest2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldSinContestarTest2.setBounds(389, 103, 107, 20);
		fieldSinContestarTest2.setColumns(10);
		fieldSinContestarTest2.addFocusListener(new SeleccionadorCompleto());
		
		JLabel label = new JLabel("Sin contestar:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(294, 106, 86, 14);
		
		JLabel lblFalladas = new JLabel("Falladas:");
		lblFalladas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFalladas.setBounds(294, 75, 86, 14);
		
		fieldFalladasTest2 = new JTextField();
		fieldFalladasTest2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldFalladasTest2.setBounds(389, 72, 107, 20);
		fieldFalladasTest2.setColumns(10);
		fieldFalladasTest2.addFocusListener(new SeleccionadorCompleto());
		
		fieldCorrectasTest2 = new JTextField();
		fieldCorrectasTest2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldCorrectasTest2.setBounds(389, 41, 107, 20);
		fieldCorrectasTest2.setColumns(10);
		fieldCorrectasTest2.addFocusListener(new SeleccionadorCompleto());
		
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
				fieldRetrasos1.setText("0"); //Poner días de retraso automaticamente -- Prueba 1: funciona.
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
				fieldRetrasos2.setText("0"); //Poner días de retraso automaticamente -- Prueba 1: funciona.
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
				fieldRetrasos3.setText("0"); //Poner días de retraso automaticamente -- Prueba 1: funciona.
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
		fieldRetrasos1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldRetrasos1.setText("0");
		fieldRetrasos1.setBounds(488, 305, 34, 20);
		fieldRetrasos1.setColumns(10);
		fieldRetrasos1.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblDasDeRetraso = new JLabel("D\u00EDas de retraso:");
		lblDasDeRetraso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDasDeRetraso.setBounds(387, 347, 91, 14);
		
		fieldRetrasos2 = new JTextField();
		fieldRetrasos2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldRetrasos2.setText("0");
		fieldRetrasos2.setBounds(488, 346, 34, 20);
		fieldRetrasos2.setColumns(10);
		fieldRetrasos2.addFocusListener(new SeleccionadorCompleto());
		
		JLabel lblDasDeRetraso_1 = new JLabel("D\u00EDas de retraso:");
		lblDasDeRetraso_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDasDeRetraso_1.setBounds(387, 388, 91, 14);
				
		fieldRetrasos3 = new JTextField();
		fieldRetrasos3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				limitarEntradaNumeros(e);
			}
		});
		fieldRetrasos3.setText("0");
		fieldRetrasos3.setBounds(488, 387, 34, 20);
		fieldRetrasos3.setColumns(10);
		fieldRetrasos3.addFocusListener(new SeleccionadorCompleto());
		
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
	 * Restringe cualquier entrada de datos que no sean números enteros
	 * 
	 * @param evt Entrada de cualquier valor 
	 */
	public void limitarEntradaNumeros (KeyEvent evt) {
		char c = evt.getKeyChar();
		
		if (c < '0' || c > '9') {
			evt.consume();
		}
	}
	
	
	/**
	 * Restringe cualquier entrada de datos que no sea un 
	 * 
	 * @param evt Entrada de cualquier valor 
	 * @param valor Número a revisar si es de tipo double
	 */
	public void limitarEntradaNumerosDecimales (KeyEvent evt, String valor) {
		char c = evt.getKeyChar();
		
		if (!Character.isDigit(c) && c!='.') {
			evt.consume();
		}
		if (c == '.' && valor.contains(".")) {
			evt.consume();
		}
	}
	
	
	/**
	 * Inicia todo el proceso para pasar los datos al servidor
	 * 
	 * @param evt Click izquierzo en el botón Finalizar
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
	}
	
	
	/**
	 * Vuelve a la pantalla de VentanaNombre. Si se ha rellenado
	 * algún campo se guardará temporalmente.
	 * 
	 * @param evt Click izquierzo en el botón Atrás
	 */
	private void btnAtrasActionPerformed(ActionEvent evt) {
			

			recogerEntradaDatos();
			
			VentanaNombre pasar = new VentanaNombre(persona, notaTotal);
			pasar.setVisible(true);
			dispose();

	}
	
	
	/**
	 * Recoge todos los datos introducidos en los campos de esta ventana.
	 */
	public void recogerEntradaDatos() {
		recogerDatosExamenesTest();
		recogerDatosExamenesClasicos();
		recogerDatosTrabajos();
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
	public void recogerDatosTrabajos() {
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
		if(verifica.campoRelleno(fieldCorrectasTest1.getText())) {
			mensaje.vacioCampo("Correctas Test 1");
			return true;
		} 
		else if(verifica.campoRelleno(fieldFalladasTest1.getText())){
			mensaje.vacioCampo("Falladas Test 1");
			return true;
		} 
		else if(verifica.campoRelleno(fieldSinContestarTest1.getText())) {
			mensaje.vacioCampo("Sin Contestar Test 1");
			return true;
		}
		else if (verifica.cantidadRespuestasTest(fieldCorrectasTest1.getText(), fieldFalladasTest1.getText(), 
				fieldSinContestarTest1.getText())) {
			
			mensaje.errorSumaTotal("Examen test 1");
			return true;
		}
		else if(verifica.campoRelleno(fieldCorrectasTest2.getText())) {
			mensaje.vacioCampo("Correctas Test 2");
			return true;
		}
		else if(verifica.campoRelleno(fieldFalladasTest2.getText())){
			mensaje.vacioCampo("Falladas Test 2");
			return true;
		}
		else if(verifica.campoRelleno(fieldSinContestarTest2.getText())) {
			mensaje.vacioCampo("Sin Contestar Test 2");
			return true;
		}
		else if (verifica.cantidadRespuestasTest(fieldCorrectasTest2.getText(), fieldFalladasTest2.getText(), 
				fieldSinContestarTest2.getText())) {
			
			mensaje.errorSumaTotal("Examen test 2");
			return true;
		}
		return false;
	}
	
	
	public boolean verificarRespuestasTotalesTest(String sCorrectas, String sFalladas, 
			String sSinContestar, String campo) {
		
		int correctas = Integer.parseInt(sCorrectas);
		int falladas = Integer.parseInt(sFalladas);
		int sinContestar = Integer.parseInt(sSinContestar);
		
		int respuestasTotales = correctas + falladas + sinContestar;
		
		if (respuestasTotales == 30) {
			mensaje.errorSumaTotal(campo);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica todas las entradas de datos de los examenes clásicos
	 * 
	 * @return devolverá false en el caso de que estar todo correcto
	 */
	public boolean verificarEntradaExClasico() {
		
			if (verificarNotaExClasico(fieldClasico1.getText(), "Examen clásico 1")) {
				
				return true;
				
			} else if(verificarNotaExClasico(fieldClasico2.getText(), "Examen clásico 2")) {
				
				return true;
				
			} else if (verificarNotaExClasico(fieldClasico3.getText(), "Examen clásico 3")) {
				
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
			if(verifica.campoRelleno(fieldRetrasos1.getText())) {
				mensaje.vacioCampo("Días de retraso (Trabajo de la evaluación 1)");
				return true;
			}
		} 
		else if(rdbtnEntregadoTrabajo2.isSelected()) {
			if(verifica.campoRelleno(fieldRetrasos2.getText())) {
				mensaje.vacioCampo("Días de retraso (Trabajo de la evaluación 2)");
				return true;
			}
		} 
		else if(rdbtnEntregadoTrabajo3.isSelected()) {
			if(verifica.campoRelleno(fieldRetrasos3.getText())) {
				mensaje.vacioCampo("Días de retraso (Trabajo de la evaluación 3)");
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Hace todas las verificaciones necesárias para la nota de examen clásico.
	 * 	-No debe de estár vacío el campo
	 *  -Que esté entre el 0 y el 10. Estos incluidos
	 * 
	 * @param nota El texto que ha introducido el usuario
	 * @param examen Que campo se está verificando 
	 * @return Devolverá false en caso de estar todo correcto
	 */
	public boolean verificarNotaExClasico (String nota, String examen) {
		if(verifica.campoRelleno(nota)) {
			mensaje.vacioCampo(examen);
			return true;
		}
		else if (verifica.rangoNotaEx(nota)) {
			mensaje.errorNotaIncorrecta(examen);
			return true;
		}
		return false;
	}
}

