import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static ArrayList<Stock> listaStock = new ArrayList<Stock>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.printf("Bienvenido al Sistema de Gestion de Stock\n");
        int f;
        do {
            System.out.printf("Ingrese el numero correspondiente de las siguientes opciones (Presione 0 para finalizar):\n");
            System.out.printf("Opcion 1: Alta Unidad/es\n");
            System.out.printf("Opcion 2: Buscar vehiculo por marca y modelo\n");
            System.out.printf("Opcion 3: Listado de vehiculos usados/nuevos\n");
            System.out.printf("Opcion 4: Eliminar Unidad\n");
            System.out.printf("Opcion 5: Modificar datos de las unidades\n");
            System.out.printf("Opcion 6: Obtener detalles de una unidad\n");
            System.out.printf("Opcion 7: Control de Stock por CUI de vehiculo\nOpción: ");
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
                    //metodo de Busqueda de unidad por cui
                    busquedaCui();
                    break;
                case 3:
                    listadoDeVehiculos();
                    break;
                case 4:
                    eliminarUnidad();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
        for (Stock stock : listaStock) {
            ArrayList<Vehiculo> vehiculos = stock.getStock();
            System.out.println(stock.getCui());
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo.getIdVehiculo() + vehiculo.getFrenoDelantero());
            }
        }
        sc.close();
    }

    public static void altaVehiculo() {

        System.out.println("\nIndique si la/s unidad/es es/son 0KM(n) o usada/s(u):\n");
        String nuevoUsado = sc.nextLine().toLowerCase();
        while (!nuevoUsado.equals("n") && !nuevoUsado.equals("u")) {
            System.out.println("\nIngreso una opción invalida.\nIngrese 'n' si la unidad es nueva, o 'u' si es usada: \n");
            nuevoUsado = sc.nextLine().toLowerCase();
        }
        System.out.println("Indique si es/son moto/s (m) o cuatriciclo/s(c):\n");
        String cuatriMoto = sc.nextLine().toLowerCase();
        while (!cuatriMoto.equals("m") && !cuatriMoto.equals("c")) {
            System.out.println("\nIngreso una opción inválida, intente de nuevo:\n");
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
            System.out.println("Ingrese tipo de tracción (traccion doble o cuatro por cuatro): ");
            tipoTraccion = sc.nextLine();
            System.out.println("Ingrese 's' si es todo terreno, o 'n' si no lo es: ");
            String todoTerreno = sc.nextLine().toLowerCase();
            while (!todoTerreno.equals("s") && !todoTerreno.equals("n")) {
                System.out.println("Ingreso una opción inválida, intente de nuevo: ");
                todoTerreno = sc.next().toLowerCase();
            }
            if (todoTerreno.equals("s")) {
                esATV = true;
            }
        }
        if (nuevoUsado.equals("n")) { //Caso Moto Nueva
            if (cuatriMoto.equals("m")) {
                System.out.println("Indique cuantas unidades quiere dar de alta: ");
                int cantidadAlta = sc.nextInt();
                sc.nextLine();
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
            } else { // Caso Cuatri Nueva
                System.out.println("Indique cuantas unidades quiere dar de alta: ");
                int cantidadAlta = sc.nextInt();
                sc.nextLine();
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
        } else {//usados
            if (cuatriMoto.equals("m")) { //Motos Usadas
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
                moto.setCui(moto.getCui() + (String.valueOf(moto.getIdVehiculo()).substring(0, 3)));
                Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + moto.getIdVehiculo(), cui);
                stock.getStock().add(moto);

                listaStock.add(stock);

            } else { //Cuatri Usada
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
                CuatricicloUsado cuatriciclo = new CuatricicloUsado(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, espejoDerecho, espejoIzquierdo, estadoBateria, estadoPintura, otrosDetalles);
                cuatriciclo.setCui(cuatriciclo.getCui() + (String.valueOf(cuatriciclo.getIdVehiculo()).substring(0, 3)));
                Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + cuatriciclo.getIdVehiculo(), cui);
                stock.getStock().add(cuatriciclo);
                listaStock.add(stock);
            }
        }
    }

    private static void busquedaCui() {

        ArrayList<Vehiculo> listaCui = new ArrayList<Vehiculo>();
        long anioFabricacion = 0;
        String cuiBusqueda = "";
        System.out.println("Ingrese la marca del vehiculo que desea encontrar: ");
        String marca = sc.nextLine();
        System.out.println("Ingrese el modelo del vehiculo: ");
        String modelo = sc.nextLine();
        System.out.println("Ingrese el color, o deje en blanco si no quiere ingresar:");
        String color = sc.nextLine();
        System.out.println("Ingrese año de fabricacion, o deje en blanco si no quiere ingresar:");
        anioFabricacion = sc.nextLong();
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
        for (Stock stock : listaStock) {
            ArrayList<Vehiculo> vehiculos = stock.getStock();
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getCui().contains(cuiBusqueda)) {
                    listaCui.add(vehiculo);
                }
            }
        }
        System.out.println("A continuacion se presentaran los resultados:");
        System.out.println("ID Veh\t\tCUI\t\tMarca\tModelo\tAño Fab\tNac\tColor\tcc");
        for (Vehiculo vehiculo : listaCui) {
            System.out.println(vehiculo.getIdVehiculo() + "\t\t" + vehiculo.getCui() + "\t\t" + vehiculo.getMarca() + "\t" + vehiculo.getModelo() + "\t" + vehiculo.getAnioFabricacion() + "\t" + vehiculo.getPaisFabricacion() + "\t" + vehiculo.getColor() + "\t" + vehiculo.getCilindrada());
        }
    }

    public static void listadoDeVehiculos() {
        ArrayList<Stock> listaVehiculos = new ArrayList<Stock>();
        System.out.println("Ingrese 'n' (0 KM) o 'u' (usados) para desplegar sus correspondientes listas:");
        String nuevoUsado = sc.nextLine();
        if (nuevoUsado.equals("n")) {
            for (Stock stock : listaStock) {
                for (Vehiculo vehiculo : stock.getStock()) {
                    if (vehiculo instanceof Moto || vehiculo instanceof Cuatriciclo) {
                        listaVehiculos.add(stock);
                    }
                }
            }

        } else if (nuevoUsado.equals("u")) {
            for (Stock stock : listaStock) {
                for (Vehiculo vehiculo : stock.getStock()) {
                    if (vehiculo instanceof MotoUsada || vehiculo instanceof CuatricicloUsado) {
                        listaVehiculos.add(stock);
                    }
                }
            }
        } else {
            System.out.println("Ingreso una opción invalida, vuelva a intentar");
        }

        if (!listaVehiculos.isEmpty()) {
            System.out.println(" |   CUI     |    Marca    |    Modelo    |  Cilindrada  |  Color  |  Año Fab |   Id Vehiculo   |");
            System.out.println(" --------------------------------------------------------------------------| ");
            for (Stock vehiculo : listaVehiculos) {
                ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
                for (Vehiculo unVehiculo : vehiculo.getStock()) {
                    System.out.println(" |" + unVehiculo.getCui() + "    |" + unVehiculo.getMarca() + "    |" + unVehiculo.getModelo() + "    |" + unVehiculo.getCilindrada() + "    |" + unVehiculo.getColor() + "    |" + unVehiculo.getAnioFabricacion() + "    |" + unVehiculo.getIdVehiculo());
                }
            }
        }
    }

    private static void eliminarUnidad() {
        ArrayList<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();
        System.out.println("¿Desea eliminar una unidad 0KM (n) o usada (u)?");
        String nuevoUsado = sc.nextLine();
        if (nuevoUsado.equals("n")) {
            System.out.println("Ingrese el CUI de la unidad que quiere eliminar");
            String cuiAEliminar = sc.nextLine();
            System.out.println("Ingrese la cantidad que desea eliminar:");
            int cantidadAEliminar = sc.nextInt();
            sc.nextLine();
            Iterator<Stock> recorredor = listaStock.iterator();
            boolean hayUnidad = false;
            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();

                int cantVehiculo = stock.getStock().size();
                if (cuiAEliminar.equals(stock.getCui())) {
                    if (cantVehiculo > cantidadAEliminar) {
                        for (int i = 0; i < cantidadAEliminar; i++) {
                            stock.getStock().remove(stock.getStock().size() - 1);
                        }
                    } else if (cantVehiculo == cantidadAEliminar) {
                        stock.getStock().clear();
                        recorredor.remove();
                    } else {
                        System.out.println("La cantidad de elemenos a eliminar supera el Stock");
                    }
                    hayUnidad = true;
                    break;
                }
                if(!hayUnidad){
                    System.out.println("La unidad que esta buscando no existe o es erronea, intente de nuevo");
                }
            }
        } else if (nuevoUsado.equals("u")) {
            System.out.println("Ingrese el CUI de la unidad que quiere eliminar");
            String cuiAEliminarUsado = sc.nextLine();
            System.out.println("Ingrese el Id del vehiculo que desea eliminar");
            long idVaEliminar = sc.nextLong();
            boolean hayUnidad = false;
            sc.nextLine();
            Iterator<Stock> recorredor = listaStock.iterator();
            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();
                for (Vehiculo vehiculo : stock.getStock()) {
                    if (vehiculo.getIdVehiculo() == idVaEliminar) {
                        stock.getStock().clear();
                        recorredor.remove();
                        hayUnidad = true;
                        break;
                    }
                }
            }
            if(!hayUnidad){
                System.out.println("La unidad que esta buscando no existe o es erronea, intente de nuevo");
            }
        } else {
            System.out.println("Ingreso una opción invalida, vuelva a intentar");
        }

    }
}


