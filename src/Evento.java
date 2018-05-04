public class Evento implements Comparable<Evento>{

    public int tipo; //0 para entrada y 1 para salida
    public int hora; //unidad de tiempo en minutos

    /**
     *
     * @param tipo_evento Tipo de evento a crear
     * @param hora_evento Tiempo aleatorio
     * @param tiempo_reloj Tiempo del reloj cuando se genera el evento
     */
    public Evento(int tipo_evento, double hora_evento, int tiempo_reloj){
        tipo = tipo_evento;

        if(tipo_evento==0)
        {
            hora = obtener_tiempo_entrada(hora_evento)+tiempo_reloj;
        }else {
            hora = obtener_tiempo_salida(tiempo_reloj)+tiempo_reloj;
        }
    }

    @Override
    public int compareTo(Evento o) {
        return 0;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    private int obtener_tiempo_entrada(double tiempo){
        int tiempo_temp= 0;
        if(tiempo!=0) {
            if (tiempo <= 0.39)
                tiempo_temp = 1;
            else if (tiempo <= 0.74)
                tiempo_temp = 2;
            else if (tiempo <= 1)
                tiempo_temp = 3;
        }
        return tiempo_temp;
    }

    private int obtener_tiempo_salida(double tiempo){
        int tiempo_temp= 0;
        if(tiempo!=0) {
            if (tiempo <= 0.09)
                tiempo_temp = 2;
            else if (tiempo <= 0.34)
                tiempo_temp = 3;
            else if (tiempo <= 0.74)
                tiempo_temp = 4;
            else if (tiempo <= 0.94)
                tiempo_temp = 7;
            else if (tiempo <= 1)
                tiempo_temp = 10;
        }
        return tiempo_temp;
    }

}
