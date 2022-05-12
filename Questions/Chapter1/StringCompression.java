public class StringCompression{

    /*
    Chapter: 1, Question: 6. 
    Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
    If the compressed string would not become smaller than the original string, your method should return the original string. You can assume the string has only
    has uppercase and lowercase characters (a-z).

    Hints: 92, 110
    */

    //Runtime: O(str) time + O(1) space
    public static String stringCompression(String str){
  
        int currentCharCount, len;
        currentCharCount = 0;
        len = str.length();
        if(len == 0 || len == 1) return str;
        StringBuilder concatenatedStr = new StringBuilder(len);

        for(int i = 0; i < len; i++){
            if(i ==  len - 1){
                if(str.charAt(i - 1) == str.charAt(i)){
                    currentCharCount++;
                    concatenatedStr.append(str.charAt(i));
                    concatenatedStr.append(currentCharCount);
                }
                else {
                    currentCharCount++;
                    concatenatedStr.append(str.charAt(i));
                    concatenatedStr.append(currentCharCount);
                }
            } else if(str.charAt(i) == str.charAt(i + 1)){
                currentCharCount++;
            } else {
                currentCharCount++;
                concatenatedStr.append(str.charAt(i));
                concatenatedStr.append(currentCharCount);
                currentCharCount = 0;
            }
        }
        if(concatenatedStr.length() < len)
            return concatenatedStr.toString();
        return str;
    }

    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
    }

    public static void main(String[] args){
        assertTest(stringCompression("abc"), "abc", "abc");
        assertTest(stringCompression("aabcccccaaa"), "aabcccccaaa", "a2b1c5a3");
        assertTest(stringCompression("aabcccccaavaaa"), "aabcccccaavaaa", "a2b1c5a2v1a3");
        assertTest(stringCompression("aabbbbbbbbbbcccccaava"), "aabbbbbbbbbbcccccaava", "a2b10c5a2v1a1");
        assertTest(stringCompression("HeLLLLLLLo"), "HeLLLLLLLo", "H1e1L7o1");
    }
}

    /*
    Questions:
        1. Must upper and lowercase characters be counted separately?
        2. In the compressed string, do the integers count as part of the string?
        3. What is the input space?

    Ideas:
        1. While character is still the same, maintain count for each letter, and then append that character and its count using StringBuilder. Only needs one variable.
        2. HashTable with counts, if still the same, increment count, if different, append the character with its count and reset the entire table.

    Edge Cases:
        1. Input space not letters leads to exit
        2. Cannot concatinate empty string or string of size 1

    Learned: Different solution, ideas:
        1.
    
    */