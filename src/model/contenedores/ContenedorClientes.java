package src.model.contenedores;

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

}
