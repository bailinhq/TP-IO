import java.util.Random;

public class Main {
    public static void main(String[] args){
        Sistema sistema = new Sistema();
        for (int i = 0; i < 100; i++){
            sistema.simular_sistema();
        }
    }
}
