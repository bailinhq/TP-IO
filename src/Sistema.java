import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

class Sistema {
    //Variables estado
    private int ocupabilidad;
    private PriorityQueue<Evento> lista_eventos;

    //Variables de simulación
    private final int numero_servidores = 2;
    private int reloj;
    private int tamano_cola;
    private Evento evento_temporal;
    private Random random;

    //Variables estadísticas
    private int numero_salidas;
    private int numero_entradas;
    //private int[] tiempo_llegada_cola;
    //private int[] tiempo_salida_cola;
    private ArrayList<Integer> tiempo_llegada_cola;
    private ArrayList<Integer> tiempo_salida_cola;

    //Números aleatorios dados en clase
    private double[] numsRandom;
    private int contador = 0;

    Sistema(){
        ocupabilidad = 0;
        lista_eventos = new PriorityQueue<>();
        lista_eventos.add(new Evento(0,0));

        reloj = 0;
        tamano_cola = 0;
        numsRandom = new double[51];
        setNumsRandom();
        evento_temporal = new Evento(0,0);
        random = new Random();

        numero_salidas = 0;
        numero_entradas=0;
        //tiempo_llegada_cola = new int[19];
        //tiempo_salida_cola = new int[19];

        tiempo_llegada_cola = new ArrayList<>();
        tiempo_salida_cola = new ArrayList<>();

        tiempo_salida_cola.add(0);
    }

    int getNumero_salidas() {
        return numero_salidas;
    }

    int getTamano_cola(){ return  tamano_cola; }


    /**
     * Se encarga de procesar el evento personal según el tipo y por lo tanto cambia las variables de estado.
     */
    void simular_sistema()
    {
        //Obtener el evento
        evento_temporal = lista_eventos.poll();
        String tipo_evento;

        //Mostrar tipo de evento en pantalla
        if((evento_temporal != null ? evento_temporal.getTipo() : 0) == 0){
            tipo_evento = "|\t" + (numero_entradas +1) + "\t\t|\tEntrada";

        } else{
            tipo_evento = "|\t" +  (numero_salidas +1) + "\t\t|\tSalida ";
        }

        //Procesar el evento
        reloj = evento_temporal.getHora();
        if (evento_temporal.getTipo() == 0){
            procesar_entrada();
        } else{
            procesar_salida();
        }

        //Mostrar el estado del sistema después del evento
        System.out.println(tipo_evento + "\t\t|\t\t" + (evento_temporal != null ? evento_temporal.getHora() : 0) +"\t\t|"+
        "\t\t\t" + ocupabilidad + "\t\t\t|\t\t" + tamano_cola +"\t\t|");
        System.out.println("|___________________________________________________________________________________|" );

    }

    /**
     * Genera una salida, sumando al reloj los valores de la tabla dada en clase.
     */
    private void generar_salida()
    {
        double valor_aleatorio = get_Random();
        int tiempo_agregado;
        if (valor_aleatorio <= 0.10){
            tiempo_agregado = 2;
        } else if (valor_aleatorio <= 0.35){
            tiempo_agregado = 3;
        } else if (valor_aleatorio <= 0.75){
            tiempo_agregado = 4;
        } else if (valor_aleatorio <=0.95){
            tiempo_agregado = 7;
        } else{
            tiempo_agregado = 10;
        }
        lista_eventos.offer(new Evento(1,reloj + tiempo_agregado));
    }

    /**
     * Procesa la salida de una llamada.
     */
    private void procesar_salida()
    {
        //tiempo_salida_cola[++numero_salidas]=evento_temporal.getHora();
        numero_salidas++;
        tiempo_salida_cola.add(evento_temporal.getHora());
        if (tamano_cola > 0){
            tamano_cola--;
            generar_salida();
        } else{
            ocupabilidad--;
        }
    }

    /**
     * Genera una llegada, sumando al reloj los valores de la tabla dada en clase.
     */
    private void generar_entrada()
    {
        double valor_aleatorio = get_Random();
        int tiempo_agregado;
        if (valor_aleatorio <= 0.40){
            tiempo_agregado = 1;
        } else if (valor_aleatorio <= 0.75){
            tiempo_agregado = 2;
        } else{
            tiempo_agregado = 3;
        }
        lista_eventos.offer(new Evento(0,reloj + tiempo_agregado));
    }


    /**
     * Procesa la entrada de una llamada.
     */
    private void procesar_entrada()
    {
        if (ocupabilidad == numero_servidores){
            tamano_cola++;
            //tiempo_llegada_cola[numero_entradas++]=evento_temporal.getHora()*-1;
            tiempo_llegada_cola.add(evento_temporal.getHora()*-1);
        } else{
            //tiempo_llegada_cola[numero_entradas++]=0;
            tiempo_llegada_cola.add(0);
            ocupabilidad++;
            generar_salida();
        }
        generar_entrada();
    }

    /**
     * Permite obtener los números aleatorios
     * @return Retorna un número aleatorio generado en java
     */
    private double get_Random()
    {
        return numsRandom[contador++];
        //return Math.random();
    }

    /**
     *
     * @return Retorna el tiempo promedio de un cliente en cola (Wq)
     */
    /*private double getTiempoCola()
    {
        double sum = 0.0;
        for (int i = 1; i < numero_salidas; i++) {
            if(tiempo_llegada_cola[i]!=0)
                sum+=tiempo_llegada_cola[i]+tiempo_salida_cola[i-1];
        }
        return sum/numero_salidas;
    }*/
    private double getTiempoCola(){
        double sum = 0;
        for (int i = 1; i < numero_salidas; i++) {
            if(tiempo_llegada_cola.get(i)!=0)
                sum+= tiempo_llegada_cola.get(i) + tiempo_salida_cola.get(i-1);
        }
        return sum/numero_salidas;
    }
    /**
     * Utiliza las variables estadísticas para realizar los cálculos y los muestra en pantalla.
     */
    void generarEstadisticas()
    {
        System.out.println("\n\n _______________________________________________" );
        System.out.println("|                  Estadísticas                 |");
        System.out.println("|_______________________________________________|" );
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("|1) El numero de clientes en el sistema es "+ tamano_cola +
                "\t|\n|                                               |" +
                "\n|2) El tiempo promedio en cola es de " + df.format(getTiempoCola() )+"\t\t|");
        System.out.println("|_______________________________________________|" );
    }


    /**
     * Números aleatorios dados en clase
     */
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

