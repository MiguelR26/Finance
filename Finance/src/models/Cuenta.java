package models;

public class Cuenta {
    private String nombre;
    private int IDEstado;
    private int IDTipoCuenta;
    private double valor;

    public Cuenta() {
    }

    public Cuenta(String nombre, int IDEstado, int IDTipoCuenta, double valor) {
        this.nombre = nombre;
        this.IDEstado = IDEstado;
        this.IDTipoCuenta = IDTipoCuenta;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIDEstado() {
        return IDEstado;
    }

    public void setIDEstado(int IDEstado) {
        this.IDEstado = IDEstado;
    }

    public int getIDTipoCuenta() {
        return IDTipoCuenta;
    }

    public void setIDTipoCuenta(int IDTipoCuenta) {
        this.IDTipoCuenta = IDTipoCuenta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
