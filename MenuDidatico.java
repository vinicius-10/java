//vinicius souza Dias
public class MenuDidatico {
    private Didatico didatico;
    private Armazenamento armazen;

    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }

    public MenuDidatico() {
        armazen = Armazenamento.geraArmazen();
        didatico = new Didatico();
    }

    //polimorfismo por sobrecarga
    public MenuDidatico(Didatico didatico, Armazenamento armazen) {
        this.didatico = didatico;
        this.armazen = armazen;
    }

    public Didatico getDidatico() { return didatico; }
    public void setDidatico(Didatico didatico) { this.didatico = didatico; }

    public void listDidatico() {
        
    }

}
