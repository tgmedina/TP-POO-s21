public class Cuatriciclo extends Vehiculo{
    private int estadoBateria;
    private boolean estadoPintura;
    private String otroFaltante;
    private boolean espejoDerecho;
    private boolean espejoIzquierdo;

    public Cuatriciclo(String idVehiculo, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoMoto, String tipoTraccion, int estadoBateria, boolean estadoPintura, String otroFaltante, boolean espejoDerecho, boolean espejoIzquierdo) {
        super(idVehiculo, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoMoto, tipoTraccion);
        this.estadoBateria = estadoBateria;
        this.estadoPintura = estadoPintura;
        this.otroFaltante = otroFaltante;
        this.espejoDerecho = espejoDerecho;
        this.espejoIzquierdo = espejoIzquierdo;
    }

    public int getEstadoBateria() {
        return estadoBateria;
    }

    public void setEstadoBateria(int estadoBateria) {
        this.estadoBateria = estadoBateria;
    }

    public boolean getEstadoPintura() {
        return estadoPintura;
    }

    public void setEstadoPintura(boolean estadoPintura) {
        this.estadoPintura = estadoPintura;
    }

    public String getOtroFaltante() {
        return otroFaltante;
    }

    public void setOtroFaltante(String otroFaltante) {
        this.otroFaltante = otroFaltante;
    }

    public boolean getEspejoDerecho() {
        return espejoDerecho;
    }

    public void setEspejoDerecho(boolean espejoDerecho) {
        this.espejoDerecho = espejoDerecho;
    }

    public boolean getEspejoIzquierdo() {
        return espejoIzquierdo;
    }

    public void setEspejoIzquierdo(boolean espejoIzquierdo) {
        this.espejoIzquierdo = espejoIzquierdo;
    }
}
