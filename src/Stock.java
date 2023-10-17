import java.time.Instant;
import java.util.ArrayList;

public class Stock {
    private String idStock = Instant.now().toEpochMilli();
    private ArrayList<Vehiculo> stock = new ArrayList<Vehiculo>();
    private String descripcionVehiculo;
    private String cui;

    public Stock( String descripcionVehiculo, String cui) {
        this.descripcionVehiculo = descripcionVehiculo;
        this.cui = cui;
    }

    public String getIdStock() {
        return idStock;
    }

    public void setIdStock(String idStock) {
        this.idStock = idStock;
    }

    public ArrayList<Vehiculo> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Vehiculo> stock) {
        this.stock = stock;
    }

    public String getDescripcionVehiculo() {
        return descripcionVehiculo;
    }

    public void setDescripcionVehiculo(String descripcionVehiculo) {
        this.descripcionVehiculo = descripcionVehiculo;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }
}
