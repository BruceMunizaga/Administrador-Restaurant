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

    //contenedores que se utilizaran en este taller
    ContenedorTrabajadores trabajadores = new ContenedorTrabajadores(999);
    ContenedorClientes clientes = new ContenedorClientes(999);
    ContenedorMesas mesas = new ContenedorMesas(18);
    ContenedorProductos inventario = new ContenedorProductos(999);

    //variables que se utilizaran para este taller
    Producto producto = null;

    @Override
    public void cargarInformacion() {

        //si no hay informacion guardada, se generan automaticamente
        producto = new Producto("Pan",200,"Comestible",30);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Cebolla",300,"Comestible",30);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Jumex Manzana",1000,"Bebestible",30);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Tacos al pastor",700,"Comestible",30);
        this.inventario.agregarProducto(producto);
    }

    @Override
    public void opcionesInventario(String opcion) {

        //Si en el menu inventario escogiste la opcion uno, esto se ejecutara
        if (opcion.equalsIgnoreCase("1")){
            int cantActual = inventario.getCantActual();

            //Si no hay productos agregados, se despliega esto
            if (cantActual == 0){
                StdOut.println("No hay productos registrados");
            }else{

                //Si hay productos agregados, se despliegan
                inventario.desplegarProductos();
            }
        }

        //Si escogio la segunda opcion, se ejecuta esto
        if (opcion.equalsIgnoreCase("2")){

            //Se comienzan a pedir todos los datos del nuevo producto
            StdOut.print("Ingrese el nombre del producto a agregar: ");
            String nombreProducto = StdIn.readString();

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

                if (stockProducto <= 0){
                    StdOut.println("El stock no puede ser  o igual a cero");
                }
            }while (stockProducto <= 0);

            String opcionCategoria;
            String categoria = null;
            do {
                StdOut.println("""
                        Ingrese la categoria del producto al cual pertenece:
                                            
                        [1] Comestible
                        [2] Bebestible
                        [3] Otros (no especificado)
                        """);
                StdOut.print("Inserte su opcion aqui: ");
                opcionCategoria = StdIn.readString();

                if (opcionCategoria.equalsIgnoreCase("1")) {
                    categoria = "Comestible";
                }
                if (opcionCategoria.equalsIgnoreCase("2")) {
                    categoria = "Bebestible";
                }
                if (opcionCategoria.equalsIgnoreCase("3")) {
                    categoria = "Otros (no especificado)";
                }
                if(!opcionCategoria.equalsIgnoreCase("1") && !opcionCategoria.equalsIgnoreCase("2") && !opcionCategoria.equalsIgnoreCase("3")){
                    StdOut.println("Solo se permiten valores 1, 2 y 3");
                }
            }while (!Objects.equals(opcionCategoria,"1") && !Objects.equals(opcionCategoria,"2") && !Objects.equals(opcionCategoria,"3"));

            this.producto = new Producto(nombreProducto,precioProducto,categoria,stockProducto);
             if(this.inventario.agregarProducto(producto)){
                 StdOut.println("Producto agregado");
             }
        }

        //Si ecogio la tercera opcion, se ejecuta esto
        if (opcion.equalsIgnoreCase("3")){
            this.inventario.desplegarProductos();

            //Se pide el nombre del producto
            StdOut.print("Ingrese el nombre del producto que desea actualizar su stock: ");
            String nombreProducto = StdIn.readString();

            //Se busca el producto en el arreglo
            this.producto = this.inventario.obtenerProducto(nombreProducto);

            //Si se encontró ese producto se ejecuta esto
            if(this.producto != null){
                //Se pide la poiscion de ese producto
                int posicionProducto = this.inventario.posicionProducto(this.producto);
                String opcionStock = null;
                do {
                    StdOut.println("""
                        ¿Desea agregar o disminuir su Stock?
                        [1] Agregar Stock.
                        [2] Disminuir Stock.
                    """);
                    StdOut.print("Inserte su opcion aqui: ");
                    opcionStock = StdIn.readString();

                    if (opcionStock.equalsIgnoreCase("1")) {
                        //variable a utilizar
                        int nuevoStock;

                        //validacion de dato
                        do {
                            StdOut.print("Ingrese el stock a agregar");
                            nuevoStock = StdIn.readInt();

                            if (nuevoStock <= 0) {
                                StdOut.println("El stock a agregar debe ser mayor a cero");
                            }
                        }while (nuevoStock <= 0);

                        this.producto.setStock(nuevoStock);

                    }
                    if (opcionStock.equalsIgnoreCase("2")) {
                        //categoria = "Bebestible";
                    }
                    if (!opcionStock.equalsIgnoreCase("1") && !opcionStock.equalsIgnoreCase("2")){
                        StdOut.println("Solo se permiten valores 1 y 2");
                    }
                }while (!Objects.equals(opcionStock,"1") && !Objects.equals(opcionStock,"2"));
            }
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
