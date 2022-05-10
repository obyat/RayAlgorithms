public class OneAway{

    /*
    Chapter: 1, Question: 5. 
        There are three types of edits that can be performed on strings: insert a character, 
        remove a character, or replace a character. given two strings, write a function to 
        check if they are one edit (or zero edits) away.

    Hints: 23, 97, 130
    */

    //runtime = O(Str1 + Str2 + 26)
    public static boolean oneAway(String str1, String str2){
        if (abs(str1.length() - str2.length()) > 1) return false;

        int[] charCount = new int[25];
        int opCount = 0;

        for(int i=0; i < str1.length(); i++)
            charCount[str1.charAt(i) - 'a']++;

        for(int i=0; i < str2.length(); i++){
            if(charCount[str2.charAt(i) - 'a'] > 0)
                charCount[str2.charAt(i) - 'a']--;
            else
                charCount[str2.charAt(i) - 'a']++;
            }

        for(int i=0; i < charCount.length; i++)
            opCount += charCount[i];

        if(opCount >= 0 && opCount <= 2)
            return true;
        return false;
    }

    //runtime = O(min(Str1, Str2))
    public static boolean oneAwayImproved(String str1, String str2){
        if (abs(str1.length() - str2.length()) > 1) return false;
        int i1, i2;
        boolean foundADifference = false;
        String s1, s2;
        i1 = i2 = 0;

        //str1 == i1 is the shorter string
        if(str1.length() < str2.length()) {
            s1 = str1; s2 = str2;
        } else {
            s1 = str2; s2 = str1;
        }

        while(i2 < s2.length() && i1 < s1.length()){
            if(s1.charAt(i1) != s2.charAt(i2)) {
                if(foundADifference) return false;
                foundADifference = true;
                // if they're the same length and we replaced, then move the now shorter string
                if(s1.length() == s2.length()) i1++; 
            
            } else { //if i1 == i2 move i1 which is the shorter
                i1++;
            }

            i2++; // keep moving pointer for longer string str2
        }
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
        assertTest(oneAwayImproved("test", "testt"), "test, testt", true);
        assertTest(oneAwayImproved("pale", "ple"), "pale, ple", true);
        assertTest(oneAwayImproved("pales", "pale"), "pales, pale", true);
        assertTest(oneAwayImproved("pale", "bale"), "pale, bale", true);
        assertTest(oneAwayImproved("pale", "bake"), "pale, bake", false);
        assertTest(oneAwayImproved("pale", "balke"), "pale, balke", false);
        assertTest(oneAwayImproved("a", "abb"), "a, abb", false);
        assertTest(oneAwayImproved("zz", "xz"), "zz, xz", true);
    }
}

 
/*
    Questions:
        1. What is the max string?
        2. What if we receive the same string? zero edits = true
        3. Is input limited to english language characters, or do we need to account for all input possibilites such as ints, etc.

    Ideas:
        1. take longer string and iterate through it, double four loop, for each character increase count, if found, decrease count, if count is not 1 or 0 then false 
        2. sort both strings, and increament pointer, then substring all equal characters out, then compare the number
        3. convert string to ascii and increment count of each character, then decrement for second string, 
        4. index first string to an array with counts, in the second string if the value is >0 then subtract, otherwise add. Then go through the array and add the values, if it is 0,1,2, then true, else, false
        5. Put all Characters in hashtable, then check if all chars in Str2 are contained in hashTable and keep count if not, then check count is 0 or 1
        6. pointer solution: increment until a difference is found, then if another difference is found return false, otherwise return true;
          
    Edge Cases:
        1. Length > 1 between strings

    Learned: Different solution, ideas:
        1. Using pointers is sometimes the best solution
    
        
    
    */