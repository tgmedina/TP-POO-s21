package entidades.vehiculo;

import interfaces.permisos.VehiculoUsado;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CuatricicloUsado extends Cuatriciclo implements VehiculoUsado {
    private String espejoDerecho;
    private String espejoIzquierdo;
    private int estadoBateria;
    private int estadoPintura;
    private String otrosDetalles;
    protected boolean tieneDeuda = false;
    protected boolean impedimentoJudicial = false;
    private LocalDate ultimoService = null;
    private long ultimoServiceKM = 0;

    private long kilometraje;

    public CuatricicloUsado(String cui, String marca, String modelo, String paisFabricacion, String color, int cilindrada, long anioFabricacion, int tipoMotor, String tipoRefrigeracion, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, String tipoTraccion, Boolean esATV, String espejoDerecho, String espejoIzquierdo, int estadoBateria, int estadoPintura, String otrosDetalles, long kilometraje) {

        super(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV);
        this.setCui(this.getCui() + (String.valueOf(this.getIdVehiculo()).substring(String.valueOf(this.getIdVehiculo()).length() - 2)));
        this.espejoDerecho = espejoDerecho;
        this.espejoIzquierdo = espejoIzquierdo;
        this.estadoBateria = estadoBateria;
        this.estadoPintura = estadoPintura;
        this.otrosDetalles = otrosDetalles;
        this.kilometraje = kilometraje;

    }

    @Override
    public void modificaUnVehiculo(String tipoRefrigeracion, int cilindrada, int tipoMotor, int tanque, String frenoDelantero, String frenoTrasero, String tipoRueda, boolean esATV, int estadoBateria, int estadoPintura, String otroDetalle, String espejoDerecho, String espejoIzquierdo, String tipoTraccion, String paisFabricacion) {
        super.modificaUnVehiculo(tipoRefrigeracion, cilindrada, tipoMotor, tanque, frenoDelantero, frenoTrasero, tipoRueda, esATV, estadoBateria, estadoPintura, otroDetalle, espejoDerecho, espejoIzquierdo, tipoTraccion, paisFabricacion);
        if (!espejoDerecho.isEmpty()) this.espejoDerecho = espejoDerecho;
        if (!espejoIzquierdo.isEmpty()) this.espejoIzquierdo = espejoIzquierdo;
        if (estadoBateria > 0) this.estadoBateria = estadoBateria;
        if (estadoPintura > 0) this.estadoPintura = estadoPintura;
        if (!otroDetalle.isEmpty()) this.otrosDetalles = otroDetalle;
    }

    @Override
    public String detalleUnVehiculo() {
        String detalleCuatricicloUsado = String.format(
                "|%-15s|%-32s|%n" +
                        "|%-15s|%-32s|%n" +
                        "|%-15s|%-32d|%n" +
                        "|%-15s|%-32d|%n"+
                        "|%-15s|%-32d|%n",
                "Espejo Der.", this.espejoDerecho,
                "Espejo Izq.", this.espejoIzquierdo,
                "Estado Bat.", this.estadoBateria,
                "Estado pint.", this.estadoPintura,
                "Kilometraje", this.kilometraje
        );
        return super.detalleUnVehiculo() + detalleCuatricicloUsado + "Otros Detalles--------------------------\n" + this.otrosDetalles;
    }

    @Override
    public void tieneDeuda() {

    }

    @Override
    public void impedimientoJudicial() {

    }

    @Override
    public void esDeudor() {

    }

    public String pesaImpedimientoJud(String impJud) {
        if (impJud.equals("s")) {
            impedimentoJudicial = true;
            return "Se actualizo estado de los impedimentos judiciales.";
        } else {
            return "No se especificó o no cuenta con impedimento judicial";
        }

    }

    @Override
    public String estadoVehiculo() {
        StringBuilder sb = new StringBuilder();
        LocalDate hoy = LocalDate.now();
        if (this.getCilindrada()>=bajaCilindrada){
            if (ChronoUnit.DAYS.between(hoy, this.ultimoService) >= duracionService || (this.kilometraje-ultimoServiceKM)>=serviceKMAltaCC) sb.append("El vehiculo " + this.getCui()+ " tiene el Service vencido");
            if (this.kilometraje>=revisionMotorAltaCC) {
                sb.append("\nEl vehiculo " + this.getCui() + " tiene el Service vencido");
                return sb.toString();
            }
        }else{
            if (ChronoUnit.DAYS.between(hoy, this.ultimoService) >= duracionService || (this.kilometraje-ultimoServiceKM)>=serviceKMBajaCC) sb.append("El vehiculo " + this.getCui()+ " tiene el Service vencido");
            if (this.kilometraje>=revisionMotorBajaCC) {
                sb.append("\nEl vehiculo " + this.getCui() + " tiene el Service vencido");
                return sb.toString();
            }
        }

        return "El vehiculo " + this.getCui() + " se encuentra en buen estado";
    }
}