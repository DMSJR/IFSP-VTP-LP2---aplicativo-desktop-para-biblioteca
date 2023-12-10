package View;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Controller.GeraRelatorio;
import Model.Livro;
import Model.ModeloTabelaLivros;
import dao.DAO;

import javax.swing.JScrollPane;

public class JLivroView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLivroView JLivroView;
	private ArrayList<Livro> livros;
	private TableRowSorter<ModeloTabelaLivros> rowSorter;
	private JTextField textFieldBusca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLivroView frame = new JLivroView();
					frame.setLocationRelativeTo(null);
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
	public JLivroView() {
		this.JLivroView = this;
		DAO dao = new DAO();
		try {
			livros = dao.listarLivro();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro ao listar o livro");
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldBusca = new JTextField();
		textFieldBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				filtrar();
			}
		});
		textFieldBusca.setBounds(151, 28, 405, 19);
		contentPane.add(textFieldBusca);
		textFieldBusca.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadastroLivro jCadastroLivro = new JCadastroLivro(null, JLivroView);
				jCadastroLivro.setLocationRelativeTo(jCadastroLivro);
				jCadastroLivro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				jCadastroLivro.setVisible(true);
			}
		});
		btnNewButton.setBounds(34, 28, 107, 21);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 73, 522, 302);
		contentPane.add(scrollPane);
		ModeloTabelaLivros modeloTabelaLivros = new ModeloTabelaLivros(livros);
		table = new JTable();
		table.setModel(modeloTabelaLivros);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {
					try {
						Livro livroSelecionado = dao
								.consultarLivro(modeloTabelaLivros.getValueAt(table.getSelectedRow(), 0).toString());
						JCadastroLivro jCadastroLivro = new JCadastroLivro(livroSelecionado, JLivroView);
						jCadastroLivro.setLocationRelativeTo(jCadastroLivro);
						jCadastroLivro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						jCadastroLivro.setVisible(true);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao selecionar livro ", "",
								JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}
				}
			}
		});
		rowSorter = new TableRowSorter<>(modeloTabelaLivros);
		table.setRowSorter(rowSorter);
		scrollPane.setViewportView(table);
		
		textFieldBusca = new JTextField();
		textFieldBusca.setBounds(151, 28, 253, 20);
		contentPane.add(textFieldBusca);
		textFieldBusca.setColumns(10);
		
		
	}
	
	private void filtrar() {
		String busca = textFieldBusca.getText().trim();

		if (busca.length() == 0) {
			rowSorter.setRowFilter(null);
		} else {
			rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + busca));
		}
	}
}

