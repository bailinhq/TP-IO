public class Sistema {

    public final int numero_servidores = 2;
    public int ocupabilidad;
    public int reloj;
    public int tamano_cola;

    public Sistema(){
        ocupabilidad = 0;
        reloj = 0;
    }

    public void generar_entrada(){
        if (ocupabilidad == numero_servidores){
            tamano_cola++;
        } else{
            ocupabilidad++;
            this.generar_salida();
        }
        generar_entrada();
    }

    public void generar_salida(){
        if (tamano_cola > 0){
            tamano_cola--;
            generar_salida();
        } else{
            ocupabilidad--;
        }
    }
}
