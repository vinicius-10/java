//vinicius souza Dias 2564599


public class Localizacao {
    private String secao;
    private int prateleira;
    private int linha;

    public Localizacao() {
        this.secao = "";
        this.prateleira = 0;
        this.linha = 0;
    }

    //polimorfismo por sobrecarga
    public Localizacao(String secao, int prateleira, int linha) {
        this.secao = secao;
        this.prateleira = prateleira;
        this.linha = linha;
    }

    public String getSecao() { return secao; }
    public int getPrateleira() { return prateleira; }
    public int getLinha() { return linha; }

    public void setSecao(String secao)throws LivroExecption {
        secao = secao.trim().replaceAll("\\s+"," ");
        
        if(secao.length() <= 3){
            throw new LivroExecption("TinySecaoExecption");
        }
        this.secao = secao;

        this.secao = secao; }
    public void setPrateleira(int prateleira) { this.prateleira = prateleira; }
    public void setLinha(int linha) { this.linha = linha; }

}
