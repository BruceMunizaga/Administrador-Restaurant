package src.model;

import edu.princeton.cs.stdlib.StdOut;

public class Producto {

    private String nombreProducto;

    private int precioProducto;

    private String categoria;

    private int stock;

    public Producto(String nombreProducto, int precioProducto, String categoria, int stock) {
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.categoria = categoria;
        this.stock = stock;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public int getPrecioProducto() {
        return this.precioProducto;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getStock() {
        return this.stock;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setStock(int stock) {
        this.stock += stock;
    }

    /**
     * Metodo que desplegara el un producto
     *
     */
    public void desplegarUnProducto(Producto productoDeplegar){

        //Se guardan sus datos en variables temporales
        String nombreProducto = productoDeplegar.getNombreProducto();
        int precioProducto = productoDeplegar.getPrecioProducto();
        String categoriaProducto = productoDeplegar.getCategoria();
        int stockProducto = productoDeplegar.getStock();

        //Se desplegia por pantalla toda la informacion del producto
        StdOut.println("...........................................");
        StdOut.println("Nombre del producto: "+nombreProducto);
        StdOut.println("Precio del producto: "+precioProducto);
        StdOut.println("Categoria del producto: "+categoriaProducto);
        StdOut.println("Stock del producto: "+stockProducto);
    }
}
