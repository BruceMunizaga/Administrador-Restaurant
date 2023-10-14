package src.model.herenciaPersona;

import src.model.Persona;

public class Trabajador extends Persona {

    // tipo de contrato que posee el trabajador
    private String tipoDeContrato;

    // fecha de contratacion del trabajador
    private String fechaInicioContratacion;

    // fecha de contratacion del trabajador
    private String fechaTerminoContratacion;

    /**
     * The constructor
     *
     * @param nombre a inicializar
     * @param edad   a inicializar
     */
    public Trabajador(String nombre, int edad, String tipoDeContrato, String fechaInicioContratacion, String fechaTerminoContratacion) {
        super(nombre, edad);

        this.tipoDeContrato = tipoDeContrato;
        this.fechaInicioContratacion = fechaInicioContratacion;
        this.fechaTerminoContratacion = fechaTerminoContratacion;
    }
    /**
     *
     * @return el tipo de contrato del trabajador
     */
    public String getTipoDeContrato() {
        return this.tipoDeContrato;
    }

    /**
     *
     * @return la fecha de contratacion del trabajador
     */
    public String getFechaInicioContratacion() {
        return this.fechaInicioContratacion;
    }

    /**
     *
     * @param tipoDeContrato del trabajador a modificar
     */
    public void setTipoDeContrato(String tipoDeContrato) {
        this.tipoDeContrato = tipoDeContrato;
    }
}
