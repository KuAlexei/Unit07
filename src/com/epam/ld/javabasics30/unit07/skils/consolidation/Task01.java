package com.epam.ld.javabasics30.unit07.skils.consolidation;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = readIntMatrixConsole(sc);

        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        System.out.println("Сумма отрицательных элементов в каждой строке:");
        printMatrix(intMatrixTranspose(intVectorToMatrix(taskA(matrix))));

        System.out.println("Максимальный элемент в каждой строке:");
        printMatrix(intMatrixTranspose(intVectorToMatrix(taskB(matrix))));

        System.out.println("Матрица с переставленными максимальным и минимальным элементами:");
        printMatrix(taskC(matrix));
    }

    public static int[][] readIntMatrixConsole(Scanner sc) {
        System.out.println("Введите матрицу NxM.");
        int n = readNaturalNumberFromConsole(sc, "Введите размер матрицы N: ");
        int m = readNaturalNumberFromConsole(sc, "Введите размер матрицы M: ");
        int[][] matrix = new int[n][m];
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = readIntFromConsole(sc, String.format("Введите элемент матрицы [%d,%d] :", i , j));
            }
        }
        return matrix;
    }

    public static int[] taskA(int[][] matrix) {
        int n = matrix.length;
        int[] negSum = new int[n];
        for (int i = 0 ; i < n; i++) {
            negSum[i] = 0;
            for (int m : matrix[i]) {
                if (m < 0) {
                    negSum[i] += m;
                }
            }
        }
        return negSum;
    }

    public static int[] taskB(int[][] matrix) {
        int n = matrix.length;
        int[] max = new int[n];
        for (int i = 0 ; i < n; i++) {
            max[i]=matrix[i][0];
            for (int m : matrix[i]) {
                if (m > max[i]) {
                    max[i] = m;
                }
            }
        }
        return max;
    }

    public static int[][] taskC(int[][] matrix) {
        int n = matrix.length;
        int iMin = 0;
        int iMax = 0;
        int jMin = 0;
        int jMax = 0;
        int newMatrix[][] = new int[n][];

        for (int i = 0 ; i < n; i++) {
            int m = matrix[i].length;
            newMatrix[i] = new int[m];
            for (int j = 0; j < m; j++) {
                newMatrix[i][j] = matrix[i][j];
                if (matrix[iMin][jMin] > matrix[i][j]) {
                    iMin = i;
                    jMin = j;
                }
                if (matrix[iMax][jMax] < matrix[i][j]) {
                    iMax = i;
                    jMax = j;
                }
            }
        }
        newMatrix[iMax][jMax] = matrix[iMin][jMin];
        newMatrix[iMin][jMin] = matrix[iMax][jMax];
        return newMatrix;
    }

    public static int readIntFromConsole(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        return sc.nextInt();
    }

    public static int readNaturalNumberFromConsole(Scanner sc, String message) {
        int n = 0;
        do {
            n = readIntFromConsole(sc, message);
        } while (n <= 0);
        return n;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] a:matrix) {
            for (int i:a) {
                System.out.printf("%9d ",i);
            }
            System.out.println();
        }
    }

    public static int[][] intVectorToMatrix(int[] vector){
        int n = vector.length;
        int[][] matrix = new int[1][n];
        for (int i = 0; i < n; i++) {
            matrix[0][i] = vector[i];
        }
        return matrix;
    }

    private static int[][] intMatrixTranspose(int[][] matrix){
        int n = matrix.length;
        if (n == 0) {
            return matrix;
        }
        int m = matrix[0].length;
        int [][] transposed = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

}
