package Generic;

import Chapter2.LinkedLists.DoublyLinkedList;
import Chapter2.LinkedLists.DllNode;

public class TESTSUIT {
        //use Arrays.toString(array)
        public static void assertTest(Object input, Object args, Object expected){
            if(!input.equals(expected)) {
                System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
            } else {
                System.out.println("[Passed] " + args);
            }
            System.out.println();
        }
    
        //requires all methods to return wrapper classes
        public static <T> void assertArray2DTest(T[][] input, Object args, T[][] expected){
            for (int row = 0; row < input.length; row++) {
                for (int col = 0; col < input[0].length; col++) {
                    if(input[row][col] != expected[row][col]){
                        System.out.println("[MY Array Failed] " + args);
                        return;
                    }
                }
            }
                System.out.println("[Array Passed] " + args);
        }
    
        public static DoublyLinkedList createLinkedList(int[] js){
            if(js.length <= 0) return null;
            DllNode node = new DllNode(js[0]);
            DoublyLinkedList  list = new DoublyLinkedList (node);
            for (int i = 1; i < js.length; i++) list.addToEnd(js[i]);
            return list;
        }
}
