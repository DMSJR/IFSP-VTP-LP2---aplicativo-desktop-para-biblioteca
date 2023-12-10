package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Backup;
import Controller.GeraRelatorio;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JHome frame = new JHome();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 529);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(123, 36, 351, 421);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPrincipal jPrincipal = new JPrincipal();
				jPrincipal.setLocationRelativeTo(null);
				jPrincipal.setVisible(true);
				jPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(53, 31, 235, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Obra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLivroView jLivroView = new JLivroView();
				jLivroView.setLocationRelativeTo(null);
				jLivroView.setVisible(true);
				jLivroView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_1.setBounds(53, 91, 235, 42);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Retirar/Devolver Obra");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLivroClienteView jLivroClienteView = new JLivroClienteView();
				jLivroClienteView.setLocationRelativeTo(null);
				jLivroClienteView.setVisible(true);
				jLivroClienteView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnNewButton_1_1.setBounds(53, 155, 235, 42);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Gerar relatório");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GeraRelatorio();
			}
		});
		btnNewButton_1_1_1.setBounds(53, 219, 235, 42);
		panel.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Cadastrar Usuário");
		btnNewButton_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroUsuario jCadastroUsuario = new JCadastroUsuario();
				jCadastroUsuario.setLocationRelativeTo(null);
				jCadastroUsuario.setVisible(true);
				jCadastroUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_1_1_2.setBounds(53, 288, 235, 42);
		panel.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_2_1 = new JButton("BackUp");
		btnNewButton_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JBackup jBackup = new JBackup();
				jBackup.setLocationRelativeTo(null);
				jBackup.setVisible(true);
				jBackup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton_1_1_2_1.setBounds(53, 352, 235, 42);
		panel.add(btnNewButton_1_1_2_1);
	}
}
