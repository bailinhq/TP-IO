public class Evento implements Comparable<Evento>{

    private int tipo; //0 para entrada y 1 para salida
    private int hora; //unidad de tiempo en minutos

    /**
     *
     * @param tipo_evento Tipo de evento a crear
     * @param tiempo_reloj Tiempo del reloj cuando se genera el evento
     */
    public Evento(int tipo_evento, int tiempo_reloj){
        tipo = tipo_evento;
        hora = tiempo_reloj;
    }




    @Override
    public int compareTo(Evento o) {
        return o.getTipo();
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

}
