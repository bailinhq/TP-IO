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

    public Sistema(){
        ocupabilidad = 0;
        reloj = 0;
        tamano_cola = 0;
        numero_salidas = 0;
        lista_eventos = new PriorityQueue<Evento>();
        lista_eventos.add(new Evento(0,10,reloj));
    }

    public void run()
    {
        while (numero_salidas<=100)
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
            }else{
                procesar_salida();
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
        lista_eventos.add(evento);
    }

    public double obtener_numero_azar(){
        return Math.random();
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
}
