import java.util.PriorityQueue;
import java.util.Random;

public class Sistema {

    public final int numero_servidores = 2;
    private int ocupabilidad;
    private int reloj;
    private int tamano_cola;
    private int numero_salidas;

    private PriorityQueue<Evento> lista_eventos;
    private Evento evento;

    //Para los eventos
    private static final int evento_entrada = 0;
    private static final int evento_salida = 1;

    //Para la practica uno
    private double numsRandom[];
    private int pos;

    public Sistema(){
        ocupabilidad = 0;
        reloj = 0;
        tamano_cola = 0;
        numero_salidas = 0;
        lista_eventos = new PriorityQueue<Evento>();
        lista_eventos.add(new Evento(0,10,reloj));

        numsRandom = new double[100];
        pos = 0;
        setNumsRandom();
    }

    public void run()
    {
        while (numero_salidas<15)
        {
            procesar_evento();
        }
    }

    public void procesar_entrada(){
        if (ocupabilidad == numero_servidores){
            tamano_cola++;
        } else{
            ocupabilidad++;
            //generar_salida();
            generar_evento(evento_salida);
        }
        //generar_entrada();
        generar_evento(evento_entrada);
    }

    public void procesar_salida(){
        if (tamano_cola > 0){
            tamano_cola--;
            //generar_salida();
            generar_evento(evento_salida);
        } else{
            ocupabilidad--;
        }
        //para contar el numero de salidas
        numero_salidas++;
    }

    public void procesar_evento(){
        Evento temporal;
        if(lista_eventos.isEmpty()) {
            System.out.println("La lista de eventos esta vacia");
        }else{
            temporal = lista_eventos.poll();
            reloj = temporal.getHora();
            if(temporal.getTipo()==evento_entrada){
                procesar_entrada();
                System.out.println("Se procesa entrada con reloj:"+reloj);
            }else{
                procesar_salida();
                System.out.println("Se procesa Salida con reloj:"+reloj);
            }
        }
    }


    /**
     * Crea evento y los guarda en la lista de eventos
     * @param tipo 0 sí es entrada y 1 para salidas
     */
    public void generar_evento(int tipo){
        double random = obtener_numero_azar();
        evento = new Evento(tipo,random,reloj);
        //lista_eventos.add(evento);
        lista_eventos.offer(evento);
    }

    public double obtener_numero_azar(){
        //return Math.random();
        return numsRandom[pos++];

    }

    public void imprimirLista()
    {
        Evento temporal=null;
        if(!lista_eventos.isEmpty())
            temporal = lista_eventos.poll();
        while(temporal!=null){
            if(temporal.getTipo()==0)
                System.out.println("\n\nTipo de evento: Entrada");
            else
                System.out.println("\n\nTipo de evento: Salida");
            System.out.println("Tiempo: "+temporal.getHora());
            temporal=lista_eventos.poll();
        }
    }

    public void setNumsRandom()
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
