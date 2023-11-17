package interfaces.permisos;

public interface VehiculoUsado {
    long duracionService = 90;
    long revisionMotorAltaCC = 110000;
    long revisionMotorBajaCC = 70000;
    long serviceKMAltaCC = 5000;
    long serviceKMBajaCC = 2000;
    int bajaCilindrada = 300;
    public void tieneDeuda();
    public void impedimientoJudicial();
    public void esDeudor();
    public String pesaImpedimientoJud(String impJud);
    public String estadoVehiculo();



}
