package src.model;

import src.model.herenciaPersona.Cliente;

public class Mesa {

    // validador para saber si esta libre u ocupada la mesa
    private boolean libreOcupada;

    // numero identificador de la mesa
    private final int numeroMesa;

    private Cliente cliente;

    /**
     * The constructor
     *
     * @param libreOcupada a utilizar
     * @param numeroMesa a utilizar
     */
    public Mesa(boolean libreOcupada, int numeroMesa) {
        this.libreOcupada = libreOcupada;
        this.numeroMesa = numeroMesa;
        this.cliente = null;
    }

    /**
     *
     * @return true si esta disponible la mesa
     */
    public boolean isLibreOcupada() {
        return this.libreOcupada;
    }

    /**
     *
     * @return un mensaje si esta ocupada o libre
     */
    public String isLibreOcupadaString() {

        if (this.isLibreOcupada()){
            return " Libre ";
        }
        return "Ocupada";
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

    /**
     *
     * @return el cliente que esta ocupando esta mesa
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /**
     *
     * @param cliente a setear
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
