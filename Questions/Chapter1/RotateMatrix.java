import java.util.Arrays;

public class RotateMatrix {

    /*
     * Chapter: 1, Question: 7.
     * Given an image represented by an NxN matrix, where each pixel in the image is
     * 4 bytes, write a method to rotate the image by 90 degrees.
     * Can you do this in place?
     * 
     * Hints:
     * 51, 100
     */


    // Runtime: O(nxn) time
    public static Integer[][] rotateMatrix(Integer[][] matrix) {
        if(matrix.length == 0) return matrix;

        int matrrowLen = matrix.length ;//4
        int matrcolLen = matrix[matrrowLen - 1].length;//3
        Integer[][] rotatedMatrix = new Integer[matrcolLen][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                rotatedMatrix[col][matrrowLen - 1] = matrix[row][col];
            }
            matrrowLen--;
        }
        // System.out.println(Arrays.deepToString(rotatedMatrix));
        return rotatedMatrix;
    }

    public static void main(String[] args) {
        Integer[][] matrix1 = { {0, 1} };
        // [1,2
        // 3,4]
        Integer[][] matrix1Rotated = { {0}, {1} };
        Integer[][] matrix2 = { {1, 2}, {3, 4} };
        // [1,2
        // 3,4]
        Integer[][] matrix2Rotated = { {3, 1}, {4, 2} };
        // [3,1
        // 4,2]
        Integer[][] matrix3 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        Integer[][] matrix3Rotated = { {7, 4, 1} , {8, 5, 2}, {9, 6, 3} };

        Integer[][] matrix4 = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 2, 3} };
        Integer[][] matrix4Rotated = { {1, 7, 4, 1} , {2, 8, 5, 2}, {3, 9, 6, 3}};

        assertArray2DTest(rotateMatrix(matrix1), "matrix1", matrix1Rotated);
        assertArray2DTest(rotateMatrix(matrix2), "matrix2", matrix2Rotated);
        assertArray2DTest(rotateMatrix(matrix3), "matrix3", matrix3Rotated);
        assertArray2DTest(rotateMatrix(matrix4), "matrix4", matrix4Rotated);

        System.out.println();
    }

/*
 * 
 * Questions:
 * 1. Why is each pixel 4 bytes? Because int is 4 byte?
 * 2. Rotate by +90 degress is assumed to be to the right
 * 3. Should the pixel by an int or an object of type pixel?
 * 4. difference in odd, even matrices?
 * 
 * Ideas:
 * 1. Rotating in place will require one temp 4 byte int. N^2 solution
 * 2.
 * 
 * Edge Cases:
 * 1. middle element might not require rotation
 * 2.
 * 
 * Pros vs. Cons in solutons:
 * 1.
 * 
 * Learned: Different solution, ideas:
 * 1. initilize 2d array with int[][] = new int[2][2] where 2 is the size.
 * 2. use row and cloumns
 * 3. input.getClass().isArray()
 * 4. use matrix[row].length for the columns so you only need the length of the inner array
 * 
 */

    //use Arrays.toString(array)
    public static void assertTest(Object input, Object args, Object expected) {
        if (!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input + ", for: " + args);
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
                    System.out.println("[Array Failed] " + args);
                    return;
                }
            }
        }
            System.out.println("[Array Worked] " + args);
    }
}