package Generic;

import Chapter2.LinkedLists.DoublyLinkedList;
import Chapter2.LinkedLists.DllNode;
import DataStructures.Stack;

public class TESTSUIT {
        //use Arrays.toString(array)
        public static void assertTest(Object input, Object args, Object expected){
            if(input != null){
                String inputStr = "";
                String expectedStr = "";
                if(input instanceof Stack){
                    if(((Stack) input).isEmpty() && ((Stack) input).isEmpty()) {
                        System.out.println("[Passed] " + args); 
                        return;
                    } else if(((Stack) input).isEmpty()){
                        System.out.println("[Failed] received: Empty Stack, for: " + args);
                        return;
                    }
                    while(!((Stack) input).isEmpty()){
                        inputStr +=  String.valueOf(((Stack) input).peek()) + ", ";
                        expectedStr += String.valueOf(((Stack) expected).peek()) + ", ";
                        if(!String.valueOf(((Stack) input).pop()).equals(String.valueOf(((Stack) expected).pop()))){
                            System.out.println("[Failed] expected: [" + expectedStr + "], received: [" + inputStr +  "], for: " + args);
                            return;
                        } 
                    }
                    System.out.println("[Passed] " + args); 
                }
                else if(!input.equals(expected)) {
                    System.out.println("[Failed] expected: " + expected + ", received: " + input +  ", for: " + args);
                } else {
                    System.out.println("[Passed] " + args);
                }            
            } else {
                if(expected == null){
                    System.out.println("[Passed] " + args);
                } else {
                    System.out.println("[Failed] expected: " + expected + ", received: null" +  ", for: " + args);
                }
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
