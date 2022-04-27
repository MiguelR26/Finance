package sql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Cuenta;
import utils.ConexionBD;
import utils.Converter;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Facade {
    static Connection con;
    static CallableStatement cs;

    public static ResultSet obtenerPresupuesto(double[] trans, double eInicial, double sme) throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerPresupuesto(?,?,?,?,?,?,?,?,?,?,?,?)}");
        for (int i = 1; i <= 10; i++) {
            cs.setDouble(i, trans[i - 1]);
        }
        cs.setDouble(11, eInicial);
        cs.setDouble(12, sme);
        return cs.executeQuery();
    }


    public static ResultSet obtenerApalancamientos(int ventaUnidades, double precioVenta, double costoVenta,
                                                   double costosFijos, double dividendosPreferentes, double accionesComunes, double impuestos, double intereses) throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call GradosApalancamiento(?,?,?,?,?,?,?,?)}");
        cs.setInt(1, ventaUnidades);
        cs.setDouble(2, precioVenta);
        cs.setDouble(3, costoVenta);
        cs.setDouble(4, costosFijos);
        cs.setDouble(5, dividendosPreferentes);
        cs.setDouble(6, accionesComunes);
        cs.setDouble(7, impuestos);
        cs.setDouble(8, intereses);
        return cs.executeQuery();
    }

    public static ObservableList<String> obtenerRazones() {
        ObservableList<String> lista = FXCollections.observableArrayList();
        lista.add("Razones de Liquidez");
        lista.add("Razones de Actividad");
        lista.add("Razones de Endeudamiento");
        lista.add("Razones de Rentabilidad");

        return lista;
    }

    public static ResultSet obtenerRazonesEndeudamiento() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerRazonesEndeudamiento}");
        return cs.executeQuery();
    }

    public static ResultSet obtenerRazonesRentabilidad() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerRazonesRentabilidad}");
        return cs.executeQuery();
    }

    public static ResultSet obtenerRazonesLiquidez() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerRazonesLiquidez}");
        return cs.executeQuery();
    }

    public static ResultSet obtenerRazonesActividad() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerRazonesActividad}");
        return cs.executeQuery();
    }

    public static int obtenerIDTipo(String nombre) throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerIDTipo(?)}");
        cs.setString(1, nombre);
        ResultSet rs = cs.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1));
        return rs.getInt(1);
    }

    public static void agregarCuenta(Cuenta c) throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call agregarCuenta(?,?,?,?)}");
        cs.setString(1, c.getNombre());
        cs.setDouble(2, c.getValor());
        cs.setInt(3, c.getIDEstado());
        cs.setInt(4, c.getIDTipoCuenta());
        cs.execute();
    }

    public static void eliminarCuenta(int id) throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call eliminarCuenta(?)}");
        cs.setInt(1, id);
        cs.execute();
    }

    public static void eliminarTodasLasCuentas() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call eliminarTodasLasCuentas}");
        cs.execute();
    }

    public static ResultSet obtenerTodasLasCuentas() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerCuentas}");
        return cs.executeQuery();
    }

    public static ObservableList<String> obtenerEstados() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerEstados}");
        ResultSet rs = cs.executeQuery();
        return Converter.resultSetToObservableList(rs, 1);
    }

    public static ObservableList<String> obtenerTipos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTipos}");
        ResultSet rs = cs.executeQuery();
        return Converter.resultSetToObservableList(rs, 1);
    }

    //Balance General
    public static ResultSet activosCirculantes() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerActivosCirculates}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalActivosCirculantes() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalActivosCirculantes}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerActivosFijos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerActivosFijos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalActivosFijos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalActivosFijos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerActivosDiferido() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerActivosDiferido}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalActivosDiferido() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalActivosDiferido}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerOtrosActivos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerOtrosActivos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalOtrosActivos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalOtrosActivos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalActivos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalActivos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerPasivoCirculante() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerPasivoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalPasivoCirculante() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerPasivoNoCirculante() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerPasivoNoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalPasivoNoCirculante() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivoNoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalPasivos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerCapitalGanado() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerCapitalGanado}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalCapitalGanado() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivoNoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerCapitalContribuido() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivoNoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalCapitalContribuido() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivoNoCirculante}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalCapital() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalCapital}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalPasivoMasCapital() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalPasivoMasCapital}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    //Estado de resultado
    public static ResultSet obtenerVentasNetas() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerVentasNetas}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerCostoDeVentas() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerCostoDeVentas}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerUtilidadBruta() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerUtilidadBruta}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerGastos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerGastos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalGastos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalGastos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerUtilidadOperativa() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerUtilidadOperativa}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerOtrosIngresos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerOtrosIngresos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalOtrosIngresos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalOtrosIngresos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerUtilidadNeta() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerUtilidadNeta}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    //Estado de flujo de efectivo
    public static ResultSet obtenerGeneracionBrutaDeRecursos() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerGeneracionBrutaDeRecursos}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerFlujoOperacion() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerFlujoOperacion}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalFlujoOperacion() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalFlujoOperacion}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerFlujoInversion() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerFlujoInversion}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalFlujoInversion() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalFlujoInversion}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerFlujoFinanciamiento() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerFlujoFinanciamiento}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerTotalFlujoFinanciamiento() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerTotalFlujoFinanciamiento}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

    public static ResultSet obtenerSaldoFinalEfectivo() throws SQLException {
        con = ConexionBD.conexion();
        cs = con.prepareCall("{call obtenerSaldoFinalEfectivo}");
        ResultSet rs = cs.executeQuery();
        return rs;
    }

}
