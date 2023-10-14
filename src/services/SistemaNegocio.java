package src.services;

public interface SistemaNegocio {

    /**
     * metodo que leera el archivo .txt
     */
    void cargarInformacion();



    /**
     * metodo que desplegara el inventario en pantalla
     */
    void opcionesInventario(String opcion);

    /**
     * metodo que desplegara a los trabajadores en pantalla
     */
    void verTrabajadores();

    /**
     * metodo que desplegara a los clientes en pantalla
     */
    void verClientes();

    /**
     * metodo que desplegara el status de sus mesas en pantalla
     */
    void verMesas();
}
