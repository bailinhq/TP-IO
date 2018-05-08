public class Evento2 implements Comparable<Evento2>{

    private int tipo; //0 para entrada y 1 para salida
    private int hora; //unidad de tiempo en minutos
    private Boolean terminalB;
    /**
     *
     * @param tipo_evento Tipo de evento a crear
     * @param tiempo_reloj Tiempo del reloj cuando se genera el evento
     */
    public Evento2(int tipo_evento, int tiempo_reloj, Boolean terminal){
        tipo = tipo_evento;
        hora = tiempo_reloj;
        terminalB = terminal;
    }

    @Override
    public int compareTo(Evento2 o) {
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

    public Boolean getTerminalB() {
        return terminalB;
    }
}
