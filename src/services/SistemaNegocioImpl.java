package src.services;

import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;
import src.model.Producto;
import src.model.contenedores.ContenedorClientes;
import src.model.contenedores.ContenedorMesas;
import src.model.contenedores.ContenedorProductos;
import src.model.contenedores.ContenedorTrabajadores;

import java.util.Objects;

public class SistemaNegocioImpl implements SistemaNegocio{
    ContenedorTrabajadores trabajadores = new ContenedorTrabajadores(999);
    ContenedorClientes clientes = new ContenedorClientes(999);
    ContenedorMesas mesas = new ContenedorMesas(18);
    ContenedorProductos inventario = new ContenedorProductos(999);

    Producto producto = null;

    @Override
    public void cargarInformacion() {
        producto = new Producto("pan",200,"Bebestible",30);
        this.inventario.agregarProducto(producto);
    }

    @Override
    public void opcionesInventario(String opcion) {

        if (opcion.equalsIgnoreCase("1")){
            int cantActual = inventario.getCantActual();

            if (cantActual == 0){
                StdOut.println("No hay productos registrados");
            }else{
                inventario.desplegarProductos();
            }
        }
        if (opcion.equalsIgnoreCase("2")){
            StdOut.print("Ingrese el nombre del producto a agregar: ");
            String nombreProducto = StdIn.readLine();

            int precioProducto;
            do {
                StdOut.print("Ingrese el precio del producto: ");
                precioProducto = StdIn.readInt();

                if (precioProducto < 0){
                    StdOut.println("El precio no puede ser inferior a cero");
                }
            }while (precioProducto < 0);

            int stockProducto;
            do {
                StdOut.print("Ingrese el stock del producto: ");
                stockProducto = StdIn.readInt();

                if (stockProducto < 0){
                    StdOut.println("El stock no puede ser inferior a cero");
                }
            }while (stockProducto < 0);

            String opcionCategoria;
            String categoria;
            do {
                StdOut.println("""
                        Ingrese la categoria del producto al cual pertenece:
                                            
                        [1] Comestible
                        [2] Bebestible
                        [3] Otros (no especificado)
                        """);
                StdOut.print("Inserte su opcion aqui: ");
                opcionCategoria = StdIn.readLine();

                if (opcionCategoria.equalsIgnoreCase("1")) {
                    categoria = "Comestible";
                }
                if (opcionCategoria.equalsIgnoreCase("2")) {
                    categoria = "Bebestible";
                }
                if (opcionCategoria.equalsIgnoreCase("3")) {
                    categoria = "Otros (no especificado)";
                }
                if (!opcionCategoria.equalsIgnoreCase("1") && !opcionCategoria.equalsIgnoreCase("2") && !opcionCategoria.equalsIgnoreCase("3")){
                    StdOut.println("Solo se permiten valores 1, 2 y 3");
                }
            }while (!Objects.equals(opcionCategoria,"1") && !Objects.equals(opcionCategoria,"2") && !Objects.equals(opcionCategoria,"3"));

            this.producto = new Producto(nombreProducto,precioProducto,opcionCategoria,stockProducto);
            this.inventario.agregarProducto(producto);
        }
    }

    @Override
    public void verTrabajadores() {

    }

    @Override
    public void verClientes() {

    }

    @Override
    public void verMesas() {

    }
}
