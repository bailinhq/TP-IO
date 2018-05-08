import java.util.PriorityQueue;
import java.util.Random;

public class Sistema2 {

    private final int numero_servidores = 2;
    private int ocupabilidad;
    private int reloj;
    private int tamano_cola;
    private double[] numsRandom;
    private PriorityQueue<Evento2> lista_eventos;
    private Evento2 evento_temporal;
    private Random random;
    private int numero_salidas;
    private int contador = 0;
    private Boolean terminalB = true;
    private int next_tiempo_disponible = 0;
    public Sistema2(){
        ocupabilidad = 0;
        reloj = 0;
        tamano_cola = 0;
        lista_eventos = new PriorityQueue<>();
        lista_eventos.add(new Evento2(0,0, false));
        numsRandom = new double[51];
        setNumsRandom();
        evento_temporal = new Evento2(0,0, false);
        random = new Random();
        numero_salidas = 0;
    }

    public void simular_sistema(){
        evento_temporal = lista_eventos.poll();
        String tipo_evento = "";
        String tipo_terminal = "";
        if(evento_temporal.getTipo() == 0){
            tipo_evento = "Entrada ";
        } else{
            tipo_evento = "Salida ";
        }
        if (evento_temporal.getTerminalB()){
            tipo_terminal = "B";
        } else{
            tipo_terminal = "A";
        }
        System.out.println(tipo_evento + "hora: " + evento_temporal.getHora() + " Terminal: " + tipo_terminal);
        reloj = evento_temporal.getHora();
        if (evento_temporal.getTipo() == 0){
            procesar_entrada();
        } else{
            procesar_salida();
        }

    }

    private void generar_salida(){
        //double valor_aleatorio = random.nextDouble();
        double valor_aleatorio = get_Random();
        //System.out.println(valor_aleatorio);
        int tiempo_agregado;
        int carguero;
        if (valor_aleatorio <= 0.40){
            carguero = 1;
        } else if (valor_aleatorio <= 0.75){
            carguero = 2;
        } else{
            carguero = 3;
        }
        if (reloj >= next_tiempo_disponible){ //terminal B
            terminalB = true;
            if (carguero ==1){
                tiempo_agregado = 3;
            } else if (carguero == 2){
                tiempo_agregado = 2;
            } else{
                tiempo_agregado =1;
            }
        } else{ //TERMINAL A
            terminalB = false;
            if (carguero ==1){
                tiempo_agregado = 4;
            } else if (carguero == 2){
                tiempo_agregado = 3;
            } else{
                tiempo_agregado =2;
            }

        }
        lista_eventos.offer(new Evento2(1,reloj + tiempo_agregado, terminalB));
        terminalB = false;
        next_tiempo_disponible = reloj + tiempo_agregado;
    }

    private void procesar_salida(){
        if (tamano_cola > 0){
            tamano_cola--;
            generar_salida();
        } else{
            ocupabilidad--;
        }
        numero_salidas++;
    }

    private void generar_entrada(){
        //double valor_aleatorio = random.nextDouble();
        double valor_aleatorio = get_Random();
        //System.out.println(valor_aleatorio);
        int tiempo_agregado;
        if (valor_aleatorio <= 0.20){
            tiempo_agregado = 1;
        } else if (valor_aleatorio <= 0.45) {
            tiempo_agregado = 2;
        } else if (valor_aleatorio <= 0.80) {
            tiempo_agregado = 3;
        } else if (valor_aleatorio <= 0.95){
            tiempo_agregado = 4;
        } else{
            tiempo_agregado = 5;
        }
        lista_eventos.offer(new Evento2(0,reloj + tiempo_agregado, false));
    }

    private void procesar_entrada(){
        if (ocupabilidad == numero_servidores){
            tamano_cola++;
        } else{
            generar_salida();
        }
        generar_entrada();
    }

    private double get_Random(){
        double x = numsRandom[contador];
        contador++;
        return x;
    }

    public int getNumero_salidas() {
        return numero_salidas;
    }

    private void setNumsRandom()
    {
        numsRandom[0]=0.4;
        numsRandom[1]=0.64;
        numsRandom[2]=0.00;
        numsRandom[3]=0.76;
        numsRandom[4]=0.29;
        numsRandom[5]=0.19;
        numsRandom[6]=0.37;
        numsRandom[7]=0.98;
        numsRandom[8]=0.62;
        numsRandom[9]=0.38;
        numsRandom[10]=0.24;
        numsRandom[11]=0.12;
        numsRandom[12]=0.29;
        numsRandom[13]=0.63;
        numsRandom[14]=0.77;
        numsRandom[15]=0.82;
        numsRandom[16]=0.01;
        numsRandom[17]=0.97;
        numsRandom[18]=0.75;
        numsRandom[19]=0.43;
        numsRandom[20]=0.91;
        numsRandom[21]=0.81;
        numsRandom[22]=0.28;
        numsRandom[23]=0.78;
        numsRandom[24]=0.77;
        numsRandom[25]=0.26;
        numsRandom[26]=0.42;
        numsRandom[27]=0.22;
        numsRandom[28]=0.45;
        numsRandom[29]=0.74;
        numsRandom[30]=0.35;
        numsRandom[31]=0.78;
        numsRandom[32]=0.03;
        numsRandom[33]=0.01;
        numsRandom[34]=0.67;
        numsRandom[35]=0.51;
        numsRandom[36]=0.99;
        numsRandom[37]=0.09;
        numsRandom[38]=0.60;
        numsRandom[39]=0.39;
        numsRandom[40]=0.62;
        numsRandom[41]=0.80;
        numsRandom[42]=0.94;
        numsRandom[43]=0.85;
        numsRandom[44]=0.67;
        numsRandom[45]=0.77;
        numsRandom[46]=0.33;
        numsRandom[47]=0.31;
        numsRandom[48]=0.59;
        numsRandom[49]=0.71;
        numsRandom[50]=0.01;
    }
}

