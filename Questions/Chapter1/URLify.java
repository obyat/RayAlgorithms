import javax.print.DocFlavor.URL;

public class URLify{

    /*
    Chapter: 1, Question: 3. 
        Write a method to replace all spaces in a string with '%20'. You may assume that string has suffiecnt space at the end to hold the additional characters,
        and that you are given the 'true' length of the string. (Note: If implemented in java, please use a character array so that you can perform this operation in place.)
    */
    public static String urlifySol(String givenStr, int givenLength){
        char[] str = givenStr.toCharArray();
        
        int spaceCount = 0, index, i;
        for (i = 0; i < givenLength; i++){
            if(str[i] == ' ') spaceCount++;
        }
        
        index = givenLength  + spaceCount * 2;
        if (givenLength < str.length) str[givenLength] = '\0';
        for(int j = givenLength - 1; j >= 0; j--){
            if(str[j] == ' '){
                str[j - 1] = '%';
                str[j - 2] = '0';
                // str[j - 3] = '2';
                index = index - 3;
            } else {
                str[index - 1] = str[j];
                index--;
            } 
        }
            return String.valueOf(str);
        }
        

    //     public static String urlify(String str, int givenLength){
    //     boolean firstStr = false;
    //     while(j >= 0){
    //         if(urlStr[j] == ' ') {
    //             counter++;
    
    //         }
    //          if(counter == 3 && firstStr){
    //             firstStr = true;

    //             counter = counter - 3;

    //         } else {
    //             urlStr[counter+j] =  urlStr[j];
    //             urlStr[j] = ' ';    
    //         }
    //         j--;
    //     }
    //     System.out.println(counter);
    //     return String.valueOf(urlStr);
    // }

    public static void assertTest(Object input, Object args, Object expected){
        if(!input.equals(expected)) {
            System.out.println("[Failed] expected: " + expected + ", received:" + input +  ", for: " + args);
        } else {
            System.out.println("[Worked] " + args);
        }
    }

    public static void main(String[] args){
        
        assertTest(urlifySol("Mr John Smith    ", 13), "Mr John Smith    ", "Mr%20John%20Smith");

    }
}
//          vj
// "Mr John     Smith"
//             ^counter+j

// "Mr John  %20Smith"
//"Sm ith"
    /*
    
    Ideas:
        1.  Go backwords and increment a count of all the white spaces and move the first string +count spaces -- reset count to 0 add '%20', then reset count and repeat
            [Mr%20John%20Smith] O(str) runtime, O(1) space
        2. Disect strings and use stringBuilder O(str) runtime, O(Str) space
            [Mr%20John%20Smith]
    Learned: Different solution, ideas:
        1. givenStr.toCharArray();
        2. Strings are immutable
        3. Some solutions require multiple passes in the array which is O(2n) => O(n) 
    
    */
