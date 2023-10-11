public abstract class Vehiculo {
    private String tipoVehiculo;
    private String idVehiculo;
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
    private String tipoRueda;
    private String tipoMoto;
    private String tipoTraccion="N/C";

    public Vehiculo(String idVehiculo, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoMoto, String tipoTraccion) {
        this.idVehiculo = idVehiculo;
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
        this.tipoMoto = tipoMoto;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
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

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    public String getTipoTraccion() {
        return tipoTraccion;
    }

    public void setTipoTraccion(String tipoTraccion) {
        this.tipoTraccion = tipoTraccion;
    }
}

