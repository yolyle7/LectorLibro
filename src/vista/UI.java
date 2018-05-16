package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	protected JTextArea textArea;
	protected JButton btnAtras;
	protected JButton btnMarcar;
	protected JButton btnIrAMarca;
	protected JLabel lblNumeroPagina;
	protected JButton btnAlante;
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

		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(4, 2));
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
		btnIrAMarca = new JButton("Ir a Marca");

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

	public void setLblNumeroPagina(JLabel lblNumeroPagina) {
		this.lblNumeroPagina = lblNumeroPagina;
	}

	public JButton getBtnAlante() {
		return btnAlante;
	}

	public void setBtnAlante(JButton btnAlante) {
		this.btnAlante = btnAlante;
	}

}
