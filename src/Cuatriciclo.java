public class Cuatriciclo extends Vehiculo{

    private String tipoTraccion;
    private Boolean esATV;

    public Cuatriciclo(String idVehiculo, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoMoto, String tipoTraccion, String tipoTraccion1, Boolean esATV) {
        super(idVehiculo, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoMoto, tipoTraccion);
        this.tipoTraccion = tipoTraccion1;
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
}
