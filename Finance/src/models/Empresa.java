package models;

public class Empresa {
    private String nombre;
    private String RIF;
    private String Correo;
    private String telefono;

    public Empresa(String nombre, String RIF, String correo, String telefono) {
        this.nombre = nombre;
        this.RIF = RIF;
        Correo = correo;
        this.telefono = telefono;
    }

    public Empresa() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRIF() {
        return RIF;
    }

    public void setRIF(String RIF) {
        this.RIF = RIF;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
