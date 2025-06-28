//Vinicius Souza Dias 2564599

public abstract class Objetos {
    private boolean bloqueado;

    public Objetos() {
        bloqueado = false;
    }

    //sobrecarga por polimorfismo
    public Objetos(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

}
