package src.Util;

import src.services.SistemaNegocio;

public class Instalador {
    private SistemaNegocio sistemaDelNegocio;

    public Instalador(){
        this.sistemaDelNegocio = instalarSistema();
    }

    public SistemaNegocio instalarSistema(){
        return this.sistemaDelNegocio;
    }
}
