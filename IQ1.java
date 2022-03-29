import java.util.Arrays;

public class IQ1{
    private String name;
    private int age;
    
    private IQ1(String name, int age){
        this.name = name;
        this.age = age;
    }

    public boolean problem1IsUniqueChars(String str){
        if (str.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++){
            int val = Character.toLowerCase(str.charAt(i));
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }
    
    public static void main(String[] args){
        IQ1 iq1 = new IQ1("Robert", 21);

        
        System.out.println(iq1.problem1IsUniqueChars("abccs")); // false
        System.out.println(iq1.problem1IsUniqueChars("ajklsdfjasldkncaklsdnvaslkdjafiopwjefiopwjmfioasndclkasndvclaskdnvjaso")); // false
        System.out.println(iq1.problem1IsUniqueChars("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")); // false
        System.out.println(iq1.problem1IsUniqueChars("abcdefghijklmnopqrstuvwxyz")); // true
        System.out.println(iq1.problem1IsUniqueChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ")); // true
        System.out.println(iq1.problem1IsUniqueChars("test")); // false


    }
}
