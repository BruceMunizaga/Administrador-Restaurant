package src.model.contenedores;

import src.model.herenciaPersona.Cliente;

public class ContenedorClientes {

    private Cliente[] clientes;

    private int cantActual;
    private final int cantMaxima;

    public ContenedorClientes(int cantMaxima) {

        if (cantMaxima <= 0){

            throw new NumberFormatException("No se pueden crear contenedores con posiciones menores o iguales que cero");
        }else{
            this.cantMaxima = cantMaxima;
            clientes = new Cliente[cantMaxima];
            this.cantActual = 0;
        }
    }

    public int getCantActual() {
        return this.cantActual;
    }

    public int getCantMaxima() {
        return this.cantMaxima;
    }

    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }

    /**
     * Funcion que agregara un nuevo cliente al contenedor
     *
     * @param nuevoCliente a agregar
     * @return true si pudo agregarlo
     */
    public boolean agregarCliente(Cliente nuevoCliente){
        if (this.cantActual == this.cantMaxima){
            System.out.println("Cantidad maxima alcanzada, no se pudo agregar al nuevo cliente.");
        }else{
            if (this.cantActual == 0){
                this.clientes[0] = nuevoCliente;
                this.cantActual++;
                System.out.println("Cliente agregado.");
                return true;
            }else{
                for (int i = 0; i < this.cantMaxima; i++) {
                    if (this.clientes[i] == null){
                        this.clientes[i] = nuevoCliente;
                        this.cantActual++;
                        System.out.println("Cliente agregado.");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Funcion que obtendra un cliente en funcion de su nombre
     *
     * @param nombreCliente a buscar
     * @return true si encontro el cliente
     */
    public Cliente obtenerCliente(String nombreCliente){
        if (this.cantActual == 0){
            System.out.println("No hay clientes registrados.");
        }else{
            for (Cliente cliente: this.clientes) {
                if(cliente.getNombre().equalsIgnoreCase(nombreCliente)){
                    return cliente; //FIXME: Agregar el desplegar toda su informacion en la clase cliente
                }
            }
            System.out.println("Cliente no encontrado.");
        }
        return null;
    }
}
