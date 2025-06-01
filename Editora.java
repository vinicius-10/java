//vinicius souza Dias 2564599


public final class Editora extends Objetos {
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

    public void setNome(String nome)throws EditoraExecption {
        nome = nome.trim().replaceAll("\\s+"," ");

        if(nome.length() <= 3) {
            throw new EditoraExecption("TinyNameExecption");
        } 
        this.nome = nome; }
    public void setCnpj(String cnpj)throws EditoraExecption {
        cnpj = cnpj.trim().replaceAll("\\s+"," ");
        if(cnpj.length() <= 3) {
            throw new EditoraExecption("TinyCnpjExecption");
        }

        //aqui faria validacao do cnpj
        this.cnpj = cnpj; }

}
