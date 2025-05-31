//vinicius souza Dias
public class MenuInfantil {
    private Infantil infantil;
    private Armazenamento armazen;

    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }

    public MenuInfantil() {
        armazen = Armazenamento.geraArmazen();
        infantil = new Infantil();
    }

    //polimorfismo por sobrecarga
    public MenuInfantil(Infantil infantil, Armazenamento armazen) {
        this.infantil = infantil;
        this.armazen = armazen;
    }

    public Infantil getInfantil() { return infantil; }
    public void setInfantil(Infantil infantil) { this.infantil = infantil; }

    public void listInfantil() {
       
    }

}
