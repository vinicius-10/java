//vinicius souza Dias
public class MenuEditora implements Menus{
    private Editora editora;
    private Armazenamento armazen;

    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }

    public MenuEditora() {
        editora = new Editora();
        armazen = Armazenamento.geraArmazen();
    }

    //polimorfismo por sobrecarga
    public MenuEditora(Editora editora, Armazenamento armazen) {
        this.editora = editora;
        this.armazen = armazen;
    }

    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }

    public void Menu(){
        boolean condition = true;

        do{
            editora = new Editora();

            System.out.println("\n\n\n\nDigite um numero para escolher uma opção");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                  |");
            System.out.println("|1-Cadastrar editora                                        |");
            System.out.println("|2-Buscar editoras                                          |");
            System.out.println("|3-Excluir editora                                          |");
            System.out.println("|4-Reativar editora                                         |");
            System.out.println("-----------------------------------------------------------");

            String opcaoGeral = Leitura.entString("Opção: ");
            
            switch (opcaoGeral) {
                case "0":
                    condition = false;
                    break;
                case "1":
                    
                    cadEditora();        

                    break;
                case "2":
                
                    exibirEditora();
                    
                    break;
                case "3":
                    String optionExcluir = Leitura.entString("Deseja lsitar as editora? (S/N): ");

                    switch (optionExcluir.toUpperCase()) {
                        case "S":
                            exibirEditora();
                            break;
                        case "N":
                            System.out.println("Continuando.");
                            break;
                        default:
                            System.out.println("Opção inválida, será exibido, precione 0 casso queira pular..");
                            exibirEditora();
                            break;
                    }
                    excluirEditora();
                    
                    break;
                case "4":
                    String optionReativar = Leitura.entString("Deseja lsitar as editora? (S/N): ");

                    switch (optionReativar.toUpperCase()) {
                        case "S":
                            exibirEditora();
                            break;
                        case "N":
                            System.out.println("Continuando.");
                            break;
                        default:
                            System.out.println("Opção inválida, será exibido, precione 0 casso queira pular..");
                            exibirEditora();
                            break;
                    }
                    reativarEditora();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
            System.gc();
        }while(condition);
        
    }


    public void exibirEditora(){
        boolean conditionExibir = false;
        do{
            conditionExibir = false;
            System.out.println("Buscar Editoras por:");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                |");
            System.out.println("|1-Nome                                                   |");
            System.out.println("|2-CNPJ                                                   |");
            System.out.println("|3-Listar todos                                           |");
            System.out.println("-----------------------------------------------------------");

            String opcaoBusca = Leitura.entString("Opção: ");
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
                            System.out.println("\nNome: " + temp.getNome() + " - CNPJ: " + temp.getCnpj() + " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
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
                    System.out.println("Opção inválida, tente novamente.");
                    conditionExibir = true;
            }
            System.gc();
        }while(conditionExibir);
    }

    public void cadEditora(){
        editora.setNome(Leitura.entString("Digite o nome da editora: "));

        editora.setCnpj(Leitura.entString("Digite o CNPJ da editora: "));

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
            System.out.println("Editora cadastrada com sucesso.");
        }
    }

    public void excluirEditora() {

        String cnpjBuscado = Leitura.entString("Digite o CNPJ da editora a ser excluída: ");
        boolean foundExcluir = true;
 
        for(Editora temp : armazen.getBdEditoras()) {
            if(temp.getCnpj().equals(cnpjBuscado)) {
                temp.setbloqueado(true);
                System.out.println("Editora excluída com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("Editora não encontrada.");
        }
    }

    public void reativarEditora() {
        String cnpjBuscado = Leitura.entString("Digite o CNPJ da editora a ser reativada: ");
        boolean foundReativar = true;

        for(Editora temp : armazen.getBdEditoras()) {
            if(temp.getCnpj().equals(cnpjBuscado)) {
                temp.setbloqueado(false);
                System.out.println("Editora reativada com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("Editora não encontrada.");
        }
    }
    public static void main(String[] args) {
        MenuEditora menu = new MenuEditora();
        menu.Menu();
    }
}
