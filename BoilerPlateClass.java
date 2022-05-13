public class BoilerPlateClass{

    /*
    Chapter: , Question: . 

    Hints:
    */

    //Runtime: 
    public static boolean Name(String str){
        return true;
    }

    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
        System.out.println();

    }


    public static void main(String[] args){
        // assertTest(isUniqueChars("abc"), "abc", true);
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