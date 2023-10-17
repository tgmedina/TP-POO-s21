import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static ArrayList<Stock> listaStock = new ArrayList<Stock>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Bienvenido al Sistema de Gestion de Stock \n");
        int f;

        do {
            System.out.printf("Ingrese el numero correspondiente de las siguientes opciones (Presione 0 para finalizar\n): ");
            System.out.printf("Opcion 1: Alta Unidad/es\n");
            System.out.printf("Opcion 2: Buscar vehiculo por ID\n");
            System.out.printf("Opcion 3: Eliminar Unidad\n");
            System.out.printf("Opcion 4: Modificar datos de las unidades\n");
            System.out.printf("Opcion 5: Obtener detalles de una unidad\n");
            System.out.printf("Opcion 6: Control de Stock por ID / nombre de vehiculo / por Moto / Por cuatriciclo\n");
            while (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un numero, intente de nuevo por favor: ");
                sc.next();
            }

            f = sc.nextInt();
            sc.nextLine();
            switch (f) {
                case 1:
                    //metodo de alta de unidades
                    altaVehiculo();
                    break;
                case 2:
                    //Clase de Busqueda de unidad por ID
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Saliendo del sistema \n Muchas gracias por elegirnos");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                default:
                    System.out.println("Ingreso una opción no validad, intente de nuevo por favor: ");
                    break;
            }


        } while (f != 0);

    }

    public static void altaVehiculo() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Indique si la/s unidad/es es/son 0KM(n) o usada/s(u): \n");
        String nuevoUsado = sc.next().toLowerCase();
        while (nuevoUsado != "n" && nuevoUsado != "u") ;
        {
            System.out.println("Ingreso una opción invalida. \n Ingrese 'n' si la unidad es nueva, o 'u' si es usada: \n");
            nuevoUsado = sc.next().toLowerCase();
        }

        System.out.println("Indique si es/son moto/s (m) o cuatriciclo/s(c): ");
        String cuatriMoto = sc.next().toLowerCase();
        while (cuatriMoto != "m" && cuatriMoto != "c") {
            System.out.println("Ingreso una opción inválida, intente de nuevo: ");
            cuatriMoto = sc.next().toLowerCase();
        }
        System.out.println("Ingrese marca: ");
        String marca = sc.nextLine();
        System.out.println("Ingrese modelo: ");
        String modelo = sc.nextLine();
        /*El cui se obtiene de los primeros 3 caracteres de la marca, los primeros 3 caracteres del modelo, los 3
        caracteres del color y el año.
         */
        String cui = "";
        if (marca.length() >= 3) {
            cui = marca.substring(0, 3);
        } else if (marca.length() == 2) {
            cui = marca.substring(0, 2);
        } else if (marca.length() == 1) {
            cui = marca.substring(0, 1);
        }
        if (modelo.length() >= 3) {
            cui = cui + modelo.substring(0, 3);
        } else if (modelo.length() == 2) {
            cui = cui + modelo.substring(0, 2);
        } else if (modelo.length() == 1) {
            cui = cui + modelo.substring(0, 1);
        }
        System.out.println("Ingrese país de fabricación: ");
        String paisFabricacion = sc.nextLine();
        System.out.println("Ingrese color: ");
        String color = sc.nextLine();
        System.out.println("Ingrese año de Fabricación: ");
        long anioFabricacion = sc.nextLong();
        sc.nextLine();
        cui = cui + color + anioFabricacion;
        System.out.println("Ingrese cilindrada: ");
        int cilindrada = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese si el motor es dos(2) o cuatro(4) tiempos: ");
        int tipoMotor = sc.nextInt();
        System.out.println("Ingrese tipo de refrigeración: ");
        String tipoRefrigeracion = sc.nextLine();
        System.out.println("Ingrese capacidad del tanque de combustible: ");
        int tanque = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el tipo de freno de la rueda delantera: ");
        String frenoDelantero = sc.nextLine();
        System.out.println("Ingrese el tipo de freno de la rueda trasera: ");
        String frenoTrasero = sc.nextLine();
        System.out.println("Ingrese tipo de rodado: ");
        String tipoRueda = sc.nextLine();
        boolean esATV = false;
        String tipoTraccion = "N/C";
        if (cuatriMoto == "c") {
            System.out.println("Ingrese tipo de tracción (traccion doble o cuatro por cuatro): ");
            tipoTraccion = sc.nextLine();
            System.out.println("Ingrese 's' si es todo terreno, o 'n' si no lo es: ");
            String todoTerreno = sc.nextLine().toLowerCase();
            while (todoTerreno != "s" && todoTerreno != "n") {
                System.out.println("Ingreso una opción inválida, intente de nuevo: ");
                todoTerreno = sc.next().toLowerCase();
            }
            if (todoTerreno == "s") {
                esATV = true;
            }
        }
        if (cuatriMoto == "m") {
            if (nuevoUsado == "n") {
                System.out.println("Indique cuantas unidades quiere dar de alta: ");
                int cantidadAlta = sc.nextInt();
                sc.nextLine();
                for (Stock hayStock : listaStock) {
                    if (hayStock.getCui() != cui) {
                        Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color, cui);
                        listaStock.add(stock);
                    } else {
                        for (int i = 1; i == cantidadAlta; i++) {
                            Moto moto = new Moto(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda);
                            hayStock.getStock().add(moto);
                        }
                    }
                }
            } else { //usados
                Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color, cui);
                listaStock.add(stock);
            }
        } else {
            if (nuevoUsado == "n") {
                System.out.println("Indique cuantas unidades quiere dar de alta: ");
                int cantidadAlta = sc.nextInt();
                sc.nextLine();
                for (Stock hayStock : listaStock) {
                    if (hayStock.getCui() != cui) {
                        Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color, cui);
                        listaStock.add(stock);
                    } else {
                        for (int i = 1; i == cantidadAlta; i++) {
                            Cuatriciclo cuatriciclo = new Cuatriciclo(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV);
                            hayStock.getStock().add(cuatriciclo);
                        }
                    }
                }
            } else { //usados
                if (cuatriMoto == "m") {
                    System.out.println("Describa el estado del espejo derecho: ");
                    String espejoDerecho = sc.nextLine();
                    System.out.println("Describa el estado del espejo izquierdo: ");
                    String espejoIzquierdo = sc.nextLine();
                    System.out.println("Ingrese, del 1 al 100, el estado de la bateria: ");
                    int estadoBateria = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese, del 1 al 100, el estado de la pintura: ");
                    int estadoPintura = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Describa otros detalles: ");
                    String otrosDetalles = sc.nextLine();
                    MotoUsada moto = new MotoUsada(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
                    Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + moto.getIdVehiculo(), cui);
                    stock.getStock().add(moto);

                } else {
                    System.out.println("Describa el estado del espejo derecho: ");
                    String espejoDerecho = sc.nextLine();
                    System.out.println("Describa el estado del espejo izquierdo: ");
                    String espejoIzquierdo = sc.nextLine();
                    System.out.println("Ingrese, del 1 al 100, el estado de la bateria: ");
                    int estadoBateria = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese, del 1 al 100, el estado de la pintura: ");
                    int estadoPintura = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Describa otros detalles: ");
                    String otrosDetalles = sc.nextLine();
                    CuatricicloUsado cuatriciclo  = new CuatricicloUsado(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
                    Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + cuatriciclo.getIdVehiculo(), cui);
                    stock.getStock().add(cuatriciclo);
                }
            }
        }
    }
}