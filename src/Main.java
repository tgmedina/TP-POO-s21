import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Bienvenido al Sistema de Gestion de Stock \n");
        int f;
        String a;

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
                    //Clase de alta de unidades
                    System.out.println("Indique si la unidad es 0KM(n) o usada(u): \n");
                    a = sc.next().toLowerCase();
                    while(a != "n" && a !="u"); {
                        System.out.println("Ingreso una opción invalida. \n Ingrese 'n' si la unidad es nueva, o 'u' si es usada: \n");
                        a = sc.next().toLowerCase();
                    }

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
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    break;
                default:
                    System.out.println("Ingreso una opción no validad, intente de nuevo por favor: ");
                    break;
            }


        } while (f != 0);

    }
}