package utils;

import models.Cuenta;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Analisis {
    private static DecimalFormat df = new DecimalFormat("#,###,##0.00");

    public static String analisisRazonesFinancieras(ArrayList<Cuenta> razones) {
        String analisis = "";
        Double valor;
        for (Cuenta razon : razones) {
            //Razones de Liquidez
            if (razon.getNombre().equals("Capital Neto de Trabajo")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();
                if (valor >= 0) {
                    analisis += "La empresa cuenta con un Capital neto de trabajo de C$" + valor + " lo que sigfinica que " +
                            "la empresa posee líquidez y puede cumplir con sus obligaciones a corto plazo.";
                } else {
                    analisis += " La empresa cuenta con un Capital neto de trabajo negativo de C$" + valor + ", por lo tanto, " +
                            "se puede concluir que la empresa no posee líquidez para cumplir con sus obligaciones a " +
                            "corto plazo";
                }
            }

            if (razon.getNombre().equals("Indice de Solvencia")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();
                if (valor >= 1) {
                    analisis += "El indice de solvencia de la empresa es de " + valor + " lo que quiere decir que cada córdoba" +
                            "de pasivos circulantes está respaldado por C$" + valor + " de activo circulante";
                } else {
                    analisis += "El indice de solvencia es de " + valor + " lo que quiere decir, que el activo circulante representa" +
                            "un " + (valor * 100) + "% del pasivo circulante. Por lo tanto la empresa no posee suficiente liquidez.";
                }
            }

            if (razon.getNombre().equals("Prueba Rapida")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();
                if (valor >= 1) {
                    analisis += "La razon de prueba rapida es " + valor + ", por ende, se puede decir que la capacidad de la empresa para " +
                            "liquidar su empresa es buena, aún dejando de lado la venta de sus inventarios.";
                } else {
                    analisis += "La razon de prueba rapida es " + valor + ", lo que quiere decir, que la empresa no posee liquidez a corto plazo" +
                            " cuando se deja de lado la venta de inventarios.";
                }
            }

            //Razones de actividad
            if (razon.getNombre().equals("Rotación de Inventario")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "La rotación de inventario es de " + valor + ". Por lo tanto, podemos pronosticar que los inventarios permanecen " +
                        "en la empresa en un periodo" +
                        " de " + df.format(12 / valor) + " meses o " + df.format(360 / valor) + " dias.";
            }

            if (razon.getNombre().equals("Rotación de cuentas por Cobrar")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "La rotación de cuentas por cobrar es de " + valor + ". Por lo tanto, podemos pronosticar " +
                        "que la empresa sobra sus creditos" +
                        " en un periodo" +
                        " de " + df.format(12 / valor) + " meses o " + df.format(360 / valor) + " dias.";
            }

            if (razon.getNombre().equals("Periodo promedio de pago en meses")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "El periodo de pago promedio en meses nos indica que la empresa tarda " + valor + " meses en pagar " +
                        "sus compras al credito.";
            }

            if (razon.getNombre().equals("Rotación de activos fijos")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();
                if (valor * 100 > 100) {
                    analisis += "La rotacion de activos fijos es de " + valor + ", lo que significa un incremento de ventas " +
                            "y una baja inversión en activos fijos.";
                } else if (valor * 100 == 100) {
                    analisis += "La razon de activos fijos es de " + valor + ", lo que quiere decir, que la empresa tiene un incremento en ventas" +
                            " proporcional al incremento en activos fijos.";
                } else if (valor * 100 < 100) {
                    analisis += "La razon de activos fijos es de " + valor + " lo que quiere decir que el incremento de las ventas es menor que" +
                            " el incremento en los activos fijos.";
                }
            }

            if (razon.getNombre().equals("Rotacion de los activos totales")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "La eficiencia con la que se utilizan los recursos totales de la empresa para generar dinero en ventas es de un " +
                        (valor * 100) + "%";
            }

            //Razones de endeudamiento TODO
            if (razon.getNombre().equals("Razón de deuda total")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                if (valor < 0.5) {
                    analisis += "La razón de deuda total de " + valor + " nos indica una garantia de la recuperación del capital de la " +
                            "empresa en cado de pérdidas o liquidacion de la empresa.";
                } else {
                    analisis += "La razón de deuda total de " + valor + " nos indica que mas del 50% de sus activos totales" +
                            " estan financiados con deudas, por lo tanto, el control de la empresa está en poder de los " +
                            "acreedores";
                }
            }

            if (razon.getNombre().equals("Razón pasivo a capital")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "LA relación entre los fondos a largo plazo que suministran los acreedores y los aportados" +
                        " por los propietarios de la empresa es de " + valor + ".";
            }

            //Razones de rentabilidad
            if (razon.getNombre().equals("Margen de utilidad bruta")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "El margen de utilidad bruta nos indica que por cada córdoba en ventas se gana C$" + valor + " en " +
                        "utilidad bruta para la empresa.";
            }
            if (razon.getNombre().equals("Margen de utilidad neta")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "El margen de utilidad neta nos indica que por cada córdoba en ventas se gana C$" + valor + " en " +
                        "utilidad neta para la empresa.";
            }
            if (razon.getNombre().equals("Margen de utilidad operativa")) {
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }
                valor = razon.getValor();

                analisis += "El margen de utilidad operativa nos indica que por cada córdoba en ventas se gana C$" + valor + " en " +
                        "utilidad operativa para la empresa.";
            }
        }

        return analisis;
    }

    public static String analisisApalancamiento(ArrayList<Cuenta> razones) {
        String analisis = "";
        Double valor;

        for (Cuenta cuenta : razones) {
            if (cuenta.getNombre().equals("Grado de Apalancamiento Operativo")) {
                valor = cuenta.getValor();
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }

                analisis += "El GAO de " + valor + " indica que un X% de incremento de ventas producira un " + valor + "X% de " +
                        "incremento en Utilidades Antes de Intereses e Impuestos (UAII).";
            }

            if (cuenta.getNombre().equals("Grado de Apalancamiento Financiero")) {
                valor = cuenta.getValor();
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }

                analisis += "El GAF nos muestra una relación entre el aumento de las UAII de la empresa y las " +
                        "Utilidades para Acciones Comunes del " + valor + "%.";
            }

            if (cuenta.getNombre().equals("Grado de Apalancamiento Total")) {
                valor = cuenta.getValor();
                if (!analisis.isEmpty()) {
                    analisis += "\n\n";
                }

                analisis += "El GAT nos muestra una relación entre el aumento de las ventas de la empresa y las " +
                        "Utilidades para Acciones Comunes del " + valor + "%.";
            }
        }
        return analisis;
    }
}
