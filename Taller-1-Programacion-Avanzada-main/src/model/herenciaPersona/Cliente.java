package src.model.herenciaPersona;

import edu.princeton.cs.stdlib.StdOut;
import src.model.Persona;
import src.model.Producto;
import src.util.ContenedorProductos;

public class Cliente extends Persona {

    private ContenedorProductos boleta;

    /**
     * The constructor
     *
     * @param nombre a inicializar
     * @param edad   a inicializar
     */
    public Cliente(String nombre, int edad) {
        super(nombre, edad);

        this.boleta = new ContenedorProductos(100);
    }

    public void realizarOrden(Producto producto1, int stockInt){
        String nombreProducto = producto1.getNombreProducto();
        Producto producto2 = this.boleta.obtenerProducto(nombreProducto);
        if (producto2 != null){
            aumentarOrden(producto2, stockInt);

        }else{
            this.boleta.agregarProducto(producto1);
        }
    }

    public void desplegarOrden(){
        StdOut.println("               ORDEN");
        this.boleta.desplegarProductos();
    }
    public void aumentarOrden(Producto producto2, int stockInt){
        producto2.setStock(stockInt);

    }

    /**
     * Metodo que desplegara el inventario
     *
     */
    public void desplegarBoletaCliente(){
        this.boleta.desplegarProductosCliente();
    }
}
