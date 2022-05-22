import java.util.Arrays;

public class ZeroMatrix{

    /*
    Chapter: , Question: . 

    Hints:
    */

    //Runtime: 
    public static Integer[][] zeroMatrix(Integer[][] matrix) {
        if (matrix.length == 0)
            return matrix;

        int matrrowLen = matrix.length;
        int matrcolLen = matrix[0].length;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if( matrix[row][col] == 0) {
                    matrix = markZeroedMatrix(matrix, row, col);
                    // System.out.println(Arrays.deepToString(matrix));
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if( matrix[row][col] == -1) 
                    matrix[row][col] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    private static Integer[][] markZeroedMatrix(Integer[][] matrix, int row, int col){
        for(int i = 0; i< matrix[row].length; i++){
            matrix[row][i] = -1;
            matrix[i][col] = -1;
        }
        return matrix;
    }

    public static void main(String[] args){
        Integer[][] matrix3 = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
        Integer[][] matrix3Zero = { { 1, 0, 3 }, { 0, 0, 0 }, { 7, 0, 9 } };

        Integer[][] matrix4 = { { 1, 7, 4, 0 }, { 2, 8, 5, 2 }, { 3, 9, 6, 3 }, { 3, 9, 6, 3 } };
        Integer[][] matrix4Zero = { { 0, 0, 0, 0 }, { 2, 8, 5, 0 }, { 3, 9, 6, 0 }, { 3, 9, 6, 0 } };
        assertArray2DTest(zeroMatrix(matrix3), "matrix3", matrix3Zero);
        assertArray2DTest(zeroMatrix(matrix4), "matrix4", matrix4Zero);

        // assertTest(isUniqueChars("abc"), "abc", true);
        // assertArray2DTest(matrix1Rotated, "matrix10", matrix1Rotated);
        // System.out.println();

    }

    /*
    Questions:
        1.

    Ideas:
        1.

    Edge Cases:
        1. 
    
    Pros vs. Cons in solutons:
        1.
    
    Learned: Different solution, ideas:
        1.
    
    Mistakes:
        1. 
    */

    //use Arrays.toString(array)
    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
        System.out.println();
    }

    //requires all methods to return wrapper classes
    public static <T> void assertArray2DTest(T[][] input, Object args, T[][] expected){
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[0].length; col++) {
                if(input[row][col] != expected[row][col]){
                    System.out.println("[MY Array Failed] " + args);
                    return;
                }
            }
        }
            System.out.println("[Array Worked] " + args);
    }
}