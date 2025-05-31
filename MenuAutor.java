//vinicius souza Dias
public class MenuAutor implements Menus{
    private Autor autor;
    private Armazenamento armazen;
   
    public MenuAutor() {
        autor = new Autor();
        armazen = Armazenamento.geraArmazen();
    }

    //polimorfismo por sobrecarga
    public MenuAutor(Autor autor, Armazenamento armazen) {
        this.autor = autor;
        this.armazen = armazen;
    }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    
    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }
    

    //polimorfismo por coesão
    public void Menu(){
        boolean condition = true;

        do{
            autor = new Autor();

            System.out.println("\n\n\n\nDigite um numero para escolher uma opção");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Voltar ao menu anterior                                 |");
            System.out.println("|1-Cadastrar autor                                         |");
            System.out.println("|2-Buscar autores                                          |");
            System.out.println("|3-Excluir autor                                           |");
            System.out.println("|4-Reativar autor                                          |");
            System.out.println("-----------------------------------------------------------");

            String opcaoGeral = Leitura.entString("Opção: ");
            
            switch (opcaoGeral) {
                case "0":
                    condition = false;
                    break;
                case "1":
                    
                    cadAutor();        

                    break;
                case "2":
                
                    exibirAutor();
                    
                    break;
                case "3":

                    String optionExcluir = Leitura.entString("Deseja listar os autores?(Y/N) : ");
                    
                    switch (optionExcluir.toUpperCase()) {
                        case "Y":
                            exibirAutor();
                            break;
                        case "N":
                            System.out.println("Continuando.");
                            break;
                        default:
                            System.out.println("Opção inválida, será exibido, precione 0 casso queira pular.");
                            exibirAutor();
                    }
                    
                    excluirAutor();
                    break;

                case "4":

                    String optionReativar = Leitura.entString("Deseja listar os autores?(Y/N) : ");
                    switch (optionReativar.toUpperCase()) {
                        case "Y":
                            exibirAutor();
                            break;
                        case "N":
                            System.out.println("Continuando.");
                            break;
                        default:
                            System.out.println("Opção inválida, será exibido, precione 0 casso queira pular.");
                            exibirAutor();
                    }
                    
                    reativarAutor();
                default:
                    System.out.println("Opção inválida, tente novamente.");                    
            }
        }while(condition);
        System.gc();
    }

    public static void  main(String[] algo) {
        MenuAutor menuAutor = new MenuAutor();
        menuAutor.Menu();
    }

    public void exibirAutor() {
        System.out.println("Buscar Autores por:");
        System.out.println("-----------------------------------------------------------");
        System.out.println("|0-Voltar para menu anterior                              |");
        System.out.println("|1-Nome                                                   |");
        System.out.println("|2-CPF                                                    |");
        System.out.println("|3-Listar todos                                           |");
        System.out.println("-----------------------------------------------------------");

        String opcaoBusca = Leitura.entString("Opção: ");
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
                System.out.println("Opção inválida, tente novamente.");
                exibirAutor();
        }
        System.gc();
    }

    public void cadAutor(){
        autor.setNome(Leitura.entString("Digite o nome do autor: "));

        autor.setCpf(Leitura.entString("Digite o CPF do autor: "));

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
            System.out.println("Autor cadastrado com sucesso.");
        }
    }

    public void excluirAutor() {

        String cpfBuscado = Leitura.entString("Digite o CPF do autor a ser excluído: ");
        boolean foundExcluir = true;
 
        for(Autor temp : armazen.getBdAutores()) {
            if(temp.getCpf().equals(cpfBuscado)) {
                temp.setbloqueado(true);
                System.out.println("Autor excluído com sucesso.");
                foundExcluir = false;
                break;
            }
        }

        if(foundExcluir) {
            System.out.println("Autor não encontrado.");
        }
    }

    public void reativarAutor() {

        String cpfBuscado = Leitura.entString("Digite o CPF do autor a ser reativado: ");
        boolean foundReativar = true;

        for(Autor temp : armazen.getBdAutores()) {
            if(temp.getCpf().equals(cpfBuscado)) {
                temp.setbloqueado(false);
                System.out.println("Autor reativado com sucesso.");
                foundReativar = false;
                break;
            }
        }

        if(foundReativar) {
            System.out.println("Autor não encontrado.");
        }
    }


}
