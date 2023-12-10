package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaLivros extends AbstractTableModel {
	
	private static final String[] colunas = { "IDLivro", "titulo", "autor", "E-ano", "editora", "isbn", "IDLocatario" };
	private ArrayList<Livro> livros;

	public ModeloTabelaLivros(ArrayList<Livro> livros) {
		super();
		this.livros = livros;
	}

	@Override
	public int getRowCount() {
		return livros.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	//String IDLivro, titulo, autor, ano, editora, isbn, IDLocatario;
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Livro livro = livros.get(rowIndex);
		if (columnIndex == 0) {
			return livro.getIDLivro();
		} else if (columnIndex == 1) {
			return livro.getTitulo();
		} else if (columnIndex == 2) {
			return livro.getAutor();
		} else if (columnIndex == 3) {
			return livro.getAno();
		} else if (columnIndex == 4) {
			return livro.getEditora();
		} else if (columnIndex == 5) {
			return livro.getIsbn();
		}  else if (columnIndex == 6) {
			return livro.getIDLocatario();
		} else {
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
}
