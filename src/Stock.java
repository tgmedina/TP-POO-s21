import java.util.ArrayList;

public class Stock {
    private String idStock;
    private ArrayList<Vehiculo> stock;
    private String descripcionVehiculo;

    public Stock(String idStock, ArrayList<Vehiculo> stock, String descripcionVehiculo) {
        this.idStock = idStock;
        this.stock = stock;
        this.descripcionVehiculo = descripcionVehiculo;
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
}
