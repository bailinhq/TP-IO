public class Evento {

    public int tipo; //0 para entrada y 1 para salida
    public int hora; //unidad de tiempo en minutos


    public Evento(int tipo_evento, int hora_evento){
        tipo = tipo_evento;
        hora = hora_evento;
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
