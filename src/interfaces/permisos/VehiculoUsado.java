package interfaces.permisos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface VehiculoUsado {
    long duracionService = 90;
    long revisionMotorAltaCC = 110000;
    long revisionMotorBajaCC = 70000;
    long serviceKMAltaCC = 5000;
    long serviceKMBajaCC = 2000;
    int bajaCilindrada = 300;

    long getUltimoServiceKM();

    long getKilometraje();

    int getCilindrada();
    LocalDate getUltimoService();
    String getCui();
    long getUltimoCheckMotor();


    public void tieneDeuda();
    public void impedimientoJudicial();
    public void esDeudor();
    public String pesaImpedimientoJud(String impJud);



    default String estadoVehiculo(){
        StringBuilder sb = new StringBuilder();
        LocalDate hoy = LocalDate.now();
        boolean flag = false; //Bandera que indica si el vehiculo cumplio con las condiciones propuesta en el metodo, y permite el return correspondiente en el ultimo if
        if (this.getCilindrada() >= bajaCilindrada) {
            try {
                if (ChronoUnit.DAYS.between(hoy, this.getUltimoService()) >= duracionService || (this.getKilometraje() - this.getUltimoServiceKM()) >= serviceKMAltaCC)
                    sb.append("Service: vencido | ");
                else sb.append("Service: OK | ");
            } catch (NullPointerException e) {
                sb.append("Service: vencido | ");
            }
            if (this.getKilometraje() >= revisionMotorAltaCC && (this.getKilometraje()-this.getUltimoCheckMotor())>=revisionMotorAltaCC) sb.append(" Motor: Check");
            else sb.append(" Motor: OK");

        } else if (this.getCilindrada() < bajaCilindrada) {
            try {
                if (ChronoUnit.DAYS.between(hoy, this.getUltimoService()) >= duracionService || (this.getKilometraje() - this.getUltimoServiceKM()) >= serviceKMBajaCC)
                    sb.append("Service: vencido | ");
                else sb.append("Service: OK | ");
            } catch (NullPointerException e) {
                sb.append("Service: vencido | ");
            }
            if (this.getKilometraje() >= revisionMotorBajaCC && (this.getKilometraje()-this.getUltimoCheckMotor())>=revisionMotorAltaCC) sb.append("Motor: Check");
            else sb.append(" Motor: OK");
        }

        return sb.toString();
    }
    public void ServiceVehiculo(String fechaService, long kilometrajePrueba);
    public void checkMotor();


}
