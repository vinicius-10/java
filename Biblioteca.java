//vinicius souza Dias

public class Biblioteca {
    public static void main(String[] args) {
        // Criando objetos 
        Autor autor = new Autor();
        Editora editora = new Editora();
        Localizacao localizacao = new Localizacao();
        
        // Criando livros
        Didatico didatico = new Didatico();
        Infantil infantil = new Infantil();
        Colecionavel colecionavel = new Colecionavel();
        
        // Criando menus
        MenuDidatico menuDidatico = new MenuDidatico();
        MenuInfantil menuInfantil = new MenuInfantil();
        MenuColecionavel menuColecionavel = new MenuColecionavel();
        MenuEditora menuEditora = new MenuEditora();
        MenuAutor menuAutor = new MenuAutor();

        // Cradastrando o autor
        autor.setNome("Machado de Assis");
        autor.setCpf("98765432100");

        // Cradastrando editora
        editora.setNome("Editora Abril");
        editora.setCnpj("98765432000199");

        // Cradastrando localização
        localizacao.setSecao("Literatura Brasileira");
        localizacao.setPrateleira(2);
        localizacao.setLinha(3);

        // Cradastrando livro didático
        menuDidatico.setDidatico(didatico);
        menuDidatico.getDidatico().setTitulo("Matemática Básica");
        menuDidatico.getDidatico().setAutor(autor);

        menuDidatico.getDidatico().getLocalizacao().setSecao("8º Ano");
        menuDidatico.getDidatico().getLocalizacao().setPrateleira(1);
        menuDidatico.getDidatico().getLocalizacao().setLinha(3);

        menuDidatico.getDidatico().setEditora(editora);
        menuDidatico.getDidatico().setMateria("Matemática");
        menuDidatico.getDidatico().setNivel("Fundamental");
        menuDidatico.getDidatico().setComplexidade("Básica");

        // Cradastrando livro infantil
        menuInfantil.setInfantil(infantil);
        menuInfantil.getInfantil().setTitulo("O Pequeno Príncipe");
        menuInfantil.getInfantil().setAutor(autor);

        menuInfantil.getInfantil().getLocalizacao().setSecao("Contos Infantis");
        menuDidatico.getDidatico().getLocalizacao().setPrateleira(2);
        menuDidatico.getDidatico().getLocalizacao().setLinha(1);

        menuInfantil.getInfantil().setEditora(editora);
        menuInfantil.getInfantil().setFaixaEtaria(8);
        menuInfantil.getInfantil().setMaterial("Papel");
        menuInfantil.getInfantil().setInterativo(true);

        // Cradastrando livro colecionável
        menuColecionavel.setColecionavel(colecionavel);
        menuColecionavel.getColecionavel().setTitulo("Dom Casmurro - Edição Especial");
        menuColecionavel.getColecionavel().setAutor(autor);

        menuColecionavel.getColecionavel().getLocalizacao().setSecao("Brasileira");
        menuDidatico.getDidatico().getLocalizacao().setPrateleira(12);
        menuDidatico.getDidatico().getLocalizacao().setLinha(2);

        menuColecionavel.getColecionavel().setEditora(editora);
        menuColecionavel.getColecionavel().setEdicaoEspecial("Edição Comemorativa");
        menuColecionavel.getColecionavel().setNumerado(true);
        menuColecionavel.getColecionavel().setAdicional("Carta do Autor");

        // Cradastrando menu editora
        menuEditora.setEditora(editora);

        // Cradastrando menu autor
        menuAutor.setAutor(autor);

        System.out.println("Sistema da Biblioteca Iniciado.\n");

        // Exibindo informações
        System.out.println("=== LIVRO DIDÁTICO ===");
        System.out.println("Título: " + menuDidatico.getDidatico().getTitulo());
        
        System.out.println("Matéria: " + menuDidatico.getDidatico().getMateria());
        System.out.println("Nível: " + menuDidatico.getDidatico().getNivel());
        System.out.println("Autor: " + menuDidatico.getDidatico().getAutor().getNome());
        System.out.println("Localização: " + menuDidatico.getDidatico().getLocalizacao().getSecao() + 
                         ", Prateleira " + menuDidatico.getDidatico().getLocalizacao().getPrateleira());
        System.out.println("Editora: " + menuDidatico.getDidatico().getEditora().getNome() + "\n");

        System.out.println("=== LIVRO INFANTIL ===");
        System.out.println("Título: " + menuInfantil.getInfantil().getTitulo());
        System.out.println("Faixa Etária: " + menuInfantil.getInfantil().getFaixaEtaria() + " anos");
        System.out.println("Interativo: " + (menuInfantil.getInfantil().isInterativo() ? "Sim" : "Não"));
        System.out.println("Material: " + menuInfantil.getInfantil().getMaterial() );
        System.out.println("Autor: " + menuDidatico.getDidatico().getAutor().getNome());
        System.out.println("Localização: " + menuDidatico.getDidatico().getLocalizacao().getSecao() + 
                         ", Prateleira " + menuDidatico.getDidatico().getLocalizacao().getPrateleira());
        System.out.println("Editora: " + menuDidatico.getDidatico().getEditora().getNome() + "\n");

        System.out.println("=== LIVRO COLECIONÁVEL ===");
        System.out.println("Título: " + menuColecionavel.getColecionavel().getTitulo());
        System.out.println("Edição Especial: " + menuColecionavel.getColecionavel().getEdicaoEspecial());
        System.out.println("Numerado: " + (menuColecionavel.getColecionavel().isNumerado() ? "Sim" : "Não"));
        System.out.println("Adicional: " + menuColecionavel.getColecionavel().getAdicional());
        System.out.println("Autor: " + menuDidatico.getDidatico().getAutor().getNome());
        System.out.println("Localização: " + menuDidatico.getDidatico().getLocalizacao().getSecao() + 
                         ", Prateleira " + menuDidatico.getDidatico().getLocalizacao().getPrateleira());
        System.out.println("Editora: " + menuDidatico.getDidatico().getEditora().getNome() + "\n");

    }
}