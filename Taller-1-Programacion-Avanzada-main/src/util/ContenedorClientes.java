package src.util;

import edu.princeton.cs.stdlib.StdOut;
import src.model.Producto;
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
     * Metodo que desplegara a los clientes
     *
     */
    public void desplegarClientes(){

        //Si no hay productos, se despliega esto
        if (this.cantActual == 0){
            System.out.println("No hay clientes registrados.");
        }else{

            //si hay productos clientes, se despliega esto
            StdOut.println("[*][*][*][*][*][*][*] CLIENTES [*][*][*][*][*][*][*]");
            String fechaFinContratacion = "";
            //se recorre el arreglo y se guardan sus datos en variables temporales
            for (int i = 0; i < this.cantActual; i++) {
                String nombreCliente = clientes[i].getNombre();
                int edadCliente = clientes[i].getEdad();

                //Se despliega por pantalla toda la informacion de del producto
                StdOut.println("...........................................");
                StdOut.println("Nombre del Cliente: "+nombreCliente);
                StdOut.println("Edad: "+edadCliente);
                clientes[i].desplegarOrden();
            }
            StdOut.println("[*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*]");
        }
    }

    /**
     * metodo que eliminara un cliente
     * @param cliente a eliminar
     */
    public void eliminarClienteNombre(Cliente cliente){

        for (int i = 0; i < this.cantActual; i++) {
            if (this.clientes[i] == cliente){
                this.clientes[i] = null;
                StdOut.println("Cliente eliminado.");
                ordenarArreglo();
                this.cantActual--;
                break;
            }
        }
    }

    /**
     * metodo que ordena el arreglo moviendo las casillas en null al final
     */
    public void ordenarArreglo() {

        // Encuentra la posición del primer producto no null
        int finNoNull = 0;
        for (int i = 0; i < this.cantActual; i++) {
            if (this.clientes[i] != null) {
                finNoNull = i;
                break;
            }
        }

        // Mueve los productos null al final del arreglo
        for (int i = finNoNull; i < this.cantActual; i++) {
            if (this.clientes[i] == null) {
                for (int j = i; j < this.cantActual - 1; j++) {
                    this.clientes[j] = this.clientes[j + 1];
                }
                this.clientes[this.cantActual - 1] = null;
            }
        }
    }

}
