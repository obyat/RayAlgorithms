import java.util.Arrays;


public class HashFunction {
    // System.out.println();
    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    HashFunction(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }

    public String findKey(String key){
        // Example: Assume array  = new String[3], With array starting at 0, must accound for 3-1 = 2 as max index [0,1,2]
        int arrayIndexHash = Integer.parseInt(key) % (this.arraySize - 1);
        while(this.theArray[arrayIndexHash] != key && arrayIndexHash < (this.arraySize - 1)){
            arrayIndexHash++;
        }
        
        if(this.theArray[arrayIndexHash] == key){
            System.out.println("Found key: " + key + ", at index: " + arrayIndexHash + ". ");
            return theArray[arrayIndexHash];
        }

        arrayIndexHash %= arraySize;
        System.out.println("Key not found");
        return null;
    }

    public static void main(String[] args) {
        HashFunction hf = new HashFunction(30);
        String[] elementsToAdd = { "100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        hf.HashFunction2(elementsToAdd, hf.theArray);
        hf.displayTheTable();
        hf.findKey("660");
        hf.findKey("1");
        hf.findKey("55");
        hf.findKey("100");


    }

    public void HashFunction1(String[] stringsForArray, String[] theArray) {
        for (int i = 0; i < stringsForArray.length; i++) {
            theArray[Integer.parseInt(stringsForArray[i])] = stringsForArray[i];
        }
    }

    public void HashFunction2(String[] stringsForArray, String[] theArray) {
        // Example: Assume array  = new String[3], With array starting at 0, must accound for 3-1 = 2 as max index [0,1,2]
        for (int i = 0; i < stringsForArray.length; i++) {
            String newElementalVal = stringsForArray[i];
            int arrayIndex = Integer.parseInt(newElementalVal) % (this.arraySize - 1);
            System.out.println("Mod index = " + arrayIndex + " for val " + newElementalVal);

            while (theArray[arrayIndex] != "-1") {
                ++arrayIndex;
                System.out.println("collision Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize;
            }
            theArray[arrayIndex] = newElementalVal;
        }
    }

    public void displayTheTable() {
        int increment = 0;
        for (int m = 0; m < 3; m++) {
            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
            }

            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();

        }

    }

}