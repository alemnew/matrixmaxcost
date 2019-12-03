/*
 * Copyright 2019 Alemnew Asrese
 * <p>
 * A test program for maximum cost finder for traversing in a two dimensional matrix.
 *
 * @author alemnew.asrese@aalto.fi Alemnew Asrese
 * Created on 2019/12/03
 */

package com.dreambroker.matrix.test;

import com.dreambroker.matrix.main.Matrix;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest {

    private Matrix matrix;


    @Test
    public void testDiagonalMatrix() {
        int[][] inputMatrix = new int[][] {
                { 1, 0, 0, 0, 0 },
                { 0, 8, 0, 0, 0 },
                { 0, 0, 4, 0, 0 },
                { 0, 0, 0, 7, 0 },
                { 0, 0, 0, 0, 1 }
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(21, actualResult);
    }

    @Test
    public void testScalarMatrix() {
        int[][] inputMatrix = new int[][] {
                { 8, 0, 0, 0, 0 },
                { 0, 8, 0, 0, 0 },
                { 0, 0, 8, 0, 0 },
                { 0, 0, 0, 8, 0 },
                { 0, 0, 0, 0, 8 }
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(40, actualResult);
    }

    @Test
    public void testLowerTriangularMatrix() {
        int[][] inputMatrix = new int[][] {
                {1, 0, 0},
                {2, 4, 0},
                {3, 5, 6}
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(18, actualResult);
    }

    @Test
    public void testUpperTriangularMatrix() {
        int[][] inputMatrix = new int[][] {
                {5, 8, 3},
                {0, 1, 2},
                {0, 0, 6}
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(24, actualResult);
    }

    @Test
    public void testNullMatrix() {
        int[][] inputMatrix = new int[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(0, actualResult);
    }

    @Test
    public void rawMatrix() {
        int[][] inputMatrix = new int[][] {
                { 1, 3, 2, 5, 0 }
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(11, actualResult);
    }

    @Test
    public void columnMatrix() {
        int[][] inputMatrix = new int[][] {
                {1},
                {3},
                {2},
                {5}
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(11, actualResult);
    }

    @Test
    public void testMatrix() {
        int[][] inputMatrix = new int[][] {
                { 1, 3, 2, 5, 0 },
                { 5, 8, 7, 4, 3 },
                { 8, 6, 4, 2, 3 },
                { 9, 0, 4, 7, 0 },
                { 3, 4, 5, 2, 1 }
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(39, actualResult);
    }

    @Test
    public void testFirstColumnLastRawMatrix() {
        int[][] inputMatrix = new int[][] {
                { 1, 0, 0, 0, 0 },
                { 5, 0, 0, 0, 0 },
                { 8, 0, 0, 0, 0 },
                { 9, 0, 0, 0, 0 },
                { 3, 4, 5, 2, 1 }
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(38, actualResult);
    }

    @Test
    public void testFirstRawLastColumnMatrix() {
        int[][] inputMatrix = new int[][] {
                { 1, 3, 2, 5, 0 },
                { 0, 0, 0, 0, 3 },
                { 0, 0, 4, 0, 3 },
                { 0, 0, 4, 0, 0 },
                { 0, 0, 0, 0, 1 }
        };
        int actualResult = Matrix.calculateMaxPathCost(inputMatrix);
        Assert.assertEquals(18, actualResult);
    }


}
