import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numero_Clientes = 0;

        System.out.println("Introduczca el número de clientes que desea procesar");
        numero_Clientes = reader.nextInt();

        Sistema sistema = new Sistema();
        while (true) {
            sistema.simular_sistema();
            if (sistema.getNumero_salidas() == 15) {
                break;
            }
        }
    }
}
