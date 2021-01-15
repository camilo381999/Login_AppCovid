package project.main;

public class Usuario {

    //Atributos
    int id;
    String nombre;
    String apellido;
    String usuario;
    String password;

    //Constructor
    public Usuario() {

    }

    public Usuario(String nombre, String apellido, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
    }

    //metodos funcionales?
    public boolean isNull(){
        if (nombre.equals("") && apellido.equals("") && usuario.equals("") && password.equals("")){
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
                '}';
    }

    //getters
    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getUsuario() {return usuario;}
    public String getPassword() {return password;}

    //setters
    public void setId(int id) {this.id = id;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public void setPassword(String password) {this.password = password;}
}
