import java.util.ArrayList;
import java.util.List;

public class Stock<t extends Vehiculo> {
    private String nombreUnidad;
    private String idVehiculo;
    private List<t> listaVehiculo = new ArrayList<t>();

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Stock(String nombreUnidad, List<t> listaVehiculo, String idVehiculo) {
        this.nombreUnidad = nombreUnidad;
        this.listaVehiculo = listaVehiculo;
        this.idVehiculo = idVehiculo;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public List<t> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<t> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    
}
