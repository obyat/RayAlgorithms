import java.util.*;
public class PalindromePermuation{

    static int count = 0;
    static boolean palindome = false;
    static List<String> palindromeList = new ArrayList<String>(); 
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

        for(String s: palindromeList) System.out.println(s);
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