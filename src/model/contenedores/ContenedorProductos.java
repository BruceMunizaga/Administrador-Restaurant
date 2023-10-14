package src.model.contenedores;

import edu.princeton.cs.stdlib.StdOut;
import src.model.Producto;

public class ContenedorProductos {

    private Producto[] inventario;

    private int cantActual;
    private final int cantMaxima;

    /**
     * The constructor
     *
     * @param cantMaxima a inicializar
     */
    public ContenedorProductos(int cantMaxima) {

        if (cantMaxima <= 0){

            throw new NumberFormatException("No se pueden crear contenedores con posiciones menores o iguales que cero");
        }else{
            this.cantMaxima = cantMaxima;
            inventario = new Producto[cantMaxima];
            this.cantActual = 0;
        }
    }

    public int getCantActual() {
        return this.cantActual;
    }

    public int getCantMaxima() {
        return this.cantMaxima;
    }

    /**
     * Funcion que agregara un nuevo producto al contenedor
     *
     * @param nuevoProducto a agregar
     * @return true si pudo agregarlo
     */
    public boolean agregarProducto(Producto nuevoProducto){
        if (this.cantActual == this.cantMaxima){
            System.out.println("Cantidad maxima alcanzada, no se pudo agregar al nuevo Producto.");
        }else{
            if (this.cantActual == 0){
                this.inventario[0] = nuevoProducto;
                this.cantActual++;
                System.out.println("Producto agregado.");
                return true;
            }else{
                for (int i = 0; i < this.cantMaxima; i++) {
                    if (this.inventario[i] == null){
                        this.inventario[i] = nuevoProducto;
                        this.cantActual++;
                        System.out.println("Producto agregado.");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Funcion que obtendra un Producto en funcion de su nombre
     *
     * @param nombreProducto a buscar
     * @return true si encontro el Producto
     */
    public Producto obtenerProducto(String nombreProducto){
        if (this.cantActual == 0){
            System.out.println("No hay Productos registrados.");
        }else{
            for (Producto producto: this.inventario) {
                if(producto.getNombreProducto().equalsIgnoreCase(nombreProducto)){
                    return producto; //FIXME: Agregar el desplegar toda su informacion en la clase Producto
                }
            }
            System.out.println("Producto no encontrado.");
        }
        return null;
    }

    /**
     * Metodo que desplegara todo el inventario
     *
     */
    public void desplegarProductos(){

        //FIXME: Completar el despliegue de forma correcta con todos sus datos
        if (this.cantActual == 0){
            System.out.println("No hay Productos registrados.");
        }else{
            for (int i = 0; i < this.cantActual; i++) {
                String nombreProducto = inventario[i].getNombreProducto();
                StdOut.println(nombreProducto);
            }
        }
    }

    //TODO: agregar la funcion de eliminar un producto si su stock es cero
}
