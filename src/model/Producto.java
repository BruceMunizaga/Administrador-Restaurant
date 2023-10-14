package src.model;

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
        this.stock = stock;
    }
}
