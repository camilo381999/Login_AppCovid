package project.main.Informes;

public class Informe {
    String cedula="";
    String correo="";
    String estado="";
    String fecha="";
    String puntaje="";
 public Informe(){

 }

    public Informe(String cedula, String correo, String estado, String fecha, String puntaje) {
        this.cedula = cedula;
        this.correo = correo;
        this.estado = estado;
        this.fecha = fecha;
        this.puntaje = puntaje;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
