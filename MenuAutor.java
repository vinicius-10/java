//vinicius souza Dias 2564599

public class MenuAutor implements Menus{
    private Autor autor;
    private Armazenamento armazen;
    
   
    private static MenuAutor unicMenuAutor; //singleton 1 passo


    private MenuAutor() { // contrutores privados 2 passo 
        autor = new Autor();
        armazen = Armazenamento.geraArmazen();
    }

    //polimorfismo por sobrecarga
    private MenuAutor(Autor autor, Armazenamento armazen) {
        this.autor = autor;
        this.armazen = armazen;
    }

    public static MenuAutor gerarMenuAutor() { //passo 3
        if(unicMenuAutor == null) {
            unicMenuAutor = new MenuAutor();
        }
        return unicMenuAutor;
    }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    
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
            autor = new Autor();

            System.out.println("\n\nBem-vindo ao menu de autores!");
            System.out.println("Por favor, escolha uma opção do menu para continuar.");
            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                 |");
            System.out.println("|1-Cadastrar autor                                         |");
            System.out.println("|2-Buscar autores                                          |");
            System.out.println("|3-Excluir autor                                           |");
            System.out.println("|4-Reativar autor                                          |");
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
                default:
                    System.out.println("Opcao invalida, tente novamente.");                    
            }
        }while(condition);
        System.gc();
    }

    

    //polimorfismo por sobrescrita
    @Override
    public void exibir() {
        System.out.println("Buscar Autores por:");
        System.out.println("-----------------------------------------------------------");
        System.out.println("|0-Voltar para menu anterior                              |");
        System.out.println("|1-Nome                                                   |");
        System.out.println("|2-CPF                                                    |");
        System.out.println("|3-Listar todos                                           |");
        System.out.println("-----------------------------------------------------------");

        String opcaoBusca = Leitura.entString("Opcao: ");
        boolean findBusca = true;
        switch (opcaoBusca) {
            case "0":
                System.out.println("Voltando ao menu anterior.");
                return;

            case "1":
                String nome = Leitura.entString("Digite o nome do autor: ");
                for(Autor temp : armazen.getBdAutores()) {
                    if(temp.getNome().equalsIgnoreCase(nome)) {
                        System.out.println("\nNome: " + temp.getNome() + " - CPF: " + temp.getCpf() + " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
                        findBusca = false;
                        break;
                    }
                }

                if(findBusca) {
                    System.out.println("Autor não encontrado.");
                }
                break;

            case "2":
                String cpf = Leitura.entString("Digite o CPF do autor: ");
                for(Autor temp : armazen.getBdAutores()) {
                    if(temp.getCpf().equals(cpf)) {
                        System.out.println("\nNome: " + temp.getNome() + " - CPF: " + temp.getCpf() + " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
                        findBusca = false;
                    }
                }
                if(findBusca) {
                    System.out.println("Autor não encontrado.");
                }
                break;
            case "3":
                System.out.println("Listando todos os autores:");
                for(Autor temp : armazen.getBdAutores()) {
                    System.out.println("\nNome: " + temp.getNome() + " - CPF: " + temp.getCpf() + " - Bloqueado: " + (temp.getbloqueado()? "Sim" : "Não"));
                }
                break;
            case "4":
                System.out.println("Continuando.");
                return;
            default:
                System.out.println("Opcao invalida, tente novamente.");
                exibir();
        }
        System.gc();
    }

    //polimorfismo por sobrescrita
    @Override
    public void cadastrar(){
        try{
            autor.setNome(Leitura.entString("Digite o nome do autor: "));
        }catch(AutorExecption e) {
            e.menExecption();
            autor = e.corTinyNameExecption(autor);
        }

        try{
            autor.setCpf(Leitura.entString("Digite o CPF do autor: "));
        }catch(AutorExecption e) {
            e.menExecption();
            autor = e.corTinyCpfExecption(autor);
        }

        boolean foundCadastro = true;

        for(Autor temp : armazen.getBdAutores()) {
            if(temp.getCpf().equals(autor.getCpf())) {
                System.out.println("Cpf já cadastrado.");
                foundCadastro = false;
                break;
            }
        }      

        if(foundCadastro) {
            armazen.getBdAutores().add(autor);
            System.out.println("\n\nAutor cadastrado com sucesso.");
        }
    }

    //polimorfismo por sobrescrita
    @Override
    public void excluir() {
        System.out.println("Será preciso digitar o CPF!!");
        String optionExcluir = Leitura.entString("Deseja listar os autores?(S/N) : ");
                    
        switch (optionExcluir.toUpperCase()) {
            case "S":
                exibir();
                break;
            case "N":
                System.out.println("Continuando.");
                break;
            default:
                System.out.println("Opcao invalida, será exibido, precione 0 casso queira pular.");
                exibir();
        }

        String cpfBuscado = Leitura.entString("Digite o CPF do autor a ser excluído: ");
        boolean foundExcluir = true;
 
        for(Autor temp : armazen.getBdAutores()) {
            if(temp.getCpf().equals(cpfBuscado)) {
                temp.setbloqueado(true);
                System.out.println("\n\nAutor excluído com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("\n\nAutor não encontrado.");
        }
    }

    //polimorfismo por sobrescrita
    @Override
    public void reativar() {
        System.out.println("Será preciso digitar o CPF!!");
        String optionExcluir = Leitura.entString("Deseja listar os autores?(S/N) : ");
                    
        switch (optionExcluir.toUpperCase()) {
            case "S":
                exibir();
                break;
            case "N":
                System.out.println("Continuando.");
                break;
            default:
                System.out.println("Opcao invalida, será exibido, precione 0 casso queira pular.");
                exibir();
        }

        String cpfBuscado = Leitura.entString("Digite o CPF do autor a ser reativado: ");
        boolean foundReativar = true;

        for(Autor temp : armazen.getBdAutores()) {
            if(temp.getCpf().equals(cpfBuscado)) {
                temp.setbloqueado(false);
                System.out.println(" \n\nAutor reativado com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("\n\nAutor não encontrado.");
        }
    }

    public static void  main(String[] algo) {
        MenuAutor menuAutor = new MenuAutor();
        menuAutor.Menu();
    }
}
