package entidades.service;

import java.time.LocalDate;

public class Service {
    private LocalDate fechaService;
    private String cui;
    private String tipoAceite;
    private String marcaAceite;
    private boolean ajusteCarroceria;
    private boolean ajusteCadena;
    private boolean cambioTramision;
    private String otrosDetalles;
    private long kilometrajeEntrada;
    private long kilometrajePrueba = 0;

    public Service(LocalDate fechaService, String cui, String tipoAceite, String marcaAceite, boolean ajusteCarroceria, boolean ajusteCadena, boolean cambioTramision, String otrosDetalles, long kilometrajeEntrada, long kilometrajePrueba) {
        this.fechaService = fechaService;
        this.cui = cui;
        this.tipoAceite = tipoAceite;
        this.marcaAceite = marcaAceite;
        this.ajusteCarroceria = ajusteCarroceria;
        this.ajusteCadena = ajusteCadena;
        this.cambioTramision = cambioTramision;
        this.otrosDetalles = otrosDetalles;
        this.kilometrajeEntrada = kilometrajeEntrada;
        this.kilometrajePrueba = kilometrajePrueba;
    }
}
