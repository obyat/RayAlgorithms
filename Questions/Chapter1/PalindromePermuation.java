import java.util.*;
public class PalindromePermuation{

    static int count = 0;
    static boolean palindome = false;
    static ArrayList<String> palindromeList = new ArrayList<String>(); 
    /*
    Chapter: 1, Question: 4. 
    Given a string, write a function to check if it is a permutation of a palindrome. A palindrome
    is a word or a phrase that is the same forward and bakwards. A permutation is an arrangement of letters. 
    The palindrome does not need to be limited to just dictionary words.

    Example:
    input: Tact Coa
    Output: True (permutations: "taco cat", "atco cta",)
    */
    public static boolean permutations(String str){
        boolean permutations = permute("", str.toLowerCase());

        // for(String s: (List<String>)  palindromeList) System.out.println(s);
        return permutations;
    }
    public static boolean permute(String prefix, String remaining){
        if(remaining.length() == 0 ) {
            if(palindrome(prefix)){
                palindome = true;
                palindromeList.add(prefix);
            }
        }
        for(int i = 0; i < remaining.length(); i++){
            
            permute(prefix + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i + 1 , remaining.length()));
        }
        return palindome;
    }

    public static boolean palindrome(String str){
        int j = str.length()-1;
        int i = 0;

        while(j>i){     
            if(str.charAt(i) == ' ') {
                i++;
            } else if(str.charAt(j) == ' ') {
                j--;
            } else if(str.charAt(i) != str.charAt(j)) {
                return false;
        } else {
            i++;
            j--;
        }

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


    public static void main(String[] args){
       // assertTest(isUniqueChars("abc"), "abc", true);
        assertTest(permutations("Tact Coa"), "Tact Coa", true);
    }
}

    /*
    
    Ideas:
        1.

    Learned: Different solution, ideas:
        1. Str.length() has the number of items. Length-1 to iterate because starting at 0
        2. It is infeasible to generate all possible permuations of long strings. If a problem is "I need to generate all of group B to find an element from group A"
            then rethinking the problem is needed.
    
    */
    class PalindromePermuationSlightlyImproved{

        static int count = 0;
        static boolean palindome = false;
        static ArrayList<String> palindromeList = new ArrayList<String>(); 
        /*
        Chapter: 1, Question: 4. 
        Given a string, write a function to check if it is a permutation of a palindrome. A palindrome
        is a word or a phrase that is the same forward and bakwards. A permutation is an arrangement of letters. 
        The palindrome does not need to be limited to just dictionary words.
    
        Example:
        input: Tact Coa
        Output: True (permutations: "taco cat", "atco cta",)
        */

        boolean isPermutationOfPlalindrome(String phrase){
            int[] table = buildCharFrequencyTable(phrase);
            return checkMaxOneOdd(table);
        }

        public boolean checkMaxOneOdd(int[] table){
            boolean foundOdd = false;
            for(int count: table){
                if(count %2 == 1){
                    if(foundOdd){
                        return false;
                } 
                foundOdd = true;
            } 
        }
            return true;
        }

        public int getCharNumber(char c){
            if(c < 'a' || c > 'z')
                return -1;
            return c - 'a';
        }

        public int[] buildCharFrequencyTable(String phrase){
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ]; //initializing array with length equal to english alphabet

            for(char c: phrase.toCharArray()){
                int x = getCharNumber(c);
                if(x != -1){
                    table[x]++;
                }
            }
            return table;
        }
    
        public static void assertTest(Object input, Object args, Object expected){
            if(!input.equals(expected)) {
                System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
            } else {
                System.out.println("[Worked] " + args);
            }
        }


        public static void main(String[] args){
           // assertTest(isUniqueChars("abc"), "abc", true);
           PalindromePermuationSlightlyImproved palindrome = new PalindromePermuationSlightlyImproved();
            assertTest(palindrome.isPermutationOfPlalindrome("tact coa"), "tact coa", true);
        }
    }
    

    class PalindromePermuationSmallerCodeImproved{
        boolean isPermutationOfPlalindrome(String phrase){
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ]; //initializing array with length equal to english alphabet
            int countOdd = 0;

            for(char c: phrase.toCharArray()){
                int x = (int) c - 'a';
                if(x != -1){
                    table[x]++;
                    if(table[x] %2 == 1){
                        countOdd++;
                    } else {
                        countOdd--;
                    }
                }
            }
            return countOdd <= 1;
       }

        public static void assertTest(Object input, Object args, Object expected){
            if(!input.equals(expected)) {
                System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
            } else {
                System.out.println("[Worked] " + args);
            }
        }


        public static void main(String[] args){
           // assertTest(isUniqueChars("abc"), "abc", true);
           PalindromePermuationSmallerCodeImproved palindrome = new PalindromePermuationSmallerCodeImproved();
            assertTest(palindrome.isPermutationOfPlalindrome("tactcoa"), "tactcoa", true);
        }
    }

    class PalindromePermuationImproved{
    
        boolean isPermutationOfPlalindrome(String phrase){
            int bitVector = createBitVector(phrase);
            return bitVector == 0 || checkExactlyOneBitSet(bitVector);
        }

        //map int to bit index
        public int createBitVector(String phrase){
            int bitVector = 0;

            for(char c: phrase.toCharArray()){
                int x = c - 'a';
                bitVector = toggle(bitVector, x);
            }
            return bitVector;
        }

        public int toggle(int bitVector, int index){
            if(index < 0 ) return bitVector;
            int mask = 1 << index;
            if((bitVector & mask) == 0) {
                //if it is the first time encountering this bit index accumulate it by setting that value to 1
                bitVector |= mask;
            } else {
                //if we encountered this bit previously we set it equal to 0
                bitVector = bitVector & ~mask;
            }
            return bitVector;
        }

        //solution to checking if only a single bit is set to 1. Subtract 1 from it and AND it with original number
        boolean checkExactlyOneBitSet(int bitVector){
            return (bitVector & (bitVector - 1)) == 0;
        }


        public static void assertTest(Object input, Object args, Object expected){
            if(!input.equals(expected)) {
                System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
            } else {
                System.out.println("[Worked] " + args);
            }
        }


        public static void main(String[] args){
           // assertTest(isUniqueChars("abc"), "abc", true);
           PalindromePermuationImproved palindrome = new PalindromePermuationImproved();
            assertTest(palindrome.isPermutationOfPlalindrome("tactcoa"), "tactcoa", true);
            assertTest(palindrome.isPermutationOfPlalindrome("racecar"), "racecar", true);
            assertTest(palindrome.isPermutationOfPlalindrome("abc"), "abc", false);
            assertTest(palindrome.isPermutationOfPlalindrome("abba"), "abba", true);

        }
    }