package src.model;

import edu.princeton.cs.stdlib.StdOut;
import src.model.herenciaPersona.Cliente;
import src.model.herenciaPersona.Trabajador;

public class Mesa {

    // validador para saber si esta libre u ocupada la mesa
    private boolean libreOcupada;

    // numero identificador de la mesa
    private final int numeroMesa;

    private Cliente cliente;
    private Trabajador trabajador;

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
        this.trabajador = null;
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

    public Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public void desplegarMesa(){

        if (this.cliente != null){
            //solicto los datos de la mesa
            int numeroMesa = getNumeroMesa();
            String statusMesa = isLibreOcupadaString();
            Cliente cliente = getCliente();
            String nombreCliente = cliente.getNombre();
            String nombreTrabajador = trabajador.getNombre();

            StdOut.println("------------------------------------------------------------");
            StdOut.println("Numero de la mesa: "+numeroMesa);
            StdOut.println("Estado de la mesa: "+statusMesa);
            StdOut.println("Cliente que ocupa la mesa: "+nombreCliente);
            StdOut.println("Trabajador que atiende la mesa: "+nombreTrabajador);
            StdOut.println("------------------------------------------------------------");
        }else{
            int numeroMesa = getNumeroMesa();
            String statusMesa = isLibreOcupadaString();

            StdOut.println("------------------------------------------------------------");
            StdOut.println("Numero de la mesa: "+numeroMesa);
            StdOut.println("Estado de la mesa: "+statusMesa);
            StdOut.println("------------------------------------------------------------");
        }


    }
}
