package src;

import edu.princeton.cs.stdlib.StdOut;
import edu.princeton.cs.stdlib.StdIn;
import src.services.SistemaNegocioImpl;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        SistemaNegocioImpl SistemaNegocioImpl = new SistemaNegocioImpl();

        SistemaNegocioImpl.cargarInformacion();


        StdOut.println("[*] BIENVENIDO AL SISTEMA DE ADMINISTRACION DEL RESTAURANTE[*]");
        String opcion = null;
        while (!Objects.equals(opcion,"5")){
            StdOut.println("""
                    ---------------------------------------------------------------------------------------------------
                    
                    [1] Opciones de inventario.
                    [2] Opciones de Trabajadores.
                    [3] Opciones de clientes.
                    [4] Opciones de Mesas.
                    [5] Guardar cambios y cerrar el programa.
                    """);
            StdOut.print("Inserte su opcion aqui: ");
            opcion = StdIn.readString();
            StdOut.println("---------------------------------------------------------------------------------------------------");

            switch (opcion){
                case "1" -> menuInventario(SistemaNegocioImpl);
                case "2" -> StdOut.println("Se esta trabajando en ello");//TODO: hay que programarlo
                case "3" -> StdOut.println("Se esta trabajando en ello");//TODO: hay que programarlo
                case "4" -> StdOut.println("Se esta trabajando en ello");//TODO: hay que programarlo
                case "5" -> StdOut.println("Hasta Pronto");
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }

    private static void menuInventario(SistemaNegocioImpl sistemaNegocioImpl){
        StdOut.println("[*] MENU INVENTARIO [*]");
        String opcion = null;
        while (!Objects.equals(opcion,"5")){
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
                case "1" -> sistemaNegocioImpl.opcionesInventario("1");
                case "2" -> sistemaNegocioImpl.opcionesInventario("2");
                case "3" -> sistemaNegocioImpl.opcionesInventario("3"); //FIXME: aun falta, esta incompleto
                case "4" -> StdOut.println("Se esta trabajando en ello"); //TODO: hay que programarlo
                case "5" -> StdOut.println("Regresando al menu principal...");
                default -> StdOut.println("Opcion no valida, intente nuevamente");

            }
        }
    }
}