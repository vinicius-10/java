//vinicius souza Dias 2564599
public class MenuColecionavel implements Menus {
    private Colecionavel colecionavel;
    private Armazenamento armazen;
    private MenuAutor menuAutor;
    private MenuEditora menuEditora;

    private static MenuColecionavel unicMenuColecionavel;//singleton 1 passo

    private MenuColecionavel() {//construtor privado 2 passo
        colecionavel = new Colecionavel();
        armazen = Armazenamento.geraArmazen();
        menuAutor = MenuAutor.gerarMenuAutor();
        menuEditora = MenuEditora.gerarMenuEditora();
        
    }

    //polimorfismo por sobrecarga
    private MenuColecionavel(Colecionavel colecionavel, Armazenamento armazen, MenuAutor menuAutor, MenuEditora menuEditora) {
        this.menuAutor = menuAutor;
        this.menuEditora = menuEditora;
        this.colecionavel = colecionavel;
        this.armazen = armazen;
    }

    public static MenuColecionavel gerarMenuColecionavel() {//singleton 3 passo
        if(unicMenuColecionavel == null) {
            unicMenuColecionavel = new MenuColecionavel();
        }
        return unicMenuColecionavel;
    }

    public Colecionavel getColecionavel() { return colecionavel; }
    public void setColecionavel(Colecionavel colecionavel) { this.colecionavel = colecionavel; }

    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }
    
    public MenuAutor getMenuAutor() {
        return menuAutor;
    }

    public void setMenuAutor(MenuAutor menuAutor) {
        this.menuAutor = menuAutor;
    }

    public MenuEditora getMenuEditora() {
        return menuEditora;
    }

    public void setMenuEditora(MenuEditora menuEditora) {
        this.menuEditora = menuEditora;
    }
    

    //polimorfismo por sobrescrita
    @Override
    public void Menu(){
        

        boolean loopMenu = true;

        do{
            
            System.out.println("\n\nBem-vindo ao menu de colecionáveis!");
            System.out.println("Por favor, escolha uma opção do menu para continuar.");
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("-------------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                   |");
            System.out.println("|1-Cadastrar colecionável                                    |");
            System.out.println("|2-Buscar colecionáveis                                      |");
            System.out.println("|3-Excluir colecionável                                      |");
            System.out.println("|4-Reativar colecionável                                     |");
            System.out.println("-------------------------------------------------------------");

            String opcaoGeral = Leitura.entString("Opcao: ");
            
            switch (opcaoGeral) {
                case "0":
                    loopMenu = false;
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
        }while(loopMenu);
    }

    //polimorfismo por sobrescrita
    @Override
    public void cadastrar() {
        colecionavel = new Colecionavel();

        boolean loopId = false;
        do{
            colecionavel.setId(Leitura.entInt("Digite o ID do colecionável: "));

            if(colecionavel.getId() <= 0) {
                System.out.println("ID invalido, nao pode ser menor ou igual a 0, tente novamente.");
                loopId = true;
                continue;
            }

            for(Colecionavel temp : armazen.getBdColecionavel()) {
                if(temp.getId() == colecionavel.getId()) {
                    System.out.println("ID já cadastrado, tente novamente.");
                    loopId = true;
                    break;
                }
            }
        } while(loopId);

        do{
            try{
                colecionavel.setTitulo(Leitura.entString("Digite o título do colecionável: "));
                break;
            }catch (LivroExecption exp) {
                exp.menExecption();
                
            }
        }while(true);

        //reflexividade para cadsatro das informaçoes sobre a localização ".getLocalizacao()"
        do{
            try{
                colecionavel.getLocalizacao().setSecao(Leitura.entString("Digite a secao do colecionável: "));
                break;
            }catch(LivroExecption exp){
                exp.menExecption();
            }
        }while(true);

        colecionavel.getLocalizacao().setPrateleira(Leitura.entInt("Digite a prateleira do colecionável: "));
        colecionavel.getLocalizacao().setLinha(Leitura.entInt("Digite a linha do colecionável: "));

        System.out.println("Para vinclar o autor, será preciso digitar o CPF do autor!!");
        boolean loopAutor = true;
        do{
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("-------------------------------------------------------------");
            System.out.println("|1-Buscar autor                                              |");
            System.out.println("|2-Cadastrar um novo autor ao sistema                        |");
            System.out.println("|3-Vincular o autor ao livro                                 |");
            System.out.println("-------------------------------------------------------------");
            
            String opcaoAutor = Leitura.entString("Opcao: ");

            switch (opcaoAutor) {
                case "1":                  
                    menuAutor.exibir();
                    break;

                case "2":                   
                    menuAutor.cadastrar();
                    break; 

                case "3": 
                
                    String cpfAutor = Leitura.entString("Digite o CPF do autor: ");
                    boolean encontrouAutor = false;
                    for (Autor temp : armazen.getBdAutores()) {
                        if(temp.getCpf().equalsIgnoreCase(cpfAutor) && !temp.getbloqueado()) {
                            colecionavel.setAutor(temp);
                            loopAutor = false; 
                            encontrouAutor = true;
                            System.out.println("\nAutor vinculado com sucesso!");
                            break;
                        }
                    }

                    if(!encontrouAutor) {
                        System.out.println("Autor não encontrado. Tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    break;
            }
            System.gc();
        }while(loopAutor);

        System.out.println("Para vincualr a editora, será preciso digitar o CPPJ da editora!!");
        boolean loopEditora = true;

        do{
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("-------------------------------------------------------------");
            System.out.println("|1-Buscar editora                                            |");
            System.out.println("|2-Cadastrar uma nova editora ao sistema                     |");
            System.out.println("|3-Vincular a editora ao livro                                |");
            System.out.println("-------------------------------------------------------------");

            String opcaoEditora = Leitura.entString("Opcao: ");

            switch (opcaoEditora) {
                case "1":                  
                    menuEditora.exibir();
                    break;

                case "2":                   
                    menuEditora.cadastrar();
                    break; 

                case "3": 
                
                    String cnpjEditora = Leitura.entString("Digite o CNPJ da editora: ");
                    boolean encontrouEditora = false;
                    for (Editora temp : armazen.getBdEditoras()) {
                        if(temp.getCnpj().equalsIgnoreCase(cnpjEditora) && !temp.getbloqueado()) {
                            colecionavel.setEditora(temp);
                            loopEditora = false; 
                            encontrouEditora = true;
                            System.out.println("\nEditora vinculada com sucesso!");
                            break;
                        }
                    }

                    if(!encontrouEditora) {
                        System.out.println("Editora não encontrada. Tente novamente.");
                    }
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    break;
            }

        }while(loopEditora);
        
        colecionavel.setEdicaoEspecial(Leitura.entString( "Digite a edição especial do colecionável: "));
        colecionavel.setAdicional(Leitura.entString("Digite o adicional se existir: "));

        do{
            String numerado = Leitura.entString("O colecionável é numerado? (S/N): ");
            if(numerado.equalsIgnoreCase("S")) {
                colecionavel.setNumerado(true);
                break;
            } else if(numerado.equalsIgnoreCase("N")) {
                colecionavel.setNumerado(false);
                break;
            }else{
                System.out.println("Opcao invalida, tente novamente.");
            }
            
        }while(true);

        armazen.getBdColecionavel().add(colecionavel);
        System.out.println("\n\nColecionável cadastrado com sucesso.");
    }

    //polimorfismo por sobrescrita
    @Override
    public void exibir() {
        boolean loopExibir = false;
        do{
            loopExibir = false;
            System.out.println("Buscar Livro por:");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                |");
            System.out.println("|1-Nome                                                   |");
            System.out.println("|2-ID                                                     |");
            System.out.println("|3-Listar todos                                           |");
            System.out.println("-----------------------------------------------------------");

            String opcaoBusca = Leitura.entString("Opcao: ");
            boolean findBusca = true;

            switch (opcaoBusca) {
                case "0":
                    System.out.println("Voltando ao menu anterior.");
                    return;
                case "1":
                    String titulo = Leitura.entString("Digite o título do colecionável: ");
                    for(Colecionavel temp : armazen.getBdColecionavel()) {
                        if(temp.getTitulo().equalsIgnoreCase(titulo)) {
                            printLivro(temp);
                            findBusca = false;
                            break;
                        }
                    }

                    if(findBusca) {
                        System.out.println("Colecionável não encontrado.");
                    }
                    break;

                case "2":
                    int id = Leitura.entInt("Digite o ID do colecionável: ");
                    for(Colecionavel temp : armazen.getBdColecionavel()) {
                        if(temp.getId() == id) {
                            printLivro(temp);
                            findBusca = false;
                            break;
                        }
                    }
                    if(findBusca) {
                        System.out.println("Colecionável não encontrado.");
                    }
                    break;

                case "3":
                    for(Colecionavel temp : armazen.getBdColecionavel()) {
                        printLivro(temp);
                        findBusca = false;
                    }
                    if(findBusca) {
                        System.out.println("Nenhum colecionável cadastrado.");
                    }
                    break;

                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    loopExibir = true;
                    break;
            }
        }while(loopExibir);
    }

    public void printLivro(Colecionavel colecionavel) {
        System.out.println("\nID: " + colecionavel.getId() + 
                           " - Título: " + colecionavel.getTitulo() + 
                           " - Edição Especial: " + colecionavel.getEdicaoEspecial() +
                           " - Adicional: " + colecionavel.getAdicional() +
                           " - Numerado: " + (colecionavel.isNumerado() ? "Sim" : "Não") +
                           "\nAutor: " + colecionavel.getAutor().getNome() +//reflexividade
                           "\nEditora: " + colecionavel.getEditora().getNome() +//reflexividade
                           "\nLocalização: Seção: " + colecionavel.getLocalizacao().getSecao() +//reflexividade
                           ", Prateleira: " + colecionavel.getLocalizacao().getPrateleira() +//reflexividade
                           ", Linha: " + colecionavel.getLocalizacao().getLinha()+//reflexividade
                           "\nDisponivel: " + (colecionavel.getbloqueado() ? "Nao" : "Sim"));
    }

    //polimorfismo por sobrescrita
    @Override
    public void excluir() {

        System.out.println("Será preciso digitar o ID!!");
        String optionReativar = Leitura.entString("Deseja listar os colecionaveis? (S/N): ");

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

        int IdBuscado = Leitura.entInt("Digite o ID do coleionavel a ser excluída, 0 para cancelar: ");
        boolean foundExcluir = true;

        for(Colecionavel temp : armazen.getBdColecionavel()) {
            if(temp.getId() == IdBuscado) {
                temp.setbloqueado(true);
                System.out.println("\n\nColecionável excluído com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("\n\nColecioanvel não encontrada.");
        }
    }

    //polimorfismo por sobrescrita
    @Override
    public void reativar() {
        System.out.println("Será preciso digitar o ID!!");
        String optionReativar = Leitura.entString("Deseja listar os colecionaveis? (S/N): ");

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
        int IdBuscado = Leitura.entInt("Digite a Id do colecionavel a ser reativada: ");
        boolean foundReativar = true;

        for(Colecionavel temp : armazen.getBdColecionavel()) {
            if(temp.getId() == IdBuscado) {
                temp.setbloqueado(false);
                System.out.println("\n\nColecionável reativado com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("\n\nEditora não encontrada.");
        }
    }

    public static void main(String[] args) {
        MenuColecionavel menu = new MenuColecionavel();
        menu.Menu();;
    }
}
