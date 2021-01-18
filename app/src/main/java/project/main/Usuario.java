package project.main;

public class Usuario {

    //Atributos
    int id;
    String nombre;
    String apellido;
    String usuario;
    String password;
    String direccion;
    String edad;
    String cedula;
    String genero;

    //Constructor
    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String usuario, String password,String edad,String cedula,String genero,String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.direccion = direccion;
        this.edad = edad;
        this.cedula = cedula;
        this.genero = genero;


    }

    //metodos funcionales?
    public boolean isNull(){
        if (nombre.equals("") && apellido.equals("") && usuario.equals("")
                && password.equals("")&&cedula.equals("")&&genero.equals("")&&direccion.equals("")&&edad.equals("")){

            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                ", edad='" + edad + '\'' +
                ", cedula='" + cedula + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    //getters
    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getUsuario() {return usuario;}
    public String getPassword() {return password;}
    public String getDireccion() {
        return direccion;
    }
    public String getGenero() {
        return genero;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCedula() {
        return cedula;
    }
    public String getEdad() {
        return edad;
    }

    //setters
    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setPassword(String password) {this.password = password;}
    public void setGenero(String genero) {
        this.genero = genero;
    }
   public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
}
