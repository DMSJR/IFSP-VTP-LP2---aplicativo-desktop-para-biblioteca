package Model;

public class Livro {
	
	String IDLivro, titulo, autor, ano, editora, isbn, IDLocatario;

	public String getIDLivro() {
		return IDLivro;
	}

	public void setIDLivro(String iDLivro) {
		IDLivro = iDLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIDLocatario() {
		return IDLocatario;
	}

	public void setIDLocatario(String iDLocatario) {
		IDLocatario = iDLocatario;
	}

	public Livro(String iDLivro, String titulo, String autor, String ano, String editora, String isbn,
			String iDLocatario) {
		super();
		IDLivro = iDLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.editora = editora;
		this.isbn = isbn;
		IDLocatario = iDLocatario;
	}
	
}
