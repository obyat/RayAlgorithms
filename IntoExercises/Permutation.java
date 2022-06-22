package IntoExercises;
public class Permutation {

    
    public static void permutation(String full){
        if(full.length() == 0 || full.equals(null)) 
            System.out.println("Must input a valid word to permute of length > 0.");
        permute("", full);
        
    }
    private static void permute(String prefix, String remaining){
        int remainingLength = remaining.length();
        if( remainingLength == 0 ) System.out.println(prefix);
        for(int i = 0; i < remainingLength; i++){
            permute(prefix + remaining.charAt(i),  remaining.substring(0, i) + remaining.substring(i + 1 , remainingLength));
        }
        return;
    }

    public static void main(String[] args) {
        permutation("ABCD");
    }
}