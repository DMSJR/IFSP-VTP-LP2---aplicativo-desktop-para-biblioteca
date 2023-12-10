package Model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaClienteLivros extends AbstractTableModel {
	
	private static final String[] colunas = { "IDLivro", "Título", "IDLocatario" };
	private ArrayList<Livro> livros;

	public ModeloTabelaClienteLivros(ArrayList<Livro> livros) {
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

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Livro livro = livros.get(rowIndex);

		switch (columnIndex) {
			case 0:
				return livro.getIDLivro();
			case 1:
				return livro.getTitulo();
			case 2:
				return livro.getIDLocatario();
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}
}
