//Vinicius Souza Dias 2564599

import javax.swing.JOptionPane;

public class LivroExecption  extends Exception {
    
    private String execption = "";

    public LivroExecption(String exeception) {
        this.execption = exeception;
    }

    public void menExecption() {
        if("TinyTitleExecption".equals(execption)){
            JOptionPane.showMessageDialog(
                null,
                "O nome do livro deve ter mais de 3 caracteres",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }else if("TinySecaoExecption".equals(execption)){
            JOptionPane.showMessageDialog(
                null,
                "A seção deve ter mais de 3 caracteres",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    
}
