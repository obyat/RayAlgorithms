public class OneAway{

    /*
    Chapter: 1, Question: 5. 
        There are three types of edits that can be performed on strings: insert a character, 
        remove a character, or replace a character. given two strings, write a function to 
        check if they are one edit (or zero edits) away.
    */
    public static boolean oneAway(String str1, String str2){
        if (abs(str1.length() - str2.length()) > 1) return false;
        //todo, take str1.toCharArray(), then i - 'a', then array[i]++
        // str2.toCharArray(), if > 0 then array[i]--, otherwise array[i]++
        // loop through char count array and add everything, if 2,1,0 then true
        return true;
    }

    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
    }

    private static int abs(int val){
        return  (val < 0) ? -val : val;
    }


    public static void main(String[] args){
        assertTest(oneAway("pale", "ple"), "pale, ple", true);
        assertTest(oneAway("pales", "pale"), "pales, pale", true);
        assertTest(oneAway("pale", "bale"), "pale, bale", true);
        assertTest(oneAway("pale", "bake"), "pale, bake", false);
        assertTest(oneAway("pale", "balke"), "pale, balke", false);
        assertTest(oneAway("a", "abb"), "a, abb", false);
        // System.out.println(0 - 1);

    }
}



 
/*
    Questions:
        1. What is the max string?
        2. What if we receive the same string? zero edits = true

    Ideas:
        1. take longer string and iterate through it, double four loop, for each character increase count, if found, decrease count, if count is not 1 or 0 then false 
        2. sort both strings, and increament pointer, then substring all equal characters out, then compare the number
        3. convert string to ascii and increment count of each character, then decrement for second string, 
        4. index first string to an array with counts, in the second string if the value is >0 then subtract, otherwise add. Then go through the array and add the values, if it is 0,1,2, then true, else, false

    Learned: Different solution, ideas:
        1.
    
    */