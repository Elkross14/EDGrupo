/** 
 *<h2> Clase DatoNotas </h2> 
 *
 * Ventana gráfica para introducir las notas y otros
 * datos necesarios.
 * @author Pablo Durán, Héctor García
 * @version 0.0.1 
 */
package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class DatosNotas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldClasico1;
	private JTextField textFieldClasico2;
	private JTextField textFieldClasico3;
	private JTextField fieldCorrectasTest1;
	private JTextField fieldIncorrectasTest1;
	private JTextField fieldSinContestarTest1;
	private JTextField fieldSinContestarTest2;
	private JTextField fieldIncorrectasTest2;
	private JTextField fieldCorrectasTest2;
	private JTextField textFieldNumFaltas;
	private JRadioButton rdbtnEntregadoTrabajo1;
	private JRadioButton rdbtnEntregadoTrabajo2;
	private JRadioButton rdbtnEntregadoTrabajo3;
	private JRadioButton rdbtnNoEntregadoTrabajo1;
	private JRadioButton rdbtnNoEntregadoTrabajo2;
	private JRadioButton rdbtnNoEntregadoTrabajo3;
	private JButton btnAtras;
	private JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosNotas frame = new DatosNotas();
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
	public DatosNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClasico1 = new JLabel("Examen Cl\u00E1sico 1:");
		
		textFieldClasico1 = new JTextField();
		textFieldClasico1.setColumns(10);
		
		JLabel lblClasico2 = new JLabel("Examen Cl\u00E1sico 2:");
		
		textFieldClasico2 = new JTextField();
		textFieldClasico2.setColumns(10);
		
		JLabel lblClasico3 = new JLabel("Examen Cl\u00E1sico 3:");
		
		textFieldClasico3 = new JTextField();
		textFieldClasico3.setColumns(10);
		
		JLabel lblTest1 = new JLabel("Ex. Test 1: (total max. 30)");
		
		JLabel lblNewLabel = new JLabel("Correctas:");
		
		fieldCorrectasTest1 = new JTextField();
		fieldCorrectasTest1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Incorrectas:");
		
		fieldIncorrectasTest1 = new JTextField();
		fieldIncorrectasTest1.setColumns(10);
		
		JLabel lblSinContestar = new JLabel("Sin contestar:");
		
		fieldSinContestarTest1 = new JTextField();
		fieldSinContestarTest1.setColumns(10);
		
		fieldSinContestarTest2 = new JTextField();
		fieldSinContestarTest2.setColumns(10);
		
		JLabel label = new JLabel("Sin contestar:");
		
		JLabel label_1 = new JLabel("Incorrectas:");
		
		fieldIncorrectasTest2 = new JTextField();
		fieldIncorrectasTest2.setColumns(10);
		
		fieldCorrectasTest2 = new JTextField();
		fieldCorrectasTest2.setColumns(10);
		
		JLabel label_2 = new JLabel("Correctas:");
		
		JLabel lblExTest = new JLabel("Ex. Test 2: (total max. 30)");
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de faltas:");
		
		textFieldNumFaltas = new JTextField();
		textFieldNumFaltas.setColumns(10);
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(fieldIncorrectasTest1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
								.addComponent(lblTest1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(26)
									.addComponent(fieldCorrectasTest1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSinContestar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(fieldSinContestarTest1, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblExTest, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(fieldCorrectasTest2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(fieldIncorrectasTest2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnAtras)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnFinalizar))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(fieldSinContestarTest2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
							.addGap(16))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClasico1)
									.addGap(18)
									.addComponent(textFieldClasico1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClasico2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(textFieldClasico2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textFieldNumFaltas, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblClasico3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(textFieldClasico3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(223))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblTrabajoDeLa, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTrabajoDeLa_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnEntregadoTrabajo3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rdbtnNoEntregadoTrabajo3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnEntregadoTrabajo2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rdbtnNoEntregadoTrabajo2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnEntregadoTrabajo1)
									.addGap(18)
									.addComponent(rdbtnNoEntregadoTrabajo1)))
							.addContainerGap(49, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
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
								.addComponent(fieldIncorrectasTest2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(label))
								.addComponent(fieldSinContestarTest2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTest1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(fieldCorrectasTest1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(fieldIncorrectasTest1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSinContestar)
								.addComponent(fieldSinContestarTest1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
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
						.addComponent(textFieldClasico3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textFieldNumFaltas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(rdbtnEntregadoTrabajo1)
						.addComponent(rdbtnNoEntregadoTrabajo1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrabajoDeLa)
						.addComponent(rdbtnEntregadoTrabajo2)
						.addComponent(rdbtnNoEntregadoTrabajo2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTrabajoDeLa_1)
						.addComponent(rdbtnEntregadoTrabajo3)
						.addComponent(rdbtnNoEntregadoTrabajo3))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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
	 * Vuelve a la pantalla de DatosNombre. Si se ha rellenado
	 * algún campo se guardará temporalmente.
	 * 
	 * @param evt click izquierzo en el botón Atrás
	 */
	private void btnAtrasActionPerformed(ActionEvent evt) {
		
	}
}
