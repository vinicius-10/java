//vinicius souza Dias 2564599



public class MenuEditora implements Menus{
    private Editora editora;
    private Armazenamento armazen;

    private static MenuEditora unicMenuEditora; //singleton 1 passo 


    private MenuEditora() { // contrutores privados 2 passo
        editora = new Editora();
        armazen = Armazenamento.geraArmazen();
    }

    //polimorfismo por sobrecarga
    private MenuEditora(Editora editora, Armazenamento armazen) {
        this.editora = editora;
        this.armazen = armazen;
    }

    public static MenuEditora gerarMenuEditora() { //passo 3
        if(unicMenuEditora == null) {
            unicMenuEditora = new MenuEditora();
        }
        return unicMenuEditora;
    }

    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }

    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }

    //polimorfismo por sobrescrita
    @Override
    public void Menu(){
        boolean condition = true;

        do{
            editora = new Editora();

            System.out.println("\n\nBem-vindo ao menu de editoras!");
            System.out.println("Por favor, escolha uma opção do menu para continuar.");
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                  |");
            System.out.println("|1-Cadastrar editora                                        |");
            System.out.println("|2-Buscar editoras                                          |");
            System.out.println("|3-Excluir editora                                          |");
            System.out.println("|4-Reativar editora                                         |");
            System.out.println("-----------------------------------------------------------");

            String opcaoGeral = Leitura.entString("Opcao: ");
            
            switch (opcaoGeral) {
                case "0":
                    condition = false;
                    break;
                case "1":
                    
                    cadastrar();        

                    break;
                case "2":
                
                    exibir();
                    
                    break;
                case "3":
        
                    excluir();
                    
                    break;
                case "4":
                    
                    reativar();
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    break;
            }
            System.gc();
        }while(condition);
        
    }

    //polimorfismo por sobrescrita
    @Override
    public void cadastrar(){
        try{
            editora.setNome(Leitura.entString("Digite o nome da editora: "));
        }catch(EditoraExecption e) {
            e.menExecption();
            editora = e.corTinyNameExecption(editora);
        }

        try{
            editora.setCnpj(Leitura.entString("Digite o CNPJ da editora: "));
        }catch(EditoraExecption e) {
            e.menExecption();
            editora = e.corTinyCnpjExecption(editora);
        }
        

        boolean foundCadastro = true;

        for(Editora temp : armazen.getBdEditoras()) {
            if(temp.getCnpj().equals(editora.getCnpj())) {
                System.out.println("CNPJ já cadastrado.");
                foundCadastro = false;
                break;
            }
        }      

        if(foundCadastro) {
            armazen.getBdEditoras().add(editora);
            System.out.println("\n\nEditora cadastrada com sucesso.");
        }
    }

    
    //polimorfismo por sobrescrita
    @Override
    public void exibir(){
        boolean conditionExibir = false;
        do{
            conditionExibir = false;
            System.out.println("Buscar Editoras por:");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                |");
            System.out.println("|1-Nome                                                   |");
            System.out.println("|2-CNPJ                                                   |");
            System.out.println("                                           |");
            System.out.println("-----------------------------------------------------------");

            String opcaoBusca = Leitura.entString("Opcao: ");
            boolean findBusca = true;
            switch (opcaoBusca) {
                case "0":
                    System.out.println("Voltando ao menu anterior.");
                    return;
                case "1":
                    String nome = Leitura.entString("Digite o nome da editora: ");
                    for(Editora temp : armazen.getBdEditoras()) {
                        if(temp.getNome().equalsIgnoreCase(nome)) {
                            System.out.println("\nNome: " + temp.getNome() + " - CNPJ: " + temp.getCnpj() + " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
                            findBusca = false;
                            break;
                        }
                    }

                    if(findBusca) {
                        System.out.println("Editora não encontrada.");
                    }
                    break;

                case "2":
                    String cnpj = Leitura.entString("Digite o CNPJ da editora: ");
                    for(Editora temp : armazen.getBdEditoras()) {
                        if(temp.getCnpj().equals(cnpj)) {
                            System.out.println(
                                "\nNome: " + temp.getNome() +
                             " - CNPJ: " + temp.getCnpj() + 
                             " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
                            findBusca = false;
                        }
                    }
                    if(findBusca) {
                        System.out.println("Editora não encontrada.");
                    }
                    break;
                case "3":
                    System.out.println("Listando todas as editoras:");
                    for(Editora temp : armazen.getBdEditoras()) {
                        System.out.println("\nNome: " + temp.getNome() + " - CNPJ: " + temp.getCnpj() + " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
                    }
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    conditionExibir = true;
            }
            System.gc();
        }while(conditionExibir);
    }

    //polimorfismo por sobrescrita
    @Override
    public void excluir() {
        System.out.println("Será preciso digitar o CNPJ!!");
        String optionReativar = Leitura.entString("Deseja lsitar as editora? (S/N): ");

        switch (optionReativar.toUpperCase()) {
            case "S":
                exibir();
                break;
            case "N":
                System.out.println("Continuando.");
                break;
            default:
                System.out.println("Opcao invalida, será exibido, precione 0 casso queira pular..");
                exibir();
                break;
        }

        String cnpjBuscado = Leitura.entString("Digite o CNPJ da editora a ser excluída: ");
        boolean foundExcluir = true;
 
        for(Editora temp : armazen.getBdEditoras()) {
            if(temp.getCnpj().equals(cnpjBuscado)) {
                temp.setbloqueado(true);
                System.out.println("\n\nEditora excluída com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("\n\nEditora não encontrada.");
        }
    }

    //polimorfismo por sobrescrita
    @Override
    public void reativar() {
        System.out.println("Será preciso digitar o CNPJ!!");
        String optionReativar = Leitura.entString("Deseja lsitar as editora? (S/N): ");

        switch (optionReativar.toUpperCase()) {
            case "S":
                exibir();
                break;
            case "N":
                System.out.println("Continuando.");
                break;
            default:
                System.out.println("Opcao invalida, será exibido, precione 0 casso queira pular..");
                exibir();
                break;
        }
        String cnpjBuscado = Leitura.entString("Digite o CNPJ da editora a ser reativada: ");
        boolean foundReativar = true;

        for(Editora temp : armazen.getBdEditoras()) {
            if(temp.getCnpj().equals(cnpjBuscado)) {
                temp.setbloqueado(false);
                System.out.println("\n\nEditora reativada com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("\n\nEditora não encontrada.");
        }
    }

    
    
    public static void main(String[] args) {
        MenuEditora menu = new MenuEditora();
        menu.Menu();
    }
}
