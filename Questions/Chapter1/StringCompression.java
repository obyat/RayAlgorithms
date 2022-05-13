public class StringCompression{

    /*
    Chapter: 1, Question: 6. 
    Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
    If the compressed string would not become smaller than the original string, your method should return the original string. You can assume the string has only
    has uppercase and lowercase characters (a-z).

    Hints: 92, 110
    */

    //Runtime: O(str) time + O(str*2) space for StringBuilder in worse case
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

        return concatenatedStr.length() < len ? concatenatedStr.toString() : str;
    }
    
    //O(2*str.legnth())
    public static String stringCompressionSlightlyImproved(String str){
 
        int finalLength = countCompression(str);
        if(finalLength >= str.length()) return str;

        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i =0; i < str.length(); i++){
            countConsecutive++;

            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1 )){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
    return  compressed.toString();
    }
    
    public static int countCompression(String str){
        int compressedLength = 0;
        int countConsecutive = 0;

        for(int i =0; i < str.length(); i++){
            countConsecutive++;

            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1 )){
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    // O(str.legnth())
    public static String stringCompressionImproved(String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for(int i = 0; i < str.length(); i++){
            countConsecutive++;

            //if next char is different append it
            if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1 )){
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
    return compressed.length() > str.length() ? str: compressed.toString();
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
        System.out.println();
        assertTest(stringCompressionSlightlyImproved("abc"), "abc", "abc");
        assertTest(stringCompressionSlightlyImproved("aabcccccaaa"), "aabcccccaaa", "a2b1c5a3");
        assertTest(stringCompressionSlightlyImproved("aabcccccaavaaa"), "aabcccccaavaaa", "a2b1c5a2v1a3");
        assertTest(stringCompressionSlightlyImproved("aabbbbbbbbbbcccccaava"), "aabbbbbbbbbbcccccaava", "a2b10c5a2v1a1");
        assertTest(stringCompressionSlightlyImproved("HeLLLLLLLo"), "HeLLLLLLLo", "H1e1L7o1");
        System.out.println();
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
    
    Pros vs. Cons in solutons:
        1. Pro: We can avoid creating a string we don't need by counting in advance before we make a string. Con: We must have O(2*Str.legnth()) runtime

    Learned: Different solution, ideas:
        1. If work is required regardless of condition, have the work occur first, then the condition. Such as always counting the character regardless of similarity
    
    */