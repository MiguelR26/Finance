package utils;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Cuenta;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Converter {

    public static ObservableList<String> resultSetToObservableList(ResultSet rs, int columna) throws SQLException {
        ObservableList<String> lista = FXCollections.observableArrayList();
        //creando y llenando la lista
        while (rs.next()) {
            lista.add(rs.getString(columna).trim());
        }
        return lista;
    }

    public static ObservableList<Cuenta> resultSetToListaCuenta(ResultSet rs) throws SQLException {
        ObservableList<Cuenta> lista = FXCollections.observableArrayList();

        while (rs.next()) {
            Cuenta c = new Cuenta();
            c.setNombre(rs.getString(1));
            c.setValor(rs.getDouble(2));
            lista.add(c);
        }
        return lista;
    }


}

