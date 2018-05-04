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
        lista_eventos.add(new Evento(0,0,0));
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
        
    }


    /**
     * Crea evento y los guarda en la lista de eventos
     * @param tipo 0 sí es entrada y 1 para salidas
     */
    public void generar_evento(int tipo){
        double random = 0;//obtener_numero_azar();
        evento = new Evento(tipo,random,reloj);
        lista_eventos.add(evento);
    }

    public double obtener_numero_azar(){
        return Math.random();
    }

    public void imprimirLista()
    {
        Evento tem;
        for (int i = 0; i <= lista_eventos.size(); i++) {
            tem=lista_eventos.poll();
            System.out.println("Tipo de evento:"+tem.tipo);
        }
    }
}
