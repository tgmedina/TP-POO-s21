import java.util.HashMap;
import java.util.Scanner;

public class AltaVehiculo {
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
    private String tipoVehiculo;
    private String tipoTraccion;
    private int estadoBateria;
    private boolean estadoPintura;
    private String otroFaltante;
    private boolean espejoDerecho;
    private boolean espejoIzquierdo;
    private HashMap<String, Stock<Vehiculo>> stocks;

    public AltaVehiculo(){
        stocks = new HashMap<>();
    }

    public static altaVehiculo(String a){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese marca: ");
        marca = sc.nextLine();
        System.out.println("Ingrese modelo: ");
        modelo = sc.nextLine();

        if (marca.length()>=3){
            idVehiculo = marca.substring(0,3);
        } else if (marca.length()==2) {
            idVehiculo = marca.substring(0,2);
        } else if (marca.length()==1) {
            idVehiculo = marca.substring(0,1);
        }
        if (modelo.length()>=3){
            idVehiculo = idVehiculo + modelo.substring(0,3);
        } else if (modelo.length()==2) {
            idVehiculo = idVehiculo + modelo.substring(0,2);
        } else if (modelo.length()==1) {
            idVehiculo = idVehiculo + modelo.substring(0,1);
        }
        //Si existe una lista del mismo idVehiculo, cargar estos datos
        System.out.println("Ingrese el Pais de Fabricación: ");
        paisFabricacion = sc.nextLine();
        System.out.println("Ingrese el color: ");
        color = sc.nextLine();
        System.out.println("Ingrese la cilindrada: ");
        cilindrada = sc.nextInt();
        sc.next();
        System.out.println("Ingrese año de fabricación: ");
        anioFabricacion = sc.nextLong();
        sc.next();
        System.out.println("Ingrese tipo de motor (2)T o (4)T: ");
        tipoMotor = sc.nextInt();
        System.out.println("Ingrese de refrigeración: ");
        tipoRefrigeracion = sc.nextLine();
        System.out.println("Ingrese la capacidad del tanque (sin decimales): ");
        tanque = sc.nextInt();
        System.out.println("Ingrese el tipo de freno delantero: ");
        frenoDelantero = sc.nextLine();
        System.out.println("Ingrese el tipo de freno trasero: ");
        frenoTrasero = sc.nextLine();
        System.out.println("Ingrese el tipo de Rueda: ");
        tipoRueda = sc.nextLine();
        System.out.println("Ingrese el tipo de vehículo (Motos o Cuatriciclos: ");
        tipoVehiculo = sc.nextLine();
        //La siguiente linea la tengo que pegar en algun if que decida por cuatri
        System.out.println("Ingrese el tipo de tracción (4x4 o 2x2): ");
        tipoTraccion = sc.nextLine();




       /* if (a=="n"){
            idVehiculo = a + idVehiculo;
            Stock stock = stocks.get(idVehiculo);
            if (stock==null){
                Stock<VehiculoNuevo> stock = new Stock<>();

                stocks.put(idVehiculo, stock);


            }

        }*/
    }
}
