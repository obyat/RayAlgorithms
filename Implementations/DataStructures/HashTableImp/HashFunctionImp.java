package DataStructures.HashTableImp;

public class HashFunctionImp {
    WorldList[] theArray;
    int arraySize;

    public int stringHashFunction(String wordToHash){
        int hashKeyValue = 0;

        for(int i = 0; i < wordToHash.length(); i++){
            int charCode = wordToHash.charAt(i) - 96;
            int hKVTemp = hashKeyValue;

            hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;
            System.out.println("HashKeyValue " + hKVTemp +  " * 27 + charCode" + charCode + "% arraySize" + arraySize + "= " + hashKeyValue + "\n");
        }
        return hashKeyValue;
    }
}

class Word {

    public String theWord;
    public String definition;
    public int key;
    public Word next;

    public Word(String theWord, String definition){
        this.theWord = theWord;
        this.definition = definition;
    }

    public String toString(){
        return theWord + ": " + definition;
    }
}

class WorldList{
    public Word firstWord = null;
    public void insert(Word newWord, int hashKey){
        Word previous = null;
        Word current = firstWord;
        newWord.key = hashKey;

        while(current != null && newWord.key > current.key){
            previous = current;
            current = current.next;
        }

        if(previous == null)
            firstWord = newWord;
        else
            previous.next = newWord;

        newWord.next = current;
    }

    public void displayWordList(){
        Word current = firstWord;
        while(current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public Word find(int hashKey){
        Word current = firstWord;
        while(current != null && current.key <= hashKey){
            if(current.key == hashKey) return current;
            current = current.next;
        }
        return null;
    }
     public static void main(String[] args) {
        
    }
} 