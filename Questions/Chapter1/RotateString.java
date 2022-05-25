public class RotateString {

    /*
     * Chapter: 1, Question: 9.
     *  Assume you have a methos isSubtring which checks if one words is a substring of antother.
     *  Given two strings s1, and s2, write code to check if s2 is a rotation of s2 using only one
     *  call to isSubtring
     * 
     * Hints:
     */

    // Runtime:
    public static boolean rotateStringBadAttempt(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        int str1index = 0;
        int str1end = str1.length();

        int str2index = 0;
        int str2end = str2.length();

        boolean firstSubtring = false;
        boolean secondSubtring = false;
        
        
        while(str1index < str1.length()){
            if(str2.charAt(str2index) != str1.charAt(str1index)){
                str1index++;
            } else if(str2.charAt(str2index) == str1.charAt(str1index)){
                System.out.println(str1.length() - str1index);
                
                String str1FirstChunk = str1.substring(str1index, str1.length());
                String str2FirstChunk = str2.substring(0, str1.length() - str1index);
                System.out.println("FirstChunks: "+ str1FirstChunk + ", " + str2FirstChunk);

                String str1SecondChunk = str1.substring(0, str1index);
                String str2SecondChunk = str2.substring(str1.length() - str1index,  str2.length());
                System.out.println("SecondChunks: "+ str1SecondChunk + ", " + str2SecondChunk);
                
                firstSubtring = sameString(str1FirstChunk, str2FirstChunk);    
                secondSubtring = sameString(str1SecondChunk, str2SecondChunk);    
                break;
            }
        }
        
        return firstSubtring && secondSubtring;
    }



    public static boolean rotateStringAttemp2(String str1, String str2){
        
        if(str1.length() != str2.length()) return false;
        int str1index = 0;
        int str2index = 0;
        boolean found = false;
        while(str2index < str2.length() && str1index < str1.length()){

            if(str1.charAt(str1index) == str2.charAt(str2index)){
                found = true;
                str1index++;
                str2index++;
            } else if(str1.charAt(str1index) != str2.charAt(str2index)){
                    str1index++;
            }
            if(str1index == str1.length() - 1 && found) str1index = 0;
        }

        return true && found;
    }

    public static boolean rotateStringAttemp3(String str1, String str2){
        
        if(str1.length() != str2.length() || str1.length() == 0 || str2.length() == 0) return false;
        int str1index = 0;
        int str2index = 0;
        while(str2index < str2.length() && str1index < str1.length()){

            if(str1.charAt(str1index) == str2.charAt(str2index)){
    
                String str1FirstChunk = str1.substring(str1index, str1.length());
                String str2FirstChunk = str2.substring(0, str1.length() - str1index);
                String str1SecondChunk = str1.substring(0, str1index);
                String str2SecondChunk = str2.substring(str1.length() - str1index,  str2.length());
                boolean firstSubtring = sameString(str1FirstChunk, str2FirstChunk);
                boolean secondSubtring = sameString(str1SecondChunk, str2SecondChunk);    

                if(firstSubtring && secondSubtring) return true;
                else 
                str1index++;  
            } else 
                str1index++;
    }
        return false;
    }
    private static boolean sameString(String sub1, String sub2) {
        return sub1.equals(sub2);
    }

    public static boolean rotateStringImrpoved(String str1, String str2){
        int len = str1.length();
        if(len == str2.length() && len > 0){
            String str1str1 = str1 + str1;
            //hellohello
            return isSubstring(str1str1, str2);
            //hell"ohell"o
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2){
        return s1.indexOf(s2) != -1;
    }
    public static void main(String[] args) {
        assertTest(rotateStringAttemp3("hello", "ohell"), "hello", true);
        assertTest(rotateStringAttemp3("hello", "xhell"), "xhello", false);
        assertTest(rotateStringAttemp3("helelo", "elohel"), "elohel", true);
        assertTest(rotateStringAttemp3("waterbottle", "erbottlewat"), "waterbottle", true);
        assertTest(rotateStringAttemp3("a", "a"), "a", true);
        assertTest(rotateStringAttemp3("", ""), "empty", false);

        assertTest(rotateStringImrpoved("hello", "ohell"), "hello", true);
        assertTest(rotateStringImrpoved("hello", "xhell"), "xhello", false);
        assertTest(rotateStringImrpoved("helelo", "elohel"), "elohel", true);
        assertTest(rotateStringImrpoved("waterbottle", "erbottlewat"), "waterbottle", true);
        assertTest(rotateStringImrpoved("a", "a"), "a", true);
        assertTest(rotateStringImrpoved("", ""), "empty", false);
        // assertArray2DTest(matrix1Rotated, "matrix10", matrix1Rotated);

    }

    /*
     * Questions:
     * 1. Capital vs lowecase?
     * 
     * 
     * Ideas:
     * 1. No string concatination. Use index and distance, if length is the same and
     * != to return false.
     * once the same character is the same for the substring check the reminaing,
     * 
     * Edge Cases:
     * 1. empty, different length, unequal size, repetitions
     * 
     * Pros vs. Cons in solutons:
     * 1.
     * 
     * Learned: Different solution, ideas:
     * 1. String,indexof("ohell")
     * 
     * Mistakes:
     * 1. repeated work
     * 2. Did not understand what "call to isSubtring" meant!
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