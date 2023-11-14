package entidades.stock;

import entidades.vehiculo.Vehiculo;

import java.time.Instant;
import java.util.ArrayList;

public class Stock {
    private long idStock = Instant.now().toEpochMilli();
    private ArrayList<Vehiculo> stock = new ArrayList<Vehiculo>();
    private String descripcionVehiculo;
    private String cui;

    public Stock( String descripcionVehiculo, String cui) {
        this.descripcionVehiculo = descripcionVehiculo;
        this.cui = cui;
    }

    public long getIdStock() {
        return idStock;
    }

    public void setIdStock(long idStock) {
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

    public void eliminarVehiculo(){
        stock.remove(stock.size()-1);
    }
    public void eliminarTodoVehiculo(){
        stock.clear();
    }

    public void
}
