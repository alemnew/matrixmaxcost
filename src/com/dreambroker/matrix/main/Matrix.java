/*
 * Copyright 2019 Alemnew Asrese
 * <p>
 * A maximum cost finder in traversing through a two dimensional integer matrix. The cost represents the sum of
 * the values on a path traversing the matrix. Any path starts with top/left position and ends with bottom/right
 * position. Only moves towards right and down are allowed.
 *
 * @author alemnew.asrese@aalto.fi Alemnew Asrese
 * @version 1.0
 * Created on 2019/12/03
 */

package com.dreambroker.matrix.main;

import java.util.Scanner;

public class Matrix {

    /**
     * Find the maximum cost of traversing a path in a 2-dimensional matrix. O
     * @param inputMatrix a two dimensional matrix
     * @return the maximum of cost
     */
     public static int calculateMaxPathCost(int [][] inputMatrix) {
         int maxPathCost = inputMatrix[0][0];

         if (inputMatrix.length == 1) { // if matrix is row matrix
             for (int i = 1; i < inputMatrix[0].length; i++) {
                 maxPathCost += inputMatrix[0][i];
             }
         }
         else if (inputMatrix[0].length == 1) { // if matrix is a column matrix
             for (int i = 1; i < inputMatrix.length; i++) {
                 maxPathCost += inputMatrix[i][0];
             }
         } else { // the matrix has more one column and row
             int[][] solutionMatrix = new int[inputMatrix.length][inputMatrix.length];

             solutionMatrix[0][0] = inputMatrix[0][0];

             // fill the first row of solution
             for (int i = 1; i < inputMatrix.length; i++) {
                 solutionMatrix[0][i] = inputMatrix[0][i] + solutionMatrix[0][i - 1];
             }

             // fill the first column of the solution
             for (int i = 1; i < inputMatrix.length; i++) {
                 solutionMatrix[i][0] = inputMatrix[i][0] + solutionMatrix[i - 1][0];
             }

             // path will be either from top or left, choose the maximum
             for (int i = 1; i < inputMatrix.length; i++) {
                 for (int j = 1; j < inputMatrix.length; j++) {
                     solutionMatrix[i][j] = inputMatrix[i][j]
                             + Math.max(solutionMatrix[i - 1][j], solutionMatrix[i][j - 1]);
                 }
             }
             maxPathCost = solutionMatrix[inputMatrix.length - 1][inputMatrix.length - 1];
         }
         return maxPathCost;
     }

    /**
     * Read matrix from user input.
     * @param scan a system scanner object that takes the input from the keyboard.
     * @param matrix an empty matrixRow by matrixCol matrix to accept the values.
     * @param matrixRow the number of rows of the matrix.
     * @param matrixColumn the number of columns of the matrix.
     */
    private static void enterMatrixData(Scanner scan, int[][] matrix, int matrixRow, int matrixColumn){
        System.out.println("Enter Matrix Data");

        for (int i = 0; i < matrixRow; i++)
        {
            System.out.printf("row %d ", (i+1));
            for (int j = 0; j < matrixColumn; j++)
            {
                matrix[i][j] = scan.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        /*int[][] exampleInputMatrix = new int[][] {
                { 1, 3, 2, 5, 0 },
                { 5, 8, 7, 4, 3 },
                { 8, 6, 4, 2, 3 },
                { 9, 0, 4, 7, 0 },
                { 3, 4, 5, 2, 1 }
        }; */

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter The Number Of Matrix Rows ");
        int matrixRow = scan.nextInt();
        System.out.print("Enter The Number Of Matrix Columns ");
        int matrixColumn = scan.nextInt();

        //defining 2D array to hold matrix data
        int[][] inputMatrix = new int[matrixRow][matrixColumn];
        // Enter Matrix Data
        enterMatrixData(scan, inputMatrix, matrixRow, matrixColumn);

        System.out.println(calculateMaxPathCost(inputMatrix));

    }
}
