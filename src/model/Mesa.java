package src.model;

public class Mesa {

    // validador para saber si esta libre u ocupada la mesa
    private boolean libreOcupada;

    // numero identificador de la mesa
    private int numeroMesa;

    /**
     * The constructor
     *
     * @param libreOcupada a utilizar
     * @param numeroMesa a utilizar
     */
    public Mesa(boolean libreOcupada, int numeroMesa) {
        this.libreOcupada = libreOcupada;
        this.numeroMesa = numeroMesa;
    }

    /**
     *
     * @return si esta libre u ocupada la mesa mediante un booleano
     */
    public boolean isLibreOcupada() {
        return this.libreOcupada;
    }

    /**
     *
     * @return el numero de la mesa
     */
    public int getNumeroMesa() {
        return this.numeroMesa;
    }

    /**
     *
     * @param libreOcupada a modificar
     */
    public void setLibreOcupada(boolean libreOcupada) {
        this.libreOcupada = libreOcupada;
    }
}
