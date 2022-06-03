package Chapter2;

public class DeleteMiddleNode{

    /*
    Chapter: 2, Question: 3. 
        Implement an algorithm to delete a node in the middle of a LinkedList, given only access to that node

    Hints:
    */

    //Runtime: 
    public static boolean deleteMiddleNode(String str){
        return true;
    }


    public static void main(String[] args){ 
        // deleteMiddleNode(isUniqueChars("abc"), "abc", true);
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
            System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
        } else {
            System.out.println("[Passed] " + args);
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
            System.out.println("[Array Passed] " + args);
    }
}