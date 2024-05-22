/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;
import java.util.Random;

public class MatricesPatrones {
    static Random rand = new Random();

    public static void main(String[] args) {
        int filas = 5;
        int columnas = 6;
        int[][] matriz = new int[filas][columnas];

        System.out.println("PRIMERA FORMA");
        llenarZigzagHorizontal(matriz, filas, columnas);
        imprimirMatriz(matriz);

        System.out.println("\nSEGUNDA FORMA");
        llenarZigzagVertical(matriz, filas, columnas);
        imprimirMatriz(matriz);

        System.out.println("\nTERCERA FORMA");
        llenarEspiral(matriz, filas, columnas);
        imprimirMatriz(matriz);
    }

    private static void llenarZigzagHorizontal(int[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < columnas; j++) 
                    matriz[i][j] = rand.nextInt(10);
                } else {
                for (int j = columnas - 1; j >= 0; j--) 
                    matriz[i][columnas - 1 - j] = rand.nextInt(10);
            }
        }
    }

    private static void llenarZigzagVertical(int[][] matriz, int filas, int columnas) {
        for (int j = 0; j < columnas; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < filas; i++) {
                    matriz[i][j] = rand.nextInt(10);
                }
            } else {
                for (int i = filas - 1; i >= 0; i--) {
                    matriz[filas - 1 - i][j] = rand.nextInt(10);
                }
            }
        }
    }

    private static void llenarEspiral(int[][] matriz, int filas, int columnas) {
        int arriba = 0, abajo = filas - 1;
        int izquierda = 0, derecha = columnas - 1;

        while (arriba <= abajo && izquierda <= derecha) {
            for (int i = izquierda; i <= derecha; i++) {
                matriz[arriba][i] = rand.nextInt(10);
            }
            arriba++;

            for (int i = arriba; i <= abajo; i++) {
                matriz[i][derecha] = rand.nextInt(10);
            }
            derecha--;

            if (arriba <= abajo) {
                for (int i = derecha; i >= izquierda; i--) {
                    matriz[abajo][i] = rand.nextInt(10);
                }
                abajo--;
            }

            if (izquierda <= derecha) {
                for (int i = abajo; i >= arriba; i--) {
                    matriz[i][izquierda] = rand.nextInt(10);
                }
                izquierda++;
            }
        }
    }

    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}
