/*
Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures.
Hint: 44,177,132
*/
public class IsUnique{

    public static boolean isUniqueChars(String str){
        if(str.length() > 26) return false;
        Character[] charSet = new Character[26]; //Assuming English Alphabet

        for(int i = 0; i < str.length(); i++){
            int charVal = Character.toLowerCase(str.charAt(i)) - 97;
            
            if(charVal > 97 || charVal < 0 || charSet[charVal] != null) 
                return false;
            else
                charSet[charVal] = Character.toLowerCase(str.charAt(i));
        }
        return true;
    }

    public static void assertTest(Object given, Object args, Object expected){
        if(!given.equals(expected)) {
            System.out.println("[Failed] expected: " + given + ", received: " + expected +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
    }

    public static void main(String[] args){
        assertTest(isUniqueChars("abc"), "abc", true);
        assertTest(isUniqueChars("ray"), "ray", true);
        assertTest(isUniqueChars("ABCDEFGHIKLMNOPQRSTVXYZ"), "ABCDEFGHIKLMNOPQRSTVXYZ", true);
        assertTest(isUniqueChars("ABCDEFGHIKLMNOPQRSTVXYZD"), "ABCDEFGHIKLMNOPQRSTVXYZD", false);
        assertTest(isUniqueChars("asdfjsdlkfjasl;jdfal;sdjfl;asjdf"), "asdfjsdlkfjasl;jdfal;sdjfl;asjdf", false);
        assertTest(isUniqueChars("abcdefgkoplmz/sldow."), "abcdefgkoplmz/sldow.", false);

    }
}

    // HashSet ==> O(c) space, O(n) time
    // An array of ASCII Mappings => O(c) space O(n) time
    // sort => O(n + k) time or O(nlogn) time for sorting + O(n) time to search the sorted array.

    /*
    Learned: Different solution, ideas:

    1. str.charAt() being cast to int will return its ascii value
        - (int) str.charAt(0) of "a" = 97
        - str.charAt(0) of "a" = "a"
    
    2. Character.toLowerCase(str.charAt(0))
    3. a[0] = a
       a[1] = b
       a[2] = c
    */
