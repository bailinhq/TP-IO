import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numero_Clientes = 0;

        System.out.println("Introduzca el número de clientes que desea procesar");
        numero_Clientes = reader.nextInt();

        System.out.print(" _______________________________________________" );
        System.out.println("\n|#Cliente\t|\tTipoEvento\t|\tTiempoReloj\t\t|");
        System.out.println("|_______________________________________________|" );

        Sistema sistema = new Sistema();
        while ( sistema.getNumero_salidas()< 15) {
            sistema.simular_sistema();
        }

        System.out.println("\n\n _______________________________________________" );
        System.out.println("|                  Estadísticas                 |");
        System.out.println("|_______________________________________________|" );

        System.out.println("|1) El numero de clientes en el sistema es "+ sistema.getTamano_cola() +
                "\t|\n|                                               |" +
                "\n|2) El tiempo promedio en cola es de " +sistema.getTiempoCola() + "\t\t|");
        System.out.println("|_______________________________________________|" );
    }
}
