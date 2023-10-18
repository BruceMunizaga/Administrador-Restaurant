package src.util;

import edu.princeton.cs.stdlib.StdOut;
import src.model.Producto;
import src.model.herenciaPersona.Trabajador;

import java.util.NoSuchElementException;

public class ContenedorTrabajadores {

    private Trabajador[] trabajadores;

    private int cantActual;
    private final int cantMaxima;

    public ContenedorTrabajadores(int cantMaxima) {

        if (cantMaxima <= 0){

            throw new NumberFormatException("No se pueden crear contenedores con posiciones menores o iguales que cero");
        }else{
            this.cantMaxima = cantMaxima;
            trabajadores = new Trabajador[cantMaxima];
            this.cantActual = 0;
        }
    }

    /**
     * Funcion que agregara un nuevo cliente al contenedor
     *
     * @param nuevoTrabajador a agregar
     * @return true si pudo agregarlo
     */
    public boolean agregarTrabajador(Trabajador nuevoTrabajador){
        if (this.cantActual == this.cantMaxima){
            System.out.println("Cantidad maxima alcanzada, no se pudo agregar al nuevo Trabajador.");
        }else{
            if (this.cantActual == 0){
                this.trabajadores[0] = nuevoTrabajador;
                this.cantActual++;
                return true;
            }else{
                for (int i = 0; i < this.cantMaxima; i++) {
                    if (this.trabajadores[i] == null){
                        this.trabajadores[i] = nuevoTrabajador;
                        this.cantActual++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Funcion que obtendra un trabajdor en funcion de su nombre
     *
     * @param nombreTrabajador a buscar
     * @return true si encontro al trabajador
     */
    public Trabajador obtenerTrabajador(String nombreTrabajador) {
        try {
            if (this.cantActual == 0) {
                return null;
            } else {
                for (Trabajador trabajador: this.trabajadores) {
                    if (trabajador.getNombre().equalsIgnoreCase(nombreTrabajador)) {
                        return trabajador;
                    }
                }
                return null;
            }
        } catch (NullPointerException e) {

            StdOut.println("Trabajador no encontrado");
            return null;
        }
    }

    /**
     * Metodo que desplegara a los trabajadores
     *
     */
    public void desplegarTrabajadores(){

        //Si no hay productos, se despliega esto
        if (this.cantActual == 0){
            System.out.println("No hay Productos registrados.");
        }else{

            //si hay productos agregados, se despliega esto
            StdOut.println("[*][*][*][*][*][*][*] INVENTARIO [*][*][*][*][*][*][*]");
            String fechaFinContratacion = "";
            //se recorre el arreglo y se guardan sus datos en variables temporales
            for (int i = 0; i < this.cantActual; i++) {
                String nombreTrabajador = trabajadores[i].getNombre();
                int edadTrabajador = trabajadores[i].getEdad();
                String tipoDeContrato = trabajadores[i].getTipoDeContrato();
                String fechaContratacion = trabajadores[i].getFechaInicioContratacion();

                if (tipoDeContrato.equalsIgnoreCase("Fijo")){
                    fechaFinContratacion = trabajadores[i].getFechaTerminoContratacion();
                }

                //Se despliega por pantalla toda la informacion de del producto
                StdOut.println("...........................................");
                StdOut.println("Nombre del Trabajador: "+nombreTrabajador);
                StdOut.println("Edad: "+edadTrabajador);
                StdOut.println("Tipo de contrato: "+tipoDeContrato);
                StdOut.println("Fecha de contratacion: "+fechaContratacion);
                if (tipoDeContrato.equalsIgnoreCase("Fijo")){
                    StdOut.println("Fecha de fin del contrato: "+ fechaFinContratacion);
                }

            }
            StdOut.println("[*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*]");
        }
    }

    /**
     *
     * @param trabajador finalizar contrato
     */
    public void finalizarContratoTrabajador(Trabajador trabajador){

        for (int i = 0; i < this.cantActual; i++) {
            if (this.trabajadores[i] == trabajador){
                this.trabajadores[i] = null;
                StdOut.println("Se le ha finalizado el contrato al trabajador " + trabajador.getNombre() + " y se ha " +
                        "eliminado de la lista de trabajadores");
                break;
            }
        }
        ordenarArregloTrabajadores();
    }

    /**
     * metodo que ordena el arreglo moviendo las casillas en null al final
     */
    public void ordenarArregloTrabajadores() {

        // Encuentra la posición del primer producto no null
        int finNoNull = 0;
        for (int i = 0; i < this.cantActual; i++) {
            if (this.trabajadores[i] != null) {
                finNoNull = i;
                break;
            }
        }

        // Mueve los productos null al final del arreglo
        for (int i = finNoNull; i < this.cantActual; i++) {
            if (this.trabajadores[i] == null) {
                for (int j = i; j < this.cantActual - 1; j++) {
                    this.trabajadores[j] = this.trabajadores[j + 1];
                }
                this.trabajadores[this.cantActual - 1] = null;
            }
        }
        this.cantActual--;
    }
}
