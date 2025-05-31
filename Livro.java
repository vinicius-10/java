//vinicius souza Dias

public abstract class Livro extends Objetos {
    private int id;
    private String titulo;
    private Autor autor;
    private Localizacao localizacao;
    private Editora editora;

    public Livro() {
        super();
        this.id = 0;
        this.titulo = "";
        this.autor = null;
        this.localizacao = new Localizacao();
        this.editora = null;
    }

    //polimorfismo por sobrecarga
    public Livro(int id ,String titulo, Autor autor, Localizacao localizacao, Editora editora, boolean bloqueado) {
        super(bloqueado);
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.localizacao = localizacao;
        this.editora = editora;
    }

    public String getTitulo() { return titulo; }
    public Autor getAutor() { return autor; }
    public Localizacao getLocalizacao() { return localizacao; }
    public Editora getEditora() { return editora; }    

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(Autor autor) { this.autor = autor; }
    public void setLocalizacao(Localizacao localizacao) { this.localizacao = localizacao; }
    public void setEditora(Editora editora) { this.editora = editora; }
    
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
    
}
