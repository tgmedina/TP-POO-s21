import entidades.Consecionaria;
import entidades.stock.Stock;
import entidades.vehiculo.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
    private static ArrayList<Stock> listaStock = new ArrayList<Stock>();
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
        if(nuevoUsado.equals("n")){
            System.out.println("Indique la cantidad de unidades que quiere dar de alta:");
            int cantidadAlta=sc.nextInt();
            sc.nextLine();
            if(cuatriMoto.equals("m")){
                consecionaria.altaMoto(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, cantidadAlta);
            }
            else{
                consecionaria.altaCuatriciclo(cui, marca, modelo, paisFabricacion, color, cilindrada, anioFabricacion, tipoMotor, tipoRefrigeracion, tanque, frenoDelantero, frenoTrasero, tipoRueda, tipoTraccion, esATV, cantidadAlta);
            }
        }
        /*if (nuevoUsado.equals("n")) { //Caso entidades.vehiculo.Moto Nueva
            if (cuatriMoto.equals("m")) {
                System.out.println("Indique cuantas unidades quiere dar de alta:");
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
                System.out.println("Indique cuantas unidades quiere dar de alta:");
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
                moto.setCui(moto.getCui() + (String.valueOf(moto.getIdVehiculo()).substring(String.valueOf(moto.getCui()).length() - 2)));
                Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + moto.getIdVehiculo(), moto.getCui());
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
                cuatriciclo.setCui(cuatriciclo.getCui() + (String.valueOf(cuatriciclo.getIdVehiculo()).substring(String.valueOf(cuatriciclo.getIdVehiculo()).length()-2)));
                Stock stock = new Stock(marca + " " + modelo + " " + anioFabricacion + " " + color + cuatriciclo.getIdVehiculo(), cuatriciclo.getCui());
                stock.getStock().add(cuatriciclo);
                listaStock.add(stock);
                System.out.println("");
            }
        }*/
    }

    private static void busquedaCui() {

        ArrayList<Vehiculo> listaCui = new ArrayList<Vehiculo>();
        long anioFabricacion = 0;
        String cuiBusqueda = "";
        System.out.println("\nIngrese la marca del vehiculo que desea encontrar: ");
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

        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-10s|%-10s|%-10s|%-5s|%n", "Id Veh", "CUI", "Marca", "Modelo", "Año Fab.", "Nac", "Color", "CC");
        System.out.println("|------------------------------------------------------------------------------------------------------| ");
        for (Vehiculo vehiculo : listaCui) {
            System.out.printf("|%-15d|%-15s|%-15s|%-15s|%-10d|%-10s|%-10s|%-5d|%n", vehiculo.getIdVehiculo(), vehiculo.getCui(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnioFabricacion(), vehiculo.getPaisFabricacion(), vehiculo.getColor(), vehiculo.getCilindrada());
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
        } else {
            System.out.println("Ingreso una opción invalida, vuelva a intentar");
        }

        if (!listaVehiculos.isEmpty()) {
            System.out.printf("|%-15s|%-10s|%-15s|%-15s|%-10s|%-10s|%-15s|%n", "CUI", "Marca", "Modelo", "Cilindrada", "Color", "Año Fab", "Id entidades.vehiculo.Vehiculo");
            System.out.println("|------------------------------------------------------------------------------------------------| ");
            Iterator<Stock> recorredor = listaVehiculos.iterator();
            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();
                for (Vehiculo unVehiculo : stock.getStock()) {
                    System.out.printf("|%-15s|%-10s|%-15s|%-15d|%-10s|%-10d|%-15d|%n", unVehiculo.getCui(), unVehiculo.getMarca(), unVehiculo.getModelo(), unVehiculo.getCilindrada(), unVehiculo.getColor(), unVehiculo.getAnioFabricacion(), unVehiculo.getIdVehiculo());
//                    System.out.println(unVehiculo.listadoDeVehiculos());
                }
            }

        }
    }

    private static void eliminarUnidad() {
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
                        System.out.println("La cantidad de elemenos a eliminar supera el entidades.stock.Stock");
                    }
                    hayUnidad = true;
                    break;
                }
                if (!hayUnidad) {
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
            if (!hayUnidad) {
                System.out.println("La unidad que esta buscando no existe o es erronea, intente de nuevo");
            }
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
        int cilindrada = 0;
        int tipoMotor = 0;
        int tanque = 0;
        int estadoBateria = 0;
        int estadoPintura = 0;
        String otroDetalle = null;
        String espejoDerecho = null;
        String espejoIzquierdo = null;
        System.out.println("ADVERTENCIA: Si no quiere agregar datos nuevos, deje en blanco\nLos datos anteriores seran reemplazados y no se podrán recuperar");
        Iterator<Stock> recorredor = listaStock.iterator();
        System.out.println("Ingrese país de fabricación: ");
        String paisFabricacion = sc.nextLine();
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
        String tipoRefrigeracion = sc.nextLine();
        System.out.println("Ingrese capacidad del tanque de combustible: ");
        if (sc.hasNextInt()) {
            try {
                tanque = sc.nextInt();
            } catch (InputMismatchException e) {
            }
        }
        sc.nextLine();
        System.out.println("Ingrese el tipo de freno de la rueda delantera: ");
        String frenoDelantero = sc.nextLine();
        System.out.println("Ingrese el tipo de freno de la rueda trasera: ");
        String frenoTrasero = sc.nextLine();
        System.out.println("Ingrese tipo de rodado: ");
        String tipoRueda = sc.nextLine();
        boolean esATV = false;
        String tipoTraccion = "N/C";
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

        if (nuevoUsado.equals("n")) {
            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();
                Iterator<Vehiculo> recorreVehiculo = stock.getStock().iterator();
                if (stock.getCui().equals(cuiAModificar)) {
                    while (recorreVehiculo.hasNext()) {
                        Vehiculo vehiculo = recorreVehiculo.next();
                        if (!paisFabricacion.isEmpty()) {
                            vehiculo.setPaisFabricacion(paisFabricacion);
                        }
                        if (cilindrada > 0) {
                            vehiculo.setCilindrada(cilindrada);
                        }
                        if (tipoMotor > 0) {
                            vehiculo.setTipoMotor(tipoMotor);
                        }
                        if (!tipoRefrigeracion.isEmpty()) {
                            vehiculo.setTipoRefrigeracion(tipoRefrigeracion);
                        }
                        if (tanque > 0) {
                            vehiculo.setTanque(tanque);
                        }
                        if (!frenoDelantero.isEmpty()) {
                            vehiculo.setFrenoDelantero(frenoDelantero);
                        }
                        if (!frenoTrasero.isEmpty()) {
                            vehiculo.setFrenoTrasero(frenoTrasero);
                        }
                        if (!tipoRefrigeracion.isEmpty()) {
                            vehiculo.setTipoRueda(tipoRueda);
                        }
                        if (!tipoRueda.isEmpty()) {
                            vehiculo.setTipoRueda(tipoRueda);
                        }
                        if (vehiculo instanceof Cuatriciclo) {
                            //entidades.vehiculo.Cuatriciclo cuatriciclo = (entidades.vehiculo.Cuatriciclo) vehiculo;
                            if (!tipoTraccion.isEmpty()) {
                                ((Cuatriciclo) vehiculo).setTipoTraccion(tipoTraccion);
                                //cuatriciclo.setTipoTraccion(tipoTraccion);
                            }
                            ((Cuatriciclo) vehiculo).setEsATV(esATV);
                        }

                    }
                }
                break;
            }
        } else if (nuevoUsado.equals("u")) {
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

            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();
                Iterator<Vehiculo> recorreVehiculo = stock.getStock().iterator();
                if (stock.getCui().equals(cuiAModificar)) {
                    while (recorreVehiculo.hasNext()) {
                        Vehiculo vehiculo = recorreVehiculo.next();
                        if (!paisFabricacion.isEmpty()) {
                            vehiculo.setPaisFabricacion(paisFabricacion);
                        }
                        if (cilindrada > 0) {
                            vehiculo.setCilindrada(cilindrada);
                        }
                        if (tipoMotor > 0) {
                            vehiculo.setTipoMotor(tipoMotor);
                        }
                        if (!tipoRefrigeracion.isEmpty()) {
                            vehiculo.setTipoRefrigeracion(tipoRefrigeracion);
                        }
                        if (tanque > 0) {
                            vehiculo.setTanque(tanque);
                        }
                        if (!frenoDelantero.isEmpty()) {
                            vehiculo.setFrenoDelantero(frenoDelantero);
                        }
                        if (!frenoTrasero.isEmpty()) {
                            vehiculo.setFrenoTrasero(frenoTrasero);
                        }
                        if (!tipoRefrigeracion.isEmpty()) {
                            vehiculo.setTipoRueda(tipoRueda);
                        }
                        if (!tipoRueda.isEmpty()) {
                            vehiculo.setTipoRueda(tipoRueda);
                        }
                        if (vehiculo instanceof MotoUsada) {
                            //entidades.vehiculo.MotoUsada motoUsada = (entidades.vehiculo.MotoUsada) vehiculo;

                            if (!espejoDerecho.isEmpty()) {
                                ((MotoUsada) vehiculo).setEspejoDerecho(espejoDerecho);
                            }
                            if (!espejoIzquierdo.isEmpty()) {
                                ((MotoUsada) vehiculo).setEspejoIzquierdo(espejoIzquierdo);
                            }
                            if (estadoBateria > 0) {
                                ((MotoUsada) vehiculo).setEstadoBateria(estadoBateria);
                            }
                            if (estadoPintura > 0) {
                                ((MotoUsada) vehiculo).setEstadoPintura(estadoPintura);
                            }
                            if (!otroDetalle.isEmpty()) {
                                ((MotoUsada) vehiculo).setOtrosDetalles(otroDetalle);
                            }

                        } else if (vehiculo instanceof CuatricicloUsado) {
                            //entidades.vehiculo.CuatricicloUsado cuatricicloUsado = (entidades.vehiculo.CuatricicloUsado) vehiculo;
                            if (!espejoDerecho.isEmpty()) {
                                ((CuatricicloUsado) vehiculo).setEspejoDerecho(espejoDerecho);
                            }
                            if (!espejoIzquierdo.isEmpty()) {
                                ((CuatricicloUsado) vehiculo).setEspejoIzquierdo(espejoIzquierdo);
                            }
                            if (estadoBateria > 0) {
                                ((CuatricicloUsado) vehiculo).setEstadoBateria(estadoBateria);
                            }
                            if (estadoPintura > 0) {
                                ((CuatricicloUsado) vehiculo).setEstadoPintura(estadoPintura);

                            }
                            if (!tipoTraccion.isEmpty()) {
                                ((CuatricicloUsado) vehiculo).setTipoTraccion(tipoTraccion);
                            }
                            ((CuatricicloUsado) vehiculo).setEsATV(esATV);
                            if (!otroDetalle.isEmpty()) {
                                ((CuatricicloUsado) vehiculo).setOtrosDetalles(otroDetalle);
                            }
                        }

                    }
                }
                break;
            }
        }
    }

    private static void detallesVehiculos() {
        Iterator<Stock> recorredor = listaStock.iterator();
        System.out.println("Ingrese el CUI del vehiculo que desea ver los detalles");
        String cuiADetallar = sc.nextLine();
        boolean hayVehiculo = false;
        if (!cuiADetallar.isEmpty()) {
            while (recorredor.hasNext()) {
                Stock stock = recorredor.next();
                if (stock.getCui().equals(cuiADetallar)) {
                    Vehiculo unVehiculo = stock.getStock().getFirst();
                    System.out.println("---------------Datos de la unidad---------------");
                    System.out.println("------------------------------------------------");
                    System.out.printf("|%-15s|%-32s|%n", "CUI", unVehiculo.getCui());
                    System.out.printf("|%-15s|%-32d|%n", "ID entidades.vehiculo.Vehiculo", unVehiculo.getIdVehiculo());
                    System.out.printf("|%-15s|%-32s|%n", "Marca", unVehiculo.getMarca());
                    System.out.printf("|%-15s|%-32s|%n", "Modelo", unVehiculo.getModelo());
                    System.out.printf("|%-15s|%-32s|%n", "Nacionalidad", unVehiculo.getPaisFabricacion());
                    System.out.printf("|%-15s|%-32s|%n", "Año de Fab.", unVehiculo.getAnioFabricacion());
                    System.out.printf("|%-15s|%-32s|%n", "Color", unVehiculo.getColor());
                    System.out.printf("|%-15s|%-32d|%n", "Cilindrada", unVehiculo.getCilindrada());
                    System.out.printf("|%-15s|%-2d%-30s%n", "Tipo Motor", unVehiculo.getTipoMotor(), " tiempos");
                    System.out.printf("|%-15s|%-32s|%n", "Refrigeracion", unVehiculo.getTipoRefrigeracion());
                    System.out.printf("|%-15s|%-32d|%n", "Cap. Tanque", unVehiculo.getTanque());
                    System.out.printf("|%-15s|%-32s|%n", "Freno Del.", unVehiculo.getFrenoDelantero());
                    System.out.printf("|%-15s|%-32s|%n", "Freno Tra.", unVehiculo.getFrenoTrasero());
                    if (unVehiculo instanceof Cuatriciclo) {
                        System.out.printf("|%-15s|%-32s|%n", "Tipo Traccion", ((Cuatriciclo) unVehiculo).getTipoTraccion());
                        if (((Cuatriciclo) unVehiculo).getEsATV()) {
                            System.out.printf("|%-15s|%-32s|%n", "ATV", "Si");
                        } else {
                            System.out.printf("|%-15s|%-32s|%n", "ATV", "No");
                        }

                    }
                    if (unVehiculo instanceof MotoUsada) {
                        System.out.printf("|%-15s|%-32s|%n", "Espejo Der.", ((MotoUsada) unVehiculo).getEspejoDerecho());
                        System.out.printf("|%-15s|%-32s|%n", "Espejo Izq.", ((MotoUsada) unVehiculo).getEspejoIzquierdo());
                        System.out.printf("|%-15s|%-20d|%n", "Estado Bat.", ((MotoUsada) unVehiculo).getEstadoBateria());
                        System.out.printf("|%-15s|%-32d|%n", "Estado pint.", ((MotoUsada) unVehiculo).getEstadoPintura());
                        System.out.println("Otros Detalles--------------------------\n" + ((MotoUsada) unVehiculo).getOtrosDetalles());
                    }
                    if (unVehiculo instanceof CuatricicloUsado) {
                        System.out.printf("|%-15s|%-32s|%n", "Espejo Der.", ((CuatricicloUsado) unVehiculo).getEspejoDerecho());
                        System.out.printf("|%-15s|%-32s|%n", "Espejo Izq.", ((CuatricicloUsado) unVehiculo).getEspejoIzquierdo());
                        System.out.printf("|%-15s|%-32d|%n", "Estado Bat.", ((CuatricicloUsado) unVehiculo).getEstadoBateria());
                        System.out.printf("|%-15s|%-32d|%n", "Estado pint.", ((CuatricicloUsado) unVehiculo).getEstadoPintura());
                        System.out.printf("|%-15s|%-32s|%n", "Tipo Traccion", ((CuatricicloUsado) unVehiculo).getTipoTraccion());
                        if (((CuatricicloUsado) unVehiculo).getEsATV()) {
                            System.out.printf("|%-15s|%-32s|%n", "ATV", "Si");
                        } else {
                            System.out.printf("|%-15s|%-32s|%n", "ATV", "No");
                        }
                        System.out.println("Otros Detalles------------------------------------\n" + ((CuatricicloUsado) unVehiculo).getOtrosDetalles());
                        System.out.println("--------------------------------------------------");
                    }
                    hayVehiculo = true;
                }

            }
        } else {
            System.out.println("No ingreso CUI alguno. Intente de nuevo.");
        }
        if (!hayVehiculo) {
            System.out.println("No se encontro el CUI, intente de nuevo.");
        }
    }
}


