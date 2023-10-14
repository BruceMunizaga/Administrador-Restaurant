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
                return true;
            }else{
                for (int i = 0; i < this.cantMaxima; i++) {
                    if (this.inventario[i] == null){
                        this.inventario[i] = nuevoProducto;
                        this.cantActual++;
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

            //FIXME: arreglar esta busqueda porque no encuentra los productos que tienen espacio
            for (int i = 0; i < this.cantActual; i++) {
                if(this.inventario[i].getNombreProducto().equalsIgnoreCase(nombreProducto)){
                    return inventario[i];
                }
            }
            System.out.println("Producto no encontrado.");
        }
        return null;
    }

    /**
     * Funcion que entegara la posicion de ese producto
     *
     * @param producto a buscar
     * @return la posicion del producto encontrado
     */
    public int posicionProducto(Producto producto){
        if (this.cantActual == 0){
            System.out.println("No hay Productos registrados.");
        }else{
            for (int i = 0; i < this.cantActual; i++) {
                if(this.inventario[i] == producto){
                    return i;
                }
            }
            System.out.println("Producto no encontrado.");
        }
        return -1;
    }

    /**
     * Metodo que desplegara el inventario
     *
     */
    public void desplegarProductos(){

        //Si no hay productos, se despliega esto
        if (this.cantActual == 0){
            System.out.println("No hay Productos registrados.");
        }else{

            //si hay productos agregados, se despliega esto
            StdOut.println("[*][*][*][*][*][*][*] INVENTARIO [*][*][*][*][*][*][*]");

            //se recorre el arreglo y se guardan sus datos en variables temporales
            for (int i = 0; i < this.cantActual; i++) {
                String nombreProducto = inventario[i].getNombreProducto();
                int precioProducto = inventario[i].getPrecioProducto();
                String categoriaProducto = inventario[i].getCategoria();
                int stockProducto = inventario[i].getStock();

                //Se desplegia por pantalla toda la informacion de del producto
                StdOut.println("...........................................");
                StdOut.println("Nombre del producto: "+nombreProducto);
                StdOut.println("Precio del producto: "+precioProducto);
                StdOut.println("Categoria del producto: "+categoriaProducto);
                StdOut.println("Stock del producto: "+stockProducto);

            }
            StdOut.println("[*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*]");
        }
    }

    //TODO: agregar la funcion de eliminar un producto si su stock es cero
}
