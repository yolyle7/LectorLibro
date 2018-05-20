package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import control.accion.ParaUI;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnAtras;
	private JButton btnMarcar;
	private JButton btnIrAMarca;
	private JLabel lblNumeroPagina;
	private JButton btnAlante;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ParaUI frame = new ParaUI();
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
	public UI() {
		setTitle("Lector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 490);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textArea = new JTextArea(
				"\n\n\n\n\n      BIENVENIDO A LECTOR DE LIBROS DE YOLANDA\n\n\n\n\n\n\n VAS A DISFRUTAR DEL MARAVILLOSO LIBRO DE\n"
						+ " JUEGO DE TRONOS, CANCION DE HIELO Y FUEGO. \n\n\n\n\n\n\n\n\n PULSA SIGUIENTE PARA CONTINUAR ",
				1, 1);
		// textArea.setPreferredSize(new Dimension(1, 1));
		textArea.setToolTipText("");
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea, BorderLayout.CENTER);

		// Panel de botones
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		lblNumeroPagina = new JLabel("0");
		btnAtras = new JButton("<<");
		btnAlante = new JButton(">>");
		btnMarcar = new JButton("Marcar");
		btnIrAMarca = new JButton("Ir a");

		panel.add(btnAtras);
		panel.add(btnMarcar);
		panel.add(btnIrAMarca);
		panel.add(btnAlante);
		panel.add(lblNumeroPagina);

	}
	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}

	public JButton getBtnMarcar() {
		return btnMarcar;
	}

	public void setBtnMarcar(JButton btnMarcar) {
		this.btnMarcar = btnMarcar;
	}

	public JButton getBtnIrAMarca() {
		return btnIrAMarca;
	}

	public void setBtnIrAMarca(JButton btnIrAMarca) {
		this.btnIrAMarca = btnIrAMarca;
	}

	public JLabel getLblNumeroPagina() {
		return lblNumeroPagina;
	}

	public void setLblNumeroPagina(String text) {
		this.lblNumeroPagina.setText(text);
	}

	public JButton getBtnAlante() {
		return btnAlante;
	}

	public void setBtnAlante(JButton btnAlante) {
		this.btnAlante = btnAlante;
	}
}
