import java.util.ArrayList;
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

    public String findKey(String key) {
        // Example: Assume array = new String[3], With array starting at 0, must accound
        // for 3-1 = 2 as max index [0,1,2]
        int arrayIndexHash = Integer.parseInt(key) % (this.arraySize - 1);
        while (this.theArray[arrayIndexHash] != key && arrayIndexHash < (this.arraySize - 1)) {
            arrayIndexHash++;
        }

        if (this.theArray[arrayIndexHash] == key) {
            System.out.println("Found key: " + key + ", at index: " + arrayIndexHash + ". ");
            return theArray[arrayIndexHash];
        }

        arrayIndexHash %= arraySize;
        System.out.println("Key: " + key + ", not found.");
        return null;
    }

    public static void main(String[] args) {
        HashFunction hf = new HashFunction(32);

        // System.out.println(hf.isPrime(17));
        // System.out.println(hf.getNextPrime(18));
        String[] elementsToAdd = { "100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        // hf.HashFunction2(elementsToAdd, hf.theArray);
        // hf.displayTheTable();
        // hf.findKey("660");
        // hf.findKey("1");
        // hf.findKey("55");
        // hf.findKey("100");

        String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };
            
        hf.HashFunction2(elementsToAdd3, hf.theArray);
        hf.increaseArraySize(60);
        hf.HashFunction2(elementsToAdd3, hf.theArray);
        hf.displayTheTable();
        Arrays.fill(hf.theArray, "-1");
        hf.HashFunction2(elementsToAdd3, hf.theArray);
        hf.displayTheTable();
        hf.findDoubleHashedKey("660");
        hf.findKey("1"); //not found
        hf.findKey("450");
        hf.findKey("180");
        hf.findKey("999"); //not found

    }

    public void HashFunction1(String[] stringsForArray, String[] theArray) {
        for (int i = 0; i < stringsForArray.length; i++) {
            theArray[Integer.parseInt(stringsForArray[i])] = stringsForArray[i];
        }
    }

    public void HashFunction2(String[] stringsForArray, String[] theArray) {
        // Example: Assume array = new String[3], With array starting at 0, must accound
        // for 3-1 = 2 as max index [0,1,2]
        for (int i = 0; i < stringsForArray.length; i++) {
            String newElementalVal = stringsForArray[i];
            int arrayIndex = Integer.parseInt(newElementalVal) % (this.arraySize);
            System.out.println("Mod index = " + arrayIndex + " for val " + newElementalVal);

            while (theArray[arrayIndex] != "-1") {
                ++arrayIndex;
                System.out.println("collision Try " + arrayIndex + " Instead");
                arrayIndex %= arraySize;
            }
            theArray[arrayIndex] = newElementalVal;
        }
    }

    public boolean isPrime(int number) {
        if(number % 2 == 0) return false;
        for(int i = 3; i * i <= number; i+=2){
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public int getNextPrime(int minNumToCheck){
        for(int i = minNumToCheck; true; i++)
            if(isPrime(i)) return i;
    }

    public void increaseArraySize(int minArraySize){
        int newArraySize = getNextPrime(minArraySize);

        moveOldArray(newArraySize);
    }

    public void moveOldArray(int newArraySize){
        String[] cleanArray = removeEmptySpacesInArray(this.theArray);
        this.theArray = new String[newArraySize];
        this.arraySize = newArraySize;
        Arrays.fill(this.theArray, "-1");
        HashFunction2(cleanArray, this.theArray);
    }

    public String[] removeEmptySpacesInArray(String[] array){
        ArrayList<String> stringList = new ArrayList<String>();
        for(String theString: array){
            if(!theString.equals("-1") && !theString.equals(""))
                stringList.add(theString);
        }
        return stringList.toArray(new String[stringList.size()]);
    }

    public void doubleHashfunc(String[] stringsForArray, String[] theArray) {
		for (int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			int arrayIndex = Integer.parseInt(newElementVal) % arraySize;
            int stepDistace = 7 - (Integer.parseInt(newElementVal) % 7); 
			while (theArray[arrayIndex] != "-1") {
				arrayIndex += stepDistace;
				arrayIndex %= arraySize;
                System.out.println("collision Try " + arrayIndex + " Instead");
			}
			theArray[arrayIndex] = newElementVal;
		}
	}

    public String findDoubleHashedKey(String key) {
        // Example: Assume array = new String[3], With array starting at 0, must accound
        // for 3-1 = 2 as max index [0,1,2]
        int arrayIndexHash = Integer.parseInt(key) % (this.arraySize - 1);
        int stepDistace = 7 - (Integer.parseInt(key) % 7); 

        while (this.theArray[arrayIndexHash] != key && arrayIndexHash < (this.arraySize - 1 )) {
            arrayIndexHash += stepDistace;
        }

        if (this.theArray[arrayIndexHash] == key) {
            System.out.println("Found key: " + key + ", at index: " + arrayIndexHash + ". ");
            return theArray[arrayIndexHash];
        }

        arrayIndexHash %= arraySize;
        System.out.println("Key: " + key + ", not found.");
        return null;
    }

	public void displayTheTable() {
		int increment = 0;
		int numberOfRows = (arraySize / 10) + 1;

		for (int m = 0; m < numberOfRows; m++) {
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
				if (n >= arraySize)
					System.out.print("|      ");
				else if (theArray[n].equals("-1"))
					System.out.print("|      ");
				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));
			}

			System.out.println("|");
			for (int n = 0; n < 71; n++)
				System.out.print("-");
			System.out.println();
		}
	}
}