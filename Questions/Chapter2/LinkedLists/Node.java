package Chapter2.LinkedLists;

//Also referred to as LinkedList
public class Node {
    Node next = null;
    int data;

    public Node(int d){
        data = d;
    }

    void appendTotail(int d){
        Node end = new Node(d);
        Node n = this; //make a temp copy of this object
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    //Note: most LinkedList problems require recursion
    //Note: if multiple things expect the head of the LinkedList to be a certain node, and it changes, some objects could still point to the old heal of the NodeList.
    //Objects cannot be passed by value (copy). Only passed by reference (Changes affect original object)
    Node deleteNode(Node head, int d){
        Node n = head;
        // System.out.println("printing head:");
        // head.PrintLinkedList();
        if(n.data == d){
            return head.next;
            //remove the reference to the head
        }

        while(n.next != null){
            if(n.next.data == d) {
                n.next = n.next.next; //if the next node has the data to be deleted, skip the next node. Set the next of current Node to next.next effectively removing reference to next node.
                return head;
                //head didn't change
            }
            n = n.next;
        }

        return head;
    }

    void PrintLinkedList(){
        Node tempCopy = cloneNode(this);
        if(tempCopy != null) System.out.println(tempCopy.data);
        while(tempCopy.next != null){
            System.out.println(tempCopy.next.data);
            tempCopy.next = tempCopy.next.next;
        }
    }

    private Node cloneNode(Node n){
        Node clone = new Node(n.data);
        clone.next = n.next;
        return clone;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendTotail(2);
        node.appendTotail(3);
        node.appendTotail(40);
        node.appendTotail(500);
        // node.PrintLinkedList();

        // node.deleteNode(node, 3);
        System.out.println("printing list");
        node.PrintLinkedList();
        System.out.println("printing list");
        node.PrintLinkedList();
    }
}
