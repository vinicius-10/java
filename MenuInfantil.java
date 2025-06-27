//vinicius souza Dias 2564599


public class MenuInfantil  implements Menus {
    private Infantil infantil;
    private Armazenamento armazen;
    private MenuAutor menuAutor;
    private MenuEditora menuEditora;

    private static MenuInfantil unicMenuInfantil; //singleton 1 passo
    

    private MenuInfantil() {// contrutores privados 2 passo
        armazen = Armazenamento.geraArmazen();
        infantil = new Infantil();
        menuAutor = MenuAutor.gerarMenuAutor();
        menuEditora = MenuEditora.gerarMenuEditora();
    }

    //polimorfismo por sobrecarga
    private MenuInfantil(Infantil infantil, Armazenamento armazen) {
        this.infantil = infantil;
        this.armazen = armazen;
    }

    public static MenuInfantil gerarMenuInfantil() { //passo 3
        if(unicMenuInfantil == null) {
            unicMenuInfantil = new MenuInfantil();
        }
        return unicMenuInfantil;
    }

    public Infantil getInfantil() { return infantil; }
    public void setInfantil(Infantil infantil) { this.infantil = infantil; }

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

    public void Menu() {

        boolean loopMenu = true;

        do{
            System.out.println("\n\nBem-vindo ao menu de livros infantis!");
            System.out.println("Por favor, escolha uma opção do menu para continuar.");
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("--------------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                    |");
            System.out.println("|1-Cadastrar livro infantil                                   |");
            System.out.println("|2-Buscar livros infantis                                     |");
            System.out.println("|3-Excluir livro infantil                                     |");
            System.out.println("|4-Reativar livro infantil                                    |");
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
   
    public void cadastrar() {
        infantil = new Infantil();

        boolean loopId = false;
        do{
            infantil.setId(Leitura.entInt("Digite o ID do livro infantil: "));

            if(infantil.getId() <= 0) {
                System.out.println("ID invalido, nao pode ser menor ou igual a 0, tente novamente.");
                loopId = true;
                continue;
            }

            for(Infantil temp : armazen.getBdInfantil()) {
                if(temp.getId() == infantil.getId()) {
                    System.out.println("ID já cadastrado, tente novamente.");
                    loopId = true;
                    break;
                }
            }
        } while(loopId);

        do{
            try{
                infantil.setTitulo(Leitura.entString("Digite o titulo do livro infantil: "));
                break;
            }catch (LivroExecption exp) {
                exp.menExecption();
                
            }
            System.gc();
        }while(true);

        //reflexividade para cadsatro das informaçoes sobre a localização ".getLocalizacao()"
        do{//tratamento de exeção
            try{
                infantil.getLocalizacao().setSecao(Leitura.entString("Digite a secao do livro infantil: "));
                break;
            }catch(LivroExecption exp){
                exp.menExecption();
            }
        }while(true);

        infantil.getLocalizacao().setPrateleira(Leitura.entInt("Digite a prateleira do livro infantil: "));
        infantil.getLocalizacao().setLinha(Leitura.entInt("Digite a linha do livro infantil: "));

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
                            infantil.setAutor(temp);
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
                            infantil.setEditora(temp);
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
        infantil.setFaixaEtaria(Leitura.entInt("Digite a faixa etária do livro infantil: "));
        infantil.setMaterial(Leitura.entString("Digite o material do livro infantil: "));

        do{
            String numerado = Leitura.entString(" E interativo? (S/N): ");
            if(numerado.equalsIgnoreCase("S")) {
            infantil.setInterativo(true);
                break;
            } else if(numerado.equalsIgnoreCase("N")) {
            infantil.setInterativo(false);
                break;
            }else{
                System.out.println("Opcao invalida, tente novamente.");
            }
            System.gc();
        }while(true);

        armazen.getBdInfantil().add(infantil);
        System.out.println("\n\nLivro infantil cadastrado com sucesso.");
    }

    //polimorfismo por sobrescrita
   
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
                    String titulo = Leitura.entString("Digite o titulo do livro infantil: ");
                    for(Infantil temp : armazen.getBdInfantil()) {
                        if(temp.getTitulo().equalsIgnoreCase(titulo)) {
                            printLivro(temp);
                            findBusca = false;
                            break;
                        }
                    }

                    if(findBusca) {
                        System.out.println("Livro infantil não encontrado.");
                    }
                    break;

                case "2":
                    int id = Leitura.entInt("Digite o ID do livro infantil: ");
                    for(Infantil temp : armazen.getBdInfantil()) {
                        if(temp.getId() == id) {
                            printLivro(temp);
                            findBusca = false;
                            break;
                        }
                    }
                    if(findBusca) {
                        System.out.println("Livro infantil não encontrado.");
                    }
                    break;

                case "3":
                    for(Infantil temp : armazen.getBdInfantil()) {
                        printLivro(temp);
                        findBusca = false;
                    }
                    if(findBusca) {
                        System.out.println("Nenhum livro infantil cadastrado.");
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

    private void printLivro(Infantil infantil) {
        System.out.println("\nID: " + infantil.getId() + 
                           " - Titulo: " + infantil.getTitulo() + 
                           " - Faixa Etária: " + infantil.getFaixaEtaria() +
                           " - Material: " + infantil.getMaterial() +
                            " - Interativo: " + (infantil.isInterativo() ? "Sim" : "Não") +
                           "\nAutor: " + infantil.getAutor().getNome() +//reflexividade
                           "\nEditora: " + infantil.getEditora().getNome() +//reflexividade
                           "\nLocalização: Seção: " + infantil.getLocalizacao().getSecao() + //reflexividade
                           ", Prateleira: " + infantil.getLocalizacao().getPrateleira() + //reflexividade
                           ", Linha: " + infantil.getLocalizacao().getLinha()+ //reflexividade
                           "\nDisponivel: " + (infantil.getbloqueado() ? "Nao" : "Sim"));
    }

    //polimorfismo por sobrescrita
   
    public void excluir() {

        System.out.println("Será preciso digitar o ID!!");
        String optionReativar = Leitura.entString("Deseja listar os livros infantis? (S/N): ");

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

        int IdBuscado = Leitura.entInt("Digite o ID do livro infantil a ser excluida, 0 para cancelar: ");
        boolean foundExcluir = true;

        for(Infantil temp : armazen.getBdInfantil()) {
            if(temp.getId() == IdBuscado) {
                temp.setbloqueado(true);
                System.out.println("\n\nLivro infantil excluido com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("\n\nLivro infantil nao encontrado.");
        }
    }

    //polimorfismo por sobrescrita
   
    public void reativar() {
        System.out.println("Sera preciso digitar o ID!!");
        String optionReativar = Leitura.entString("Deseja listar os livros infantis? (S/N): ");

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
        int IdBuscado = Leitura.entInt("Digite a Id do livro infantil a ser reativada: ");
        boolean foundReativar = true;

        for(Infantil temp : armazen.getBdInfantil()) {
            if(temp.getId() == IdBuscado) {
                temp.setbloqueado(false);
                System.out.println("\n\nLivro infantil reativado com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("\n\nLivro infantil não encontrado.");
        }
    }

    public static void main(String[] args) {
        MenuInfantil menuInfantil = new MenuInfantil();
        menuInfantil.Menu();
    }

}

