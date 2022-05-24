import java.util.Arrays;

public class ZeroMatrix {

    /*
     * Chapter: 1, Question: 8.
     *  Write an algorithm such that if a n element in MxN matrix is 0, its entire row and column are set to 0.
     *
     * Hints:
     */

    // Runtime:2N^2 = O(N^2), O(N^2) Space.
    //Solves the wrong problem
    public static Integer[][] zeroMatrix(Integer[][] matrix) {
        if (matrix.length == 0)
            return matrix;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix = markZeroedMatrix(matrix, row, col);
                    // System.out.println(Arrays.deepToString(matrix));
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == -1)
                    matrix[row][col] = 0;
            }
        }
        // System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    // Runtime:2N^2 = O(N^2), O(M + N) Space.
    private static Integer[][] markZeroedMatrix(Integer[][] matrix, int row, int col) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = -1;
            matrix[i][col] = -1;
        }
        return matrix;
    }


    public static Integer[][] zeroMatrixIntermediate(Integer[][] matrix) {
        boolean[] rowHasZero = new boolean[matrix.length];
        boolean[] columnHasZero = new boolean[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if( matrix[row][col] == 0) {
                    rowHasZero[row] = true;
                    columnHasZero[col] = true;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            if(rowHasZero[row]) makeZerosRow(matrix, row);
        }
        
        for (int col = 0; col < matrix[0].length; col++) {
            if(columnHasZero[col]) makeZerosColumn(matrix, col);
        }

        // System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }


    // Runtime: O(N^2), O(1) Space.
    public static Integer[][] zeroMatrixImproved(Integer[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // check if first col has a zero
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // check zeros for rest of array
        //if you see any zeros make sure that row and colum are marked
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }

            }
        }

        // makeZeros rows based on values in first row
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                makeZerosRow(matrix, row);
            }
        }

        // makeZeros columns based on values in first col
        for (int col = 1; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                makeZerosColumn(matrix, col);
            }
        }

        if (rowHasZero)
            makeZerosRow(matrix, 0);
        if (colHasZero)
            makeZerosColumn(matrix, 0);

        // System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    public static void makeZerosRow(Integer[][] matrix, int row) {
        for (int col = 1; col < matrix[0].length; col++) {
            matrix[row][col] = 0;
        }
    }

    public static void makeZerosColumn(Integer[][] matrix, int col) {
        for (int row = 1; row < matrix.length; row++) {
            matrix[row][col] = 0;
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix3 = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
        Integer[][] matrix3Zero = { {1, 0, 0}, {0, 0, 0}, {0, 0, 0} };
        Integer[][] matrix4 = { { 1, 7, 4, 0 }, { 2, 8, 5, 2 }, { 3, 9, 6, 3 }, { 3, 9, 6, 3 } };
        Integer[][] matrix4Zero = { {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0} };

        assertArray2DTest(zeroMatrix(matrix3), "matrix3", matrix3Zero);
        assertArray2DTest(zeroMatrix(matrix4), "matrix4", matrix4Zero);

        assertArray2DTest(zeroMatrixIntermediate(matrix3), "matrix3", matrix3Zero);
        assertArray2DTest(zeroMatrixIntermediate(matrix4), "matrix4", matrix4Zero);

        assertArray2DTest(zeroMatrixImproved(matrix3), "matrix3", matrix3Zero);
        assertArray2DTest(zeroMatrixImproved(matrix4), "matrix4", matrix4Zero);

        // System.out.println();

    }

    /*
     * Questions:
     * 1. Will the final matrix have only the rows/cols with zeros that were found
     * in first check?
     * 
     * Ideas:
     * 1. Iterate matrix and mark locations, then iterate the etnire matrix again
     * and change marked locations.
     * 
     * Edge Cases:
     * 1. Worst case if matrix has all zeros?
     * 2. empty matrix, or no colms inside rows, keep changing zeros until the
     *     majority of matrix is zeros
     * 
     * Pros vs. Cons in solutons:
     * 1.
     * 
     * Learned: Different solution, ideas:
     * 1. You can use break inside for loop in java
     * 2. System.out.println(Arrays.deepToString(matrix));

     * 
     * Mistakes:
     * 1. Did not answer the correct question because of ambiguity
     */

    // use Arrays.toString(array)
    public static void assertTest(Object input, Object args, Object expected) {
        if (!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input + ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
        System.out.println();
    }

    // requires all methods to return wrapper classes
    public static <T> void assertArray2DTest(T[][] input, Object args, T[][] expected) {
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if (input[row][col] != expected[row][col]) {
                    System.out.println("[MY Array Failed] " + args);
                    return;
                }
            }
        }
        System.out.println("[Array Worked] " + args);
    }
}