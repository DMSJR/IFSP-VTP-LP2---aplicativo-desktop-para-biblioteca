package Model;

public class ClienteLivro {
	

	    private String id;
	    private String nome;

	    public ClienteLivro(String id, String nome) {
	        this.id = id;
	        this.nome = nome;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    @Override
	    public String toString() {
	        return nome;
	    }

	
}
