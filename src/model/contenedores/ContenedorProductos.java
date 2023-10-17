package src.model.contenedores;

import edu.princeton.cs.stdlib.StdOut;
import src.model.Producto;

public class ContenedorProductos {

    private final Producto[] inventario;
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
            for (int i = 0; i < this.cantActual; i++) {
                if(this.inventario[i].getNombreProducto().toLowerCase().contains(nombreProducto.toLowerCase())){
                    return inventario[i];
                }
            }
            System.out.println("Producto no encontrado.");
        }
        return null;
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
                StdOut.println("Stock del unitario del producto: "+stockProducto);

            }
            StdOut.println("...........................................");
        }
    }

    /**
     * metodo que elimina productos que tengan stock cero
     */
    public void eliminarProductosStockCero() {

        // Busca los productos con stock en cero o menor que cero
        for (int i = 0; i < this.cantActual; i++) {
            if (this.inventario[i].getStock() <= 0) {
                // Elimina el producto
                StdOut.println("Se elimino el producto " + this.inventario[i].getNombreProducto() + " del inventario " +
                        "porque ya no queda en stock");
                this.inventario[i] = null;
            }
        }
        ordenarArreglo();
    }

    /**
     * metodo que ordena el arreglo moviendo las casillas en null al final
     */
    public void ordenarArreglo() {

        // Encuentra la posición del primer producto no null
        int finNoNull = 0;
        for (int i = 0; i < this.cantActual; i++) {
            if (this.inventario[i] != null) {
                finNoNull = i;
                break;
            }
        }

        // Mueve los productos null al final del arreglo
        for (int i = finNoNull; i < this.cantActual; i++) {
            if (this.inventario[i] == null) {
                for (int j = i; j < this.cantActual - 1; j++) {
                    this.inventario[j] = this.inventario[j + 1];
                }
                this.inventario[this.cantActual - 1] = null;
            }
        }
        this.cantActual--;
    }

    /**
     * metodo que eliminara un producto por su nombre
     * @param producto a eliminar
     */
    public void eliminarProductoNombre(Producto producto){

        for (int i = 0; i < this.cantActual; i++) {
            if (this.inventario[i] == producto){
                this.inventario[i] = null;
                StdOut.println("Producto eliminado.");
                break;
            }
        }
        ordenarArreglo();
    }
}
