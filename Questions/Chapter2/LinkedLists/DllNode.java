package Chapter2.LinkedLists;

public class DllNode {
    public int data;
    public DllNode prev;
    public DllNode next;

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

    public int size(){
        int size = 1;
        DllNode n = this;
        while(n.next != null){
            size++;
            n = n.next;
        }
        return size;
    }

    public void printLinkedList(){
        DllNode tempCopy = cloneNode(this);
        if(tempCopy != null) System.out.println(tempCopy.data);
        while(tempCopy.next != null){
            //only changing the next for tempcopy. Therefore the enxt for the head has not changed
            System.out.println(tempCopy.next.data);
            tempCopy = tempCopy.next;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("DllNode Ran");
    }
}
