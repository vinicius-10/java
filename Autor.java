//vinicius souza Dias

public class Autor extends Objetos {
    private String nome;
    private String cpf;

    public Autor() {
        super();
        this.nome = "";
        this.cpf = "";
    }

    //polimorfismo por sobrecarga
    public Autor(boolean bloqueado, String nome, String cpf) {
        super(bloqueado);
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }

    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }

}
