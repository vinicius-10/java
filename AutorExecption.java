
import javax.swing.JOptionPane;

//vinicius souza Dias 2564599
public class AutorExecption extends Exception {

    private String execption = "";

    public AutorExecption(String exeception) {
        this.execption = exeception;
    }
    

    public void menExecption() {
        if("TinyNameExecption".equals(execption)){
            System.out.println("Nome muito pequeno");
        }else if("TinyCpfExecption".equals(execption)){
            System.out.println("CPF muito curto");
        }
    }

    public Autor corTinyNameExecption(Autor autor) {
        
            try{
                autor.setNome(getCorrecao("Nome muito curto. Digite novamente: "));
            }catch(AutorExecption e) {
     
                return corTinyNameExecption(autor);
            }
        return autor;
    }

    public Autor corTinyCpfExecption(Autor autor) {
        
            try{
                autor.setCpf(getCorrecao("CPF muito curto. Digite novamente: "));
            }catch(AutorExecption e) {
     
                return corTinyCpfExecption(autor);
            }
        return autor;
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
