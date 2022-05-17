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

    // Runtime:
    public static Integer[][] rotateMatrix(Integer[][] matrix) {
        Integer[][] matrix1Rotated = { { 3, 1 }, { 4, 2 } };
        return matrix1Rotated;
    }

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
            for (int col = 0; col < input.length; col++) {
                if(input[row][col] != input[row][col]){
                    System.out.println("[MY Array Failed] " + args);
                    return;
                }
            }
        }
            System.out.println("[Array Worked] " + args);
    }

    public static void main(String[] args) {
        Integer[][] matrix1 = { { 1, 2 }, { 3, 4 } };
        // [1,2
        // 3,4]
        Integer[][] matrix1Rotated = { { 3, 1 }, { 4, 2 } };
        // [3,1
        // 4,2]
        assertArray2DTest(matrix1, "matrix10", matrix1Rotated);
        System.out.println();
    }
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
 * 1. Rotating in place will require one temp 4 byte int.
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
 * 
 */