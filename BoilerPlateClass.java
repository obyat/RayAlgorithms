public class BoilerPlateClass{

    /*
    Chapter: , Question: . 

    Hints:
    */

    //Runtime: 
    public static boolean Name(String str){
        return true;
    }

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
            for (int col = 0; col < input.length; col++) {
                if(input[row][col] != input[row][col]){
                    System.out.println("[MY Array Failed] " + args);
                    return;
                }
            }
        }
            System.out.println("[Array Worked] " + args);
    }


    public static void main(String[] args){
        // assertTest(isUniqueChars("abc"), "abc", true);
        // assertArray2DTest(matrix1Rotated, "matrix10", matrix1Rotated);
        // System.out.println();

    }
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
    
    */