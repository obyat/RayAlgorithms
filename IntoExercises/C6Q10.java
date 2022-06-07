package IntoExercises;

public class C6Q10 {
    public static void main(String args[]) {
      System.out.println(isPrime(33));
    }
    
    public static boolean isPrime(int n){
         System.out.println("is " + n + " prime?  " );
        for (int x = 2; x * x <= n; x++){
            if (n % x  == 0) return false;
        }
        return true;
    }
}