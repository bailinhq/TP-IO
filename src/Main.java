import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numero_Clientes = 0;

        System.out.println("Introduzca el número de clientes que desea procesar");
        //numero_Clientes = reader.nextInt();

        Sistema sistema = new Sistema();
        while ( sistema.getNumero_salidas()< 15) {
            sistema.simular_sistema();
        }
        System.out.println("El numero de clientes en el sistema es "+ sistema.getTamano_cola() + "\n" +
                "El tiempo promedio en cola es de " +sistema.getTiempoCola());
    }
}
