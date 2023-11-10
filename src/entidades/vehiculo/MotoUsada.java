package entidades.vehiculo;

import entidades.vehiculo.Moto;
import interfaces.permisos.VehiculoUsado;

public class MotoUsada extends Moto implements VehiculoUsado {
    private String espejoDerecho;
    private String espejoIzquierdo;
    private int estadoBateria;
    private int estadoPintura;
    private String otrosDetalles;
    private boolean tieneDeuda = false;
    private boolean impedimentoJudicial = false;

    public MotoUsada(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles) {
        super(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda);
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

    @Override
    public void tieneDeuda() {

    }

    @Override
    public void impedimientoJudicial() {

    }

    @Override
    public void esDeudor() {

    }

    @Override
    public String pesaImpedimientoJud(String impJud) {
        if (impJud.equals("s")){
            impedimentoJudicial=true;
            return "Se actualizo estado de los impedimentos judiciales.";
        }
        else{
            return "No se especificó o no cuenta con impedimento judicial";
        }
    }


}
