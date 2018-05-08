import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        //Se lee el número de clientes que quiere procesar
        Scanner reader = new Scanner(System.in);
        int numero_Clientes = 0;
        System.out.println("Introduzca el número de clientes que desea procesar");
        numero_Clientes = reader.nextInt();

        //Imprimir encabezado para los datos
        System.out.print(" ___________________________________________________________________________________" +
                         "\n|#Cliente\t|\tTipoEvento\t|\tTiempoReloj\t|\tServidoresOcupados\t|\tLargoCola\t|\n" +
                         "|___________________________________________________________________________________|\n" );

        char seguir='S'; //Booleano para comprobar la repetición de la simulación

        Sistema sistema = new Sistema();
        while(seguir=='S') {

            //Iniciar la simulación
            while (sistema.getNumero_salidas() < 15) {
                sistema.simular_sistema();
            }

            //Mostrar las estadísticas
            sistema.generarEstadisticas();

            System.out.println("\n\n¿Desea repetir la simulación?\n [S/N]");
            seguir = Character.toUpperCase(reader.next().charAt(0));
        }
    }
}
