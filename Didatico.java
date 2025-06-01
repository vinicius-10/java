//vinicius souza Dias 2564599
public final class Didatico extends Livro {
    private String materia;
    private String nivel;
    private String complexidade;

    public Didatico() {
        super(); 
        this.materia = "";
        this.nivel = "";
        this.complexidade = "";
    }

    //polimorfismo por sobrecarga
    public Didatico(int id, String titulo, Autor autor, Localizacao localizacao, Editora editora, boolean bloqueado, String materia, String nivel, String complexidade) {
        super(id,titulo, autor, localizacao, editora, bloqueado);
        this.materia = materia;
        this.nivel = nivel;
        this.complexidade = complexidade;
    }

    public String getMateria() { return materia; }
    public String getNivel() { return nivel; }
    public String getComplexidade() { return complexidade; }

    public void setMateria(String materia) { this.materia = materia; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public void setComplexidade(String complexidade) { this.complexidade = complexidade; }

}
