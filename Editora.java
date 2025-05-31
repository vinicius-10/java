//vinicius souza Dias
public class Editora extends Objetos {
    private String nome;
    private String cnpj;
    

    public Editora() {
        super();
        this.nome = "";
        this.cnpj = "";
    }

    //polimorfismo por sobrecarga
    public Editora(boolean bloqueado, String nome, String cnpj) {
        super(bloqueado);
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

}
