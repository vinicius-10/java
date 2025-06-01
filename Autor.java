//vinicius souza Dias 2564599


public final class Autor extends Objetos {
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

    public void setNome(String nome) throws AutorExecption {
        nome = nome.trim().replaceAll("\\s+", " ");

        if (nome.length() <= 3) {
            throw new AutorExecption("TinyNameExecption");
        }
        
        this.nome = nome; 
    }
    public void setCpf(String cpf)throws AutorExecption {
        cpf = cpf.trim().replaceAll("\\s+", " ");
        if (cpf.length() <= 3) {
            throw new AutorExecption("TinyCpfExecption");
        }
        
        this.cpf = cpf; 
    }

}
