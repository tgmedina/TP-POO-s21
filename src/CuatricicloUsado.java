public class CuatricicloUsado extends Vehiculo {

    private String tipoTraccion;
    private Boolean esATV;
    private String espejoDerecho;
    private String espejoIzquierdo;
    private int estadoBateria;
    private int estadoPintura;
    private String otrosDetalles;

    public CuatricicloUsado(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoTraccion, Boolean esATV, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles) {
        super(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda);
        this.tipoTraccion = tipoTraccion;
        this.esATV = esATV;
        this.espejoDerecho = espejoDerecho;
        this.espejoIzquierdo = espejoIzquierdo;
        this.estadoBateria = estadoBateria;
        this.estadoPintura = estadoPintura;
        this.otrosDetalles = otrosDetalles;
    }

    public String getEspejoDerecho() {
        return espejoDerecho;
    }

    public void setEspejoDerecho(String espejoDerecho) {
        this.espejoDerecho = espejoDerecho;
    }

    public String getEspejoIzquierdo() {
        return espejoIzquierdo;
    }

    public void setEspejoIzquierdo(String espejoIzquierdo) {
        this.espejoIzquierdo = espejoIzquierdo;
    }

    public int getEstadoBateria() {
        return estadoBateria;
    }

    public void setEstadoBateria(int estadoBateria) {
        this.estadoBateria = estadoBateria;
    }

    public int getEstadoPintura() {
        return estadoPintura;
    }

    public void setEstadoPintura(int estadoPintura) {
        this.estadoPintura = estadoPintura;
    }

    public String getOtrosDetalles() {
        return otrosDetalles;
    }

    public void setOtrosDetalles(String otrosDetalles) {
        this.otrosDetalles = otrosDetalles;
    }

    public String getTipoTraccion() {
        return tipoTraccion;
    }

    public void setTipoTraccion(String tipoTraccion) {
        this.tipoTraccion = tipoTraccion;
    }

    public Boolean getEsATV() {
        return esATV;
    }

    public void setEsATV(Boolean esATV) {
        this.esATV = esATV;
    }
}