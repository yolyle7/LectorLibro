package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
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
		setResizable(false);
		setTitle("Lector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 490);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		textArea = new JTextArea(
				"\r\n\r\n\r\n\r\n    Bienvenido al lector de libros de\n\n\n\n                           Yolanda\n\n\n\n\n\n\n\n             Pulse >> para continuar",
				1, 1);
		textArea.setFont(new Font("Eagle Lake", Font.PLAIN, 13));
	
		// textArea.setPreferredSize(new Dimension(1, 1));
		textArea.setToolTipText("");
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea, BorderLayout.CENTER);

		// Panel de botones
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(25, 25, 112), null, null, null));
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel, BorderLayout.SOUTH);

		lblNumeroPagina = new JLabel("0");
		lblNumeroPagina.setFont(new Font("Eagle Lake", Font.BOLD, 9));
		btnAtras = new JButton("<<");
		btnAtras.setFont(new Font("Eagle Lake", Font.BOLD, 9));
		btnAlante = new JButton(">>");
		btnAlante.setFont(new Font("Eagle Lake", Font.BOLD, 9));
		btnMarcar = new JButton("Marcar");
		btnMarcar.setFont(new Font("Eagle Lake", Font.BOLD, 9));
		btnIrAMarca = new JButton("Ir a");
		btnIrAMarca.setFont(new Font("Eagle Lake", Font.BOLD, 9));

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
