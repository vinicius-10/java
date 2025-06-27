
import javax.swing.JOptionPane;

//vinicius souza Dias 2564599

public class EditoraExecption  extends Exception {
    
    private String execption = "";

    public EditoraExecption(String exeception) {
        this.execption = exeception;
    }
    

    public void menExecption() {
        if("TinyNameExecption".equals(execption)){
            System.out.println("Nome muito pequeno");
        }else if("TinyCnpjExecption".equals(execption)){
            System.out.println("CNPJ muito curto");
        }
    }

    public Editora corTinyNameExecption(Editora editora) {
        
            try{
                editora.setNome(getCorrecao("Digite o nome da editora: "));
            }catch(EditoraExecption e) {
                e.menExecption();
                return corTinyNameExecption(editora);
            }
        return editora;
    }

    public Editora corTinyCnpjExecption(Editora editora) {
        
            try{
                editora.setCnpj(getCorrecao("Digite o CNPJ da editora: "));
            }catch(EditoraExecption e) {
                e.menExecption();
                return corTinyCnpjExecption(editora);
            }
        return editora;
    }
    
    public String getCorrecao(String men){
        String corecao = JOptionPane.showInputDialog(
                null,
                men,
                "Valor invalido",
                JOptionPane.INFORMATION_MESSAGE
        );
        
        return corecao;
    }
}
