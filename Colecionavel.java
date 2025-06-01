//vinicius souza Dias 2564599
public final class Colecionavel extends Livro {
    private String edicaoEspecial;
    private boolean numerado;
    private String adicional;

    public Colecionavel() {
        super();
        this.edicaoEspecial = "";
        this.numerado = false;
        this.adicional = "";
    }

    //polimorfismo por sobrecarga
    public Colecionavel(int id, String titulo, Autor autor, Localizacao localizacao, Editora editora, boolean bloqueado, String edicaoEspecial, boolean numerado, String adicional) {
        super(id,titulo, autor, localizacao, editora, bloqueado);
        this.edicaoEspecial = edicaoEspecial;
        this.numerado = numerado;
        this.adicional = adicional;
    }

    public String getEdicaoEspecial() { return edicaoEspecial; }
    public boolean isNumerado() { return numerado; }
    public String getAdicional() { return adicional; }

    public void setEdicaoEspecial(String edicaoEspecial) { this.edicaoEspecial = edicaoEspecial; }
    public void setNumerado(boolean numerado) { this.numerado = numerado; }
    public void setAdicional(String adicional) { this.adicional = adicional; }

}
