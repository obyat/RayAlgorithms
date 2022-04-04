public class CheckPermutation{

    /*
    Chapter: 1, Question: 2. 
     Given two strings, write a method to decide if one is a permutation of the other.
    */
    public static boolean permutedStrings(String str1, String str2){
        int str1len = str1.length();
        int str2len = str2.length();
        if(str1len != str2len || str1.equals(str2)) return false;
        int[] charsCount = new int[128];

        for(int i = 0; i < str1len; i++){
            charsCount[(int) Character.toLowerCase(str1.charAt(i))] = charsCount[(int) Character.toLowerCase(str1.charAt(i))] + 1; // goes to the index and increments it;  charsCount[(int) str1.charAt(i)]++
        }

        for(int i = 0; i < str2len; i++){
            charsCount[(int) Character.toLowerCase(str2.charAt(i))]--;
            if (charsCount[(int) Character.toLowerCase(str2.charAt(i))] < 0 ) return false;
        }
        return true;
    }

    public static void assertTest(Object expected, Object args, Object given){
        if(!given.equals(expected)) {
            System.out.println("[Failed] expected: " + given + ", received: " + expected +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
    }
    public static void main(String[] args){
       // assertTest(isUniqueChars("abc"), "abc", true);
        assertTest(permutedStrings("can", "anc"), "can, anc", true);
        assertTest(permutedStrings("clam", "calm"), "clam, calm", true);
        assertTest(permutedStrings("clam", "clam"), "clam, clam", false);
        assertTest(permutedStrings("RACECAR", "CARRacE"), "RACECAR, CARRacE", true);
        assertTest(permutedStrings("dafasdfasdfsafd", "dafsadfasdfasdASDFASDFASdfasd"), "dafasdfasdfsafd, dafsadfasdfasdASDFASDFASdfasd", false);
    }
}

/*
    Ideas:
        1. Insert str1 into HashTable and iterate through Str2 which decreasing count. O(Str1 + Str2) time with O(Str1) space => best solution but avoid HT overhead with array
        2. Make 0-97 ascii representation of the strings and inc, dec counts based on chars. O(Str1 + Str2) time with O(Str1) space
        3. Merge Sort both strings and check neighbors O(Str1+Str2logStr1+Str2) time and O(Str1+Str2) space

    Learned: Different solution, ideas:
        1. ask about whitespace and case senisitivity
        2. increment index in an array
        3. can trade off space of 128 bits char array or more trade off time with mainting only characters encourtered by 'a' - 97 => 0th index in array
    */
