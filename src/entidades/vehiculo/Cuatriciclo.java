package entidades.vehiculo;

public class Cuatriciclo extends Vehiculo {

    private String tipoTraccion;
    private Boolean esATV;

    public Cuatriciclo(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoTraccion, Boolean esATV) {
        super(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda);
        this.tipoTraccion = tipoTraccion;
        this.esATV = esATV;
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

    @Override
    public void modificaUnVehiculo(String tipoRefrigeracion, int cilindrada, int tipoMotor, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, boolean esATV, int estadoBateria, int estadoPintura, String otroDetalle, String espejoDerecho, String espejoIzquierdo, String tipoTraccion, String paisFabricacion) {
        super.modificaUnVehiculo(tipoRefrigeracion, cilindrada, tipoMotor, tanque, frenoDelantero, frenoTrasero, tipoRueda, esATV, estadoBateria, estadoPintura, otroDetalle, espejoDerecho, espejoIzquierdo, tipoTraccion, paisFabricacion);
        if (!tipoTraccion.isEmpty()) this.tipoTraccion = tipoTraccion;
        this.esATV = esATV;
    }

    @Override
    public String detalleUnVehiculo() {

        String detalleCuatriciclo = "";
        if (this.esATV) {
            detalleCuatriciclo = String.format("|%-15s|%-32s|%n", "ATV", "Si");
        } else {
            detalleCuatriciclo = String.format("|%-15s|%-32s|%n", "ATV", "No");
        }

        detalleCuatriciclo = detalleCuatriciclo + String.format(
                "|%-15s|%-32s|%n", "Tipo Traccion", this.tipoTraccion
        );
        return super.detalleUnVehiculo() + detalleCuatriciclo;
    }
}