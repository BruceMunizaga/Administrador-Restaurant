package src.model.herenciaPersona;

import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;
import src.model.Persona;
import src.model.Producto;
import src.model.contenedores.ContenedorProductos;

public class Cliente extends Persona {

    private ContenedorProductos boleta;

    private Producto producto;

    /**
     * The constructor
     *
     * @param nombre a inicializar
     * @param edad   a inicializar
     */
    public Cliente(String nombre, int edad) {
        super(nombre, edad);

        this.boleta = new ContenedorProductos(100);
        this.producto = null;
    }

    public void realizarOrden(Producto producto1, int stock){
        this.producto = producto1;
        this.producto.setStock(stock);
        this.boleta.agregarProducto(this.producto);
    }

    public void desplegarOrden(){
        StdOut.println("               ORDEN");
        this.boleta.desplegarProductos();
    }
}
