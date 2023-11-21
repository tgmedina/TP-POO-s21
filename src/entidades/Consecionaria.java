package entidades;

import entidades.service.Service;
import entidades.stock.Stock;
import entidades.vehiculo.*;
import interfaces.permisos.VehiculoUsado;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Consecionaria {
    private ArrayList<Stock> listaStock = new ArrayList<Stock>();
    private ArrayList<Service> listaService = new ArrayList<Service>();

    public void altaMoto(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, int cantidadAlta) {
        boolean existeStock = false;
        for (Stock hayStock : listaStock) {
            if (hayStock.getCui().equals(cui)) {
                for (int i = 1; i <= cantidadAlta; i++) {
                    Moto moto = new Moto(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda);
                    hayStock.getStock().add(moto);
                    moto.setIdVehiculo(moto.getIdVehiculo() + i);
                }
                existeStock = true;
                break;
            }
        }
        if (!existeStock) {
            Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color, cui);
            for (int i = 1; i <= cantidadAlta; i++) {
                Moto moto = new Moto(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda);
                moto.setIdVehiculo(moto.getIdVehiculo() + i);
                stock.getStock().add(moto);
            }
            listaStock.add(stock);
        }
    }

    public void altaCuatriciclo(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoTraccion, Boolean esATV, int cantidadAlta) {
        boolean existeStock = false;
        for (Stock hayStock : listaStock) {
            if (hayStock.getCui().equals(cui)) {
                for (int i = 1; i <= cantidadAlta; i++) {
                    Cuatriciclo cuatriciclo = new Cuatriciclo(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV);
                    hayStock.getStock().add(cuatriciclo);
                    cuatriciclo.setIdVehiculo(cuatriciclo.getIdVehiculo() + i);
                }
                existeStock = true;
                break;
            }
        }
        if (!existeStock) {
            Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color, cui);
            for (int i = 1; i <= cantidadAlta; i++) {
                Cuatriciclo cuatriciclo = new Cuatriciclo(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV);
                cuatriciclo.setIdVehiculo(cuatriciclo.getIdVehiculo() + i);
                stock.getStock().add(cuatriciclo);
            }
            listaStock.add(stock);
        }
    }

    public void altaMotoUsada(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles, long kilometraje) {
        MotoUsada moto = new MotoUsada(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles, kilometraje);
        Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + moto.getIdVehiculo(), moto.getCui());
        stock.getStock().add(moto);
        listaStock.add(stock);
    }

    public void altaCuatricicloUsado(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoTraccion, Boolean esATV, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles, long kilometraje) {
        CuatricicloUsado cuatriciclo = new CuatricicloUsado(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles, kilometraje);
        Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + cuatriciclo.getIdVehiculo(), cuatriciclo.getCui());
        stock.getStock().add(cuatriciclo);
        listaStock.add(stock);
    }

    public String busquedaCui(String cuiBusqueda) {
        ArrayList<Vehiculo> listaCui = new ArrayList<Vehiculo>();
        for (Stock stock : listaStock) {
            ArrayList<Vehiculo> vehiculos = stock.getStock();
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getCui().contains(cuiBusqueda)) {
                    listaCui.add(vehiculo);
                }
            }
        }
        if (!listaCui.isEmpty()) {
            StringBuilder listaAString = new StringBuilder();
            listaAString.append("|");
            for (Vehiculo vehiculo : listaCui) {
                listaAString.append(String.format(
                        "%-15d|%-15s|%-15s|%-15s|%-10d|%-10s|%-10s|%-5d|%n",
                        vehiculo.getIdVehiculo(),
                        vehiculo.getCui(),
                        vehiculo.getMarca(),
                        vehiculo.getModelo(),
                        vehiculo.getAnioFabricacion(),
                        vehiculo.getPaisFabricacion(),
                        vehiculo.getColor(),
                        vehiculo.getCilindrada()));

            }
            return listaAString.toString();
        } else {
            return "No se encontro vehiculos con esas coincidencias";
        }
    }

    public String listadoDeVehiculo(String nuevoUsado) {
        ArrayList<Stock> listaVehiculos = new ArrayList<Stock>();
        StringBuilder listaAString = new StringBuilder();
        if (nuevoUsado.equals("n")) {
            for (Stock stock : listaStock) {

                for (Vehiculo vehiculo : stock.getStock()) {
                    if (vehiculo instanceof Moto || vehiculo instanceof Cuatriciclo) {
                        listaVehiculos.add(stock);
                        break;
                    }
                }
            }
        } else if (nuevoUsado.equals("u")) {
            for (Stock stock : listaStock) {
                for (Vehiculo vehiculo : stock.getStock()) {
                    if (vehiculo instanceof MotoUsada || vehiculo instanceof CuatricicloUsado) {
                        listaVehiculos.add(stock);
                        break;
                    }
                }
            }
        } /*else {
            System.out.println("Ingreso una opción invalida, vuelva a intentar");
        }*/

        if (!listaVehiculos.isEmpty()) {
            listaAString.append(String.format("|%-15s|%-10s|%-15s|%-15s|%-10s|%-10s|%-15s|%n", "CUI", "Marca", "Modelo", "Cilindrada", "Color", "Año Fab", "Id Vehiculo"));
            listaAString.append("|------------------------------------------------------------------------------------------------|\n");
            Iterator<Stock> recorredor = listaVehiculos.iterator();
            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();
                for (Vehiculo unVehiculo : stock.getStock()) {
                    listaAString.append(String.format(
                                    "|%-15s|%-10s|%-15s|%-15d|%-10s|%-10d|%-15d|\n",
                                    unVehiculo.getCui(),
                                    unVehiculo.getMarca(),
                                    unVehiculo.getModelo(),
                                    unVehiculo.getCilindrada(),
                                    unVehiculo.getColor(),
                                    unVehiculo.getAnioFabricacion(),
                                    unVehiculo.getIdVehiculo()
                            )
                    );

                }
            }
            return listaAString.toString();

        }
        return "Ingreso una opción invalida, vuelva a intentar";
    }

    public String eliminarUnidadNueva(String cuiAEliminar, int cantidadAEliminar) {
        Iterator<Stock> recorredor = listaStock.iterator();
        boolean hayUnidad = false;
        while (recorredor.hasNext()) {
            Stock stock = recorredor.next();

            int cantVehiculo = stock.getStock().size();
            if (cuiAEliminar.equals(stock.getCui())) {
                if (cantVehiculo > cantidadAEliminar) {
                    for (int i = 0; i < cantidadAEliminar; i++) {
                        stock.eliminarVehiculo();
                        /*stock.getStock().remove(stock.getStock().size() - 1);*/
                    }
                } else if (cantVehiculo == cantidadAEliminar) {
                    stock.eliminarTodoVehiculo();
                    recorredor.remove();
                } else {
                    return "La cantidad de elemenos a eliminar supera el Stock, intente de nuevo";
                }
                hayUnidad = true;
                break;
            }

        }
        if (!hayUnidad) {
            return "La unidad que esta buscando no existe o es erronea, intente de nuevo";
        } else {
            return "Se elimino/eliminaron la/s unidade/s solicitada/s satifactoriamente";
        }
    }

    public String eliminarUnidadUsada(String cuiAEliminar) {
        boolean hayUnidad = false;
        Iterator<Stock> recorredor = listaStock.iterator();
        while (recorredor.hasNext()) {
            Stock stock = recorredor.next();
            for (Vehiculo vehiculo : stock.getStock()) {
                if (vehiculo.getCui().equals(cuiAEliminar)) {
                    stock.eliminarTodoVehiculo();
                    recorredor.remove();
                    hayUnidad = true;
                    break;
                }
            }
        }
        if (!hayUnidad) {
            return "La unidad que esta buscando no existe o es erronea, intente de nuevo";
        }
        return "Se elimino la unidad solicitada satifactoriamente";
    }

    public String modificarVehiculo(String cuiAModificar, String tipoRefrigeracion, int cilindrada, int tipoMotor, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, boolean esATV, int estadoBateria, int estadoPintura, String otroDetalle, String espejoDerecho, String espejoIzquierdo, String tipoTraccion, String paisFabricacion) {
        Iterator<Stock> recorredor = listaStock.iterator();
        boolean hayVehiculo = false;
        while (recorredor.hasNext()) {
            Stock stock = recorredor.next();
            Iterator<Vehiculo> recorreVehiculo = stock.getStock().iterator();
            if (stock.getCui().equals(cuiAModificar)) {
                while (recorreVehiculo.hasNext()) {
                    Vehiculo vehiculo = recorreVehiculo.next();
                    vehiculo.modificaUnVehiculo(tipoRefrigeracion, cilindrada, tipoMotor, tanque, frenoDelantero, frenoTrasero, tipoRueda, esATV, estadoBateria, estadoPintura, otroDetalle, espejoDerecho, espejoIzquierdo, tipoTraccion, paisFabricacion);
                }
                hayVehiculo = true;
                break;
            }

        }
        if (hayVehiculo) return "La modificacion se llevo con exito";
        else return "No se encontro vehiculo, intente de nuevo";
    }

    public String detallesVehiculos(String cuiADetallar) {
        Iterator<Stock> recorredor = listaStock.iterator();

        StringBuilder listaAString = new StringBuilder();
        listaAString.append("---------------Datos de la unidad---------------");
        listaAString.append("\n------------------------------------------------");
        while (recorredor.hasNext()) {
            Stock stock = recorredor.next();
            if (stock.getCui().equals(cuiADetallar)) {
                Vehiculo unVehiculo = stock.getStock().getFirst();
                listaAString.append(unVehiculo.detalleUnVehiculo());
                return listaAString.toString();
            }

        }
        return "Se ingreso un CUI inexistente";
    }

    public String estadoVehiculo() {
        Iterator<Stock> iterador = listaStock.iterator();
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        StringBuilder listaAString = new StringBuilder();

        while (iterador.hasNext()) {
            Stock stock = iterador.next();
            if (stock.getStock().getFirst() instanceof MotoUsada || stock.getStock().getFirst() instanceof CuatricicloUsado) {
                listaVehiculos.add(stock.getStock().getFirst());
            }

        }
        if (!listaVehiculos.isEmpty()) {
            listaAString.append(String.format("|%-15s|%-30s|%n", "CUI", "Estado de Vehiculo"));
            listaAString.append("|---------------------------------------------|\n");
            Iterator<Vehiculo> iteradorVehiculo = listaVehiculos.iterator();
            while (iteradorVehiculo.hasNext()) {
                Vehiculo unVehiculo = iteradorVehiculo.next();
                if (unVehiculo instanceof VehiculoUsado) {
                    VehiculoUsado vehiculoUsado = (VehiculoUsado) unVehiculo;
                    listaAString.append(String.format(
                            "|%-15s|%-30s|%n",
                            unVehiculo.getCui(),
                            vehiculoUsado.estadoVehiculo()
                    ));
                }
            }
            return listaAString.toString();
        }
        return "no se encontro el vehiculo ingresado";
    }
    public String serviceVehiculo (String cuiDeService,int f, String fechaService, String tipoAceite, String marcaAceite, boolean ajusteCarroceria, boolean ajusteCadena, boolean cambioTramision, String otrosDetalles, long kilometrajePrueba){
        Iterator<Stock> recorredor = listaStock.iterator();
        boolean hayVehiculo = false;
        VehiculoUsado vehiculo = null;


        while (recorredor.hasNext()){
            Stock stock = recorredor.next();
            if(stock.getCui().equals(cuiDeService)){
                vehiculo = (VehiculoUsado) stock.getStock().getFirst();
                hayVehiculo=true;
            }
        }
        if(f==2) {
            vehiculo.checkMotor();
        }
        vehiculo.ServiceVehiculo(fechaService, kilometrajePrueba);
        if(hayVehiculo) {
            Service unService = new Service(vehiculo.getUltimoService(),
                    vehiculo.getCui(),
                    tipoAceite,
                    marcaAceite,
                    ajusteCarroceria,
                    ajusteCadena,
                    cambioTramision,
                    otrosDetalles,
                    vehiculo.getKilometraje(),
                    vehiculo.getKilometraje() + kilometrajePrueba);
            listaService.add(unService);
            return "El service se creo con exito";
        }
        return "No se encontro vehiculo, intente de nuevo";
    }

}
