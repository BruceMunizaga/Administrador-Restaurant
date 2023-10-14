package src.model.contenedores;

import src.model.herenciaPersona.Trabajador;

public class ContenedorTrabajadores {

    private Trabajador[] trabajdores;

    private int cantActual;
    private final int cantMaxima;

    public ContenedorTrabajadores(int cantMaxima) {

        if (cantMaxima <= 0){

            throw new NumberFormatException("No se pueden crear contenedores con posiciones menores o iguales que cero");
        }else{
            this.cantMaxima = cantMaxima;
            trabajdores = new Trabajador[cantMaxima];
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
     * @param nuevoTrabajador a agregar
     * @return true si pudo agregarlo
     */
    public boolean agregarTrabajador(Trabajador nuevoTrabajador){
        if (this.cantActual == this.cantMaxima){
            System.out.println("Cantidad maxima alcanzada, no se pudo agregar al nuevo Trabajador.");
        }else{
            if (this.cantActual == 0){
                this.trabajdores[0] = nuevoTrabajador;
                this.cantActual++;
                System.out.println("Trabajador agregado.");
                return true;
            }else{
                for (int i = 0; i < this.cantMaxima; i++) {
                    if (this.trabajdores[i] == null){
                        this.trabajdores[i] = nuevoTrabajador;
                        this.cantActual++;
                        System.out.println("Trabajador agregado.");
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
    public Trabajador obtenerTrabajador(String nombreTrabajador){
        if (this.cantActual == 0){
            System.out.println("No hay trabajadores registrados.");
        }else{
            for (Trabajador trabajador: this.trabajdores) {
                if(trabajador.getNombre().equalsIgnoreCase(nombreTrabajador)){
                    return trabajador; //FIXME: Agregar el desplegar toda su informacion en la clase Trabajador
                }
            }
            System.out.println("Trabajador no encontrado.");
        }
        return null;
    }

    /**
     * Funcion que eliminara al trabajador en base a su nombre
     * @param nombreTrabajador a buscar
     * @return true si encontro al trabajador por eliminar
     */
    public boolean eliminarTrabajador(String nombreTrabajador){
        if (this.cantActual == 0){
            System.out.println("No hay trabajadores registrados.");
        }else{
            Trabajador trabajador;
            for (int i = 0; i < this.cantActual; i++) {
                if(this.trabajdores[i].getNombre().equalsIgnoreCase(nombreTrabajador)){
                    this.trabajdores[i] = null;
                    System.out.println("Trabajador eliminado."); //FIXME: Agregar reordenamiento
                    return true;
                }
            }
            System.out.println("Trabajador no encontrado.");
        }
        return false;
    }
}
