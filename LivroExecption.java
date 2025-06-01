//Vinicius Souza Dias 2564599

public class LivroExecption  extends Exception {
    
    private String execption = "";

    public LivroExecption(String exeception) {
        this.execption = exeception;
    }

    public void menExecption() {
        if("TinyTitleExecption".equals(execption)){
            System.out.println("Nome muito pequeno");
        }else if("TinySecaoExecption".equals(execption)){
            System.out.println("Secao muito curta");
        }
    }
    
    
}
