package IntoExercises;

public class C6E12 {
    private static int count = 0;
    public static void main(String args[]) {
      permutation("abbc", "");
    }

    public void permutation(String str){
        permutation(str, "");
    }
    
    public static void permutation(String str, String prefix){

        // System.out.println("the string to permute is: " + str + ", Prefix is:" + prefix);
        if(prefix.length() == 4){
            System.out.println(prefix);
            count++;
            System.out.println(count);
        }
        if(str.length() == 0){
            // System.out.println(prefix);
        } else {
            for (int i=0; i < str.length(); i++){
                String rem = str.substring(0, i) + str.substring(i+1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
}
}