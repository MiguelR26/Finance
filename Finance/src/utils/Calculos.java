package utils;

public class Calculos {

    public static double[] efectivoTotal(double pronostico[], double entradaSalida[], double plazo1mes, double plazo2meses,
                                         double contado) {
        double[][] matriz = new double[4][5];
        double[] resultado = new double[5];

        for (int i = 0; i < 5; i++) {
            matriz[0][i] = pronostico[i] * contado;
            if (i < 4) {
                matriz[1][i + 1] = pronostico[i] * plazo1mes;
            }

            if (i < 3) {
                matriz[2][i + 2] = pronostico[i] * plazo2meses;
            }

            matriz[3][i] = entradaSalida[i];
        }

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 5; y++) {
                System.out.print(matriz[x][y] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            double suma = 0;
            for (int j = 0; j < 4; j++) {
                suma += matriz[j][i];
            }
            resultado[i] = suma;
        }


        return resultado;
    }

    public static void imprimirVector(double[] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + " ");
            System.out.println();
        }
    }
}
