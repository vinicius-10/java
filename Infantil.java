//vinicius souza Dias
public class Infantil extends Livro {
    private int faixaEtaria;
    private String material;
    private boolean interativo;

    public Infantil() {
        super();
        this.faixaEtaria = 0;
        this.material = "";
        this.interativo = false;
    }

    //polimorfismo por sobrecarga
    public Infantil(int id, String titulo, Autor autor, Localizacao localizacao, Editora editora, boolean bloqueado, int faixaEtaria, String material, boolean interativo) {
        super(id,titulo, autor, localizacao, editora, bloqueado);
        this.faixaEtaria = faixaEtaria;
        this.material = material;
        this.interativo = interativo;
    }

    public int getFaixaEtaria() { return faixaEtaria; }
    public String getMaterial() { return material; }
    public boolean isInterativo() { return interativo; }

    public void setFaixaEtaria(int faixaEtaria) { this.faixaEtaria = faixaEtaria; }
    public void setMaterial(String material) { this.material = material; }
    public void setInterativo(boolean interativo) { this.interativo = interativo; }

}
