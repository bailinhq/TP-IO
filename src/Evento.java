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

    /**
     * Ordena un evento en la lista de eventos por tiempo del reloj y si hay dos iguales, primero coloca la salida.
     * @param o Recibe el evento a ordenar
     * @return Retorna un número que permite ordenar la lista.
     */
    @Override
    public int compareTo(Evento o) {
        if (this.hora < o.hora){
            return -1;
        } else if (this.hora > o.hora){
            return 1;
        } else{
            if (this.tipo == o.tipo){
                return 0;
            } else if (this.tipo == 1){
                return -1;
            } else{
                return 1;
            }
        }
    }

    public int getTipo() { return tipo; }

    public void setTipo(int tipo) { this.tipo = tipo; }

    public int getHora() {  return hora; }

    public void setHora(int hora) { this.hora = hora; }

}
