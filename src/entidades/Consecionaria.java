package entidades;

import entidades.stock.Stock;
import entidades.vehiculo.Cuatriciclo;
import entidades.vehiculo.CuatricicloUsado;
import entidades.vehiculo.Moto;
import entidades.vehiculo.MotoUsada;

import java.util.ArrayList;

public class Consecionaria {
    private ArrayList<Stock> listaStock = new ArrayList<Stock>();

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

    public void altaMotoUsada(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles) {
        MotoUsada moto = new MotoUsada(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
        moto.setCui(moto.getCui() + (String.valueOf(moto.getIdVehiculo()).substring(String.valueOf(moto.getCui()).length() - 2)));
        Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + moto.getIdVehiculo(), moto.getCui());
        stock.getStock().add(moto);
        listaStock.add(stock);
    }

    public void altaCuatricicloUsado(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoTraccion, Boolean esATV, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles) {
        CuatricicloUsado cuatriciclo = new CuatricicloUsado(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
//        cuatriciclo.setCui(cuatriciclo.getCui() + (String.valueOf(cuatriciclo.getIdVehiculo()).substring(String.valueOf(cuatriciclo.getIdVehiculo()).length() - 2)));
        Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + cuatriciclo.getIdVehiculo(), cuatriciclo.getCui());
        stock.getStock().add(cuatriciclo);
        listaStock.add(stock);
    }

}
