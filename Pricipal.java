//vinicius souza Dias 2564599

public class Pricipal {
    public static void main(String[] args) {
        do{
            MenuAutor menuAutor = MenuAutor.gerarMenuAutor();
            MenuEditora menuEditora = MenuEditora.gerarMenuEditora();
            MenuDidatico menuDidatico = MenuDidatico.geraMenuDidatico();
            MenuColecionavel menuColecionavel = MenuColecionavel.gerarMenuColecionavel();
            MenuInfantil menuInfantil = MenuInfantil.gerarMenuInfantil();

            System.out.println("\n\nBem-vindo ao sistema de gerenciamento da biblioteca!");
            System.out.println("Por favor, escolha uma opção do menu para continuar.");

            System.out.println("\nDigite um numero para escolher uma Opcao");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|0-Sair                                                   |");
            System.out.println("|1-Menu infantil                                          |");
            System.out.println("|2-Menu colecionavel                                      |");
            System.out.println("|3-Menu didatico                                          |");
            System.out.println("|4-Menu editora                                           |");
            System.out.println("|5-Menu autor                                             |");
            System.out.println("-----------------------------------------------------------");

            String opcaoGeral = Leitura.entString("Opcao: ");
            switch (opcaoGeral) {
                case "0":
                    System.out.println("Saindo do sistema. Até logo!");
                    return;
                    
                case "1":
                    menuInfantil.Menu();
                    break;
                case "2":
                    menuColecionavel.Menu();
                    break;
                case "3":
                    menuDidatico.Menu();
                    break;
                case "4":
                    menuEditora.Menu();
                    break;
                case "5":
                    menuAutor.Menu();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
            System.gc();
        }while (true);
    }
}