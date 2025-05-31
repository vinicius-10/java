//vinicius souza Dias
public class MenuColecionavel implements Menus {
    private Colecionavel colecionavel;
    private Armazenamento armazen;

    public MenuColecionavel() {
        colecionavel = new Colecionavel();
        
    }

    //polimorfismo por sobrecarga
    public MenuColecionavel(Colecionavel colecionavel, Armazenamento armazen) {
        this.colecionavel = colecionavel;
        this.armazen = armazen;
    }

    public Colecionavel getColecionavel() { return colecionavel; }
    public void setColecionavel(Colecionavel colecionavel) { this.colecionavel = colecionavel; }

    public Armazenamento getArmaze() {
        return armazen;
    }

    public void setArmaze(Armazenamento armazen) {
        this.armazen = armazen;
    }


    @Override
    public void menu(){
        
    }

}
