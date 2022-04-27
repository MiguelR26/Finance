package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Cuenta;
import sql.Facade;
import utils.*;

import javax.swing.*;
import javax.xml.transform.Result;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button ajustes_btnEditar;

    @FXML
    private Button apalancamiento_calcularBtn;

    @FXML
    private TextField apalancamiento_intereses;

    @FXML
    private ComboBox<String> PC_estadoDeResultados;

    @FXML
    private TextField PC_cobroCuentas1Mes;

    @FXML
    private TextField PC_pagoCuentas1Mes;

    @FXML
    private TextField ajustes_correoTF;

    @FXML
    private Button panelControl_agregarCuenta;

    @FXML
    private Button menu_panelControl;

    @FXML
    private TextField PC_ventasContado;

    @FXML
    private AnchorPane presupuestoPane;

    @FXML
    private TextField apalancamiento_ventasUnidadesTF;

    @FXML
    private TextArea AF_analisisTA;

    @FXML
    private TextField PC_pagoCuentas2Mes;

    @FXML
    private TextField apalancamiento_costosFijos;

    @FXML
    private Button EF_reporteBtn;

    @FXML
    private TextField panelControl_nombreCuenta;

    @FXML
    private AnchorPane estadosFinancierosPane;

    @FXML
    private TextField apalancamiento_costoDeVenta;

    @FXML
    private AnchorPane paneSuperior;

    @FXML
    private TextField PC_cobroCuentas2Mes;

    @FXML
    private TableView<?> AF_tablaRazones;

    @FXML
    private TextField ajustes_rifEmpresaTF;

    @FXML
    private ComboBox<String> PC_tipoDeCuenta;

    @FXML
    private Button PC_borrarActivo;

    @FXML
    private Button ajustes_btnGuardar;

    @FXML
    private TableView<?> panelControl_tablaCuentasAgregadas;

    @FXML
    private Button btnCloseApp;

    @FXML
    private Button PC_borrarTodosActivos;

    @FXML
    private AnchorPane apalancamientoPane;

    @FXML
    private TextField apalancamiento_accionesComunes;

    @FXML
    private Button btnMinimizeApp;

    @FXML
    private TableView<?> PC_tablaDatosPresupuestoCaja;

    @FXML
    private TextField ajustes_telefonoTF;

    @FXML
    private Button PC_calcularPresupuesto;

    @FXML
    private TableView<?> apalancamiento_tablaDatosApalancamiento;

    @FXML
    private TextField PC_SalidasDeEfectivoMes1;

    @FXML
    private TextField PC_SalidasDeEfectivoMes3;

    @FXML
    private TextField PC_SalidasDeEfectivoMes2;

    @FXML
    private TextField PC_SalidasDeEfectivoMes5;

    @FXML
    private AnchorPane panelControlPane;

    @FXML
    private TextField PC_SalidasDeEfectivoMes4;

    @FXML
    private TextField PC_PronosticoVentaMes4;

    @FXML
    private TextField PC_PronosticoVentaMes5;

    @FXML
    private TextField PC_PronosticoVentaMes3;

    @FXML
    private Button menu_analisisFInanciero;

    @FXML
    private TextField PC_PronosticoVentaMes2;

    @FXML
    private TextField PC_PronosticoVentaMes1;

    @FXML
    private ComboBox<String> EF_SeleccionEstadoComboBox;

    @FXML
    private TextArea apalancamiento_analisisApalancamiento;

    @FXML
    private Button menu_estadosFinancieros;

    @FXML
    private TextField PC_entradasEfectivoMes4;

    @FXML
    private TextField PC_entradasEfectivoMes5;

    @FXML
    private TextField PC_entradasEfectivoMes2;

    @FXML
    private AnchorPane analisisFinancieroPane;

    @FXML
    private TextField PC_entradasEfectivoMes3;

    @FXML
    private TextField ajustes_nombreTF;

    @FXML
    private Button menu_apalancamiento;

    @FXML
    private Button menu_ajustes;

    @FXML
    private TextField PC_entradasEfectivoMes1;

    @FXML
    private TextField apalancamiento_DividendosPreferentes;

    @FXML
    private AnchorPane ajustesPane;

    @FXML
    private TableView<?> EF_tablaEstadoFinanciero;

    @FXML
    private TextField panelControl_valorCuenta;

    @FXML
    private TextField apalancamiento_impuestos;

    @FXML
    private Label EF_MensajePersonalizado;

    @FXML
    private TextField apalancamiento_precioVenta;

    @FXML
    private Button menu_presupuesto;

    @FXML
    private TextField PC_comprasEfectivo;

    @FXML
    private TextField PC_saldoInicial;

    @FXML
    private ComboBox<String> AF_seleccionAnalisisCombobox;

    @FXML
    private TextField PC_saldoMinimoRequerido;

    @FXML
    private TextField PC_procentajeCompras;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Panel de control
        try {
            Fuller.llenarComboBox(PC_estadoDeResultados, Facade.obtenerEstados());
            Fuller.llenarComboBox(PC_tipoDeCuenta, Facade.obtenerTipos());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        actualizarTablasPanelControl();


        //Estados Financieros
        try {
            Fuller.llenarComboBox(EF_SeleccionEstadoComboBox, Facade.obtenerEstados());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Analisis Financiero
        Fuller.llenarComboBox(AF_seleccionAnalisisCombobox, Facade.obtenerRazones());
    }

    void actualizarTablasPanelControl() {
        try {
            Fuller.llenarTableView(panelControl_tablaCuentasAgregadas, Facade.obtenerTodasLasCuentas());
        } catch (SQLException throwables) {
            System.out.println("Error al obtener las cuentas");
            throwables.printStackTrace();
        }
    }

    public void estadoFinancieroChange(ActionEvent event) {
        String opcion = EF_SeleccionEstadoComboBox.getValue().toString();
        System.out.println(opcion);

        if (opcion.equals("Balance General")) {
            try {
                llenarBalanceGeneral();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (opcion.equals("Estado de Resultados")) {
            try {
                llenarEstadoResultados();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (opcion.equals("Flujo de efectivo")) {
            try {
                llenarFlujoEfectivo();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void razonesFinancierasChange(ActionEvent event) {
        if (AF_seleccionAnalisisCombobox.getValue().equals("Razones de Liquidez")) {
            try {
                Fuller.llenarEstado(AF_tablaRazones, new ResultSet[]{Facade.obtenerRazonesLiquidez()});

                ResultSet rsp = Facade.obtenerRazonesLiquidez();
                ArrayList<Cuenta> listaRazonesLiquidez = new ArrayList<>();
                while (rsp.next()) {
                    System.out.println(rsp.getString(1));
                    //System.out.println(rsp.getDouble(2));
                    if (rsp.getDouble(2) != 0.0) {
                        Cuenta c = new Cuenta();
                        c.setNombre(rsp.getString(1));
                        c.setValor(rsp.getDouble(2));
                        listaRazonesLiquidez.add(c);
                    }
                }
                AF_analisisTA.setText(Analisis.analisisRazonesFinancieras(listaRazonesLiquidez));

            } catch (SQLException throwables) {
                System.out.println("Error al obtener razones de liquidez");
                throwables.printStackTrace();
            }
        }

        if (AF_seleccionAnalisisCombobox.getValue().equals("Razones de Actividad")) {
            try {
                Fuller.llenarEstado(AF_tablaRazones, new ResultSet[]{Facade.obtenerRazonesActividad()});

                ResultSet rsp = Facade.obtenerRazonesActividad();
                ArrayList<Cuenta> lista = new ArrayList<>();
                while (rsp.next()) {
                    System.out.println(rsp.getString(1));
                    //System.out.println(rsp.getDouble(2));
                    if (rsp.getDouble(2) != 0.0) {
                        Cuenta c = new Cuenta();
                        c.setNombre(rsp.getString(1));
                        c.setValor(rsp.getDouble(2));
                        lista.add(c);
                    }
                }
                AF_analisisTA.setText(Analisis.analisisRazonesFinancieras(lista));

            } catch (SQLException throwables) {
                System.out.println("Error al obtener razones de liquidez");
                throwables.printStackTrace();
            }
        }

        if (AF_seleccionAnalisisCombobox.getValue().equals("Razones de Endeudamiento")) {
            try {
                Fuller.llenarEstado(AF_tablaRazones, new ResultSet[]{Facade.obtenerRazonesEndeudamiento()});

                ResultSet rsp = Facade.obtenerRazonesEndeudamiento();
                ArrayList<Cuenta> lista = new ArrayList<>();
                while (rsp.next()) {
                    System.out.println(rsp.getString(1));
                    //System.out.println(rsp.getDouble(2));
                    if (rsp.getDouble(2) != 0.0) {
                        Cuenta c = new Cuenta();
                        c.setNombre(rsp.getString(1));
                        c.setValor(rsp.getDouble(2));
                        lista.add(c);
                    }
                }
                AF_analisisTA.setText(Analisis.analisisRazonesFinancieras(lista));

            } catch (SQLException throwables) {
                System.out.println("Error al obtener razones de liquidez");
                throwables.printStackTrace();
            }
        }

        if (AF_seleccionAnalisisCombobox.getValue().equals("Razones de Rentabilidad")) {
            try {
                Fuller.llenarEstado(AF_tablaRazones, new ResultSet[]{Facade.obtenerRazonesRentabilidad()});

                ResultSet rsp = Facade.obtenerRazonesRentabilidad();
                ArrayList<Cuenta> lista = new ArrayList<>();
                while (rsp.next()) {
                    System.out.println(rsp.getString(1));
                    //System.out.println(rsp.getDouble(2));
                    if (rsp.getDouble(2) != 0.0) {
                        Cuenta c = new Cuenta();
                        c.setNombre(rsp.getString(1));
                        c.setValor(rsp.getDouble(2));
                        lista.add(c);
                    }
                }
                AF_analisisTA.setText(Analisis.analisisRazonesFinancieras(lista));

            } catch (SQLException throwables) {
                System.out.println("Error al obtener razones de liquidez");
                throwables.printStackTrace();
            }
        }
    }

    void llenarBalanceGeneral() throws SQLException {
        ResultSet[] resultSets = new ResultSet[]{
                Facade.activosCirculantes(),
                Facade.obtenerTotalActivosCirculantes(),
                Facade.obtenerActivosFijos(),
                Facade.obtenerTotalActivosFijos(),
                Facade.obtenerActivosDiferido(),
                Facade.obtenerTotalActivosDiferido(),
                Facade.obtenerOtrosActivos(),
                Facade.obtenerTotalOtrosActivos(),
                Facade.obtenerTotalActivos(),

                Facade.obtenerPasivoCirculante(),
                Facade.obtenerTotalPasivoCirculante(),
                Facade.obtenerPasivoNoCirculante(),
                Facade.obtenerTotalPasivoNoCirculante(),
                Facade.obtenerTotalPasivos(),
                Facade.obtenerCapitalGanado(),
                Facade.obtenerTotalCapitalGanado(),
                Facade.obtenerCapitalContribuido(),
                Facade.obtenerTotalCapitalContribuido(),
                Facade.obtenerTotalCapital(),
                Facade.obtenerTotalPasivoMasCapital()
        };
        Fuller.llenarEstado(EF_tablaEstadoFinanciero, resultSets);
    }

    void llenarEstadoResultados() throws SQLException {
        ResultSet[] rs = new ResultSet[]{
                Facade.obtenerVentasNetas(),
                Facade.obtenerCostoDeVentas(),
                Facade.obtenerUtilidadBruta(),
                Facade.obtenerGastos(),
                Facade.obtenerTotalGastos(),
                Facade.obtenerOtrosIngresos(),
                Facade.obtenerTotalOtrosIngresos(),
                Facade.obtenerUtilidadNeta()
        };
        Fuller.llenarEstado(EF_tablaEstadoFinanciero, rs);
    }

    void llenarFlujoEfectivo() throws SQLException {
        ResultSet[] rs = new ResultSet[]{
                Facade.obtenerGeneracionBrutaDeRecursos(),
                Facade.obtenerFlujoOperacion(),
                Facade.obtenerTotalFlujoOperacion(),
                Facade.obtenerFlujoInversion(),
                Facade.obtenerTotalFlujoInversion(),
                Facade.obtenerFlujoFinanciamiento(),
                Facade.obtenerTotalFlujoFinanciamiento(),
                Facade.obtenerSaldoFinalEfectivo()
        };

        Fuller.llenarEstado(EF_tablaEstadoFinanciero, rs);
    }


    //Eventos de botones
    public void panelControlHandle(ActionEvent e) throws SQLException {
        if (e.getSource() == panelControl_agregarCuenta) {
            TextField[] tfs = {panelControl_nombreCuenta, panelControl_valorCuenta};
            ComboBox[] cbs = {PC_estadoDeResultados, PC_tipoDeCuenta};

            if (Validator.validarTextFields(tfs) && Validator.validarComboBoxs(cbs)) {
                Cuenta c = new Cuenta();
                c.setNombre(panelControl_nombreCuenta.getText());
                c.setValor(Double.parseDouble(panelControl_valorCuenta.getText()));

                if (PC_estadoDeResultados.getValue().equals("Balance General")) {
                    c.setIDEstado(1);
                }
                if (PC_estadoDeResultados.getValue().equals("Estado de Resultados")) {
                    c.setIDEstado(2);
                }
                if (PC_estadoDeResultados.getValue().equals("Flujo de efectivo")) {
                    c.setIDEstado(3);
                }
                System.out.println(PC_estadoDeResultados.getValue());
                System.out.println(c.getIDEstado());
                c.setIDTipoCuenta(Facade.obtenerIDTipo(PC_tipoDeCuenta.getValue()));

                Facade.agregarCuenta(c);

                actualizarTablasPanelControl();
                llenarBalanceGeneral();
                Cleaner.vaciarTextFields(tfs);
                //Cleaner.vaciarComboBox(cbs);
            } else {
                JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
            }
        }

        if (e.getSource() == PC_borrarActivo) {
            String id = panelControl_tablaCuentasAgregadas.getSelectionModel().getSelectedItem().toString();
            String idCortado = "";
            for (int i = 0; i < id.length(); i++) {
                if (id.charAt(i) == ',') {
                    break;
                } else {
                    if (id.charAt(i) != '[') {
                        idCortado += id.charAt(i);
                    }
                }
            }

            int idCuenta = Integer.parseInt(idCortado);
            Facade.eliminarCuenta(idCuenta);
            actualizarTablasPanelControl();
        }

        if (e.getSource() == PC_borrarTodosActivos) {
            int op = JOptionPane.showConfirmDialog(null, "Deseas eliminar todas las cuentas?");
            System.out.println(op);
            if (op == 0) {
                Facade.eliminarTodasLasCuentas();
            }
            actualizarTablasPanelControl();
        }
    }

    //Apalancamineto
    public void apalancamientoHandle(ActionEvent e) throws SQLException {
        if (e.getSource() == apalancamiento_calcularBtn) {
            TextField[] tfs = {apalancamiento_accionesComunes,
                    apalancamiento_ventasUnidadesTF,
                    apalancamiento_costoDeVenta,
                    apalancamiento_impuestos,
                    apalancamiento_costosFijos,
                    apalancamiento_DividendosPreferentes,
                    apalancamiento_intereses
            };
            if (Validator.validarTextFields(tfs)) {
                int ventasUnidades = Integer.parseInt(apalancamiento_ventasUnidadesTF.getText());
                Double precioVenta = Double.parseDouble(apalancamiento_precioVenta.getText());
                Double costoVenta = Double.parseDouble(apalancamiento_costoDeVenta.getText());
                Double impuestos = Double.parseDouble(apalancamiento_impuestos.getText());
                Double costosFijos = Double.parseDouble(apalancamiento_costosFijos.getText());
                Double dividendosPreferentes = Double.parseDouble(apalancamiento_DividendosPreferentes.getText());
                Double accionesComunes = Double.parseDouble(apalancamiento_accionesComunes.getText());
                Double intereses = Double.parseDouble(apalancamiento_intereses.getText());

                Fuller.llenarEstado(apalancamiento_tablaDatosApalancamiento,
                        new ResultSet[]{
                                Facade.obtenerApalancamientos(ventasUnidades, precioVenta, costoVenta,
                                        costosFijos, dividendosPreferentes, accionesComunes, impuestos, intereses)
                        }
                );

                ResultSet rsp = Facade.obtenerApalancamientos(ventasUnidades, precioVenta, costoVenta,
                        costosFijos, dividendosPreferentes, accionesComunes, impuestos, intereses);
                ArrayList<Cuenta> lista = new ArrayList<>();
                while (rsp.next()) {
                    System.out.println(rsp.getString(1));
                    //System.out.println(rsp.getDouble(2));
                    if (rsp.getDouble(2) != 0.0) {
                        Cuenta c = new Cuenta();
                        c.setNombre(rsp.getString(1));
                        c.setValor(rsp.getDouble(2));
                        lista.add(c);
                    }
                }
                apalancamiento_analisisApalancamiento.setText(Analisis.analisisApalancamiento(lista));


            } else {
                JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
            }
        }
    }

    //Presupuesto de caja
    public void generarPresupuestoCaja(ActionEvent e) {

        double pCompras = PC_procentajeCompras.getText().isEmpty() ? 0 : Double.parseDouble(PC_procentajeCompras.getText());

        double[] pronosticosVentas = {
                PC_PronosticoVentaMes1.getText().isEmpty() ? 0 : Double.parseDouble(PC_PronosticoVentaMes1.getText()),
                PC_PronosticoVentaMes2.getText().isEmpty() ? 0 : Double.parseDouble(PC_PronosticoVentaMes2.getText()),
                PC_PronosticoVentaMes3.getText().isEmpty() ? 0 : Double.parseDouble(PC_PronosticoVentaMes3.getText()),
                PC_PronosticoVentaMes4.getText().isEmpty() ? 0 : Double.parseDouble(PC_PronosticoVentaMes4.getText()),
                PC_PronosticoVentaMes5.getText().isEmpty() ? 0 : Double.parseDouble(PC_PronosticoVentaMes5.getText())
        };

        double pronosticoCompra[] = new double[5];
        System.out.println(pCompras);
        for (int i = 0; i < pronosticoCompra.length; i++) {
            pronosticoCompra[i] = pronosticosVentas[i] * pCompras;
        }

        Calculos.imprimirVector(pronosticosVentas);
        Calculos.imprimirVector(pronosticoCompra);

        double[] entradasEfectivo = {
                PC_entradasEfectivoMes1.getText().isEmpty() ? 0 : Double.parseDouble(PC_entradasEfectivoMes1.getText()),
                PC_entradasEfectivoMes2.getText().isEmpty() ? 0 : Double.parseDouble(PC_entradasEfectivoMes2.getText()),
                PC_entradasEfectivoMes3.getText().isEmpty() ? 0 : Double.parseDouble(PC_entradasEfectivoMes3.getText()),
                PC_entradasEfectivoMes4.getText().isEmpty() ? 0 : Double.parseDouble(PC_entradasEfectivoMes4.getText()),
                PC_entradasEfectivoMes5.getText().isEmpty() ? 0 : Double.parseDouble(PC_entradasEfectivoMes5.getText())
        };

        double[] salidasEfectivo = {
                PC_SalidasDeEfectivoMes1.getText().isEmpty() ? 0 : Double.parseDouble(PC_SalidasDeEfectivoMes1.getText()),
                PC_SalidasDeEfectivoMes2.getText().isEmpty() ? 0 : Double.parseDouble(PC_SalidasDeEfectivoMes2.getText()),
                PC_SalidasDeEfectivoMes3.getText().isEmpty() ? 0 : Double.parseDouble(PC_SalidasDeEfectivoMes3.getText()),
                PC_SalidasDeEfectivoMes4.getText().isEmpty() ? 0 : Double.parseDouble(PC_SalidasDeEfectivoMes4.getText()),
                PC_SalidasDeEfectivoMes5.getText().isEmpty() ? 0 : Double.parseDouble(PC_SalidasDeEfectivoMes5.getText())
        };

        double cobroCuentas1mes = PC_cobroCuentas1Mes.getText().isEmpty() ? 0 : Double.parseDouble(PC_cobroCuentas1Mes.getText());
        double cobroCuentas2mes = PC_cobroCuentas2Mes.getText().isEmpty() ? 0 : Double.parseDouble(PC_cobroCuentas2Mes.getText());
        double ventasContado = PC_ventasContado.getText().isEmpty() ? 0 : Double.parseDouble(PC_ventasContado.getText());

        double pagoCuentas1mes = PC_pagoCuentas1Mes.getText().isEmpty() ? 0 : Double.parseDouble(PC_pagoCuentas1Mes.getText());
        double pagoCuentas2mes = PC_pagoCuentas2Mes.getText().isEmpty() ? 0 : Double.parseDouble(PC_pagoCuentas2Mes.getText());
        double comprasContado = PC_comprasEfectivo.getText().isEmpty() ? 0 : Double.parseDouble(PC_comprasEfectivo.getText());

        double saldoInicial = PC_saldoInicial.getText().isEmpty() ? 0 : Double.parseDouble(PC_saldoInicial.getText());
        double sme = PC_saldoMinimoRequerido.getText().isEmpty() ? 0 : Double.parseDouble(PC_saldoMinimoRequerido.getText());

        double[] entradas = Calculos.efectivoTotal(pronosticosVentas, entradasEfectivo, cobroCuentas1mes, cobroCuentas2mes, ventasContado);
        double[] salidas = Calculos.efectivoTotal(pronosticoCompra, salidasEfectivo, pagoCuentas1mes, pagoCuentas2mes, comprasContado);
        double[] trans = new double[10];

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                trans[i] = entradas[i];
            } else {
                trans[i] = salidas[i - 5];
            }
        }
        try {
            Fuller.llenarEstado(PC_tablaDatosPresupuestoCaja, new ResultSet[]{Facade.obtenerPresupuesto(trans, saldoInicial, sme)});
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cerrarApp(ActionEvent e) {
        if (e.getSource() == btnCloseApp) {
            System.exit(0);
        }
        if (e.getSource() == btnMinimizeApp) {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setIconified(true);
        }
    }

    public void handleMenuButton(ActionEvent e) {
        if (e.getSource() == menu_panelControl) {
            setActive(menu_panelControl);
            panelControlPane.toFront();
        }
        if (e.getSource() == menu_estadosFinancieros) {
            setActive(menu_estadosFinancieros);
            estadosFinancierosPane.toFront();
        }
        if (e.getSource() == menu_analisisFInanciero) {
            setActive(menu_analisisFInanciero);
            analisisFinancieroPane.toFront();
        }
        if (e.getSource() == menu_apalancamiento) {
            setActive(menu_apalancamiento);
            apalancamientoPane.toFront();
        }
        if (e.getSource() == menu_ajustes) {
            setActive(menu_ajustes);
            ajustesPane.toFront();
        }
        if (e.getSource() == menu_presupuesto) {
            setActive(menu_presupuesto);
            presupuestoPane.toFront();
        }
    }

    private void setActive(Button b) {
        ArrayList<Button> menuBotones = new ArrayList<>();
        menuBotones.add(menu_panelControl);
        menuBotones.add(menu_estadosFinancieros);
        menuBotones.add(menu_analisisFInanciero);
        menuBotones.add(menu_apalancamiento);
        menuBotones.add(menu_ajustes);
        menuBotones.add(menu_presupuesto);

        for (Button button : menuBotones) {
            if (button == b) {
                button.setStyle("-fx-background-color: rgba(0,0,0,.35)");
            } else {
                button.setStyle("-fx-background-color: transparent");
            }
        }
        menuBotones.clear();
    }

    //Atributos para la funcionalidad de arrastrar la ventana
    private double xOffset = 0;
    private double yOffset = 0;

    //Funcionalidad para arrastrar la ventana
    public void onMouseDragged(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    public void onMousePressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }


}
