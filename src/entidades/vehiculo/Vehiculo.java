package entidades.vehiculo;

import java.time.Instant;

public abstract class Vehiculo {
    private String cui; //Codigo Unico de Inventario
    private long idVehiculo = Instant.now().toEpochMilli();
    private String marca;
    private String modelo;
    private String paisFabricacion;
    private String color;
    private int cilindrada;
    private long anioFabricacion;
    private int tipoMotor;
    private String tipoRefrigeracion;
    private int tanque;
    private String frenoDelantero;
    private String frenoTrasero;

    public Vehiculo(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda) {
        this.cui = cui;
        this.marca = marca;
        this.modelo = modelo;
        this.paisFabricacion = paisFabricacion;
        this.color = color;
        this.cilindrada = cilindrada;
        this.anioFabricacion = anioFabricacion;
        this.tipoMotor = tipoMotor;
        this.tipoRefrigeracion = tipoRefrigeracion;
        this.tanque = tanque;
        this.frenoDelantero = frenoDelantero;
        this.frenoTrasero = frenoTrasero;
        this.tipoRueda = tipoRueda;
    }

    private String tipoRueda;

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public long getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(long anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(int tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getTipoRefrigeracion() {
        return tipoRefrigeracion;
    }

    public void setTipoRefrigeracion(String tipoRefrigeracion) {
        this.tipoRefrigeracion = tipoRefrigeracion;
    }

    public int getTanque() {
        return tanque;
    }

    public void setTanque(int tanque) {
        this.tanque = tanque;
    }

    public String getFrenoDelantero() {
        return frenoDelantero;
    }

    public void setFrenoDelantero(String frenoDelantero) {
        this.frenoDelantero = frenoDelantero;
    }

    public String getFrenoTrasero() {
        return frenoTrasero;
    }

    public void setFrenoTrasero(String frenoTrasero) {
        this.frenoTrasero = frenoTrasero;
    }

    public String getTipoRueda() {
        return tipoRueda;
    }

    public void setTipoRueda(String tipoRueda) {
        this.tipoRueda = tipoRueda;
    }

    public long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void modificaUnVehiculo(String tipoRefrigeracion, int cilindrada, int tipoMotor, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, boolean esATV, int estadoBateria, int estadoPintura, String otroDetalle, String espejoDerecho, String espejoIzquierdo, String tipoTraccion, String paisFabricacion) {
        if (!paisFabricacion.isEmpty()) this.paisFabricacion = paisFabricacion;
        if (cilindrada > 0) this.cilindrada = cilindrada;
        if (tipoMotor > 0) this.tipoMotor = tipoMotor;
        if (!tipoRefrigeracion.isEmpty()) this.tipoRefrigeracion = tipoRefrigeracion;
        if (tanque > 0) this.tanque = tanque;
        if (!frenoDelantero.isEmpty()) this.frenoDelantero = frenoDelantero;
        if (!frenoTrasero.isEmpty()) this.frenoTrasero = frenoTrasero;
        if (!tipoRueda.isEmpty()) this.tipoRueda = tipoRueda;
    }

    public String detalleUnVehiculo() {
        return String.format("%n"+
                "|%-15s|%-32s|%n" +
                        "|%-15s|%-32d|%n" +
                        "|%-15s|%-32s|%n" +
                        "|%-15s|%-32s|%n" +//modelo
                        "|%-15s|%-32s|%n" +//pais
                        "|%-15s|%-32d|%n" +//anio
                        "|%-15s|%-32s|%n" +//color
                        "|%-15s|%-32d|%n" +//cc
                        "|%-15s|%-2d-%30s|%n" +//tipoMotor
                        "|%-15s|%-32s|%n" +//tipoRef
                        "|%-15s|%-32d|%n" +//Tanque
                        "|%-15s|%-32s|%n" +
                        "|%-15s|%-32s|%n",
                "CUI", this.cui,
                "ID Vehiculo", this.idVehiculo,
                "Marca", this.marca,
                "Modelo", this.modelo,
                "Nacionalidad", this.paisFabricacion,
                "Año. Fab.", this.anioFabricacion,
                "Color", this.color,
                "Cilindrada", this.cilindrada,
                "Tipo Motor", this.tipoMotor, "Tiempos",
                "Tipo Ref.", this.tipoRefrigeracion,
                "Cap. Tanque", this.tanque,
                "Freno Del.", this.frenoDelantero,
                "Freno Tras.", this.frenoTrasero
                );
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "cui='" + cui + '\'' +
                ", idVehiculo=" + idVehiculo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", paisFabricacion='" + paisFabricacion + '\'' +
                ", color='" + color + '\'' +
                ", cilindrada=" + cilindrada +
                ", anioFabricacion=" + anioFabricacion +
                ", tipoMotor=" + tipoMotor +
                ", tipoRefrigeracion='" + tipoRefrigeracion + '\'' +
                ", tanque=" + tanque +
                ", frenoDelantero='" + frenoDelantero + '\'' +
                ", frenoTrasero='" + frenoTrasero + '\'' +
                ", tipoRueda='" + tipoRueda + '\'' +
                '}';
    }
}

