import entidades.Consecionaria;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private static Consecionaria consecionaria = new Consecionaria();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.printf("Bienvenido al Sistema de Gestion de entidades.stock.Stock\n");
        int f;
        do {
            System.out.printf("\nIngrese el numero correspondiente de las siguientes opciones (Presione 0 para finalizar):\n");
            System.out.printf("Opcion 1: Alta Unidad/es\n");
            System.out.printf("Opcion 2: Buscar vehiculo por marca y modelo\n");
            System.out.printf("Opcion 3: Listado de vehiculos usados/nuevos\n");
            System.out.printf("Opcion 4: Eliminar Unidad\n");
            System.out.printf("Opcion 5: Modificar datos de las unidades vacias\n");
            System.out.printf("Opcion 6: Obtener detalles de una unidad\nOpción:");

            while (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un numero, intente de nuevo por favor: ");
                sc.next();
            }
            f = sc.nextInt();
            sc.nextLine();
            switch (f) {
                case 1:
                    altaVehiculo();
                    break;
                case 2:
                    busquedaCui();
                    break;
                case 3:
                    listadoDeVehiculos();
                    break;
                case 4:
                    eliminarUnidad();
                    break;
                case 5:
                    modificarVehiculo();
                    break;
                case 6:
                    detallesVehiculos();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema\nMuchas gracias por elegirnos");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                default:
                    System.out.println("Ingreso una opción no validad, intente de nuevo por favor:");
                    break;
            }
        } while (f != 0);
        sc.close();
    }

    public static void altaVehiculo() {

        System.out.println("\nIndique si la/s unidad/es es/son 0KM(n) o usada/s(u):");
        String nuevoUsado = sc.nextLine().toLowerCase();
        while (!nuevoUsado.equals("n") && !nuevoUsado.equals("u")) {
            System.out.println("Ingreso una opción invalida.\nIngrese 'n' si la unidad es nueva, o 'u' si es usada:");
            nuevoUsado = sc.nextLine().toLowerCase();
        }
        System.out.println("Indique si es/son moto/s (m) o cuatriciclo/s(c):");
        String cuatriMoto = sc.nextLine().toLowerCase();
        while (!cuatriMoto.equals("m") && !cuatriMoto.equals("c")) {
            System.out.println("Ingreso una opción inválida, intente de nuevo:");
            cuatriMoto = sc.nextLine().toLowerCase();
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
        sc.nextLine();
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
        if (cuatriMoto.equals("c")) {
            System.out.println("Ingrese tipo de tracción (traccion doble o cuatro por cuatro):");
            tipoTraccion = sc.nextLine();
            System.out.println("Ingrese 's' si es todo terreno, o 'n' si no lo es:");
            String todoTerreno = sc.nextLine().toLowerCase();
            while (!todoTerreno.equals("s") && !todoTerreno.equals("n")) {
                System.out.println("Ingreso una opción inválida, intente de nuevo:");
                todoTerreno = sc.next().toLowerCase();
            }
            if (todoTerreno.equals("s")) {
                esATV = true;
            }
        }
        if (nuevoUsado.equals("n")) {
            System.out.println("Indique la cantidad de unidades que quiere dar de alta:");
            int cantidadAlta = sc.nextInt();
            sc.nextLine();
            if (cuatriMoto.equals("m")) {
                consecionaria.altaMoto(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, cantidadAlta);
            } else {
                consecionaria.altaCuatriciclo(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, cantidadAlta);
            }
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
            if (cuatriMoto.equals("m")) {
                consecionaria.altaMotoUsada(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
            } else {
                consecionaria.altaCuatricicloUsado(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
            }
        }
    }

    private static void busquedaCui() {
        long anioFabricacion = 0;
        String cuiBusqueda = "";
        System.out.println("\nIngrese la marca del vehiculo que desea encontrar: ");
        String marca = sc.nextLine();
        System.out.println("Ingrese el modelo del vehiculo: ");
        String modelo = sc.nextLine();
        System.out.println("Ingrese el color, o deje en blanco si no quiere ingresar:");
        String color = sc.nextLine();
        System.out.println("Ingrese año de fabricacion, o deje en blanco si no quiere ingresar:");
        if (sc.hasNextLong()) {
            anioFabricacion = sc.nextLong();
        }
        if (marca.length() >= 3) {
            cuiBusqueda = marca.substring(0, 3);
        } else if (marca.length() == 2) {
            cuiBusqueda = marca.substring(0, 2);
        } else if (marca.length() == 1) {
            cuiBusqueda = marca.substring(0, 1);
        }
        if (modelo.length() >= 3) {
            cuiBusqueda = cuiBusqueda + modelo.substring(0, 3);
        } else if (modelo.length() == 2) {
            cuiBusqueda = cuiBusqueda + modelo.substring(0, 2);
        } else if (modelo.length() == 1) {
            cuiBusqueda = cuiBusqueda + modelo.substring(0, 1);
        }
        if (!color.isEmpty()) {
            cuiBusqueda = cuiBusqueda + color;
        }
        if (anioFabricacion != 0) {
            cuiBusqueda = cuiBusqueda + anioFabricacion;
        }
        System.out.println(consecionaria.busquedaCui(cuiBusqueda));
    }

    public static void listadoDeVehiculos() {
        System.out.println("Ingrese 'n' (0 KM) o 'u' (usados) para desplegar sus correspondientes listas:");
        String nuevoUsado = sc.nextLine();
        System.out.println(consecionaria.listadoDeVehiculo(nuevoUsado));
    }

    private static void eliminarUnidad() {
        System.out.println("¿Desea eliminar una unidad 0KM (n) o usada (u)?");
        String nuevoUsado = sc.nextLine();
        int cantidadAEliminar = 0; //Para los vehiculos usados, si hay que eliminarlos, se elimina directamente la unidad, ya que hay un solo objeto Vehiculo por cada objeto Stock
        if (nuevoUsado.equals("n")) {
            System.out.println("Ingrese el CUI de la unidad que quiere eliminar");
            String cuiAEliminar = sc.nextLine();
            System.out.println("Ingrese la cantidad que desea eliminar:");
            cantidadAEliminar = sc.nextInt();
            sc.nextLine();
            System.out.printf(consecionaria.eliminarUnidadNueva(cuiAEliminar, cantidadAEliminar));
        } else if (nuevoUsado.equals("u")) {
            System.out.println("Ingrese el Id del vehiculo que desea eliminar");
            String cuiAEliminar = sc.nextLine();
            System.out.println(consecionaria.eliminarUnidadUsada(cuiAEliminar));
        } else {
            System.out.println("Ingreso una opción invalida, vuelva a intentar");
        }
    }

    private static void modificarVehiculo() {
        System.out.println("¿Desea modificar un vehiculo (n)uevo o (u)sado?");
        String nuevoUsado = sc.nextLine();
        System.out.println("Ingrese si es (m)oto o (c)uatriciclo");
        String esCuatriciclo = sc.nextLine();
        System.out.println("Ingrese el CUI de la unidad a modificar:");
        String cuiAModificar = sc.nextLine();
        String tipoRefrigeracion = "";
        int cilindrada = 0;
        int tipoMotor = 0;
        int tanque = 0;
        String frenoDelantero = "";
        String frenoTrasero = "";
        String tipoRueda = "";
        boolean esATV = false;
        int estadoBateria = 0;
        int estadoPintura = 0;
        String otroDetalle = "";
        String espejoDerecho = "";
        String espejoIzquierdo = "";
        String tipoTraccion = "";
        String paisFabricacion = "";
        System.out.println("ADVERTENCIA: Si no quiere agregar datos nuevos, deje en blanco\nLos datos anteriores seran reemplazados y no se podrán recuperar");

        System.out.println("Ingrese país de fabricación: ");
        paisFabricacion = sc.nextLine();
        System.out.println("Ingrese cilindrada: ");

        if (sc.hasNextInt()) {
            try {
                cilindrada = sc.nextInt();
            } catch (InputMismatchException e) {

            }
        }
        sc.nextLine();
        System.out.println("Ingrese si el motor es dos(2) o cuatro(4) tiempos: ");
        if (sc.hasNextInt()) {
            try {
                tipoMotor = sc.nextInt();
            } catch (InputMismatchException e) {

            }
        }
        sc.nextLine();
        System.out.println("Ingrese tipo de refrigeración: ");
        tipoRefrigeracion = sc.nextLine();
        System.out.println("Ingrese capacidad del tanque de combustible: ");
        if (sc.hasNextInt()) {
            try {
                tanque = sc.nextInt();
            } catch (InputMismatchException e) {
            }
        }
        sc.nextLine();
        System.out.println("Ingrese el tipo de freno de la rueda delantera: ");
        frenoDelantero = sc.nextLine();
        System.out.println("Ingrese el tipo de freno de la rueda trasera: ");
        frenoTrasero = sc.nextLine();
        System.out.println("Ingrese tipo de rodado: ");
        tipoRueda = sc.nextLine();
        if (esCuatriciclo.equals("c")) {
            System.out.println("Ingrese tipo de tracción (traccion doble o cuatro por cuatro):");
            tipoTraccion = sc.nextLine();
            System.out.println("Ingrese 's' si es todo terreno, o 'n' si no lo es:");
            String todoTerreno = sc.nextLine().toLowerCase();
            while (!todoTerreno.equals("s") && !todoTerreno.equals("n")) {
                System.out.println("Ingreso una opción inválida, intente de nuevo:");
                todoTerreno = sc.next().toLowerCase();
            }
            if (todoTerreno.equals("s")) {
                esATV = true;
            }
        }
        if (nuevoUsado.equals("u")) {
            System.out.println("Ingrese el estado del espejo derecho");
            espejoDerecho = sc.nextLine();
            System.out.println("Ingrese el estado del espejo izquierdo");
            espejoIzquierdo = sc.nextLine();
            System.out.println("Ingrese del 0-100 el estado de la bateria");
            if (sc.hasNextInt()) {
                try {
                    estadoBateria = sc.nextInt();
                } catch (InputMismatchException e) {

                }

            }
            sc.nextLine();
            System.out.println("Ingrese del 0-100 el estado de la pintura");
            if (sc.hasNextInt()) {
                try {
                    estadoPintura = sc.nextInt();
                } catch (InputMismatchException e) {
                }
            }
            sc.nextLine();
            System.out.println("Ingrese otros detalles");
            otroDetalle = sc.nextLine();
        }
        System.out.println(consecionaria.modificarVehiculo(cuiAModificar, tipoRefrigeracion, cilindrada, tipoMotor, tanque, frenoDelantero, frenoTrasero, tipoRueda, esATV, estadoBateria, estadoPintura, otroDetalle, espejoDerecho, espejoIzquierdo, tipoTraccion, paisFabricacion));
    }

    private static void detallesVehiculos() {
        System.out.println("Ingrese el CUI del vehiculo que desea ver los detalles");
        String cuiADetallar = sc.nextLine();
        System.out.println(consecionaria.detallesVehiculos(cuiADetallar));
    }
}


