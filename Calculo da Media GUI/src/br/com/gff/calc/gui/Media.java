package br.com.gff.calc.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Media extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtMedia;
	private JTextField txtSituacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Media frame = new Media();
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
	public Media() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Media.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Calculadora de M\u00E9dia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNota = new JLabel("1\u00BA Nota:");
		lblNota.setBounds(30, 31, 46, 14);
		contentPane.add(lblNota);

		JLabel lblNota_1 = new JLabel("2\u00BA Nota:");
		lblNota_1.setBounds(30, 73, 46, 14);
		contentPane.add(lblNota_1);

		txtNota1 = new JTextField();
		txtNota1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNota1.setToolTipText("Adicione a 1\u00BA nota");
		txtNota1.setBounds(132, 28, 86, 20);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);

		txtNota2 = new JTextField();
		txtNota2.setHorizontalAlignment(SwingConstants.CENTER);
		txtNota2.setToolTipText("Adicione a 2\u00BA nota");
		txtNota2.setBounds(132, 70, 86, 20);
		contentPane.add(txtNota2);
		txtNota2.setColumns(10);

		JLabel lblMedia = new JLabel("M\u00E9dia:");
		lblMedia.setBounds(30, 116, 46, 14);
		contentPane.add(lblMedia);

		txtMedia = new JTextField();
		txtMedia.setHorizontalAlignment(SwingConstants.CENTER);
		txtMedia.setEditable(false);
		txtMedia.setBounds(132, 113, 86, 20);
		contentPane.add(txtMedia);
		txtMedia.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.setToolTipText("Calcular\r\n a m\u00E9dia");
		btnCalcular.setIcon(new ImageIcon(Media.class.getResource("/br/com/gff/calc/icon/Calcular.png")));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcular();
			}
		});
		btnCalcular.setBounds(241, 31, 65, 65);
		contentPane.add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.setToolTipText("Limpar campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Media.class.getResource("/br/com/gff/calc/icon/Borracha.png")));
		btnLimpar.setBounds(241, 126, 66, 66);
		contentPane.add(btnLimpar);
		
		txtSituacao = new JTextField();
		txtSituacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtSituacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSituacao.setEditable(false);
		txtSituacao.setBounds(132, 161, 86, 20);
		contentPane.add(txtSituacao);
		txtSituacao.setColumns(10);
		
		JLabel lblSitu = new JLabel("Situa\u00E7\u00E3o");
		lblSitu.setBounds(30, 164, 58, 14);
		contentPane.add(lblSitu);
	}

	private void calcular() {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		Double nota1, nota2, media;
		nota1 = Double.parseDouble(txtNota1.getText().replace(",", "."));
		nota2 = Double.parseDouble(txtNota2.getText().replace(",", "."));
		media = (nota1 + nota2) / 2;
		txtMedia.setText(""+ formatador.format(media));
		
		if(media>=6) {
			txtSituacao.setText("Aprovado");
		}else if(media>=2) {
			txtSituacao.setText("Recuperação");
		}else {
			txtSituacao.setText("Reprovado");
		}
		
	}

	private void limpar() {
		txtNota1.setText(null);
		txtNota2.setText(null);
		txtMedia.setText(null);
		txtSituacao.setText(null);
	}
	
}
