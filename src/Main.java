import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        while (true) {
            sistema.simular_sistema();
            if (sistema.getNumero_salidas() == 15) {
                break;
            }
        }
    }
}
