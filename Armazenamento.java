//vinicius souza dias 2564599
import java.util.List;
import java.util.ArrayList;

public class Armazenamento {
    private List<Infantil> bdInfantil = new ArrayList<Infantil>();
    private List<Didatico> bdDidatico = new ArrayList<Didatico>();
    private List<Colecionavel> bdColecionavel = new ArrayList<Colecionavel>();
    private List<Editora> bdEditoras = new ArrayList<Editora>();
    private List<Autor> bdAutores = new ArrayList<Autor>();

    private static Armazenamento armazenUnic; // Singleton  1 passo
    private Armazenamento() { // 2 passo
        //listas já inicializadas
    }

    public static Armazenamento geraArmazen() {//3 passo
        if (armazenUnic == null) {
            armazenUnic = new Armazenamento();
        }
        return armazenUnic;
    }

    public List<Infantil> getBdInfantil() {
        return bdInfantil;
    }

    public void setBdInfantil(List<Infantil> bdInfantil) {
        this.bdInfantil = bdInfantil;
    }

    public List<Didatico> getBdDidatico() {
        return bdDidatico;
    }

    public void setBdDidatico(List<Didatico> bdDidatico) {
        this.bdDidatico = bdDidatico;
    }

    public List<Colecionavel> getBdColecionavel() {
        return bdColecionavel;
    }

    public void setBdColecionavel(List<Colecionavel> bdColecionavel) {
        this.bdColecionavel = bdColecionavel;
    }

    public List<Editora> getBdEditoras() {
        return bdEditoras;
    }

    public void setBdEditoras(List<Editora> bdEditoras) {
        this.bdEditoras = bdEditoras;
    }

    public List<Autor> getBdAutores() {
        return bdAutores;
    }

    public  void setBdAutores(List<Autor> bdAutores) {
        this.bdAutores = bdAutores;
    }


    public Autor getAutorByCpf(String cpf) {
        for (Autor autor : bdAutores) {
            if (autor.getCpf().equals(cpf)) {
                return autor;
            }
        }
        return null; 
    }

    public Editora getEditoraByCnpj(String cnpj) {
        for (Editora editora : bdEditoras) {
            if (editora.getCnpj().equals(cnpj)) {
                return editora;
            }
        }
        return null; 
    }

    public Didatico getDidaticoById(int id) {
        for (Didatico didatico : bdDidatico) {
            if (didatico.getId() == id) {
                return didatico;
            }
        }
        return null; 
    }

    public Infantil getInfantilById(int id) {
        for (Infantil infantil : bdInfantil) {
            if (infantil.getId() == id) {
                return infantil;
            }
        }
        return null; 
    }

    public Colecionavel getColecionavelById(int id) {
        for (Colecionavel colecionavel : bdColecionavel) {
            if (colecionavel.getId() == id) {
                return colecionavel;
            }
        }
        return null; 
    }
    
}
