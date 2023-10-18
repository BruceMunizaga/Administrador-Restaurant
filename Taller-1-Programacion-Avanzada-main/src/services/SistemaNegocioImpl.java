package src.services;

import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;
import src.model.Mesa;
import src.model.Producto;
import src.util.ContenedorClientes;
import src.util.ContenedorMesas;
import src.util.ContenedorProductos;
import src.util.ContenedorTrabajadores;
import src.model.herenciaPersona.Cliente;
import src.model.herenciaPersona.Trabajador;

import java.util.Objects;

public class SistemaNegocioImpl implements SistemaNegocio{

    //contenedores que se utilizaran en este taller
    ContenedorTrabajadores trabajadores = new ContenedorTrabajadores(99);
    ContenedorClientes clientes = new ContenedorClientes(99);
    ContenedorMesas mesas = new ContenedorMesas(18);
    ContenedorProductos inventario = new ContenedorProductos(99);

    //variables que se utilizaran para este taller
    Producto producto = null;
    Trabajador trabajador = null;
    Mesa mesa = null;
    Cliente cliente = null;

    @Override
    public void cargarInformacion() {

        //si no hay informacion guardada, se generan automaticamente

        //inventario
        producto = new Producto("Pan",200,"Comestible",50);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Carbonada",300,"Comestible",20);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Jumex Manzana",1000,"Bebestible",30);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Tacos al pastor",700,"Comestible",30);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Chorrillana",3500,"Comestible",15);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Palta reina",1500,"Comestible",20);
        this.inventario.agregarProducto(producto);
        producto = new Producto("CocaCola",700,"Bebestible",45);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Te",700,"Bebestible",45);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Cafe",1600,"Bebestible",15);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Mole",3500,"Comestible",45);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Pozole",2500,"Comestible",63);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Quezadillas",700,"Comestible",30);
        this.inventario.agregarProducto(producto);
        producto = new Producto("Nachos",1000,"Comestible",45);
        this.inventario.agregarProducto(producto);

        //trabajadores
        trabajador = new Trabajador("Jorge", 23, "Indefinido", "25/05/2023","");
        this.trabajadores.agregarTrabajador(trabajador);
        trabajador = new Trabajador("Matias", 19, "Fijo", "05/09/2023","05/12/2023");
        this.trabajadores.agregarTrabajador(trabajador);
        trabajador = new Trabajador("Victoria", 25, "Indefinido", "23/10/2023","");
        this.trabajadores.agregarTrabajador(trabajador);
        trabajador = new Trabajador("Sofia", 21, "Fijo", "18/10/2023","18/01/2024");
        this.trabajadores.agregarTrabajador(trabajador);

        //mesas
        for (int i = 1; i <=18 ; i++) {
            this.mesa = new Mesa(true,i);
            this.mesas.agregarMesa(this.mesa);
        }

    }

    @Override
    public void actualizarStock() {

        //se despliegan los productos en pantalla
        this.inventario.desplegarProductos();

        //Se pide el nombre del producto
        StdOut.print("Ingrese el nombre del producto que desea actualizar su stock: ");
        String nombreProducto = StdIn.readString();

        //Se busca el producto en el arreglo
        this.producto = this.inventario.obtenerProducto(nombreProducto);

        //Si se encontró ese producto se ejecuta esto
        if(this.producto != null){

            //variable a utilizar
            int nuevoStock;
            String opcionStock;

            //se pregunta sobre la accion

            do {
                StdOut.println("""
                        ¿Desea agregar o disminuir su Stock?
                        [1] Agregar Stock.
                        [2] Disminuir Stock.
                    """);
                StdOut.print("Inserte su opcion aqui: ");
                opcionStock = StdIn.readString();

                //si quiere agregar al stock

                if (opcionStock.equalsIgnoreCase("1")) {

                    //validacion de dato
                    do {
                        StdOut.print("Ingrese el stock a agregar: ");
                        nuevoStock = StdIn.readInt();

                        if (nuevoStock <= 0) {
                            StdOut.println("El stock a agregar debe ser mayor a cero");
                        }
                    }while (nuevoStock <= 0);

                    this.producto.setStock(nuevoStock);

                } else if (opcionStock.equalsIgnoreCase("2")){

                    //validacion de dato
                    do {
                        StdOut.print("Ingrese el stock a quitar: ");
                        nuevoStock = StdIn.readInt();

                        if (nuevoStock <= 0) {
                            StdOut.println("El stock a quitar debe ser mayor a cero");
                        }
                    }while (nuevoStock <= 0);

                    int nuevoStock1 = nuevoStock * -1;
                    this.producto.setStock(nuevoStock1);
                    this.inventario.eliminarProductosStockCero();
                }
                if (!opcionStock.equalsIgnoreCase("1") && !opcionStock.equalsIgnoreCase("2")){
                    StdOut.println("Solo se permiten valores 1 y 2");
                }
            }while (!opcionStock.equalsIgnoreCase("1") && !opcionStock.equalsIgnoreCase("2"));

        }else{
            System.out.println("Producto no encontrado.");
        }
    }

    @Override
    public void verInventario(){

        //importo la cantidad actual del inventario
        int cantActual = inventario.getCantActual();

        //Si no hay productos agregados, se despliega esto
        if (cantActual == 0){
            StdOut.println("No hay productos registrados");
        }else{

            //Si hay productos agregados, se despliegan
            StdOut.println("[*][*][*][*][*][*][*] INVENTARIO [*][*][*][*][*][*][*]");
            inventario.desplegarProductos();
            StdOut.println("[*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*][*]");
        }
    }

    @Override
    public void agregarProducto(){

        //Se comienzan a pedir todos los datos del nuevo producto
        StdOut.print("Ingrese el nombre del producto a agregar: ");
        String nombreProducto = StdIn.readString();

        double precioProducto = -1;
        do {
            StdOut.print("Ingrese el precio del producto: ");
            String precioStr = StdIn.readString();
            if (!precioStr.matches("\\d+")) {
                StdOut.println("El precio debe ser un número entero.");
            }else{
                precioProducto = Double.parseDouble(precioStr);
                if (precioProducto < 0) {
                    StdOut.println("La edad debe ser igual o mayor que 0.");
                }
            }
        } while (precioProducto < 0);

        //casting
        int precioProductoInt = (int) precioProducto;

        double stockProductoDouble = -1;
        do {
            StdOut.print("Ingrese el stock del producto: ");
            String stockStr = StdIn.readString();
            if (!stockStr.matches("\\d+")) {
                StdOut.println("El stock debe ser un número entero.");
            }else{
                stockProductoDouble = Double.parseDouble(stockStr);
                if (stockProductoDouble < 0) {
                    StdOut.println("El stock debe ser mayor que 0.");
                }
            }

        } while (stockProductoDouble < 0);

        //casting
        int stockProducto = (int) stockProductoDouble;

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

        //se guardan los datos
        this.producto = new Producto(nombreProducto,precioProductoInt,categoria,stockProducto);
        if(this.inventario.agregarProducto(producto)){
            StdOut.println("Producto agregado");
        }
    }

    @Override
    public void eliminarUnProducto(){
        //se solicita el nombre del producto a buscar
        StdOut.print("Ingrese el nombre del producto que desea eliminar del inventario: ");
        String nombreProductoStock = StdIn.readString();

        // se busca el producto en funcion de su nombre
        this.producto = this.inventario.obtenerProducto(nombreProductoStock);

        //si se encontro el producto, se llama al metodo que lo eliminara
        if (this.producto != null){
            this.inventario.eliminarProductoNombre(this.producto);
        }
    }

    @Override
    public void verTrabajadores() {
        //se despliega por pantalla a los trabajadores registrados
        this.trabajadores.desplegarTrabajadores();

    }

    @Override
    public void renovarContrato(){

        //se despliegan los trabajadores por pantalla
        this.trabajadores.desplegarTrabajadores();

        //se solicita el nombre del trabajador
        StdOut.print("Ingrese el nombre del trabajador al cual desee renovarle el contrato: ");
        String nombreTrabajador = StdIn.readString();
        this.trabajador = this.trabajadores.obtenerTrabajador(nombreTrabajador);

        //si encuentra al trabajador, se ejecuta esto
        if (trabajador != null){

            //si el trabajador no mantiene contrato indefinido
            if (!(this.trabajador.getTipoDeContrato().equalsIgnoreCase("Indefinido"))){
                StdOut.print("Indique la fecha de renovacion del contrato (dd//mm/aaaa): ");
                String fechaContratacion = StdIn.readString();
                StdOut.print("Indique la fecha de finalizacion del contrato (dd//mm/aaaa): ");
                String fechaFinContratacion = StdIn.readString();

                //se guardan los datos
                this.trabajador.setFechaInicioContratacion(fechaContratacion);
                this.trabajador.setFechaTerminoContratacion(fechaFinContratacion);
            } else{

                //si el trabajador ya mantiene un contrato indefinido, no se puede hacer una renovacion
                StdOut.println("No se le puede renovar el contrato a un trabajador que posee contrato Indefinido");
            }
        }
    }

    @Override
    public void finalizarContrato(){

        this.trabajadores.desplegarTrabajadores();

        //se solicita el nombre del trabajador
        StdOut.print("Ingrese el nombre del trabajador al cual desee finalizarle el contrato: ");
        String nombreTrabajador = StdIn.readString();

        //se busca al trabajador en el arreglo
        this.trabajador = this.trabajadores.obtenerTrabajador(nombreTrabajador);

        if (this.trabajador != null){
            this.trabajadores.finalizarContratoTrabajador(this.trabajador);
        }


    }

    @Override
    public void otorgarIndefinido(){

        this.trabajadores.desplegarTrabajadores();

        //se solicita el nombre del trabajador
        StdOut.print("Ingrese el nombre del trabajador al cual desee otorgarle el contrato Indefinido: ");
        String nombreTrabajador = StdIn.readString();

        //se busca al trabajador en el arreglo
        this.trabajador = this.trabajadores.obtenerTrabajador(nombreTrabajador);

        //si encontro al trabajador
        if (this.trabajador != null){

            //si el trabajdor ya tiene el contrato indefinido
            if (this.trabajador.getTipoDeContrato().equalsIgnoreCase("Indefinido")){
                StdOut.println("No se puede otorgar un contrato Indefinido a un trabajador que ya lo posee");
            }else{
                //si el trabajador no tiene contrato indefinido, se le otorga
                StdOut.print("Indique la fecha en la cual se le esta otorgando el contrato Indefinido (dd/mm/aaaa): ");
                String fechaIndefinido = StdIn.readString();
                this.trabajador.setFechaInicioContratacion(fechaIndefinido);
                this.trabajador.setFechaTerminoContratacion("");
                this.trabajador.setTipoDeContrato("Indefinido");
            }
        }
    }

    @Override
    public void registrarCliente() {

        //se solicitan los datos del nuevo cliente
        StdOut.print("Registrar el nombre del nuevo cliente: ");
        String nombreClienteNuevo = StdIn.readString();

        double edadClienteNuevo = 0;
        do {
            StdOut.print("Registrar el edad del nuevo cliente: ");
            String edadStr = StdIn.readString();
            if (!edadStr.matches("\\d+")) {
                StdOut.println("La edad debe ser un número entero.");
                continue;
            }
            edadClienteNuevo = Double.parseDouble(edadStr);
            if (edadClienteNuevo < 18 || edadClienteNuevo > 100) {
                StdOut.println("La edad debe ser igual o mayor que 18 y menor o igual que 100.");
            }
        } while (edadClienteNuevo < 18 || edadClienteNuevo > 100);

        //casting
        int edadClienteNuevoInt = (int) edadClienteNuevo;

        //se consulta la mesa que ocupara
        while(true){

            double numeroMesa = 0;
            do {
                StdOut.print("¿Que mesa ocupara?(incerte numero de mesa): ");
                String numerMesaStr = StdIn.readString();

                if (!numerMesaStr.matches("\\d+")) {
                    StdOut.println("El numero debe ser un número entero.");
                    continue;
                }
                numeroMesa = Double.parseDouble(numerMesaStr);
                if (numeroMesa < 1 || numeroMesa > 18) {
                    StdOut.println("El numero debe ser igual o mayor que 1 y menor o igual que 19.");
                }
            } while (numeroMesa < 1 || numeroMesa > 18);

            int mesaOcupar = (int) numeroMesa;
            this.mesa = this.mesas.obtenerMesa(mesaOcupar);


            //se valida si es que esa mesa esta ocupada o no
            if (!(this.mesa.isLibreOcupada())){
                StdOut.println("Mesa ocupada, esoga otra");
            }else{

                //si la mesa no esta ocupada, el cliente se situara en ella
                this.cliente = new Cliente(nombreClienteNuevo,edadClienteNuevoInt);
                this.clientes.agregarCliente(this.cliente);
                this.mesa.setLibreOcupada(false);
                this.mesa.setCliente(cliente);

                //se consulta que trabajador atendera esa mesa
                do {
                    StdOut.print("Ingrese el nombre del trabajador que atendera esa mesa: ");
                    String nombreTrabajador = StdIn.readString();

                    //busca si el trabajador realmente existe
                    this.trabajador = this.trabajadores.obtenerTrabajador(nombreTrabajador);

                    //si no se encuentra, se vuelve a preguntar
                }while(this.trabajador == null);

                //si encontro la trabajador, se guarda en esa mesa
                this.mesa.setTrabajador(this.trabajador);

                this.mesa.desplegarMesa();

                StdOut.println("""
                        
                        """);
                String pregunta = "";
                do {
                    //se pregunta por elproducto
                    StdOut.print("¿Que producto desea el cliente?: ");
                    String productoUno = StdIn.readString();

                    //se busca el producto consultado
                    this.producto = inventario.obtenerProducto(productoUno);

                    if (this.producto != null){

                        int stockInt = 0;
                        int stockAux = this.producto.getStock();
                        boolean noInt;

                        do {
                            noInt = true;
                            StdOut.print("¿En que cantidad quiere el producto?: ");
                            String stockStr = StdIn.readString();

                            try{
                                stockInt = Integer.parseInt(stockStr);
                            }catch (NumberFormatException e){
                                StdOut.println("Solo se permiten numeros.");
                                noInt = false;
                            }
                            if (noInt){
                                if (stockInt < 1 || stockInt > stockAux) {
                                    StdOut.println("El numero debe ser igual o mayor que 1 y menor o igual que "+stockAux+".");
                                }
                            }
                        } while (stockInt < 1 || stockInt > stockAux || !noInt);

                        Producto producto1 = new Producto(this.producto.getNombreProducto(),this.producto.getPrecioProducto(),this.producto.getCategoria(), stockInt);
                        this.cliente.realizarOrden(producto1, 0);
                        this.producto.setStock(stockInt * -1); //FIXME: no setea correctamente el stock
                        this.inventario.eliminarProductosStockCero();

                        //se consulta si quiere agregar otro producto a la orden
                        do {
                            StdOut.print("¿Desea agregar otro producto?: ");
                            pregunta = StdIn.readString();

                            if (!(pregunta.equalsIgnoreCase("Si")) && !(pregunta.equalsIgnoreCase("No"))){
                                StdOut.println("Responde si o no.");
                            }
                        }while (!(pregunta.equalsIgnoreCase("Si")) && !(pregunta.equalsIgnoreCase("No")));
                    }else{
                        System.out.println("Producto no encontrado.");
                    }
                }while (this.producto == null || pregunta.equalsIgnoreCase("si"));

                break;
            }
        }
    }

    @Override
    public void aumentarOrden() {

        //se consulta la mesa que se le agregara otra orden
        while (true) {

            double numeroMesa = 0;
            do {
                StdOut.print("Ingrese el numero de la mesa a la cual se le aumentara la orden: ");
                String numerMesaStr = StdIn.readString();

                if (!numerMesaStr.matches("\\d+")) {
                    StdOut.println("El numero debe ser un número entero.");
                    continue;
                }
                numeroMesa = Double.parseDouble(numerMesaStr);
                if (numeroMesa < 1 || numeroMesa > 18) {
                    StdOut.println("El numero debe ser igual o mayor que 1 y menor o igual que 19.");
                }
            } while (numeroMesa < 1 || numeroMesa > 18);

            int numeroMesaInt = (int) numeroMesa;


            this.mesa = this.mesas.obtenerMesa(numeroMesaInt);

            //se valida si es que esa mesa esta ocupada o no
            if ((this.mesa.isLibreOcupada())){
                StdOut.println("Mesa libre, esoga otra");
            }else{
                this.cliente = this.mesa.getCliente();

                String pregunta = "";
                do {
                    //se pregunta por elproducto
                    StdOut.print("¿Que producto desea el cliente?: ");
                    String productoUno = StdIn.readString();

                    //se busca el producto consultado
                    this.producto = inventario.obtenerProducto(productoUno);

                    if (this.producto != null){

                        int stockInt = 0;
                        int stockAux = this.producto.getStock();
                        boolean noInt;

                        do {
                            noInt = true;
                            StdOut.print("¿En que cantidad quiere el producto?: ");
                            String stockStr = StdIn.readString();

                            try{
                                stockInt = Integer.parseInt(stockStr);
                            }catch (NumberFormatException e){
                                StdOut.println("Solo se permiten numeros.");
                                noInt = false;
                            }
                            if (noInt){
                                if (stockInt < 1 || stockInt > stockAux) {
                                    StdOut.println("El numero debe ser igual o mayor que 1 y menor o igual que "+stockAux+".");
                                }
                            }
                        } while (stockInt < 1 || stockInt > stockAux || !noInt);

                        this.cliente.realizarOrden(this.producto, stockInt);
                        this.producto.setStock(stockInt * -1);
                        this.inventario.eliminarProductosStockCero();

                        //se consulta si quiere agregar otro producto a la orden
                        do {
                            StdOut.print("¿Desea agregar otro producto?: ");
                            pregunta = StdIn.readString();

                            if (!(pregunta.equalsIgnoreCase("Si")) && !(pregunta.equalsIgnoreCase("No"))){
                                StdOut.println("Responde si o no.");
                            }
                        }while (!(pregunta.equalsIgnoreCase("Si")) && !(pregunta.equalsIgnoreCase("No")));
                    }
                }while (this.producto == null || pregunta.equalsIgnoreCase("si"));

                break;
            }
        }
    }

    @Override
    public void verMesa(){
        double numeroMesa = 0;
        do {
            StdOut.print("Incerte el numero de la mesa a ver: ");
            String numerMesaStr = StdIn.readString();

            if (!numerMesaStr.matches("\\d+")) {
                StdOut.println("El numero debe ser un número entero.");
                continue;
            }
            numeroMesa = Double.parseDouble(numerMesaStr);
            if (numeroMesa < 1 || numeroMesa > 18) {
                StdOut.println("El numero debe ser igual o mayor que 1 y menor o igual que 19.");
            }
        } while (numeroMesa < 1 || numeroMesa > 18);

        int verMesa = (int) numeroMesa;
        this.mesa = this.mesas.obtenerMesa(verMesa);
        this.mesa.desplegarMesa();
    }

    @Override
    public void verClientes(){
        this.clientes.desplegarClientes();
    }

    @Override
    public void desplegarMesas() {

        //se despliegan las mesas en pantalla visiblemente agradable con el status y su numero
        StdOut.print();
        StdOut.print();
        StdOut.println("+---------+         +---------+         +---------+         +---------+" +
                "         +---------+         +---------+");
        StdOut.println("|    1    |         |    2    |         |    3    |         |    4    |" +
                "         |    5    |         |    6    |");
        StdOut.println("|         |         |         |         |         |         |         |" +
                "         |         |         |         |");
        StdOut.println("| "+this.mesas.obtenerMesa(1).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(2).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(3).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(4).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(5).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(6).isLibreOcupadaString()+" |");
        StdOut.println("|         |         |         |         |         |         |         |" +
                "         |         |         |         |");
        StdOut.println("+---------+         +---------+         +---------+         +---------+" +
                "         +---------+         +---------+");
        StdOut.println();
        StdOut.println();
        StdOut.println("+---------+         +---------+         +---------+         +---------+" +
                "         +---------+         +---------+");
        StdOut.println("|    7    |         |    8    |         |    9    |         |    10   |" +
                "         |    11   |         |    12   |");
        StdOut.println("|         |         |         |         |         |         |         |" +
                "         |         |         |         |");
        StdOut.println("| "+this.mesas.obtenerMesa(7).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(8).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(9).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(10).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(11).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(12).isLibreOcupadaString()+" |");
        StdOut.println("|         |         |         |         |         |         |         |" +
                "         |         |         |         |");
        StdOut.println("+---------+         +---------+         +---------+         +---------+" +
                "         +---------+         +---------+");
        StdOut.println();
        StdOut.println();
        StdOut.println("+---------+         +---------+         +---------+         +---------+" +
                "         +---------+         +---------+");
        StdOut.println("|    13   |         |    14   |         |    15   |         |    16   |" +
                "         |    17   |         |    18   |");
        StdOut.println("|         |         |         |         |         |         |         |" +
                "         |         |         |         |");
        StdOut.println("| "+this.mesas.obtenerMesa(13).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(14).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(15).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(16).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(17).isLibreOcupadaString()+" |         | "
                +this.mesas.obtenerMesa(18).isLibreOcupadaString()+" |");
        StdOut.println("|         |         |         |         |         |         |         |" +
                "         |         |         |         |");
        StdOut.println("+---------+         +---------+         +---------+         +---------+" +
                "         +---------+         +---------+");

        StdOut.println();
        StdOut.println();
    }

    @Override
    public void desplegarBoleta(){
        double numeroMesa = 0;
        do {
            StdOut.print("Incerte el numero de la mesa que pagara la cuenta: ");
            String numerMesaStr = StdIn.readString();

            if (!numerMesaStr.matches("\\d+")) {
                StdOut.println("El numero debe ser un número entero.");
                continue;
            }
            numeroMesa = Double.parseDouble(numerMesaStr);
            if (numeroMesa < 1 || numeroMesa > 18) {
                StdOut.println("El numero debe ser igual o mayor que 1 y menor o igual que 19.");
            }
        } while (numeroMesa < 1 || numeroMesa > 18);

        int verMesa = (int) numeroMesa;
        this.mesa = this.mesas.obtenerMesa(verMesa);
        this.cliente = this.mesa.getCliente();
        this.cliente.desplegarBoletaCliente();
        this.clientes.eliminarClienteNombre(this.cliente);
    }
}
