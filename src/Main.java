package src;

import edu.princeton.cs.stdlib.StdOut;
import edu.princeton.cs.stdlib.StdIn;
import src.services.SistemaNegocioImpl;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * El menu principal
     */
    private static void menuPrincipal() {
        SistemaNegocioImpl SistemaNegocioImpl = new SistemaNegocioImpl();
        SistemaNegocioImpl.cargarInformacion();


        StdOut.println("[*] BIENVENIDO AL SISTEMA DE ADMINISTRACION DEL RESTAURANTE[*]");
        String opcion = "0";
        while (!opcion.equalsIgnoreCase("5")){
            StdOut.println("""
                    ---------------------------------------------------------------------------------------------------
                    
                    [1] Opciones de inventario.
                    [2] Opciones de Trabajadores.
                    [3] Opciones de clientes.
                    [4] Opciones de Mesas.
                    [5] Cerrar el programa.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readString();
            StdOut.println("---------------------------------------------------------------------------------------------------");

            switch (opcion){
                case "1" -> menuInventario(SistemaNegocioImpl);
                case "2" -> menuTrabajador(SistemaNegocioImpl);
                case "3" -> menuCliente(SistemaNegocioImpl);
                case "4" -> menuMesa(SistemaNegocioImpl);
                case "5" -> StdOut.println("Hasta Pronto");
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }

    /**
     * El menu para interactuar con el inventario
     *
     * @param sistemaNegocioImpl a utilizar
     */
    private static void menuInventario(SistemaNegocioImpl sistemaNegocioImpl){
        StdOut.println("[*] MENU INVENTARIO [*]");
        String opcion = "0";
        while (!opcion.equalsIgnoreCase("5")){
            StdOut.println("""
                    ---------------------------------------------------------------------------------------------------
                    
                    [1] Ver inventario.
                    [2] Agregar un producto.
                    [3] Actualizar stock.
                    [4] Eliminar un producto.
                    [5] Regresar al menu principal.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readString();
            StdOut.println("---------------------------------------------------------------------------------------------------");

            switch (opcion){
                case "1" -> sistemaNegocioImpl.verInventario();
                case "2" -> sistemaNegocioImpl.agregarProducto();
                case "3" -> sistemaNegocioImpl.actualizarStock(); //FIXME: falta arreglarlo ya que lee un dato de mas
                case "4" -> sistemaNegocioImpl.eliminarUnProducto();
                case "5" -> StdOut.println("Regresando al menu principal...");
                default -> StdOut.println("Opcion no valida, intente nuevamente");
            }
        }
    }

    /**
     * El menu para interactuar con los trabajadores
     *
     * @param sistemaNegocioImpl a utilizar
     */
    private static void menuTrabajador(SistemaNegocioImpl sistemaNegocioImpl){
        StdOut.println("[*] ADMINISTRACION [*]");
        String opcion = "0";
        while (!opcion.equalsIgnoreCase("5")){
            StdOut.println("""
                    ---------------------------------------------------------------------------------------------------
                    
                    [1] Ver Trabajadores.
                    [2] Renovar contrato.
                    [3] Finalizar contrato.
                    [4] Otorgar contrato indefinido.
                    [5] Regresar al menu principal.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readString();
            StdOut.println("---------------------------------------------------------------------------------------------------");

            switch (opcion){
                case "1" -> sistemaNegocioImpl.verTrabajadores();
                case "2" -> sistemaNegocioImpl.renovarContrato();
                case "3" -> sistemaNegocioImpl.finalizarContrato();
                case "4" -> sistemaNegocioImpl.otorgarIndefinido();
                case "5" -> StdOut.println("Regresando al menu principal...");
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }

    /**
     * El menu para interactuar con los clientes
     *
     * @param sistemaNegocioImpl a utilizar
     */
    private static void menuCliente(SistemaNegocioImpl sistemaNegocioImpl){
        sistemaNegocioImpl.desplegarMesas();

        StdOut.println("[*] MENU CLIENTES [*]");
        String opcion = "0";
        while (!opcion.equalsIgnoreCase("5")){
            StdOut.println("""
                    ---------------------------------------------------------------------------------------------------
                    
                    [1] Registrar nuevo cliente.
                    [2] Ver clientes registrados.
                    [3] Aumentar la orden de un cliente.
                    [4] Pagar Boleta.
                    [5] Regresar al menu principal.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readString();
            StdOut.println("---------------------------------------------------------------------------------------------------");

            switch (opcion){
                case "1" -> sistemaNegocioImpl.registrarCliente(); //FIXME: arreglar el metodo ya que lee algo demas
                case "2" -> sistemaNegocioImpl.verClientes();
                case "3" -> sistemaNegocioImpl.aumentarOrden();
                case "4" -> StdOut.println("Se esta trabajando en ello");//TODO: hay que programarlo
                case "5" -> StdOut.println("Regresando al menu principal...");
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }

    /**
     * El menu para interactuar con las mesas
     * @param sistemaNegocioImpl a utilizar
     */
    private static void menuMesa(SistemaNegocioImpl sistemaNegocioImpl){
        StdOut.println("[*] MESAS [*]");
        String opcion = "0";
        while (!opcion.equalsIgnoreCase("5")){
            StdOut.println("""
                    ---------------------------------------------------------------------------------------------------
                    
                    [1] Ver mesas.
                    [2] Desplegar contenido de una mesa.
                    [3] Regresar al menu principal.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readString();
            StdOut.println("---------------------------------------------------------------------------------------------------");

            switch (opcion){
                case "1" -> sistemaNegocioImpl.desplegarMesas();
                case "2" -> sistemaNegocioImpl.verMesa();
                case "3" -> StdOut.println("Regresando al menu principal...");
                default -> StdOut.println("Opcion no valida, intente nuevamente");
            }
        }
    }
}