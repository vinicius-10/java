//vinicius souza Dias 2564599


public class MenuDidatico implements Menus {
    private Didatico didatico;
    private Armazenamento armazen;
    private MenuAutor menuAutor;
    private MenuEditora menuEditora;

    private static MenuDidatico unicMenuDidatico; //singleton 1 passo
    
    private MenuDidatico() {// contrutores privados 2 passo
        armazen = Armazenamento.geraArmazen();
        didatico = new Didatico();
        menuAutor = MenuAutor.gerarMenuAutor();
        menuEditora = MenuEditora.gerarMenuEditora();
    }

    //polimorfismo por sobrecarga
    private MenuDidatico(Didatico didatico, Armazenamento armazen) {
        this.didatico = didatico;
        this.armazen = armazen;
    }

    public static MenuDidatico geraMenuDidatico() { //passo 3
        if(unicMenuDidatico == null) {
            unicMenuDidatico = new MenuDidatico();
        }
        return unicMenuDidatico;
    }

    public Didatico getDidatico() { return didatico; }
    public void setDidatico(Didatico didatico) { this.didatico = didatico; }
    
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

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }
    public Armazenamento getArmaze() {
        return armazen;
    }

    public void Menu() {

        boolean loopMenu = true;

        do{
            System.out.println("\n\nBem-vindo ao menu de livros didáticos!");
            System.out.println("Por favor, escolha uma opção do menu para continuar.");
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("--------------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                    |");
            System.out.println("|1-Cadastrar livro didático                                   |");
            System.out.println("|2-Buscar livros didáticos                                     |");
            System.out.println("|3-Excluir livro didático                                     |");
            System.out.println("|4-Reativar livro didático                                    |");
            System.out.println("--------------------------------------------------------------");

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
        didatico = new Didatico();

        boolean loopId = false;
        do{
            didatico.setId(Leitura.entInt("Digite o ID do livro didático: "));

            if(didatico.getId() <= 0) {
                System.out.println("ID invalido, nao pode ser menor ou igual a 0, tente novamente.");
                loopId = true;
                continue;
            }

            for(Didatico temp : armazen.getBdDidatico()) {
                if(temp.getId() == didatico.getId()) {
                    System.out.println("ID já cadastrado, tente novamente.");
                    loopId = true;
                    break;
                }
            }
        } while(loopId);

        do{
            try{
                didatico.setTitulo(Leitura.entString("Digite o titulo do livro didático: "));
                break;
            }catch (LivroExecption exp) {
                exp.menExecption();
                
            }
        }while(true);

        //reflexividade para cadsatro das informaçoes sobre a localização ".getLocalizacao()"
        do{//tratamento de exeção
            try{
                didatico.getLocalizacao().setSecao(Leitura.entString("Digite a secao do livro didático: "));
                break;
            }catch(LivroExecption exp){
                exp.menExecption();
            }
            System.gc();
        }while(true);

        didatico.getLocalizacao().setPrateleira(Leitura.entInt("Digite a prateleira do livro didático: "));
        didatico.getLocalizacao().setLinha(Leitura.entInt("Digite a linha do livro didático: "));

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
                            didatico.setAutor(temp);
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
        System.out.println("Para vincualr a editora, sera preciso digitar o CPPJ da editora!!");
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
                            didatico.setEditora(temp);
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
            System.gc();
        }while(loopEditora);

        didatico.setNivel(Leitura.entString("Digite o nivel de ensino do livro didático: "));
        didatico.setMateria(Leitura.entString("Digite a materia do livro didatico: "));
        didatico.setComplexidade(Leitura.entString("Digite a complexidade do livro didático: "));

        armazen.getBdDidatico().add(didatico);
        System.out.println("\n\nLivro didático cadastrado com sucesso.");
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
                    String titulo = Leitura.entString("Digite o titulo do livro didático: ");
                    for(Didatico temp : armazen.getBdDidatico()) {
                        if(temp.getTitulo().equalsIgnoreCase(titulo)) {
                            printLivro(temp);
                            findBusca = false;
                            break;
                        }
                    }

                    if(findBusca) {
                        System.out.println("Livro didatico não encontrado.");
                    }
                    break;

                case "2":
                    int id = Leitura.entInt("Digite o ID do livro didático: ");
                    for(Didatico temp : armazen.getBdDidatico()) {
                        if(temp.getId() == id) {
                            printLivro(temp);
                            findBusca = false;
                            break;
                        }
                    }
                    if(findBusca) {
                        System.out.println("Livro didático não encontrado.");
                    }
                    break;

                case "3":
                    for(Didatico temp : armazen.getBdDidatico()) {
                        printLivro(temp);
                        findBusca = false;
                    }
                    if(findBusca) {
                        System.out.println("Nenhum livro didático cadastrado.");
                    }
                    break;

                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    loopExibir = true;
                    break;
            }
            System.gc();
        }while(loopExibir);
    }

    private void printLivro(Didatico didatico) {
        System.out.println("\nID: " + didatico.getId() + 
                           " - Titulo: " + didatico.getTitulo() + 
                           " - Nivel de Ensino: " + didatico.getNivel() +
                           " - Materia: " + didatico.getMateria() +
                           " - Complexidade: " + didatico.getComplexidade() +
                           "\nAutor: " + didatico.getAutor().getNome() +//reflexividade
                           "\nEditora: " + didatico.getEditora().getNome() +//reflexividade
                           "\nLocalização: Seção: " + didatico.getLocalizacao().getSecao() +//reflexividade
                           ", Prateleira: " + didatico.getLocalizacao().getPrateleira() +//reflexividade
                           ", Linha: " + didatico.getLocalizacao().getLinha()+//reflexividade
                           "\nDisponivel: " + (didatico.getbloqueado() ? "Nao" : "Sim"));
    }

    //polimorfismo por sobrescrita
    @Override
    public void excluir() {

        System.out.println("Será preciso digitar o ID!!");
        String optionReativar = Leitura.entString("Deseja listar os livros didáticos? (S/N): ");

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

        int IdBuscado = Leitura.entInt("Digite o ID do livro didático a ser excluida, 0 para cancelar: ");
        boolean foundExcluir = true;

        for(Didatico temp : armazen.getBdDidatico()) {
            if(temp.getId() == IdBuscado) {
                temp.setbloqueado(true);
                System.out.println("\n\nLivro didatico excluido com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("\n\nLivro didatico nao encontrado.");
        }
    }

    //polimorfismo por sobrescrita
    @Override
    public void reativar() {
        System.out.println("Sera preciso digitar o ID!!");
        String optionReativar = Leitura.entString("Deseja listar os livros didaticos? (S/N): ");

        switch (optionReativar.toUpperCase()) {
            case "S":
                exibir();
                break;
            case "N":
                System.out.println("Continuando.");
                break;
            default:
                System.out.println("Opcao invalida, sera exibido, precione 0 casso queira pular..");
                exibir();
                break;
        }
        int IdBuscado = Leitura.entInt("Digite a Id do livro didatico a ser reativada: ");
        boolean foundReativar = true;

        for(Didatico temp : armazen.getBdDidatico()) {
            if(temp.getId() == IdBuscado) {
                temp.setbloqueado(false);
                System.out.println("\n\nLivro didatico reativado com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("\n\nLivro didatico nao encontrado.");
        }
    }

    public static void main(String[] args) {
        MenuDidatico menuDidatico = MenuDidatico.geraMenuDidatico();
        menuDidatico.Menu();
    }
}

