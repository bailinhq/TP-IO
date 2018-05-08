import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        //Se lee el número de clientes que quiere procesar
        Scanner reader = new Scanner(System.in);
        int numero_Clientes = 0;
        System.out.println("Introduzca el número de clientes que desea procesar");
        numero_Clientes = reader.nextInt();


        char seguir='S'; //Booleano para comprobar la repetición de la simulación

        Sistema sistema;
        while(seguir=='S') {
            sistema = new Sistema();
            //Iniciar la simulación

            //Imprimir encabezado para los datos
            System.out.print(" ___________________________________________________________________________________" +
                    "\n|#Cliente\t|\tTipoEvento\t|\tTiempoReloj\t|\tServidoresOcupados\t|\tLargoCola\t|\n" +
                    "|___________________________________________________________________________________|\n" );

            while (sistema.getNumero_salidas() < numero_Clientes) {
                sistema.simular_sistema();
            }

            //Mostrar las estadísticas
            sistema.generarEstadisticas();

            System.out.println("\n\n¿Desea repetir la simulación (El mismo número de clientes)?\n [S/N]");
            seguir = Character.toUpperCase(reader.next().charAt(0));
        }
    }
}
