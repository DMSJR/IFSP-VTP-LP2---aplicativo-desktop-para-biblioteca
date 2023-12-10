package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Model.Cliente;
import Model.Livro;
import dao.DAO;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCadastroLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textEditora;
	private JTextField textIsbn;
	private JTextField textAno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroLivro frame = new JCadastroLivro(null, null);
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
	public JCadastroLivro(Livro livroSelecionado, JLivroView jLivroView) {
		DAO dao = new DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(37, 23, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(37, 81, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ano");
		lblNewLabel_2.setBounds(204, 81, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Editora");
		lblNewLabel_3.setBounds(37, 128, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Autor");
		lblNewLabel_3_1.setBounds(37, 179, 45, 13);
		contentPane.add(lblNewLabel_3_1);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(37, 51, 367, 19);
		contentPane.add(textTitulo);
		
		textIsbn = new JTextField();
		textIsbn.setColumns(10);
		textIsbn.setBounds(37, 105, 152, 19);
		contentPane.add(textIsbn);
		
		textAno = new JTextField();
		textAno.setColumns(10);
		textAno.setBounds(204, 105, 192, 19);
		contentPane.add(textAno);
		
		textAutor = new JTextField();
		textAutor.setBounds(37, 201, 367, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		textEditora = new JTextField();
		textEditora.setColumns(10);
		textEditora.setBounds(37, 149, 367, 19);
		contentPane.add(textEditora);
		
		JButton btnNewButton = new JButton(livroSelecionado == null?"Incluir":"Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				Livro livro = new Livro(null, textTitulo.getText(), textAutor.getText(), textAno.getText(), textEditora.getText(), textIsbn.getText(), null);
				if(livroSelecionado == null) {
					if(!"".equalsIgnoreCase(textTitulo.getText()) && !"".equalsIgnoreCase(textIsbn.getText())) {
						dao.cadastrarLivro(livro);
						abrirTelaPrincipal(jLivroView);
					}else {
						JOptionPane.showMessageDialog(null, "Confira o nome e ISBN");
					}


				}else {
					if(!"".equalsIgnoreCase(textTitulo.getText()) && !"".equalsIgnoreCase(textIsbn.getText())) {
						dao.alterarLivro(livroSelecionado.getIDLivro(), livro);
						abrirTelaPrincipal(jLivroView);
					}else {
						JOptionPane.showMessageDialog(null, "Confira o nome e ISBN");
					}
				}
				
			}
		});
		btnNewButton.setBounds(311, 252, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.excluirCliente(livroSelecionado.getIDLivro());
				abrirTelaPrincipal(jLivroView);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(29, 251, 89, 23);
		btnNewButton_1.setVisible(false);
		contentPane.add(btnNewButton_1);
		

		
		if(livroSelecionado != null) {
			preencherCampos(livroSelecionado);
			btnNewButton_1.setVisible(true);
		}
	}
	
	private void preencherCampos(Livro livroSelecionado) {
		textTitulo.setText(livroSelecionado.getTitulo());
		textIsbn.setText(livroSelecionado.getIsbn());
		textAutor.setText(livroSelecionado.getAutor());
		textEditora.setText(livroSelecionado.getEditora());
		textAno.setText(livroSelecionado.getAno());
	}
	
	private void abrirTelaPrincipal(JLivroView jLivroView) {
		jLivroView.dispose();
		dispose();
		jLivroView = new JLivroView();
		jLivroView.setLocationRelativeTo(jLivroView);
		jLivroView.setVisible(true);
	}
}

