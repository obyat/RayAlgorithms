package DataStructures.LinkedLists;

public class DllNode {
    int data;
    DllNode prev;
    DllNode next;

    public DllNode(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    private DllNode cloneNode(DllNode n){
        DllNode clone = new DllNode(n.data);
        clone.next = n.next;
        return clone;
    }

    

    void PrintLinkedList(){
        DllNode tempCopy = cloneNode(this);
        if(tempCopy != null) System.out.println(tempCopy.data);
        while(tempCopy.next != null){
            System.out.println(tempCopy.next.data);
            tempCopy.next = tempCopy.next.next;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
